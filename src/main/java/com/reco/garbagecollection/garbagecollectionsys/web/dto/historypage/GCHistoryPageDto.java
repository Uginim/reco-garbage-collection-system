package com.reco.garbagecollection.garbagecollectionsys.web.dto.historypage;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 이력PageDto
 */
@Getter
public class GCHistoryPageDto {
    private long totalElementCount;
    private int totalPageCount;
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
