Select p.name as "Partido",COUNT( DISTINCT c.id)
FROM DelivPerCant as dc

INNER JOIN Canton as c ON dc.canton_id = c.id
INNER JOIN Deliverable as d ON dc.deli_id = d.id
INNER JOIN [Action] as a ON d.action_id = a.id

INNER JOIN Userr as u ON d.createBy = u.id
INNER JOIN Party as p ON u.party_id = p.id

GROUP BY p.name
ORDER BY p.name ASC
--Ver los partidos y los cantones a los que entregan

Select p.name as "Partido",a.name as "Accion", c.name as "Canton", MAX(d.kpiCant) as "Cant Kpi Entregables"
FROM DelivPerCant as dc

INNER JOIN Canton as c ON dc.canton_id = c.id
INNER JOIN Deliverable as d ON dc.deli_id = d.id
INNER JOIN [Action] as a ON d.action_id = a.id

INNER JOIN Userr as u ON d.createBy = u.id
INNER JOIN Party as p ON u.party_id = p.id

GROUP BY c.name,a.name,p.name
ORDER BY p.name,MAX(d.kpiCant) DESC
--Pruebaaa

Select p.name as "Partido",a.name as "Accion", MAX(d.kpiCant) as "Cant Kpi Entregables"
FROM DelivPerCant as dc

INNER JOIN Canton as c ON dc.canton_id = c.id
INNER JOIN Deliverable as d ON dc.deli_id = d.id
INNER JOIN [Action] as a ON d.action_id = a.id

INNER JOIN Userr as u ON d.createBy = u.id
INNER JOIN Party as p ON u.party_id = p.id

GROUP BY a.name,p.name
ORDER BY p.name,MAX(d.kpiCant) DESC
-- Solo MAX

WITH Rows as (
    Select  ROW_NUMBER() OVER(PARTITION BY p.name ORDER BY MAX(d.kpiCant) DESC) as "row",p.name as "Partido",a.name as "Accion", c.name as "Canton", MAX(d.kpiCant) as "Cant Kpi Entregables"
    FROM DelivPerCant as dc

    INNER JOIN Canton as c ON dc.canton_id = c.id
    INNER JOIN Deliverable as d ON dc.deli_id = d.id
    INNER JOIN [Action] as a ON d.action_id = a.id

    INNER JOIN Userr as u ON d.createBy = u.id
    INNER JOIN Party as p ON u.party_id = p.id

    GROUP BY c.name,a.name,p.name 
    
    )
Select Partido,Accion,Canton,[Cant Kpi Entregables] FROM Rows WHERE row = 1

--Cambiar el DESC O ASC en el select
--DESC = MAX , ASC = MIN