USE [PcShop]
GO

Create View Users as
SELECT        userName, password, firstname, lastName, "C" as UserType
FROM            client
union
SELECT        userName, password, firstname, lastName, "E" as UserType
FROM            employee

