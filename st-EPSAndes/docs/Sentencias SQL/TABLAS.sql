--------------------------------------------------------
-- Archivo creado  - domingo-septiembre-29-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_ORDEN
--------------------------------------------------------

   CREATE SEQUENCE  "ISIS2304B101920"."SEQ_ORDEN"  MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE   ;
--------------------------------------------------------
--  DDL for Table ADMINISTRADOR
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."ADMINISTRADOR" 
   (	"CARACTERISTICAS" VARCHAR2(255 BYTE), 
	"IDIPS" NUMBER, 
	"IDSERVSALUD" NUMBER, 
	"IDUSUARIO" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table ATIENDEN
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."ATIENDEN" 
   (	"IDMEDICO" NUMBER, 
	"IDUSUARIO" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table CONSULTACONTROL
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."CONSULTACONTROL" 
   (	"IDCONSCONT" NUMBER, 
	"EFECTIVIDAD" VARCHAR2(255 BYTE), 
	"RESULTADO" VARCHAR2(255 BYTE), 
	"TRATAMIENTO" VARCHAR2(255 BYTE), 
	"IDHOPITALIZ" NUMBER, 
	"IDSERVSALUD" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table CONSULTAESPECIALISTA
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."CONSULTAESPECIALISTA" 
   (	"IDCONSESP" NUMBER, 
	"IDMEDICO" NUMBER, 
	"DOLENCIA" VARCHAR2(255 BYTE), 
	"IDSERVSALUD" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table CONSULTAMEDICO
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."CONSULTAMEDICO" 
   (	"IDCONSMEDICA" NUMBER, 
	"DOLENCIA" VARCHAR2(255 BYTE), 
	"TIPO" VARCHAR2(255 BYTE), 
	"IDSERVSALUD" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table CONSULTAURGENCIAS
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."CONSULTAURGENCIAS" 
   (	"IDCONSURGEN" NUMBER, 
	"TRIAGE" VARCHAR2(255 BYTE), 
	"IDMEDICO" NUMBER, 
	"DADAALTA" NUMBER, 
	"IDSERVSALUD" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table EMPLEADO
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."EMPLEADO" 
   (	"TIPO" VARCHAR2(255 BYTE), 
	"NOMBRE" VARCHAR2(255 BYTE), 
	"IDEMPLEADO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table EXAMENDIAGNOSTICO
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."EXAMENDIAGNOSTICO" 
   (	"IDEXDIAGNOSTICO" NUMBER, 
	"RESULTADO" VARCHAR2(255 BYTE), 
	"DIAGNOSTICO" VARCHAR2(255 BYTE), 
	"IDSERVSALUD" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table GERENTE
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."GERENTE" 
   (	"REPORTE" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table HOSPITALIZACION
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."HOSPITALIZACION" 
   (	"IDHOSP" NUMBER, 
	"IPS" NUMBER, 
	"ESTADOSALUD" VARCHAR2(255 BYTE), 
	"VISITAS" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table IPS
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."IPS" 
   (	"IDIPS" NUMBER, 
	"TIPO" VARCHAR2(255 BYTE), 
	"LOCALIZACION" VARCHAR2(255 BYTE), 
	"IDSERVSALUD" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table MEDICO
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."MEDICO" 
   (	"IDMEDICO" NUMBER, 
	"ESPECIALIDAD" VARCHAR2(255 BYTE), 
	"NREGMEDICO" NUMBER, 
	"IDEMPLEADO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table ORDEN
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."ORDEN" 
   (	"IDORDEN" NUMBER, 
	"RMEDICA" VARCHAR2(20 BYTE), 
	"FECHA" DATE, 
	"IDMEDICO" NUMBER, 
	"IDUSUARIO" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table ORDENDETAIL
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."ORDENDETAIL" 
   (	"ORDENID" NUMBER, 
	"SERVICIOID" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table PROCEDIMIENTOSESPECIALIZADOS
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."PROCEDIMIENTOSESPECIALIZADOS" 
   (	"IDPROCESP" NUMBER, 
	"TIPO" VARCHAR2(255 BYTE), 
	"EQUIPOS" VARCHAR2(255 BYTE), 
	"IDSERVSALUD" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table RECEPCIONISTA
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."RECEPCIONISTA" 
   (	"IDEMPLEADO" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table SERVICIOSALUD
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."SERVICIOSALUD" 
   (	"IDSERVSALUD" NUMBER, 
	"IDIPS" NUMBER, 
	"CAPACIDAD" NUMBER, 
	"HORARIO" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table TERAPIA
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."TERAPIA" 
   (	"IDTERAPIA" NUMBER, 
	"TIPO" VARCHAR2(255 BYTE), 
	"NSESIONES" NUMBER, 
	"IDSERVSALUD" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table TRABAJAN
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."TRABAJAN" 
   (	"IDMEDICO" NUMBER, 
	"IDIPS" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table USAN
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."USAN" 
   (	"IDUSUARIO" NUMBER, 
	"IDSERVSALUD" NUMBER, 
	"ESTADO" NUMBER, 
	"FECHARESERVA" DATE, 
	"FECHAATENCION" DATE, 
	"IDRECEPCIONISTA" NUMBER, 
	"IDORDEN" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "ISIS2304B101920"."USUARIO" 
   (	"NIDENTIFICACION" NUMBER, 
	"NOMBRE" VARCHAR2(255 BYTE), 
	"TIPOID" VARCHAR2(255 BYTE), 
	"FECHANACIMIENTO" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index ATIENDEN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."ATIENDEN_PK" ON "ISIS2304B101920"."ATIENDEN" ("IDMEDICO", "IDUSUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index CONSULTACONTROL_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."CONSULTACONTROL_PK" ON "ISIS2304B101920"."CONSULTACONTROL" ("IDCONSCONT") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index CONSULTAMEDICO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."CONSULTAMEDICO_PK" ON "ISIS2304B101920"."CONSULTAMEDICO" ("IDCONSMEDICA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index CONSULTAURGENCIAS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."CONSULTAURGENCIAS_PK" ON "ISIS2304B101920"."CONSULTAURGENCIAS" ("IDCONSURGEN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index EMPLEADO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."EMPLEADO_PK" ON "ISIS2304B101920"."EMPLEADO" ("IDEMPLEADO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index EXAMENDIAGNOSTICO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."EXAMENDIAGNOSTICO_PK" ON "ISIS2304B101920"."EXAMENDIAGNOSTICO" ("IDEXDIAGNOSTICO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index HOSPITALIZACION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."HOSPITALIZACION_PK" ON "ISIS2304B101920"."HOSPITALIZACION" ("IDHOSP") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index IPS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."IPS_PK" ON "ISIS2304B101920"."IPS" ("IDIPS") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index MEDICO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."MEDICO_PK" ON "ISIS2304B101920"."MEDICO" ("IDMEDICO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index PROCEDIMIENTOSESPECIALIZAD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."PROCEDIMIENTOSESPECIALIZAD_PK" ON "ISIS2304B101920"."PROCEDIMIENTOSESPECIALIZADOS" ("IDPROCESP") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index RECEPCIONISTA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."RECEPCIONISTA_PK" ON "ISIS2304B101920"."RECEPCIONISTA" ("IDEMPLEADO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index REMISIONESPECIALISTA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."REMISIONESPECIALISTA_PK" ON "ISIS2304B101920"."CONSULTAESPECIALISTA" ("IDCONSESP") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index SERVICIOSALUD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."SERVICIOSALUD_PK" ON "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index TERAPIA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."TERAPIA_PK" ON "ISIS2304B101920"."TERAPIA" ("IDTERAPIA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index TRABAJAN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."TRABAJAN_PK" ON "ISIS2304B101920"."TRABAJAN" ("IDMEDICO", "IDIPS") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index USAN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."USAN_PK" ON "ISIS2304B101920"."USAN" ("IDUSUARIO", "IDSERVSALUD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index USUARIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."USUARIO_PK" ON "ISIS2304B101920"."USUARIO" ("NIDENTIFICACION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index VISITA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304B101920"."VISITA_PK" ON "ISIS2304B101920"."ORDEN" ("IDORDEN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  Constraints for Table ATIENDEN
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."ATIENDEN" MODIFY ("IDUSUARIO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."ATIENDEN" MODIFY ("IDMEDICO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."ATIENDEN" ADD CONSTRAINT "ATIENDEN_PK" PRIMARY KEY ("IDMEDICO", "IDUSUARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CONSULTACONTROL
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."CONSULTACONTROL" MODIFY ("IDSERVSALUD" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTACONTROL" MODIFY ("IDHOPITALIZ" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTACONTROL" MODIFY ("TRATAMIENTO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTACONTROL" MODIFY ("RESULTADO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTACONTROL" MODIFY ("EFECTIVIDAD" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTACONTROL" MODIFY ("IDCONSCONT" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTACONTROL" ADD CONSTRAINT "CONSULTACONTROL_PK" PRIMARY KEY ("IDCONSCONT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CONSULTAESPECIALISTA
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."CONSULTAESPECIALISTA" MODIFY ("IDCONSESP" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTAESPECIALISTA" MODIFY ("IDMEDICO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTAESPECIALISTA" ADD CONSTRAINT "REMISIONESPECIALISTA_PK" PRIMARY KEY ("IDCONSESP")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CONSULTAMEDICO
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."CONSULTAMEDICO" MODIFY ("DOLENCIA" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTAMEDICO" MODIFY ("IDSERVSALUD" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTAMEDICO" MODIFY ("IDCONSMEDICA" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTAMEDICO" ADD CONSTRAINT "CONSULTAMEDICO_PK" PRIMARY KEY ("IDCONSMEDICA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CONSULTAURGENCIAS
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."CONSULTAURGENCIAS" MODIFY ("DADAALTA" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTAURGENCIAS" MODIFY ("IDMEDICO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTAURGENCIAS" MODIFY ("TRIAGE" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTAURGENCIAS" MODIFY ("IDCONSURGEN" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."CONSULTAURGENCIAS" ADD CONSTRAINT "CONSULTAURGENCIAS_PK" PRIMARY KEY ("IDCONSURGEN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EMPLEADO
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."EMPLEADO" MODIFY ("IDEMPLEADO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."EMPLEADO" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."EMPLEADO" MODIFY ("TIPO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."EMPLEADO" ADD CONSTRAINT "EMPLEADO_PK" PRIMARY KEY ("IDEMPLEADO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EXAMENDIAGNOSTICO
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."EXAMENDIAGNOSTICO" MODIFY ("IDEXDIAGNOSTICO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."EXAMENDIAGNOSTICO" ADD CONSTRAINT "EXAMENDIAGNOSTICO_PK" PRIMARY KEY ("IDEXDIAGNOSTICO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table HOSPITALIZACION
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."HOSPITALIZACION" MODIFY ("IDHOSP" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."HOSPITALIZACION" MODIFY ("VISITAS" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."HOSPITALIZACION" MODIFY ("ESTADOSALUD" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."HOSPITALIZACION" MODIFY ("IPS" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."HOSPITALIZACION" ADD CONSTRAINT "HOSPITALIZACION_PK" PRIMARY KEY ("IDHOSP")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table IPS
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."IPS" MODIFY ("IDIPS" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."IPS" ADD CONSTRAINT "IPS_PK" PRIMARY KEY ("IDIPS")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MEDICO
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."MEDICO" MODIFY ("IDEMPLEADO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."MEDICO" MODIFY ("NREGMEDICO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."MEDICO" MODIFY ("ESPECIALIDAD" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."MEDICO" MODIFY ("IDMEDICO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."MEDICO" ADD CONSTRAINT "MEDICO_PK" PRIMARY KEY ("IDMEDICO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ORDEN
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."ORDEN" MODIFY ("IDORDEN" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."ORDEN" ADD CONSTRAINT "ORDEN_PK" PRIMARY KEY ("IDORDEN")
  USING INDEX (CREATE UNIQUE INDEX "ISIS2304B101920"."VISITA_PK" ON "ISIS2304B101920"."ORDEN" ("IDORDEN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD" )  ENABLE;
--------------------------------------------------------
--  Constraints for Table ORDENDETAIL
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."ORDENDETAIL" MODIFY ("ORDENID" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."ORDENDETAIL" MODIFY ("SERVICIOID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PROCEDIMIENTOSESPECIALIZADOS
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."PROCEDIMIENTOSESPECIALIZADOS" MODIFY ("IDPROCESP" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."PROCEDIMIENTOSESPECIALIZADOS" ADD CONSTRAINT "PROCEDIMIENTOSESPECIALIZAD_PK" PRIMARY KEY ("IDPROCESP")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table RECEPCIONISTA
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."RECEPCIONISTA" MODIFY ("IDEMPLEADO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."RECEPCIONISTA" ADD CONSTRAINT "RECEPCIONISTA_PK" PRIMARY KEY ("IDEMPLEADO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SERVICIOSALUD
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."SERVICIOSALUD" MODIFY ("IDSERVSALUD" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."SERVICIOSALUD" ADD CONSTRAINT "SERVICIOSALUD_PK" PRIMARY KEY ("IDSERVSALUD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TERAPIA
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."TERAPIA" ADD CONSTRAINT "TERAPIA_PK" PRIMARY KEY ("IDTERAPIA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
  ALTER TABLE "ISIS2304B101920"."TERAPIA" MODIFY ("IDTERAPIA" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."TERAPIA" MODIFY ("TIPO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRABAJAN
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."TRABAJAN" ADD CONSTRAINT "TRABAJAN_PK" PRIMARY KEY ("IDMEDICO", "IDIPS")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
  ALTER TABLE "ISIS2304B101920"."TRABAJAN" MODIFY ("IDIPS" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."TRABAJAN" MODIFY ("IDMEDICO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USAN
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."USAN" ADD CONSTRAINT "USAN_PK" PRIMARY KEY ("IDUSUARIO", "IDSERVSALUD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
  ALTER TABLE "ISIS2304B101920"."USAN" MODIFY ("IDSERVSALUD" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B101920"."USAN" MODIFY ("IDUSUARIO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."USUARIO" ADD CONSTRAINT "USUARIO_PK" PRIMARY KEY ("NIDENTIFICACION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
  ALTER TABLE "ISIS2304B101920"."USUARIO" MODIFY ("NIDENTIFICACION" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ADMINISTRADOR
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."ADMINISTRADOR" ADD CONSTRAINT "FK_IPSID" FOREIGN KEY ("IDIPS")
	  REFERENCES "ISIS2304B101920"."IPS" ("IDIPS") ENABLE;
  ALTER TABLE "ISIS2304B101920"."ADMINISTRADOR" ADD CONSTRAINT "FK_SERVSALUDID" FOREIGN KEY ("IDSERVSALUD")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ENABLE;
  ALTER TABLE "ISIS2304B101920"."ADMINISTRADOR" ADD CONSTRAINT "FK_USUARIOID" FOREIGN KEY ("IDUSUARIO")
	  REFERENCES "ISIS2304B101920"."USUARIO" ("NIDENTIFICACION") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ATIENDEN
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."ATIENDEN" ADD CONSTRAINT "ATIENDEN_FK1" FOREIGN KEY ("IDMEDICO")
	  REFERENCES "ISIS2304B101920"."MEDICO" ("IDMEDICO") ENABLE;
  ALTER TABLE "ISIS2304B101920"."ATIENDEN" ADD CONSTRAINT "ATIENDEN_FK2" FOREIGN KEY ("IDUSUARIO")
	  REFERENCES "ISIS2304B101920"."USUARIO" ("NIDENTIFICACION") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CONSULTACONTROL
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."CONSULTACONTROL" ADD CONSTRAINT "CONSULTACONTROL_FK1" FOREIGN KEY ("IDSERVSALUD")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ENABLE;
  ALTER TABLE "ISIS2304B101920"."CONSULTACONTROL" ADD CONSTRAINT "CONSULTACONTROL_FK2" FOREIGN KEY ("IDCONSCONT")
	  REFERENCES "ISIS2304B101920"."HOSPITALIZACION" ("IDHOSP") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CONSULTAESPECIALISTA
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."CONSULTAESPECIALISTA" ADD CONSTRAINT "CONSULTAESPECIALISTA_FK1" FOREIGN KEY ("IDSERVSALUD")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ENABLE;
  ALTER TABLE "ISIS2304B101920"."CONSULTAESPECIALISTA" ADD CONSTRAINT "REMISIONESPECIALISTA_FK1" FOREIGN KEY ("IDMEDICO")
	  REFERENCES "ISIS2304B101920"."MEDICO" ("IDMEDICO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CONSULTAMEDICO
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."CONSULTAMEDICO" ADD CONSTRAINT "CONSULTAMEDICO_FK1" FOREIGN KEY ("IDSERVSALUD")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CONSULTAURGENCIAS
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."CONSULTAURGENCIAS" ADD CONSTRAINT "CONSULTAURGENCIAS_FKMED" FOREIGN KEY ("IDSERVSALUD")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ENABLE;
  ALTER TABLE "ISIS2304B101920"."CONSULTAURGENCIAS" ADD CONSTRAINT "CONSULTAURGENCIAS_FKSERSAL" FOREIGN KEY ("IDMEDICO")
	  REFERENCES "ISIS2304B101920"."MEDICO" ("IDMEDICO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EXAMENDIAGNOSTICO
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."EXAMENDIAGNOSTICO" ADD CONSTRAINT "EXAMENDIAGNOSTICO_FK1" FOREIGN KEY ("IDSERVSALUD")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table IPS
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."IPS" ADD CONSTRAINT "IPS_FK1" FOREIGN KEY ("IDSERVSALUD")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MEDICO
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."MEDICO" ADD CONSTRAINT "MEDICO_FK1" FOREIGN KEY ("IDEMPLEADO")
	  REFERENCES "ISIS2304B101920"."EMPLEADO" ("IDEMPLEADO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDEN
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."ORDEN" ADD CONSTRAINT "ORDEN_FK1" FOREIGN KEY ("IDMEDICO")
	  REFERENCES "ISIS2304B101920"."MEDICO" ("IDMEDICO") ENABLE;
  ALTER TABLE "ISIS2304B101920"."ORDEN" ADD CONSTRAINT "ORDEN_FK2" FOREIGN KEY ("IDUSUARIO")
	  REFERENCES "ISIS2304B101920"."USUARIO" ("NIDENTIFICACION") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDENDETAIL
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."ORDENDETAIL" ADD CONSTRAINT "ORDENDETAIL_FK1" FOREIGN KEY ("SERVICIOID")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ENABLE;
  ALTER TABLE "ISIS2304B101920"."ORDENDETAIL" ADD CONSTRAINT "ORDENDETAIL_FK2" FOREIGN KEY ("ORDENID")
	  REFERENCES "ISIS2304B101920"."ORDEN" ("IDORDEN") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PROCEDIMIENTOSESPECIALIZADOS
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."PROCEDIMIENTOSESPECIALIZADOS" ADD CONSTRAINT "PROCEDIMIENTOSESPECIALIZA_FK1" FOREIGN KEY ("IDSERVSALUD")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RECEPCIONISTA
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."RECEPCIONISTA" ADD CONSTRAINT "RECEPCIONISTA_FK2" FOREIGN KEY ("IDEMPLEADO")
	  REFERENCES "ISIS2304B101920"."EMPLEADO" ("IDEMPLEADO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SERVICIOSALUD
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."SERVICIOSALUD" ADD CONSTRAINT "SERVICIOSALUD_FK1" FOREIGN KEY ("IDIPS")
	  REFERENCES "ISIS2304B101920"."IPS" ("IDIPS") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TERAPIA
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."TERAPIA" ADD CONSTRAINT "TERAPIA_FK1" FOREIGN KEY ("IDSERVSALUD")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TRABAJAN
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."TRABAJAN" ADD CONSTRAINT "TRABAJAN_FK1" FOREIGN KEY ("IDMEDICO")
	  REFERENCES "ISIS2304B101920"."MEDICO" ("IDMEDICO") ENABLE;
  ALTER TABLE "ISIS2304B101920"."TRABAJAN" ADD CONSTRAINT "TRABAJAN_FK2" FOREIGN KEY ("IDIPS")
	  REFERENCES "ISIS2304B101920"."IPS" ("IDIPS") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USAN
--------------------------------------------------------

  ALTER TABLE "ISIS2304B101920"."USAN" ADD CONSTRAINT "USAN_FK1" FOREIGN KEY ("IDUSUARIO")
	  REFERENCES "ISIS2304B101920"."USUARIO" ("NIDENTIFICACION") ENABLE;
  ALTER TABLE "ISIS2304B101920"."USAN" ADD CONSTRAINT "USAN_FK2" FOREIGN KEY ("IDSERVSALUD")
	  REFERENCES "ISIS2304B101920"."SERVICIOSALUD" ("IDSERVSALUD") ENABLE;
  ALTER TABLE "ISIS2304B101920"."USAN" ADD CONSTRAINT "USAN_FK3" FOREIGN KEY ("IDRECEPCIONISTA")
	  REFERENCES "ISIS2304B101920"."RECEPCIONISTA" ("IDEMPLEADO") ENABLE;
  ALTER TABLE "ISIS2304B101920"."USAN" ADD CONSTRAINT "USAN_FK4" FOREIGN KEY ("IDORDEN")
	  REFERENCES "ISIS2304B101920"."ORDEN" ("IDORDEN") ENABLE;
