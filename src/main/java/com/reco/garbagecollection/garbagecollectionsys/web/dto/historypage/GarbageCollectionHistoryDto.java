package com.reco.garbagecollection.garbagecollectionsys.web.dto.historypage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GarbageCollectionHistoryDto {
    private long siteId; // 사업장ID
    private String siteName; // 업장명
    private String locationName; // 위치명
    private long historyId; // 이력ID
    private long collectedAmount; // 수거량
    private long collectedCanCount; // 수거통수
    private long attachmentPictureCount; // 첨부사진개수
    private String specialNote; // 특이사항
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
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
