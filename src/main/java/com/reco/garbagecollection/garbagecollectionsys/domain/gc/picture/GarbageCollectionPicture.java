package com.reco.garbagecollection.garbagecollectionsys.domain.gc.picture;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 수거사진 엔티티
 */
@Getter
@NoArgsConstructor
@Entity(name = "garbage_collection_picture")
public class GarbageCollectionPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pictureId;

    @Column
    private String filename;

    @Column
    private String filenameExtension;

    @Column(name="gc_history_id")
    private long gcHistoryId;

    @Column
    private LocalDateTime createTime;

    @Column
    private LocalDateTime update_time;
}
