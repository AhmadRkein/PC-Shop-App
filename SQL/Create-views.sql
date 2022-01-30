USE [PcShop]
GO

Create View Users as
SELECT        username, password, firstName, lastName, 'C' as UserType, 0 as isAdmin
FROM            client
union
SELECT        username, password, firstName, lastName, 'E' as UserType, isAdmin
FROM            employee

