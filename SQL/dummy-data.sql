use PcShop
go

--Users
insert into client values('m','m','mohamad','Nasser')
insert into client values('client','123','Ali','Awada')
insert into employee values('admin','admin','ADMIN',' ',1)
insert into employee values('e','e','e',' ',0)
insert into employee values('employee','123','Ahmad','Rkein',0)

--CPU
insert into cpu VALUES('Core™ i7-4790','Intel®',200.9,9,5)
insert into cpu VALUES('Core™ i5','Intel®',50.9,5,5)
insert into cpu VALUES('cpu i9000k','intel',200.9,12,2)
insert into cpu VALUES('cpu i7000k','intel',400.9,12,2)
insert into cpu VALUES('ryzen 5','AMD',350,12,3.4)
insert into cpu VALUES('Ryzen 7','AMD',550,24,4.2)


--GPU
insert into gpu VALUES('RTX 3070','Nvidia',700,4200,10000,'PCIe 16x gen4')
insert into gpu VALUES('Gtx 1060','Nvidia',200,2400,5000,'PCIe 8x gen3')
insert into gpu VALUES('RTX 3090','Nvidia',1200,4600,18000,'PCIe 16x gen4')
insert into gpu VALUES('gtx 960','nvidia',150,2100,2048,'PCIe 8x gen3')
insert into gpu VALUES('gtx 980','nvidia',200,2600,4000,'PCIe 8x gen3')

--RAM
insert into ram VALUES('TEAM XTREEM','ARGB',99,16)
insert into ram VALUES('Chinese XTREEM','ARGB',10,8)
insert into ram VALUES('Vengeance','Corsair',120,16)
insert into ram VALUES('Trident Z','G.SKILL',240,32)
insert into ram VALUES('HyperX','KingSton',89,8)

--Monitor
insert into monitor VALUES('Odyssey','samsung',840,26,1440)
insert into monitor VALUES('Flatron','LG',150,16,1080)
insert into monitor VALUES('SB220Q','ACER',120,21,1080)
insert into monitor VALUES('ROG SWIFT','ASUS',500,22,1440)

--HardDisk
insert into hardDisk VALUES('EVO 890', 'Samsung', 400, 2000)
insert into hardDisk VALUES('WD BLUE', 'Western Digital', 70, 500)
insert into hardDisk VALUES('BarraCuda', 'Seagate', 270, 8000)
insert into hardDisk VALUES('Canvio', 'Toshiba', 80, 1000)
insert into hardDisk VALUES('FireCuda', 'SeaGate', 229.99, 2048)
