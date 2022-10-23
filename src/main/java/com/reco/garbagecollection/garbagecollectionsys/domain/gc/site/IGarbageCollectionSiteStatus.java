package com.reco.garbagecollection.garbagecollectionsys.domain.gc.site;

public interface IGarbageCollectionSiteStatus {
    Long getSiteId(); // 업장ID
    String getSiteName(); // 업장명
    String getLocationName(); // 위치명
    long getCollectedAmount(); // 수거량
    long getCollectedCanCount(); // 수거통수
}
