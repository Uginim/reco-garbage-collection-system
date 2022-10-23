package com.reco.garbagecollection.garbagecollectionsys.domain.gc.site;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 수거업장 엔티티
 */
@Getter
@NoArgsConstructor
@Entity(name = "garbage_collection_site")
public class GarbageCollectionSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gcSiteId;
    @Column
    private String siteName;
    @Column
    private String locationName;
    @Column
    private LocalDateTime contractStartDate;
    @Column
    private String ownerName;
    @Builder
    public GarbageCollectionSite(long gcSiteId,
                                 String siteName,
                                 String locationName,
                                 LocalDateTime contractStartDate,
                                 String ownerName){
        this.gcSiteId = gcSiteId;
        this.siteName = siteName;
        this.locationName = locationName;
        this.contractStartDate = contractStartDate;
        this.ownerName = ownerName;
    }
}
