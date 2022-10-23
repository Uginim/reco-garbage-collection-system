package com.reco.garbagecollection.garbagecollectionsys.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;




@Getter
@Builder
@RequiredArgsConstructor
public class SiteStatusDto {
    private long siteId; // 업장ID
    private String siteName; // 업장명
    private String locationName; // 장소명
    private long collectedAmount; // 누적수거량
    private long collectedCanCount; // 누적수거통수
    public SiteStatusDto(long siteId, String siteName, String locationName, long collectedAmount, long collectedCanCount) {
        this.siteId = siteId;
        this.siteName = siteName;
        this.locationName = locationName;
        this.collectedAmount = collectedAmount;
        this.collectedCanCount = collectedCanCount;
    }
}
