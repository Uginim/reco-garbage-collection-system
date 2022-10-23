package com.reco.garbagecollection.garbagecollectionsys.domain.gc.site;

import com.reco.garbagecollection.garbagecollectionsys.web.dto.SiteStatusDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GarbageCollectionSiteRepository extends JpaRepository<GarbageCollectionSite,Long> {
    @Query(value =
            "select\n" +
                    "gcs.gc_site_id as siteId\n" +
                    ", gcs.site_name as  siteName\n" +
                    ", gcs.location_name as locationName\n" +
                    ", sum(nvl(gch.collected_amount,0)) as collectedAmount\n" +
                    ", sum(nvl(gch.gc_attachment_picture_count,0)) as collectedCanCount\n" +
                    "from garbage_collection_site gcs\n" +
                    "left outer join garbage_collection_history gch\n" +
                    "on gcs.gc_site_id = gch.gc_site_id\n" +
                    "group by\n" +
                    "gcs.gc_site_id\n" +
                    ", gcs.site_name\n" +
                    ", gcs.location_name\n"
            , nativeQuery = true
    )
    List<IGarbageCollectionSiteStatus> siteStatusWithNativeQuery();



}
