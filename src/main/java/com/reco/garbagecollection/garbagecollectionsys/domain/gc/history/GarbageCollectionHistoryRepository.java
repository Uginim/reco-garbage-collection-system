package com.reco.garbagecollection.garbagecollectionsys.domain.gc.history;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface GarbageCollectionHistoryRepository extends JpaRepository<GarbageCollectionHistory,Long> {
    /**
     * 특정 기간동안의 업장수거이력과 수거사진을 조회함
     * @param start 시작일시(포함)
     * @param end 끝일시(배제)
     * @return 업장수거이력:수거사진(1:N) 정보를 리턴
     */
    List<GarbageCollectionHistory> findAllByCollectedTimeGreaterThanEqualAndCollectedTimeLessThan(LocalDateTime start,LocalDateTime end);
}
