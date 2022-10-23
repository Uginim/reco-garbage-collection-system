/* truncate를 하려면 FOREIGN_KEY_CHECKS를 0으로 셋팅해야함.
 * 아래 3줄의 주석을 해제하고 실행할 것
 * */
-- SET FOREIGN_KEY_CHECKS = 0;
-- truncate table garbage_collection_site;
-- SET FOREIGN_KEY_CHECKS = 1;
insert into garbage_collection_site
(gc_site_id, site_name, location_name, contract_start_date, owner_name)
values
(1,'맘스터치','강남','2021-01-01','김맘스'),
(2,'롯데리아','서초','2021-11-01','박롯데'),
(3,'베스킨라빈스','역삼','2021-11-05','베스킨'),
(4,'본죽','삼성','2021-11-03','최본죽');

/*auto_increment값을 입력된 데이터 개수 이후로 변경*/
alter table garbage_collection_site auto_increment = 5;
commit;


/* truncate를 하려면 FOREIGN_KEY_CHECKS를 0으로 셋팅해야함.
 * 아래 3줄의 주석을 해제하고 실행할 것
 * */
-- set FOREIGN_KEY_CHECKS = 0;
-- truncate table  garbage_collection_history;
-- set FOREIGN_KEY_CHECKS = 1;

insert into garbage_collection_history
(gc_hitory_ID, gc_site_id, gc_amount, gc_trash_can_count, gc_attachment_picture_count, gc_special_note, real_gc_time)
values
(1, 1, 450, 4, 3, '새벽 수거 해야함', '2021-11-03 01:15:13'),
(2, 2, 110, 1, 1, '없음', '2021-11-03 13:25:36'),
(3, 3, 362, 3, 2, '하루 2번 수거', '2021-11-03 12:25:14'),
(4, 4, 651, 6, 1, '매일 수거', '2021-11-04 01:10:13')
;

/*auto_increment값을 입력된 데이터 개수 이후로 변경*/
alter table garbage_collection_history  auto_increment = 5;
commit;


/* truncate를 하려면 FOREIGN_KEY_CHECKS를 0으로 셋팅해야함.
 * 아래 3줄의 주석을 해제하고 실행할 것
 * */
-- set FOREIGN_KEY_CHECKS = 0;
-- truncate table  garbage_collection_picture;
-- set FOREIGN_KEY_CHECKS = 1;

insert into garbage_collection_picture
(picture_id, filename, filename_extension, gc_history_id, create_time, update_time)
values
(1, '맘스터치_01', 'jpg', 1, '2021-11-03 01:15:13', '2021-11-03 01:15:13'),
(2, '맘스터치_02', 'jpg', 1, '2021-11-03 01:15:14', '2021-11-03 01:15:14'),
(3, '맘스터치_03', 'jpg', 1, '2021-11-03 01:15:15', '2021-11-03 01:15:15'),
(4, '롯데리아_01', 'png', 2, '2021-11-03 13:25:36', '2021-11-03 13:25:36'),
(5, '베스킨라빈스_01', 'jpeg', 3, '2021-11-03 12:25:14', '2021-11-03 12:25:14'),
(6, '베스킨라빈스_02', 'jpeg', 3, '2021-11-03 12:25:20', '2021-11-03 12:25:20'),
(7, '본죽_01', 'jpg', 4, '2021-11-04 01:10:13', '2021-11-04 01:10:13')
;

/*auto_increment값을 입력된 데이터 개수 이후로 변경*/
alter table garbage_collection_picture  auto_increment = 8;
commit;
