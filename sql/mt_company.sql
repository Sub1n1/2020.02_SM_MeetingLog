--------------------------------------------------------
--  파일이 생성됨 - 목요일-2월-27-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MT_COMPANY
--------------------------------------------------------

  CREATE TABLE "HR"."MT_COMPANY" 
   (	"SEQ" NUMBER, 
	"NAME" VARCHAR2(50 BYTE), 
	"CODE" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HR.MT_COMPANY
SET DEFINE OFF;
Insert into HR.MT_COMPANY (SEQ,NAME,CODE) values (1,'스마트미디어인재개발원','SM0123');
Insert into HR.MT_COMPANY (SEQ,NAME,CODE) values (2,'전남대학교','JU0123');
