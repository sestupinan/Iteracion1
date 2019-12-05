--RF10 Reserva y registro campaña
INSERT INTO campaniaprevencion (
    id,
    fechainicio,
    fechafin,
    nombrecampania
) VALUES (
    SEQ_IDCAMPANIA.nextval,
    pfechainicio,
    pfechafin,
    pnombrecampania
);
INSERT INTO reservan
(SELECT serviciosalud.idservsalud, SEQ_IDCAMPANIA.currval, pCantidadSol
FROM serviciosalud
WHERE idservsalud = pIdServSalud AND capacidad>=pCantidadSol)
;
UPDATE serviciosalud
SET capacidad=capacidad-pCantidadSol
WHERE idservsalud=pId
;
SELECT reservan.idcampaniaprev, reservan.idservsalud, serviciosalud.nombre, reservan.cantidadreservados, serviciosalud.horario
FROM reservan JOIN serviciosalud on serviciosalud.idservsalud = reservan.idservsalud
WHERE reservan.idcampaniaprev = SEQ_IDCAMPANIA.currval;

--RF11
--Caso especifico
DELETE FROM reservan
WHERE idcampaniaprev = pIdCampania AND idservsalud=pIdServSalud;
--Borrar todos los servicios
DELETE FROM reservan
WHERE idcampaniaprev = pIdCampania;
--Borrar campania
DELETE FROM campaniaprevencion
WHERE id=pIdCampania;

--RF12
INSERT INTO nodisponibilidad (
    idservsalud,
    fechainicio,
    idips,
    causa,
    fechafin
) VALUES (
    pidservsalud,
    pfechainicio,
    pidips,
    pcausa,
    pfechafin
);
update serviciosalud
set estado=0
where idservsalud = pIdServSalud;

--RF13
update serviciosalud
set estado=1
where idservsalud = pIdServSalud;

--RFC6
SELECT usan.idservsalud,  TO_CHAR(usan.fechareserva, 'WW') unidadtiempo, serviciosalud.nombre, COUNT(*)cuenta
FROM usan JOIN serviciosalud on serviciosalud.idservsalud=usan.idservsalud
WHERE usan.estado=0
GROUP BY usan.idservsalud, TO_CHAR(usan.fechareserva, 'WW'), serviciosalud.nombre
ORDER BY cuenta desc
;
    
SELECT usan.idservsalud,  TO_CHAR(usan.fechaatencion, 'WW') unidadtiempo, serviciosalud.nombre, COUNT(*)cuenta
FROM usan JOIN serviciosalud on serviciosalud.idservsalud=usan.idservsalud
WHERE usan.estado=1
GROUP BY usan.idservsalud, TO_CHAR(usan.fechaatencion, 'WW'), serviciosalud.nombre
ORDER BY cuenta desc
;

SELECT usan.idservsalud,  TO_CHAR(usan.fechareserva, 'WW') unidadtiempo, serviciosalud.nombre, COUNT(*)cuenta
FROM usan JOIN serviciosalud on serviciosalud.idservsalud=usan.idservsalud
WHERE usan.estado=0
GROUP BY usan.idservsalud, TO_CHAR(usan.fechareserva, 'WW'), serviciosalud.nombre
ORDER BY cuenta asc
;


--RFC7
SELECT *
FROM usuario, 
    (
    SELECT COUNT(*) c,  usuario.nidentificacion n
    FROM usan, usuario,
        (
        SELECT COUNT(DISTINCT(usan.idservsalud)) co, usan.idusuario 
        FROM usan group by usan.idusuario
        ) aux2
    WHERE usan.idusuario = usuario.nidentificacion AND usan.estado=1  AND aux2.co >3
    GROUP BY usuario.nidentificacion
    ) aux
WHERE aux.c > 11 and usuario.nidentificacion=aux.n
;

--RFC8
SELECT serviciosalud.idservsalud, serviciosalud.nombre, COUNT(*), TO_CHAR(usan.fechareserva, 'WW')
FROM usan, serviciosalud
WHERE  usan.idservsalud = serviciosalud.idservsalud AND EXTRACT (YEAR FROM usan.fechareserva) = EXTRACT (YEAR FROM SYSDATE) -1
group by serviciosalud.idservsalud, serviciosalud.nombre, TO_CHAR(usan.fechareserva, 'WW') 
HAVING COUNT(*)<3
;

select table_name, column_name, data_type, data_length, nullable from user_tab_columns order by table_name ;

select table_name, constraint_name, constraint_type, r_constraint_name from user_constraints order by table_name ;