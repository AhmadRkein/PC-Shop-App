use master
go

ALTER DATABASE [PcShop] SET  SINGLE_USER WITH ROLLBACK IMMEDIATE
GO

DROP DATABASE IF EXISTS PcShop
go

create database PcShop
go

use PcShop
go
create table cpu(
    id int IDENTITY(1,1) not null,
    name varchar(50) not null,
    brand char(50) null,
    price FLOAT null,
    coresNb int not null,
    freq float not null,
    PRIMARY KEY (id)
)

create table gpu(
    id int IDENTITY(1,1) not null,
    name varchar(50) not null,
    brand char(50) null,
    price FLOAT null,
    clockSpeed int not null,
    vram int not null,
    busType VARCHAR(50) not null,
    PRIMARY KEY (id)

)

create table ram(
   id int IDENTITY(1,1) not null,
    name varchar(50) not null,
    brand char(50) null,
    price FLOAT null,
    size int not null,
    PRIMARY KEY (id)
)

create table monitor(
   id int IDENTITY(1,1) not null,
    name varchar(50) not null,
    brand char(50) null,
    price FLOAT null,
    size int not null,
    resolution VARCHAR(50) not null,
    PRIMARY KEY (id)

)

create table hardDisk(
   id int IDENTITY(1,1) not null,
    name varchar(50) not null,
    brand char(50) null,
    price FLOAT null,
    storage int null,
    PRIMARY KEY (id)
)

create table pc(
    id int IDENTITY(1,1) not null,
    Name varchar(50) not null,
    Creator varchar(50) null,
    price FLOAT null,
    cpuId int null,
    gpuId int null,
    ramId int null,
    monitorId int null,
    hardDiskId int null,
    PRIMARY KEY (id),
    foreign key (cpuId) references cpu (id),
    foreign key (gpuId) references gpu (id),
    foreign key (ramId) references ram (id),
    foreign key (monitorId) references monitor (id),
    foreign key (hardDiskId) references hardDisk (id),
)

create table client(
    userName VARCHAR(50) not null,
    password VARCHAR(50) not null,
    firstName VARCHAR(50) null,
    lastName varchar(50) null,
    primary key (userName)
)
create table employee(
    username VARCHAR(50) not null,
    password VARCHAR(50) not null,
    firstName VARCHAR(50) null,
    lastName varchar(50) null,
    isAdmin bit not null,
    primary key (userName)
)