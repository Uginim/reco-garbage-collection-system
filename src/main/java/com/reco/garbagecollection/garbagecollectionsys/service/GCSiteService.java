package com.reco.garbagecollection.garbagecollectionsys.service;

import com.reco.garbagecollection.garbagecollectionsys.domain.gc.site.GarbageCollectionSite;
import com.reco.garbagecollection.garbagecollectionsys.domain.gc.site.GarbageCollectionSiteRepository;
import com.reco.garbagecollection.garbagecollectionsys.domain.gc.site.IGarbageCollectionSiteStatus;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.SiteInfoDto;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.SiteStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 수거업장관리 서비스
 */
@Service
@RequiredArgsConstructor
public class GCSiteService {
    private final GarbageCollectionSiteRepository siteRepository;

    @Transactional
    public List<SiteStatusDto> getAllSiteStatus() {
        List<SiteStatusDto> result = null;
        List<IGarbageCollectionSiteStatus> siteStatusResults = siteRepository.siteStatusWithNativeQuery();
        result = siteStatusResults.stream().map(statusValues -> {
            SiteStatusDto siteStatusDto = null;
            siteStatusDto =SiteStatusDto.builder().siteId(statusValues.getSiteId())
                    .siteName(statusValues.getSiteName())
                    .locationName(statusValues.getLocationName())
                    .collectedAmount(statusValues.getCollectedAmount())
                    .collectedCanCount(statusValues.getCollectedCanCount())
                    .build();
            return siteStatusDto;
        }).collect(Collectors.toList());
        return result;
    }

    @Transactional
    public long saveSiteInfoDto(SiteInfoDto siteInfoDto) {
        GarbageCollectionSite siteEntity = GarbageCollectionSite.builder()
            .siteName(siteInfoDto.getSiteName())
            .locationName(siteInfoDto.getLocation())
            .ownerName(siteInfoDto.getOwnerName())
            .contractStartDate(LocalDateTime.of(siteInfoDto.getContractDate(), LocalTime.of(0,0)))
            .build();
        return siteRepository.save(siteEntity).getGcSiteId();
    }
}
