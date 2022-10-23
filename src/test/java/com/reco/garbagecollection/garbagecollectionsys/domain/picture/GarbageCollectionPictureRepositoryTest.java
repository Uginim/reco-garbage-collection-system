package com.reco.garbagecollection.garbagecollectionsys.domain.picture;

import com.reco.garbagecollection.garbagecollectionsys.domain.gc.history.GarbageCollectionHistoryRepository;
import com.reco.garbagecollection.garbagecollectionsys.domain.gc.picture.GarbageCollectionPicture;
import com.reco.garbagecollection.garbagecollectionsys.domain.gc.picture.GarbageCollectionPictureRepository;
import com.reco.garbagecollection.garbagecollectionsys.domain.gc.site.GarbageCollectionSite;
import com.reco.garbagecollection.garbagecollectionsys.domain.history.GarbageCollectionHistoryRepositoryTest;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GarbageCollectionPictureRepositoryTest {
    LocalDateTime testTime = LocalDateTime.now();
    private final Logger logger = LoggerFactory.getLogger(GarbageCollectionHistoryRepositoryTest.class);

    @Autowired
    private GarbageCollectionPictureRepository pictureRepository;



    @Test
    public void load_picturs() {
        List<GarbageCollectionPicture> pictures = pictureRepository.findAll();
        pictures.forEach(picture -> {
            logger.info("id:"+picture.getPictureId());
            logger.info(picture.getFilename());
            logger.info(picture.getFilenameExtension());
        });
    }
}
