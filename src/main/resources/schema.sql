
/* 수거업장 */
CREATE TABLE `garbage_collection_site` (
  `gc_site_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '업장ID',
  `site_name` varchar(256) NOT NULL COMMENT '업장명',
  `location_name` varchar(256) NOT NULL COMMENT '지역명',
  `contract_start_date` date DEFAULT NULL COMMENT '계약시작일',
  `owner_name` varchar(100) DEFAULT NULL COMMENT '사업자이름',
  PRIMARY KEY (`gc_site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='수거업장';


/* 수거이력 */
CREATE TABLE `garbage_collection_history` (
  `gc_history_id` bigint(20) unsigned NOT NULL COMMENT '이력ID',
  `gc_site_id` bigint(20) unsigned DEFAULT NULL COMMENT '업장ID',
  `collected_amount` bigint(20) DEFAULT 0 COMMENT '수거량',
  `collected_trash_can_count` bigint(20) DEFAULT 0 COMMENT '수거통수',
  `gc_attachment_picture_count` bigint(20) DEFAULT 0 COMMENT '첨부사진개수',
  `gc_special_note` varchar(2000) DEFAULT NULL COMMENT '특이사항',
  `collected_time` datetime NOT NULL COMMENT '수거시간',
  PRIMARY KEY (`gc_history_id`),
  KEY `garbage_collection_history_FK` (`gc_site_id`),
  CONSTRAINT `garbage_collection_history_FK` FOREIGN KEY (`gc_site_id`) REFERENCES `garbage_collection_site` (`gc_site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='수거이력';


/* 수거사진 */
CREATE TABLE `garbage_collection_picture` (
  `picture_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '사진ID',
  `filename` varchar(200) NOT NULL COMMENT '파일명',
  `filename_extension` enum('jpg','jpeg','png','gif','bmp','tif','tiff','raw','rle','dib') DEFAULT NULL COMMENT '파일확장자',
  `gc_history_id` bigint(20) unsigned DEFAULT NULL COMMENT '수거이력ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '생성시간',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '수정시간',
  PRIMARY KEY (`picture_id`),
  KEY `garbage_collection_picture_gc_history_id_IDX` (`gc_history_id`,`picture_id`) USING BTREE,
  CONSTRAINT `garbage_collection_picture_FK` FOREIGN KEY (`gc_history_id`) REFERENCES `garbage_collection_history` (`gc_history_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='수거사진';