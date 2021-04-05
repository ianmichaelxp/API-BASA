--------------------------------------------------------
--  Arquivo criado - Segunda-feira-Abril-05-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence HIBERNATE_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "IANMICHAEL"."HIBERNATE_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence PROCESSO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "IANMICHAEL"."PROCESSO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 42 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence TKO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "IANMICHAEL"."TKO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table PROCESSO
--------------------------------------------------------

  CREATE TABLE "IANMICHAEL"."PROCESSO" 
   (	"ID" NUMBER, 
	"NUMERO" VARCHAR2(19 CHAR), 
	"DATA_CADASTRO" TIMESTAMP (6), 
	"SEGREDO_JUSTICA" VARCHAR2(20 BYTE), 
	"SITUACAO" VARCHAR2(20 BYTE), 
	"QTD_PARTES" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into IANMICHAEL.PROCESSO
SET DEFINE OFF;
Insert into IANMICHAEL.PROCESSO (ID,NUMERO,DATA_CADASTRO,SEGREDO_JUSTICA,SITUACAO,QTD_PARTES) values ('23','5555555590123456789',to_timestamp('04/04/21 18:20:28,587000000','DD/MM/RR HH24:MI:SSXFF'),'PUBLICO','JULGADO','5');
Insert into IANMICHAEL.PROCESSO (ID,NUMERO,DATA_CADASTRO,SEGREDO_JUSTICA,SITUACAO,QTD_PARTES) values ('1','1114567890123456789',to_timestamp('05/01/20 08:00:00,000000000','DD/MM/RR HH24:MI:SSXFF'),'PUBLICO','JULGADO','5');
--------------------------------------------------------
--  DDL for Index PK_PROCESSO_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "IANMICHAEL"."PK_PROCESSO_ID" ON "IANMICHAEL"."PROCESSO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger PROCESSO_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "IANMICHAEL"."PROCESSO_TRG" 
BEFORE INSERT ON PROCESSO 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PROCESSO_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "IANMICHAEL"."PROCESSO_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Procedure SP_PROCESSO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "IANMICHAEL"."SP_PROCESSO" 
(p_segredo_justica IN VARCHAR2, o_segredo_justica OUT SYS_REFCURSOR)

IS

BEGIN

--dbms_output.put_line('Hello 1');

OPEN o_segredo_justica FOR select * from processo where segredo_justica = p_segredo_justica;

--dbms_output.put_line('Hello 2');

EXCEPTION WHEN OTHERS THEN

--dbms_output.put_line('Hello  3');

OPEN o_segredo_justica FOR SELECT 'something wrong' as error from dual;
END sp_processo;

/
--------------------------------------------------------
--  DDL for Procedure SP_SITUACAO_PROCESSO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "IANMICHAEL"."SP_SITUACAO_PROCESSO" 
(p_situacao IN VARCHAR2, o_situacao OUT SYS_REFCURSOR)

IS
BEGIN

OPEN o_situacao FOR select * from processo where situacao = p_situacao;

EXCEPTION WHEN OTHERS THEN

OPEN o_situacao FOR SELECT 'Ocorreu um erro.' as error from dual;
END sp_situacao_processo;

/
--------------------------------------------------------
--  Constraints for Table PROCESSO
--------------------------------------------------------

  ALTER TABLE "IANMICHAEL"."PROCESSO" ADD CONSTRAINT "PK_PROCESSO_ID" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "IANMICHAEL"."PROCESSO" MODIFY ("NUMERO" NOT NULL ENABLE);
  ALTER TABLE "IANMICHAEL"."PROCESSO" MODIFY ("DATA_CADASTRO" NOT NULL ENABLE);
  ALTER TABLE "IANMICHAEL"."PROCESSO" MODIFY ("SEGREDO_JUSTICA" NOT NULL ENABLE);
  ALTER TABLE "IANMICHAEL"."PROCESSO" MODIFY ("SITUACAO" NOT NULL ENABLE);
  ALTER TABLE "IANMICHAEL"."PROCESSO" MODIFY ("QTD_PARTES" NOT NULL ENABLE);
