drop sequence userinfo_id;
create sequence userinfo_id;
drop table userinfo cascade constraints;
create table userinfo(
	id number primary key,
	userid varchar2(100) not null,
	password varchar2(100)
);
insert into userinfo values(userinfo_id.nextval,'zhenlei','zhenlei');
insert into userinfo values(userinfo_id.nextval,'estore','estore');
commit;
create sequence product_id;
drop table product cascade constraints;
create table product(
	id number primary key,
	name varchar2(100),
	price number,
	author varchar2(100),
	publish varchar2(100),
	page number,
	category varchar2(100),
	content varchar2(500),
	image varchar2(100)
);
insert into product values(product_id.nextval,'corejava',69.00,'xx','清华出版社',986,'计算机','这是一部书','image/xx.gif');
insert into product values(product_id.nextval,'corejava2',69.00,'xx2','清华出版社2',987,'计算机','这是2部书','image/xx2.gif');
-----orderline
create sequence orderline_id;
drop table orderline cascade constraints;
create table orderline(
	id number primary key,
	productid number,
	productname varchar2(100),
	price number,
	counts number,
	total number,
	orderformid number references orderform(id)
);
-----orderform
drop table orderform cascade constraints;
create table orderform(
	id number primary key,
	total number,
	status varchar2(100),
	payway varchar2(100),
	usercode number references userinfo(id)
);


--我的
-- ----------------------------
-- Table structure for USERINFO
-- ----------------------------
DROP TABLE "SYSTEM"."USERINFO";
CREATE TABLE "SYSTEM"."USERINFO" (
"ID" NUMBER NOT NULL ,
"USERID" VARCHAR2(100 BYTE) NOT NULL ,
"PASSWORD" VARCHAR2(100 BYTE) NULL ,
"department" VARCHAR2(255 BYTE) NULL ,
"lianxi1" VARCHAR2(255 BYTE) NULL ,
"lianxi2" VARCHAR2(255 BYTE) NULL ,
"youbian" VARCHAR2(255 BYTE) NULL ,
"tel" VARCHAR2(100 BYTE) NULL ,
"telphone" VARCHAR2(100 BYTE) NULL ,
"shouji" VARCHAR2(255 BYTE) NULL ,
"email" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of USERINFO
-- ----------------------------
INSERT INTO "SYSTEM"."USERINFO" VALUES ('1', 

'admin', 'admin', null, null, null, null, null, 

null, null, null);
INSERT INTO "SYSTEM"."USERINFO" VALUES ('2', 

'estore', 'estore', null, null, null, null, 

null, null, null, null);
INSERT INTO "SYSTEM"."USERINFO" VALUES ('21', 

'aaaaaa', 'aaaaaa', null, null, null, '0', '0', 

'0', '0', '0');
INSERT INTO "SYSTEM"."USERINFO" VALUES ('22', 

'caohao', 'caohao', null, null, null, '0', '0', 

'0', '0', '0');
INSERT INTO "SYSTEM"."USERINFO" VALUES ('23', 

'æ¹æ', 'caohao', null, null, null, '0', '0', 

'0', '0', '0');
INSERT INTO "SYSTEM"."USERINFO" VALUES ('24', '

才好', 'aaaaaa', null, null, null, '0', '0', 

'0', '0', '0');
INSERT INTO "SYSTEM"."USERINFO" VALUES ('25', '

曹昊', 'aaaaaa', null, null, null, '0', '0', 

'0', '0', '0');
INSERT INTO "SYSTEM"."USERINFO" VALUES ('26', 

'nishiwo', 'nishiwo', null, 'aadfafd', 

'afdasfdas', '111123', '2131213', '2434224', 

'424242', '111123');
INSERT INTO "SYSTEM"."USERINFO" VALUES ('27', 

'1111111', '111111', null, 'sdaf', 'fasfds', 

'111111', '11111', '111', '11', '111111');
INSERT INTO "SYSTEM"."USERINFO" VALUES ('41', 

'dsf', '123111', null, '111', '11', '111', 

'11111', '111', '111', '111');
INSERT INTO "SYSTEM"."USERINFO" VALUES ('42', 

'dsfk', '111111', null, '111', '11', '111', 

'11111', '111', '111', '111');

-- ----------------------------
-- Indexes structure for table USERINFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table USERINFO
-- ----------------------------
ALTER TABLE "SYSTEM"."USERINFO" ADD CHECK 

("USERID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table USERINFO
-- ----------------------------
ALTER TABLE "SYSTEM"."USERINFO" ADD PRIMARY KEY 

("ID");



DROP TABLE "SYSTEM"."PRODUCT";
CREATE TABLE "SYSTEM"."PRODUCT" (
"ID" NUMBER NOT NULL ,
"NAME" VARCHAR2(100 BYTE) NULL ,
"PRICE" NUMBER NULL ,
"AUTHOR" VARCHAR2(100 BYTE) NULL ,
"PUBLISH" VARCHAR2(100 BYTE) NULL ,
"PAGE" NUMBER NULL ,
"CATEGORY" VARCHAR2(100 BYTE) NULL ,
"CONTENT" VARCHAR2(500 BYTE) NULL ,
"IMAGE" VARCHAR2(100 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of PRODUCT
-- ----------------------------
INSERT INTO "SYSTEM"."PRODUCT" VALUES ('1', 'corejava', '69', 'zzf', 'dd', '366', 'aaa', 'fsafsaf', 'fsaf');
INSERT INTO "SYSTEM"."PRODUCT" VALUES ('2', 'jini', '33', 'zzf', 'jj', '999', '99', '99', 'dsa');
INSERT INTO "SYSTEM"."PRODUCT" VALUES ('9', 'shujulu', '88', 'zzgf', 'huhu', '888', '88', '88', 'dsaf');

-- ----------------------------
-- Indexes structure for table PRODUCT
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table PRODUCT
-- ----------------------------
ALTER TABLE "SYSTEM"."PRODUCT" ADD PRIMARY KEY ("ID");
