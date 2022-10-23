package com.reco.garbagecollection.garbagecollectionsys.web.dto.historypage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.historyofday.CollectionPictureDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@ApiModel( value = "GarbageCollectionHistoryDto",description = "수거이력항목")
@Getter
@NoArgsConstructor
public class GarbageCollectionHistoryDto {
    @ApiModelProperty(value = "수거업장ID", example = "142")
    private long siteId; // 사업장ID
    @ApiModelProperty(value = "수거업장명", example = "맘스터치")
    private String siteName; // 업장명
    @ApiModelProperty(value = "위치명", example = "역삼")
    private String locationName; // 위치명
    @ApiModelProperty(value = "이력ID", example = "155")
    private long historyId; // 이력ID
    @ApiModelProperty(value = "수거량", example = "642")
    private long collectedAmount; // 수거량
    @ApiModelProperty(value = "수거통수", example = "2")
    private long collectedCanCount; // 수거통수
    @ApiModelProperty(value = "첨부사진개수", example = "2")
    private long attachmentPictureCount; // 첨부사진개수
    @ApiModelProperty(value = "특이사항", example = "새벽 수거 해야함")
    private String specialNote; // 특이사항
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "수거일시", example = "2021-11-03 12:25:14")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime collectedTime; //수거일시


    @Builder
    public GarbageCollectionHistoryDto(String siteName,
                                       String locationName,
                                       long siteId,
                                       long historyId,
                                       long collectedAmount,
                                       long collectedCanCount,
                                       long attachmentPictureCount,
                                       String specialNote,
                                       LocalDateTime collectedTime) {
        this.siteName = siteName;
        this.locationName = locationName;
        this.siteId = siteId;
        this.historyId = historyId;
        this.collectedAmount = collectedAmount;
        this.collectedCanCount = collectedCanCount;
        this.attachmentPictureCount = attachmentPictureCount;
        this.specialNote = specialNote;
        this.collectedTime = collectedTime;
    }
}
