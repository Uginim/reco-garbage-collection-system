package com.reco.garbagecollection.garbagecollectionsys.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class SiteCollectionHistoryDto {
    private String siteName;
    private LocalDateTime collectedTime;
    private long collectedAmount;
    private long collectedCanCount;
    private String ownerName;

    List<CollectionPictureDto> pictureDtoList ;
    @Builder
    SiteCollectionHistoryDto(String siteName,
                             LocalDateTime collectedTime,
                             long collectedAmount,
                             long collectedCanCount,
                             String ownerName,
                        List<CollectionPictureDto> pictureDtoList) {
        this.siteName = siteName;
        this.collectedTime = collectedTime;
        this.collectedAmount = collectedAmount;
        this.collectedCanCount = collectedCanCount;
        this.ownerName = ownerName;
        this.pictureDtoList =  pictureDtoList;

    }
}
