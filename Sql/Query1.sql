/*
Query1: listar todos los entregables agrupados por partido para un cantón dado por parámetro, y cada
hilo usa un cantón diferente.
*/
use aseni
go

Create procedure qr1 (@canton char(20)) as
begin
    Select p.name as "Partido",COUNT( DISTINCT dc.id) as "Entregables"
    FROM DelivPerCant as dc

    INNER JOIN Canton as c ON dc.canton_id = c.id
    INNER JOIN Deliverable as d ON dc.deli_id = d.id

    INNER JOIN Userr as u ON d.createBy = u.id
    INNER JOIN Party as p ON u.party_id = p.id

    where c.name = @canton
    GROUP BY p.name
    ORDER BY p.name ASC

end
go


--Ver los partidos y los cantones a los que entregan por canton(parametro)
/*
exec qr1 @canton = 'Alajuela'
exec qr1 @canton = 'Naranjo'
exec qr1 @canton = 'Atenas'
exec qr1 @canton = 'Grecia'
*/