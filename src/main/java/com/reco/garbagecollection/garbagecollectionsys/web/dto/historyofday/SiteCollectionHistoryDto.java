package com.reco.garbagecollection.garbagecollectionsys.web.dto.historyofday;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 업장수거이력DTO
 */
@Getter
@ApiModel( value = "SiteCollectionHistoryDto",description = "업장수거이력" )
public class SiteCollectionHistoryDto {
    @ApiModelProperty(value = "수거업장명", example = "버거킹")
    private String siteName; // 수거업장명

    @ApiModelProperty(value = "실제수거시간", example = "2021-11-03 12:25:14")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime collectedTime; // 수거일시
    @ApiModelProperty(value = "수거량", example = "642")
    private long collectedAmount;
    @ApiModelProperty(value = "수거통수", example = "2")
    private long collectedCanCount;
    @ApiModelProperty(value = "사업자명", example = "김버거")
    private String ownerName;

    @ApiModelProperty(value = "첨부사진리스트")
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
