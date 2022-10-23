package com.reco.garbagecollection.garbagecollectionsys.web.dto.historyofday;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * 수거사진 DTO
 */
@ApiModel( value = "CollectionPictureDto",description = "수거사진 ")
@Getter
public class CollectionPictureDto {
    @ApiModelProperty(value = "파일명(확장자포함)", example = "롯데리아_01.png")
    private String fileName; // 파일명(확장자포함)
    @ApiModelProperty(value = "위치명", example = "역삼")
    private String locationName; // 위치명
    @ApiModelProperty(value = "수거업장명", example = "맘스터치")
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
