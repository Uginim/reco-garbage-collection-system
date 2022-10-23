
/* ���ž��� */
CREATE TABLE `garbage_collection_site` (
  `gc_site_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '����ID',
  `site_name` varchar(256) NOT NULL COMMENT '�����',
  `location_name` varchar(256) NOT NULL COMMENT '������',
  `contract_start_date` date DEFAULT NULL COMMENT '��������',
  `owner_name` varchar(100) DEFAULT NULL COMMENT '������̸�',
  PRIMARY KEY (`gc_site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='���ž���';


/* �����̷� */
CREATE TABLE `garbage_collection_history` (
  `gc_history_id` bigint(20) unsigned NOT NULL COMMENT '�̷�ID',
  `gc_site_id` bigint(20) unsigned DEFAULT NULL COMMENT '����ID',
  `collected_amount` bigint(20) DEFAULT 0 COMMENT '���ŷ�',
  `collected_trash_can_count` bigint(20) DEFAULT 0 COMMENT '�������',
  `gc_attachment_picture_count` bigint(20) DEFAULT 0 COMMENT '÷�λ�������',
  `gc_special_note` varchar(2000) DEFAULT NULL COMMENT 'Ư�̻���',
  `collected_time` datetime NOT NULL COMMENT '���Žð�',
  PRIMARY KEY (`gc_history_id`),
  KEY `garbage_collection_history_FK` (`gc_site_id`),
  CONSTRAINT `garbage_collection_history_FK` FOREIGN KEY (`gc_site_id`) REFERENCES `garbage_collection_site` (`gc_site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='�����̷�';


/* ���Ż��� */
CREATE TABLE `garbage_collection_picture` (
  `picture_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '����ID',
  `filename` varchar(200) NOT NULL COMMENT '���ϸ�',
  `filename_extension` enum('jpg','jpeg','png','gif','bmp','tif','tiff','raw','rle','dib') DEFAULT NULL COMMENT '����Ȯ����',
  `gc_history_id` bigint(20) unsigned DEFAULT NULL COMMENT '�����̷�ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '�����ð�',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '�����ð�',
  PRIMARY KEY (`picture_id`),
  KEY `garbage_collection_picture_gc_history_id_IDX` (`gc_history_id`,`picture_id`) USING BTREE,
  CONSTRAINT `garbage_collection_picture_FK` FOREIGN KEY (`gc_history_id`) REFERENCES `garbage_collection_history` (`gc_history_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='���Ż���';