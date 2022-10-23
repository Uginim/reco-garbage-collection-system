package com.reco.garbagecollection.garbagecollectionsys.service;

import com.reco.garbagecollection.garbagecollectionsys.domain.gc.history.GarbageCollectionHistory;
import com.reco.garbagecollection.garbagecollectionsys.domain.gc.history.GarbageCollectionHistoryRepository;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.historyofday.CollectionPictureDto;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.historypage.GCHistoryPageDto;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.historypage.GarbageCollectionHistoryDto;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.historyofday.SiteCollectionHistoryDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 수거이력관리서비스
 */
@Service
@RequiredArgsConstructor
public class GCHistoryService {
    private final Logger logger = LoggerFactory.getLogger(GCHistoryService.class);

    private final GarbageCollectionHistoryRepository historyRepository;


    /**
     * 수거이력을 페이지네이션하여 조회
     * @param pageable 페이지 설정
     * @return 수거이력
     */
    @Transactional
    public GCHistoryPageDto getHistoriesPage(Pageable pageable) {
        GCHistoryPageDto resultPage = null;
        List<GarbageCollectionHistoryDto> list = null;
        Page<GarbageCollectionHistory> historyPage = historyRepository.findAll(pageable);

        List<GarbageCollectionHistory> historyList = historyPage.toList();
        list = historyPage.stream().map(
               history -> {
                   return GarbageCollectionHistoryDto.builder()
                           .specialNote(history.getGcSpecialNote()) // 특이사항
                           .historyId(history.getGcHistoryId()) // 이력ID
                           .locationName(history.getSite().getLocationName()) // 지역명
                           .attachmentPictureCount(history.getGcAttachmentPictureCount()) // 첨부사진개수
                           .collectedAmount(history.getCollectedAmount()) // 수거량
                           .collectedCanCount(history.getCollectedTrashCanCount()) // 수거통수
                           .siteId(history.getSite().getGcSiteId()) // 업장ID
                           .siteName(history.getSite().getSiteName()) // 업장명
                           .collectedTime(history.getCollectedTime()) // 수거일시
                           .build();
               }
       ).collect(Collectors.toList());
        resultPage = GCHistoryPageDto.builder()
                .historyDtoList(list)
                .totalElementCount(historyPage.getTotalElements())
                .totalPageCount(historyPage.getTotalPages())
                .build();
       return resultPage;
   }

    /**
     * 특정날짜의 수거이력을 검색함
     * @param startDateTime 검색 날짜
     * @return 검색한 날짜의 수거이력
     */
    @Transactional
    public List<SiteCollectionHistoryDto> getCollectionHistoriesOnDate(LocalDateTime startDateTime) {
        List<SiteCollectionHistoryDto> result = null;
        LocalDateTime endDateTime = startDateTime.plusDays(1);
        // entity 조회
        List<GarbageCollectionHistory> histories = historyRepository.findAllByCollectedTimeGreaterThanEqualAndCollectedTimeLessThan(startDateTime,endDateTime);
        result = histories.stream().map(garbageCollectionHistory -> {
            return SiteCollectionHistoryDto.builder()
                    .siteName(garbageCollectionHistory.getSite().getSiteName()) // 업장명
                    .collectedAmount(garbageCollectionHistory.getCollectedAmount()) // 수거량
                    .collectedTime(garbageCollectionHistory.getCollectedTime()) // 수거일시
                    .collectedCanCount(garbageCollectionHistory.getCollectedTrashCanCount()) // 수거통수
                    // 첨부사진(N개)
                    .pictureDtoList(garbageCollectionHistory.getPictures().stream().map(picture->{
                        return CollectionPictureDto.builder()
                                .fileName(
                                        String.format("%s.%s"
                                                , picture.getFilename()
                                                , picture.getFilenameExtension()))
                                .ownerName(garbageCollectionHistory.getSite().getOwnerName())
                                .locationName(garbageCollectionHistory.getSite().getLocationName())
                                .build();
                    }).collect(Collectors.toList()))
                    .build();
        }).collect(Collectors.toList());
        return result;
    }
}
