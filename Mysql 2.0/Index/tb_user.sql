create table tb_user(
	id int primary key auto_increment comment '主键',
	name varchar(50) not null comment '用户名',
	phone varchar(11) not null comment '手机号',
	email varchar(100) comment '邮箱',
	profession varchar(11) comment '专业',
	age tinyint unsigned comment '年龄',
	gender char(1) comment '性别 , 1: 男, 2: 女',
	status char(1) comment '状态',
	createtime datetime comment '创建时间'
) comment '系统用户表';



INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Jack', '17799990000', 'jack123@163.com', '软件工程', 23, '1', '6', '2001-02-02 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Joe', '17799990001', 'joe100@qq.com', '通讯工程', 33, '1', '0', '2001-03-05 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Alice', '17799990002', 'alice_a@example.com', '计算机科学', 25, '2', '1', '2002-01-01 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Bob', '17799990003', 'bob.smith@gmail.com', '电子工程', 22, '1', '6', '2002-02-14 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Charlie', '17799990004', 'charlie123@outlook.com', '人工智能', 30, '1', '0', '2003-03-15 00:00:00');  

INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Zoe', '17799990027', 'zoe_z@example.net', '数据科学', 28, '2', '1', '2023-04-01 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('David', '17799990005', 'david_d@domain.com', '机械设计', 29, '1', '1', '2004-04-20 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Emily', '17799990006', 'emily_e@mail.com', '化学工程', 21, '2', '6', '2005-05-10 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Frank', '17799990007', 'frank_f@gmail.com', '生物科学', 32, '1', '0', '2006-06-15 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Grace', '17799990008', 'grace_g@example.com', '环境科学', 26, '2', '1', '2007-07-07 00:00:00');  

INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Henry', '17799990009', 'henry_h@domain.org', '土木工程', 31, '1', '6', '2008-08-08 00:00:00');    
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Isabella', '17799990010', 'isabella_i@school.edu', '教育学', 24, '2', '0', '2009-09-09 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('James', '17799990011', 'james_j@company.com', '商学', 34, '1', '1', '2010-10-10 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Katie', '17799990012', 'katie_k@email.net', '医学', 27, '2', '6', '2011-11-11 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Lucas', '17799990013', 'lucas_l@school.edu', '法律', 30, '1', '0', '2012-12-12 00:00:00');  

INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Mia', '17799990014', 'mia_m@mail.com', '物理', 23, '2', '1', '2013-01-13 00:00:00');    
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Nathan', '17799990015', '17775292_mun@domain.com', '天文学', 35, '1', '6', '2014-02-14 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Oliver', '17799990016', '1777505_o@gmail.com', '地质学', 28, '2', '0', '2014-02-14 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Zebediah', '17799990028', 'zebediah_z@mail.com', '语言学', 30, '1', '6', '2022-01-25 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Aaron', '17799990029', 'aaron_a@example.net', '护理学', 28, '1', '2', '2021-01-25 00:00:00');

INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Peter', '17799990017', 'peter_p@mail.com', '市场营销', 29, '1', '1', '2015-03-15 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Quincy', '17799990018', 'quincy_q@example.com', '心理学', 22, '2', '6', '2016-04-16 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Rachel', '17799990019', 'rachel_r@school.edu', '历史学', 33, '1', '0', '2017-05-17 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Samuel', '17799990020', 'samuel_s@domain.com', '哲学', 25, '2', '1', '2018-06-18 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Thomas', '17799990021', 'thomas_t@gmail.com', '体育学', 31, '1', '6', '2019-07-19 00:00:00');  
  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Ursula', '17799990022', 'ursula_u@mail.com', '文学', 26, '2', '0', '2020-08-20 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Victor', '17799990023', 'victor_v@example.com', '政治学', 32, '1', '1', '2021-09-21 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Willow', '17799990024', 'willow_w@school.edu', '艺术', 27, '2', '6', '2022-10-22 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Xavier', '17799990025', 'xavier_x@domain.org', '建筑学', 34, '1', '0', '2023-11-23 00:00:00');  
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('Yasmin', '17799990026', 'yasmin_y@gmail.com', '经济学', 24, '2', '1', '2024-12-24 00:00:00');  


