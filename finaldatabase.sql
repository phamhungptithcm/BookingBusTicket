CREATE DATABASE BookingBusTicket;

USE BookingBusTicket;

CREATE TABLE Provinces
(
	province_Id INT PRIMARY KEY AUTO_INCREMENT,
    last_Update DATETIME DEFAULT NOW(),
    province_Name NVARCHAR(50) NOT NULL UNIQUE
    
);
CREATE TABLE Routes
(
	route_Id INT PRIMARY KEY AUTO_INCREMENT,
    route_From int,
    route_To int check(route_From <> route_To),
    route_Status BIT DEFAULT True,
    last_Update DATETIME DEFAULT NOW(),
    FOREIGN KEY (route_From) REFERENCES Provinces(province_Id),
    FOREIGN KEY (route_To) REFERENCES Provinces(province_Id)
);
CREATE TABLE Bus
(
	bus_Id INT PRIMARY KEY AUTO_INCREMENT,
    bus_Name nvarchar(50) not null,
    num_Seat int default 20,
    bus_license_plate varchar(50),
    last_Update datetime default now()
);
CREATE TABLE Trips(
	trip_Id INT PRIMARY KEY AUTO_INCREMENT,
    Departure_Time TIME NOT NULL,
    Arrival_Time TIME NOT NULL,
    route_Id INT,
    unit_Price FLOAT NOT NULL DEFAULT 0.0,
    last_Update DATETIME DEFAULT NOW(),
    bus_Id INT,
    FOREIGN KEY (bus_Id)  REFERENCES Bus(bus_Id),
    FOREIGN KEY (route_Id)  REFERENCES Routes(route_Id)
);

CREATE TABLE Tickets(
	ticket_Id INT PRIMARY KEY AUTO_INCREMENT,
    bus_Id int not null,
    last_Update DATETIME DEFAULT NOW(),
    ticket_Status bit default true,
    discout float default 0.0,
    FOREIGN KEY (bus_Id)  REFERENCES Bus(bus_Id)
);
CREATE TABLE Users(
	user_Id INT PRIMARY KEY AUTO_INCREMENT,
	user_Name VARCHAR(50) UNIQUE,
    password VARCHAR(100) NOT NULL,
    user_Role int default 1 check (user_Role > 0 and user_Role <4),
    full_Name NVARCHAR(100) NOT NULL,
    date_Of_Birth DATE,
    phone_Num VARCHAR(20) NOT NULL,
    email VARCHAR(70) NOT NULL,
    gender BIT DEFAULT True,
    address NVARCHAR(100)
);
CREATE TABLE OrderStatuses(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    last_Update datetime default now()
);
CREATE TABLE Orders(
	order_Id INT PRIMARY KEY AUTO_INCREMENT,
    amount FLOAT DEFAULT 0.0,
    order_Date DATETIME DEFAULT NOW(),
    order_Status_Id INT DEFAULT 1,
    user_Id Int DEFAULT 0,
    last_Update DATETIME DEFAULT NOW(),
    note NVARCHAR(100),
    FOREIGN KEY (user_Id)  REFERENCES Users(user_Id),
	FOREIGN KEY (order_Status_Id)  REFERENCES OrderStatuses(id)
);
CREATE TABLE TicketDetails(
	ticket_Detail_Id INT PRIMARY KEY AUTO_INCREMENT,
    Departure_Date DATETIME DEFAULT NOW(),
    Last_Name NVARCHAR(50) NOT NULL,
    first_Name NVARCHAR(50) NOT NULL,
    gender BIT DEFAULT True,
    age int NOT NULL,
    num_Seat int not null,
    last_Update DATETIME DEFAULT NOW(),
    ticket_Id INT not null,
    order_Id INT not null,
    FOREIGN KEY (ticket_Id)  REFERENCES Tickets(ticket_Id),
    FOREIGN KEY (order_Id)  REFERENCES Orders(order_Id)
);
insert into  Provinces
(
    province_Name

)values(
"An Giang"
);
insert into  Provinces
(
    province_Name

)values(
"Bà Rịa - Vũng Tàu"
);
insert into  Provinces
(
    province_Name

)values(
"Bạc Liêu"
);
insert into  Provinces
(
    province_Name

)values(
"Bắc Kạn"
);
insert into  Provinces
(
    province_Name

)values(
"Bắc Giang"
);
insert into  Provinces
(
    province_Name

)values(
"Bắc Ninh"
);
insert into  Provinces
(
    province_Name

)values(
"Bến Tre
"
);
insert into  Provinces
(
    province_Name

)values(
"Bình Dương"
);
insert into  Provinces
(
    province_Name

)values(
"Bình Định"
);
insert into  Provinces
(
    province_Name

)values(
"Bình Phước"
);
insert into  Provinces
(
    province_Name

)values(
"Bình Thuận"
);
insert into  Provinces
(
    province_Name

)values(
"Cà Mau"
);
insert into  Provinces
(
    province_Name

)values(
"Cao Bằng"
);
insert into  Provinces
(
    province_Name

)values(
"Cần Thơ"
);
insert into  Provinces
(
    province_Name

)values(
"Đà Nẵng"
);
insert into  Provinces
(
    province_Name

)values(
"Đắk Lắk"
);
insert into  Provinces
(
    province_Name

)values(
"Đắk Nông"
);
insert into  Provinces
(
    province_Name

)values(
"Đồng Nai"
);
insert into  Provinces
(
    province_Name

)values(
"Đồng Tháp"
);
insert into  Provinces
(
    province_Name

)values(
"Điện Biên"
);
insert into  Provinces
(
    province_Name

)values(
"Gia Lai"
);
use bookingbusticket;
insert into Routes
(
    route_From,
    route_To) values(1,2);
    
    insert into Routes
(
    route_From,
    route_To) values(2,1);
    insert into Routes
(
    route_From,
    route_To) values(3,4);
    
    insert into Routes
(
    route_From,
    route_To) values(4,3);
    
    insert into Routes
(
    route_From,
    route_To) values(5,6);
    
    insert into Routes
(
    route_From,
    route_To) values(6,5);
    
    insert into Routes
(
    route_From,
    route_To) values(7,8);
    insert into Routes
(
    route_From,
    route_To) values(8,7);
    
    insert into Routes
(
    route_From,
    route_To) values(9,10);
    
    insert into Routes
(
    route_From,
    route_To) values(10,9);
    
insert into  Bus
(
    bus_Name ,
     bus_license_plate
)values
 ("The Beast 1","abc1234");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 2","abc1235");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 3","abc1236");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 4","abc1237");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 5","abc1238");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 6","abc123q");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 7","abc123w");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 8","abc123e");
  insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 9","abc123egff");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 10","abc123r");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 11","abc1234t");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 12","abc1235y");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 13","abc1236u");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 14","abc123i7");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 15","abc1238");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 16","abc123qy");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 17","abc123wh");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 18","abc123engh");
 insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 19","abc123r");
  insert into  Bus
(
    bus_Name ,
     bus_license_plate

)values
 ("The Beast 20","abc123ryyyyy");
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '05:30:00','09:30:00',1,1,100);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '12:30:00','16:30:00',1,2,200);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '05:30:00','09:30:00',2,3,300);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '12:30:00','16:30:00',2,4,400);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '05:30:00','09:30:00',3,5,500);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '12:30:00','16:30:00',3,6,600);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '05:30:00','09:30:00',4,7,700);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '12:30:00','16:30:00',4,8,800);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '05:30:00','09:30:00',5,9,900);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '12:30:00','16:30:00',5,10,1000);

insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '12:30:00','16:30:00',6,11,1100);

insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '08:30:00','12:30:00',6,12,1200);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '12:30:00','19:30:00',7,13,1300);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '14:30:00','21:30:00',7,14,1400);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '12:30:00','17:30:00',8,15,1500);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '14:30:00','19:30:00',8,16,1600);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '12:30:00','18:30:00',9,17,1700);
insert into  Trips (
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '13:30:00','19:30:00',9,18,1800);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '12:30:00','20:30:00',10,19,1900);
insert into  Trips(
    Departure_Time,
    Arrival_Time,
    route_Id,
    bus_Id,
    unit_Price
)values( '13:30:00','21:30:00',10,20,2000);

insert into Tickets(
    bus_Id
)values( 1);
insert into Tickets(
    
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
       
    bus_Id
)values( 1);
insert into Tickets(
    bus_Id
)values( 1);
insert into Tickets(
    bus_Id
)values( 1);
insert into Tickets(
    bus_Id
)values( 1);
insert into Tickets(
    bus_Id
)values( 1);
insert into Tickets(
    bus_Id
)values( 1);
insert into Tickets(
    bus_Id
)values( 1);
insert into Tickets(
    bus_Id
)values( 1);

insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
insert into Tickets(
    bus_Id
)values( 2);
select * from tickets;

insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
insert into Tickets(
    bus_Id
)values( 3);
select * from tickets;

insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
insert into Tickets(
     
    bus_Id
)values( 4);
select * from tickets;

insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
insert into Tickets(
     
    bus_Id
)values( 5);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
insert into Tickets(
     
    bus_Id
)values( 6);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
insert into Tickets(
     
    bus_Id
)values( 7);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
insert into Tickets(
     
    bus_Id
)values( 8);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
       
    bus_Id
)values( 9);
insert into Tickets(
       
    bus_Id
)values( 9);
insert into Tickets(
       
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
insert into Tickets(
     
    bus_Id
)values( 9);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
insert into Tickets(
     
    bus_Id
)values( 10);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values(11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
insert into Tickets(
     
    bus_Id
)values( 11);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values(12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
insert into Tickets(
     
    bus_Id
)values( 12);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values(13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
insert into Tickets(
     
    bus_Id
)values( 13);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values(14);
insert into Tickets(
     
    bus_Id
)values(14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values(14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
insert into Tickets(
     
    bus_Id
)values( 14);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values(15);
insert into Tickets(
     
    bus_Id
)values(15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
insert into Tickets(
     
    bus_Id
)values( 15);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values( 16);
insert into Tickets(
     
    bus_Id
)values( 16);
insert into Tickets(
     
    bus_Id
)values( 16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values( 16);
insert into Tickets(
     
    bus_Id
)values( 16);
insert into Tickets(
     
    bus_Id
)values(16);
insert into Tickets(
     
    bus_Id
)values( 16);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values(17);
insert into Tickets(
     
    bus_Id
)values( 17);
insert into Tickets(
     
    bus_Id
)values( 17);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values( 18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values(18);
insert into Tickets(
     
    bus_Id
)values( 18);
insert into Tickets(
     
    bus_Id
)values( 18);
insert into Tickets(
     
    bus_Id
)values( 18);
insert into Tickets(
     
    bus_Id
)values( 18);
insert into Tickets(
     
    bus_Id
)values( 18);
insert into Tickets(
     
    bus_Id
)values( 18);
insert into Tickets(
     
    bus_Id
)values( 18);
insert into Tickets(
     
    bus_Id
)values( 18);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values(19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values(19);
insert into Tickets(
     
    bus_Id
)values(19);
insert into Tickets(
     
    bus_Id
)values(19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values(19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
    bus_Id
)values(19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values( 19);
insert into Tickets(
     
    bus_Id
)values( 19);
select * from tickets;
insert into Tickets(
     
    bus_Id
)values(  20);
insert into Tickets(
     
    bus_Id
)values(  20);
insert into Tickets(
     
    bus_Id
)values(  20);
insert into Tickets(
     
    bus_Id
)values( 20);
insert into Tickets(
     
    bus_Id
)values(  20);
insert into Tickets(
    bus_Id
)values(  20);
insert into Tickets(
     
    bus_Id
)values(  20);
insert into Tickets(
    bus_Id
)values(  20);
insert into Tickets(
    bus_Id
)values(  20);
insert into Tickets(
    bus_Id
)values(20);
insert into Tickets(
     
    bus_Id
)values(20);
insert into Tickets(
    bus_Id
)values(20);
insert into Tickets(
    bus_Id
)values(20);
insert into Tickets(
    bus_Id
)values(20);
insert into Tickets(
    bus_Id
)values(  20);
insert into Tickets(
    bus_Id
)values(  20);
insert into Tickets(
    bus_Id
)values(  20);
insert into Tickets(
    bus_Id
)values(  20);
insert into Tickets(
    bus_Id
)values(  20);
insert into Tickets(
    bus_Id
)values(  20);


 insert into users (user_Name,password,user_Role,full_Name,date_Of_Birth,phone_Num,email,gender,address)
values ('cus01','1234',1,'Tran Trung Truc','1997-04-22','0934234234','tructt@fsoft.com.vn',1,'Tien Giang');
insert into users (user_Name,password,user_Role,full_Name,date_Of_Birth,phone_Num,email,gender,address)
values ('cus02','1234',1,'Le Trung Truc','1997-04-22','0934234234','reuctt@fsoft.com.vn',0,'Tien Giang');
insert into users (user_Name,password,user_Role,full_Name,date_Of_Birth,phone_Num,email,gender,address)
values ('cus03','1234',1,'Tran thu Truc','1997-04-22','0934234234','tyutt@fsoft.com.vn',1,'Tien Giang');
insert into users (user_Name,password,user_Role,full_Name,date_Of_Birth,phone_Num,email,gender,address)
values ('cus04','1234',1,'Trrt wwr Truc','1997-04-22','0934234234','tgstt@fsoft.com.vn',0,'Tien Giang');
insert into users (user_Name,password,user_Role,full_Name,date_Of_Birth,phone_Num,email,gender,address)
values ('cus05','1234',1,'Hunh Hong Song','1997-04-22','0934234234','thongt@fsoft.com.vn',1,'Tien Giang');

insert into users (user_Name,password,user_Role,full_Name,date_Of_Birth,phone_Num,email,gender,address)
values ('sta01','1234',2,'Hoang Mai Huy','1997-04-22','0934234234','sssst@fsoft.com.vn',0,'Tien Giang');
insert into users (user_Name,password,user_Role,full_Name,date_Of_Birth,phone_Num,email,gender,address)
values ('sta02','1234',2,'Hoang Mai Truong','1997-04-22','0933234234','sshjkt@fsoft.com.vn',1,'Tien Giang');
insert into users (user_Name,password,user_Role,full_Name,date_Of_Birth,phone_Num,email,gender,address)
values ('sta03','1234',2,'Tran Mai Truong','1997-04-22','093124234','466t@fsoft.com.vn',0,'Tien Giang');

insert into users (user_Name,password,user_Role,full_Name,date_Of_Birth,phone_Num,email,gender,address)
values ('adm01','1234',3,'Ngo Mai Truong','1997-04-22','09313234','4ngoit@fsoft.com.vn',1,'Tien Giang');
insert into users (user_Name,password,user_Role,full_Name,date_Of_Birth,phone_Num,email,gender,address)
values ('adm02','1234',3,'Tran Mai Thu','1997-04-22','09313234','4thut@fsoft.com.vn',0,'Tien Giang');
insert into orderstatuses(name)
values ('Processing');

insert into orderstatuses(name)
values ('Completed');

insert into orderstatuses(name)
values ('Canceled');

