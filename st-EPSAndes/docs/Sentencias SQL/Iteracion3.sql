
--RFC9----------------------------Falta ordenar en Java la adicion segun lo que desee el usuario. 
--Se tiene que ir armando la sentencia pedazo a pedazo
SELECT *
FROM usuario JOIN usan ON usan.idusuario = usuario.nidentificacion, serviciosalud
WHERE usan.idservsalud = 1 AND usan.fechaatencion>'04/04/18' AND usan.fechaatencion<'04/05/19' 
AND serviciosalud.idservsalud=usan.idservsalud AND serviciosalud.idips = 7007
ORDER BY serviciosalud.idservsalud
;
SELECT * FROM USAN;

--RFC10----------------------------Cada sentencia es una opcion que elige el usuario. 
--EJ el usuario quiere ver los servicios de salud que no son usados

--Usuarios que no usan ningun servicio
SELECT count(*)
FROM usuario LEFT JOIN usan ON usuario.nidentificacion = usan.idusuario 
WHERE usan.idusuario is NULL;
--Servicios de salud que no son usados
SELECT count(*)
FROM serviciosalud LEFT JOIN usan ON serviciosalud.idservsalud = usan.idservsalud 
WHERE usan.idservsalud is NULL;
--IPS que no son usadas en ningun servicio de salud
SELECT count(*)
FROM ips LEFT JOIN (serviciosalud JOIN usan ON usan.idservsalud = serviciosalud.idservsalud) ON ips.idips =serviciosalud.idips 
WHERE serviciosalud.idips IS NULL;



--RFC11---------------------------- Lo mismo que el anterior. Cada sentencia es una que elige el usuario

--El servicio mas usado por semana
SELECT *
FROM(
SELECT semana, aux.idservsalud, MIN(cuenta) over (partition by semana ORDER BY cuenta desc )as maximo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM
FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(usan.idservsalud) cuenta, usan.idservsalud
    FROM usan
    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), usan.idservsalud
    ORDER BY semana, cuenta DESC) aux
ORDER BY semana)
WHERE ROW_NUM=1
    ;
    
--El servicio menos usado por semana
SELECT *
FROM (
SELECT semana, aux.idservsalud, MAX(cuenta) over (partition by semana ORDER BY cuenta  )as minimo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM
FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(usan.idservsalud) cuenta, usan.idservsalud
    FROM usan
    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), usan.idservsalud
    ORDER BY semana, cuenta DESC) aux
ORDER BY semana)
WHERE ROW_NUM = 1
    ;
--El usuario que mas usa servicios por semana
SELECT *
FROM (
SELECT semana, aux.idusuario, MIN(cuenta) over (partition by semana ORDER BY cuenta  desc)as maximo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM
FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(usan.idusuario) cuenta, usan.idusuario
    FROM usan
    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), usan.idusuario
    ORDER BY semana, cuenta DESC) aux
ORDER BY semana)
WHERE ROW_NUM = 1
    ;
    
--El usuario que menos usa servicios por semana
SELECT *
FROM (
SELECT semana, aux.idusuario, MAX(cuenta) over (partition by semana ORDER BY cuenta  )as minimo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM
FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(usan.idusuario) cuenta, usan.idusuario
    FROM usan
    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), usan.idusuario
    ORDER BY semana, cuenta DESC) aux
ORDER BY semana)
WHERE ROW_NUM = 1
    ;
    
--El ips menos usado por semana
SELECT *
FROM (
SELECT semana, aux.idips, MAX(cuenta) over (partition by semana ORDER BY cuenta  )as minimo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM
FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(ips.idips) cuenta, ips.idips
    FROM usan join serviciosalud on usan.idservsalud = serviciosalud.idservsalud join ips on serviciosalud.idips = ips.idips
    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), ips.idips
    ORDER BY semana, cuenta DESC) aux
ORDER BY semana)
WHERE ROW_NUM = 1
    ;
--El ips mas usado por semana
SELECT *
FROM (
SELECT semana, aux.idips, MIN(cuenta) over (partition by semana ORDER BY cuenta desc )as maximo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM
FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(ips.idips) cuenta, ips.idips
    FROM usan join serviciosalud on usan.idservsalud = serviciosalud.idservsalud join ips on serviciosalud.idips = ips.idips
    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), ips.idips
    ORDER BY semana, cuenta DESC) aux
ORDER BY semana)
WHERE ROW_NUM = 1
    ;


--RFC12---------------------------- No lo supe hacer send help

--Verifica que haya usado 1 al menos 1 vez en el mes
SELECT * 
FROM (
SELECT TO_CHAR(usan.fechareserva, 'YYYY'), COUNT(usan.idservsalud) cuenta, idusuario
FROM usan
group by TO_CHAR(usan.fechareserva, 'YYYY'), idusuario
order by cuenta desc) aux
WHERE aux.cuenta >=12
;
--Verifica si siempre requieren un serv medico especializado (Trae todos aquellos que tengan diferentes a los especializados)
SELECT usan.idusuario FROM (
SELECT DISTINCT usan.idusuario, idservsalud
FROM usan
WHERE idservsalud != 7 AND idservsalud!=2 order by idusuario 
)aux , usan--join usuario on aux.idusuario = usuario.nidentificacion
WHERE usan.idusuario != aux.idusuario
;
SELECT usan.idusuario, count(idservsalud)
FROM usan
--WHERE  idservsalud in (7,2) and idservsalud NOT IN(1, 3, 4, 5, 6, 8, 9, 10, 11, 12) 
WHERE idservsalud = 7
group by usan.idusuario 
;
SELECT *
FROM USAN
WHERE idusuario = 143079;




----------------------------------------------------Indices-------------------------------------------------------------------------------------
 CREATE INDEX "ISIS2304B101920"."FECHARESERVANUSAN" ON "ISIS2304B101920"."USAN" ("FECHARESERVA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD" ;
  
  CREATE INDEX "ISIS2304B101920"."FECHAATENCIONUSAN" ON "ISIS2304B101920"."USAN" ("FECHAATENCION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD" ;