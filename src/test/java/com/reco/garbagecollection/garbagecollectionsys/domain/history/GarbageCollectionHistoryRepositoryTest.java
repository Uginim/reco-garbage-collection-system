package com.reco.garbagecollection.garbagecollectionsys.domain.history;

import com.reco.garbagecollection.garbagecollectionsys.domain.gc.history.GarbageCollectionHistory;
import com.reco.garbagecollection.garbagecollectionsys.domain.gc.history.GarbageCollectionHistoryRepository;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GarbageCollectionHistoryRepositoryTest {
    LocalDateTime testTime = LocalDateTime.now();
    private final Logger logger = LoggerFactory.getLogger(GarbageCollectionHistoryRepositoryTest.class);

    @Autowired
    private GarbageCollectionHistoryRepository historyRepository;

    @After
    public void cleanUp(){

    }

    @Test
    @Transactional
    public void load_history() {
//        System.out.printf("hello_test");
        logger.info("test");
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("YYYY-mm-dd HH:MM:SS.LLL");
        List<GarbageCollectionHistory> histories = historyRepository.findAll();
        histories.stream().forEach(history->{
            System.out.printf("%d %d %s %s %d%n",history.getGcHistoryId(),history.getCollectedAmount()
                    ,history.getCollectedTime().format(formatter)
                    ,history.getSite().getSiteName()
                    ,history.getPictures().size()

            );
        });
        logger.info("size: "+histories.size());

    }

    @Test
    @Transactional
    public void loadHistoryWithDate() {
        String dateStr = "2021-11-03";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-ddHHmmss");
        LocalDateTime searchStartDateTime = LocalDateTime.parse(dateStr+"000000",format);
        LocalDateTime endDateTime = searchStartDateTime.plusDays(1);
        historyRepository.findAllByCollectedTimeGreaterThanEqualAndCollectedTimeLessThan(searchStartDateTime,endDateTime).stream()
            .forEach(garbageCollectionHistory ->{
                 logger.info("date : "+garbageCollectionHistory.getCollectedTime());
                 logger.info("date : "+garbageCollectionHistory.getGcSpecialNote());
            });
    }

}
