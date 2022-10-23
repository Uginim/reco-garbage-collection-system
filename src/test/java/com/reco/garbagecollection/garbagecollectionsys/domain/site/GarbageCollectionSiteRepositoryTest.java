package com.reco.garbagecollection.garbagecollectionsys.domain.site;


import com.reco.garbagecollection.garbagecollectionsys.domain.gc.site.GarbageCollectionSiteRepository;
import com.reco.garbagecollection.garbagecollectionsys.domain.gc.site.IGarbageCollectionSiteStatus;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GarbageCollectionSiteRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(GarbageCollectionSiteRepositoryTest.class);

    @Autowired
    private GarbageCollectionSiteRepository siteRepository;


    @Test
    public void returnsSiteStatus() {
        List<IGarbageCollectionSiteStatus> siteStatusDtoList = siteRepository.siteStatusWithNativeQuery();
        siteStatusDtoList.forEach(siteStatus -> {
            logger.info("id:"+siteStatus.getSiteId());
            logger.info("이름:"+siteStatus.getSiteName());
            logger.info("지역:"+siteStatus.getLocationName());
            logger.info("수거량:"+siteStatus.getCollectedAmount());
            logger.info("수거통수:"+siteStatus.getCollectedCanCount());
        });
    }

    @After
    public void cleanup() {



    }


    @Test
    public void saveNewSite() {
        // given
        String siteName = "피자스쿨";
        String location = "약수";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localDate = LocalDateTime.parse("20221022000000",formatter);
        logger.info("localDateTime:"+localDate.format(formatter));

    }
}
