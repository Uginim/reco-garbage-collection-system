package com.reco.garbagecollection.garbagecollectionsys.web.dto.historypage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 이력PageDto
 */
@ApiModel( value = "GCHistoryPageDto",description = "이력 페이지")
@Getter
public class GCHistoryPageDto {
    @ApiModelProperty(value = "전체항목개수", example = "14245")
    private long totalElementCount;
    @ApiModelProperty(value = "전체페이지수", example = "145")
    private int totalPageCount;
    @ApiModelProperty(value = "수거이력리스트")
    private List<GarbageCollectionHistoryDto> historyDtoList;

    @Builder
    public GCHistoryPageDto(
            long totalElementCount,
            int totalPageCount,
            List<GarbageCollectionHistoryDto> historyDtoList
    ) {
        this.totalElementCount = totalElementCount;
        this.totalPageCount = totalPageCount;
        this.historyDtoList = historyDtoList;
    }
}
