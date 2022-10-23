package com.reco.garbagecollection.garbagecollectionsys.web.dto.historyofday;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 업장수거이력DTO
 */
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
