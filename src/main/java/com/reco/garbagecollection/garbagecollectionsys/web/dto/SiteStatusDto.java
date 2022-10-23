package com.reco.garbagecollection.garbagecollectionsys.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;



@ApiModel( value = "SiteStatusDto",description = "수거업장현황" )
@Getter
@Builder
@RequiredArgsConstructor
public class SiteStatusDto {
    @ApiModelProperty(value = "수거업장ID", example = "1")
    private long siteId; // 업장ID
    @ApiModelProperty(value = "수거업장명", example = "맘스터치")
    private String siteName; // 업장명
    @ApiModelProperty(value = "위치명", example = "역삼")
    private String locationName; // 장소명
    @ApiModelProperty(value = "누적수거량", example = "14556")
    private long collectedAmount; // 누적수거량
    @ApiModelProperty(value = "누적수거통수", example = "142")
    private long collectedCanCount; // 누적수거통수
    public SiteStatusDto(long siteId, String siteName, String locationName, long collectedAmount, long collectedCanCount) {
        this.siteId = siteId;
        this.siteName = siteName;
        this.locationName = locationName;
        this.collectedAmount = collectedAmount;
        this.collectedCanCount = collectedCanCount;
    }
}
