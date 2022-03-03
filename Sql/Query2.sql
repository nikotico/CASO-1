/*
Query2: listar todos los cantones que van a recibir entregables de máximo el 25% de los partidos,
agregando la cantidad de entregables por cantón
*/
use aseni
go

Create procedure qr2 as
declare 
    @total int
    set @total = (select count(Party.id) as id from Party)
begin
    Select c.name as "Canton",COUNT( DISTINCT dc.id) as "Entregables"
    FROM DelivPerCant as dc

    INNER JOIN Canton as c ON dc.canton_id = c.id
    INNER JOIN Deliverable as d ON dc.deli_id = d.id

    group by c.name
    Having @total*0.25 = COUNT( DISTINCT dc.id)
end
GO


