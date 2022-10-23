/* truncate�� �Ϸ��� FOREIGN_KEY_CHECKS�� 0���� �����ؾ���. 
 * �Ʒ� 3���� �ּ��� �����ϰ� ������ ��
 * */
-- SET FOREIGN_KEY_CHECKS = 0;
-- truncate table garbage_collection_site; 
-- SET FOREIGN_KEY_CHECKS = 1; 
insert into garbage_collection_site
(gc_site_id, site_name, location_name, contract_start_date, owner_name)
values 
(1,'������ġ','����','2021-01-01','�踾��'),
(2,'�Ե�����','����','2021-11-01','�ڷԵ�'),
(3,'����Ų���','����','2021-11-05','����Ų'),
(4,'����','�Ｚ','2021-11-03','�ֺ���');

/*auto_increment���� �Էµ� ������ ���� ���ķ� ����*/
alter table garbage_collection_site auto_increment = 5;  
commit;


/* truncate�� �Ϸ��� FOREIGN_KEY_CHECKS�� 0���� �����ؾ���. 
 * �Ʒ� 3���� �ּ��� �����ϰ� ������ ��
 * */
-- set FOREIGN_KEY_CHECKS = 0;
-- truncate table  garbage_collection_history;
-- set FOREIGN_KEY_CHECKS = 1;

insert into garbage_collection_history
(gc_hitory_ID, gc_site_id, gc_amount, gc_trash_can_count, gc_attachment_picture_count, gc_special_note, real_gc_time)
values 
(1, 1, 450, 4, 3, '���� ���� �ؾ���', '2021-11-03 01:15:13'),
(2, 2, 110, 1, 1, '����', '2021-11-03 13:25:36'),
(3, 3, 362, 3, 2, '�Ϸ� 2�� ����', '2021-11-03 12:25:14'),
(4, 4, 651, 6, 1, '���� ����', '2021-11-04 01:10:13')
;

/*auto_increment���� �Էµ� ������ ���� ���ķ� ����*/
alter table garbage_collection_history  auto_increment = 5;
commit;


/* truncate�� �Ϸ��� FOREIGN_KEY_CHECKS�� 0���� �����ؾ���. 
 * �Ʒ� 3���� �ּ��� �����ϰ� ������ ��
 * */
-- set FOREIGN_KEY_CHECKS = 0;
-- truncate table  garbage_collection_picture;
-- set FOREIGN_KEY_CHECKS = 1;

insert into garbage_collection_picture
(picture_id, filename, filename_extension, gc_history_id, create_time, update_time)
values 
(1, '������ġ_01', 'jpg', 1, '2021-11-03 01:15:13', '2021-11-03 01:15:13'),
(2, '������ġ_02', 'jpg', 1, '2021-11-03 01:15:14', '2021-11-03 01:15:14'),
(3, '������ġ_03', 'jpg', 1, '2021-11-03 01:15:15', '2021-11-03 01:15:15'),
(4, '�Ե�����_01', 'png', 2, '2021-11-03 13:25:36', '2021-11-03 13:25:36'),
(5, '����Ų���_01', 'jpeg', 3, '2021-11-03 12:25:14', '2021-11-03 12:25:14'),
(6, '����Ų���_02', 'jpeg', 3, '2021-11-03 12:25:20', '2021-11-03 12:25:20'),
(7, '����_01', 'jpg', 4, '2021-11-04 01:10:13', '2021-11-04 01:10:13')
;

/*auto_increment���� �Էµ� ������ ���� ���ķ� ����*/
alter table garbage_collection_picture  auto_increment = 8;
commit;
