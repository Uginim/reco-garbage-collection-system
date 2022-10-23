package com.reco.garbagecollection.garbagecollectionsys.web.dto.historyofday;

import lombok.Builder;
import lombok.Getter;

/**
 * 수거사진 DTO
 */
@Getter
public class CollectionPictureDto {
    private String fileName; // 파일명(확장자포함)
    private String locationName; // 위치명
    private String ownerName; // 사업자명

    @Builder
    CollectionPictureDto(String fileName,
                         String locationName,
                         String ownerName) {
        this.fileName = fileName;
        this.locationName = locationName;
        this.ownerName = ownerName;
    }
}
