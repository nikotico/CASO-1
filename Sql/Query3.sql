/*Para cada partido y para cada acción del plan mostrar el cantón con menos entregables y la
cantidad, y el cantón con más entregables y la cantidad.*/
use aseni
go

Create view qr3Min AS
	WITH Rows as (
		Select  ROW_NUMBER() OVER(PARTITION BY p.name ORDER BY MAX(d.kpiCant) ASC) as "row",p.name as "Partido",a.name as "Accion", c.name as "Canton", MAX(d.kpiCant) as "Cant Kpi Entregables"
		FROM DelivPerCant as dc

		INNER JOIN Canton as c ON dc.canton_id = c.id
		INNER JOIN Deliverable as d ON dc.deli_id = d.id
		INNER JOIN [Action] as a ON d.action_id = a.id

		INNER JOIN Userr as u ON d.createBy = u.id
		INNER JOIN Party as p ON u.party_id = p.id

		GROUP BY c.name,a.name,p.name     )
	Select Partido,Accion,Canton,[Cant Kpi Entregables] FROM Rows WHERE row = 1
go

Create view qr3Max AS
	WITH Rows as (
		Select  ROW_NUMBER() OVER(PARTITION BY p.name ORDER BY MAX(d.kpiCant) DESC) as "row",p.name as "Partido",a.name as "Accion", c.name as "Canton", MAX(d.kpiCant) as "Cant Kpi Entregables"
		FROM DelivPerCant as dc

		INNER JOIN Canton as c ON dc.canton_id = c.id
		INNER JOIN Deliverable as d ON dc.deli_id = d.id
		INNER JOIN [Action] as a ON d.action_id = a.id

		INNER JOIN Userr as u ON d.createBy = u.id
		INNER JOIN Party as p ON u.party_id = p.id

		GROUP BY c.name,a.name,p.name     )
	Select Partido,Accion,Canton,[Cant Kpi Entregables] FROM Rows WHERE row = 1
go
