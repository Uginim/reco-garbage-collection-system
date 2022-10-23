package com.reco.garbagecollection.garbagecollectionsys.domain.gc.history;


import com.reco.garbagecollection.garbagecollectionsys.domain.gc.picture.GarbageCollectionPicture;
import com.reco.garbagecollection.garbagecollectionsys.domain.gc.site.GarbageCollectionSite;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 수거이력 엔티티
 */
@Getter
@NoArgsConstructor
@Entity(name = "garbage_collection_history")
public class GarbageCollectionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gcHistoryId; // 수거이력ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gc_site_id")
    private GarbageCollectionSite site; //  업장정보(N : 1)

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "gc_history_id")
    private List<GarbageCollectionPicture> pictures; // 수거이력사진(1:N)

    @Column
    private long collectedAmount; // 수거량
    @Column
    private long collectedTrashCanCount; // 수거통수
    @Column
    private long gcAttachmentPictureCount; // 첨부사진개수
    @Column
    private String gcSpecialNote; // 특이사항
    @Column
    private LocalDateTime collectedTime; // 수거일시
    @Builder
    public GarbageCollectionHistory(long gcHistoryId, long collectedAmount,
                                    long collectedTrashCanCount,
                                    long gcAttachmentPictureCount,
                                    String gcSpecialNote,
                                    LocalDateTime collectedTime) {
        this.gcHistoryId = gcHistoryId;
        this.collectedAmount = collectedAmount;
        this.collectedTrashCanCount = collectedTrashCanCount;
        this.gcAttachmentPictureCount = gcAttachmentPictureCount;
        this.gcSpecialNote = gcSpecialNote;
        this.collectedTime = collectedTime;
    }
}
