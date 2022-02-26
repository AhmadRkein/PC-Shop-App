use master
create database PcShop
go
use PcShop
go
create table cpu(
    id int IDENTITY(1,1) not null,
    name varchar(30) not null,
    brand char(10) null,
    price FLOAT null,
    coresNb int not null,
    freq float not null,
    PRIMARY KEY (id)
)
drop table cpu
create table gpu(
    id int IDENTITY(1,1) not null,
    name varchar(30) not null,
    brand char(10) null,
    price FLOAT null,
    clockSpeed int not null,
    vram int not null,
    busType VARCHAR(10) not null,
    PRIMARY KEY (id)

)
create table ram(
   id int IDENTITY(1,1) not null,
    name varchar(30) not null,
    brand char(10) null,
    price FLOAT null,
    size int not null,
    PRIMARY KEY (id)
)
drop table ram
create table monitor(
   id int IDENTITY(1,1) not null,
    name varchar(30) not null,
    brand char(10) null,
    price FLOAT null,
    size int not null,
    resolution VARCHAR(20) not null,
    PRIMARY KEY (id)

)
create table hardDisk(
   id int IDENTITY(1,1) not null,
    name varchar(30) not null,
    brand char(10) null,
    price FLOAT null,
    storage int null,
    PRIMARY KEY (id)
)
create table pc(
    id int IDENTITY(1,1) not null,
    name varchar(30) not null,
    brand char(10) null,
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
    userName VARCHAR(30) not null,
    password VARCHAR(30) not null,
    firstName VARCHAR(30) null,
    lastName varchar(30) null,
    primary key (userName)
)
create table employee(
    username VARCHAR(30) not null,
    password VARCHAR(30) not null,
    firstName VARCHAR(30) null,
    lastName varchar(30) null,
    isAdmin bit not null,
    primary key (userName)
)