--RF7 Registrar orden (Medico)
INSERT INTO orden (idorden,rmedica,fecha,idmedico, idusuario) VALUES (SEQ_ORDEN.nextval,pMedicina,sysdate,pIdMedico, pIdUsuario);
--Se repite el siguiente query para cada servicio extra en la orden
INSERT INTO ordendetail (ordenid,servicioid) VALUES (ordenId,servSaludId);

--RF8 Reserva servicio medico (Usuario)--Estado (0=reserva, 1=atendido)
--Verifico disponibilidad
SELECT COUNT(*)
FROM usan INNER JOIN serviciosalud ON usan.idservsalud = serviciosalud.idservsalud
WHERE fecha = pFechaReserva AND usan.idservsalud = pIdServSalud AND serviciosalud.idips = pIps;
--Se verifica que si se tenga orden si el servicio medico lo requiere
SELECT idorden 
FROM orden JOIN ordendetail ON orden.idorden = ordendetail.ordenid
WHERE orden.idusuario = pIdUsuario AND ordendetail.servicioid = pIdServSalud;
--Se hace la reserva
INSERT INTO usan (idusuario,idservsalud,estado,fechareserva,fechaatencion,idrecepcionista, idorden) 
VALUES (pIdUsuario,pIdServSalud,0, pFechaReserva,null,null, pIdOrden);

--RF9
UPDATE usan
SET
    estado = 1, fechaatencion= sysdate, idrecepcionista = pIdRecepcionista
WHERE
    idusuario = pIdUsuario
    AND idservsalud = pIdServSalud
    AND estado = 0
    AND fechareserva = pFechaReserva;
    
--RFC1 (Estado en 1 significa que ya fue atendido)
SELECT COUNT(*)
FROM usan
WHERE (fechaatencion BETWEEN pFechaInicial AND pFechaFinal) AND estado = 1;

--RFC2
SELECT *
FROM(
SELECT idservsalud, COUNT(idServSalud) c
FROM usan 
WHERE (fechaatencion BETWEEN pFechaInicial AND pFechaFinal) AND estado = 1
group by idservsalud
ORDER BY c)
WHERE ROWNUM <=20;

--RFC3
SELECT serviciosalud.idservsalud, COUNT(*)*100/serviciosalud.capacidad
FROM usan JOIN serviciosalud ON usan.idservsalud = serviciosalud.idservsalud
WHERE (fechaatencion BETWEEN pFechaInicial AND pFechaFinal) AND estado = 1 
group by serviciosalud.idservsalud;

--RFC4
SELECT usan.idservsalud, usan.idusuario, usan.fechaatencion, usan.fechareserva, usan.estado
FROM usan, serviciosalud
WHERE usan.idrecepcionista = pIdRecepcionista OR idservsalud = pIdServSalud OR fechaatencion BETWEEN pFechaInicial AND pFechaFinal
;


--RFC5
SELECT usuario.nombre
FROM usuario, usan
WHERE pUsuarioId = usuario.nidentificacion AND usan.idusuario = pIdUsuario AND fechaatencion BETWEEN pFechaInicial AND pFechaFinal;

