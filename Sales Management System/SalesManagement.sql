create database [SalesManagement]
go
use [SalesManagement]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 11/09/2017 13:14:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Product](
	[ID] [int] NOT NULL,
	[ProductName] [varchar](100) NOT NULL,
	[Price] [float] NOT NULL,
	[SalePrice] [float] NOT NULL,
	[Stock] [int] NOT NULL,
	[Approved] [char](1) NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Product] ([ID], [ProductName], [Price], [SalePrice], [Stock], [Approved]) VALUES (1, N'Supreme Rice', 100,120,  50,'Y')
INSERT [dbo].[Product] ([ID], [ProductName], [Price], [SalePrice], [Stock], [Approved]) VALUES (2, N'Dawn Bread',  50,70, 200,'Y')
INSERT [dbo].[Product] ([ID], [ProductName], [Price], [SalePrice], [Stock], [Approved]) VALUES (3, N'6 Eggs',  30, 45,100,'Y')
INSERT [dbo].[Product] ([ID], [ProductName], [Price], [SalePrice], [Stock], [Approved]) VALUES (4, N'Nestle Mango Juice',  25,40, 400,'Y')
INSERT [dbo].[Product] ([ID], [ProductName], [Price], [SalePrice], [Stock], [Approved]) VALUES (5, N'Walls Cornetto', 30, 50, 250,'Y')
INSERT [dbo].[Product] ([ID], [ProductName], [Price], [SalePrice], [Stock], [Approved]) VALUES (6, N'Coca Cola 1.5ltr', 40, 80, 550,'Y')
INSERT [dbo].[Product] ([ID], [ProductName], [Price], [SalePrice], [Stock], [Approved]) VALUES (7, N'Nestle Instant Coffee',  15,35, 550,'N')
INSERT [dbo].[Product] ([ID], [ProductName], [Price], [SalePrice], [Stock], [Approved]) VALUES (8, N'Oye Hoye Chilli Family Pack', 25,50,  550,'Y')
INSERT [dbo].[Product] ([ID], [ProductName], [Price], [SalePrice], [Stock], [Approved]) VALUES (9, N'Michalle Orange Marmalade',  230,300, 550,'Y')
INSERT [dbo].[Product] ([ID], [ProductName], [Price], [SalePrice], [Stock], [Approved]) VALUES (10, N'Tapal Tea Pouch 0.25Kg',  250,310, 550,'N')
/****** Object:  Table [dbo].[Person]    Script Date: 11/09/2017 13:14:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Person](
	[PID] [varchar](10) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Address] [varchar](500) NULL,
	[Mobile] [char](11) NULL,
	[Payment Method] [varchar](50) NOT NULL,
	[Approved] [char](1) NOT NULL,
 CONSTRAINT [PK_Person] PRIMARY KEY CLUSTERED 
(
	[PID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'A1', N'OOAD Group', N'45gds', N'03334567895', N'Credit','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'C1', N'Ahmad     ', N'43542fdsd', N'03334567882', N'Cash','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'C2', N'Ahmad', N'473hdsds  ', N'03334567892', N'Cash','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'C3', N'Faizan', N'4784nhjkj', N'03334567891', N'Credit','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'C4', N'Zain', N'ew454', N'03334567893', N'Cash','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'C5', N'Haroon', N'435fdsd', N'03334567894', N'Credit','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'C8', N'Ahmad     ', N'4453fssa', N'03334567883', N'Cash','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'E1', N'Maghfoor', N'fdsfds', N'03334567898', N'Credit','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'E2', N'Muhammad', N'fdssfd54', N'03334567899', N'Credit','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'E3', N'Sultan', N'445dfs', N'03334567881', N'Credit','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'M1', N'Ahmad     ', N'3543dfs', N'03334567896', N'Credit','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'M2', N'Anas', N'4533', N'03334567897', N'Credit','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'S1', N'Rabia', N'7644vd', N'03334567885', N'Cash','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'S2', N'Ahmad     ', N'653fdsa', N'03334567884', N'Cash','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'S3', N'Ali', N'75fds', N'03334567886', N'Cash','Y')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'C9', N'Khalid     ', N'653fdsa', N'03332367884', N'Cash','N')
INSERT [dbo].[Person] ([PID], [Name], [Address], [Mobile], [Payment Method], [Approved]) VALUES (N'C10', N'Burhan', N'75fds', N'03334237886', N'Cash','N')
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 11/09/2017 13:14:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[OrderID] [int] NOT NULL,
	[CustID] [varchar](10) NULL,
	[TotalCost] [float] NOT NULL,
	[Discount] [float] NOT NULL,
	[Date] [date] NOT NULL,
 CONSTRAINT [PK_OrderDetails_1] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[OrderDetails] ([OrderID], [CustID], [TotalCost], [Discount], [Date]) VALUES (1, N'C1', 3000, 500,CONVERT(datetime, '1.2.2017', 120))
INSERT [dbo].[OrderDetails] ([OrderID], [CustID], [TotalCost], [Discount], [Date]) VALUES (2, N'S1', 5000, 0,CONVERT(datetime, '11.12.2017', 120))
INSERT [dbo].[OrderDetails] ([OrderID], [CustID], [TotalCost], [Discount], [Date]) VALUES (3, N'C2', 1000, 0,CONVERT(datetime, '3.21.2017', 120))
INSERT [dbo].[OrderDetails] ([OrderID], [CustID], [TotalCost], [Discount], [Date]) VALUES (4, N'E1', 2500, 100,CONVERT(datetime, '7.14.2016', 120))
/****** Object:  Table [dbo].[Member]    Script Date: 11/09/2017 13:14:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Member](
	[ID] [varchar](10) NOT NULL,
	[CardID] [int] NOT NULL,
	[Point] [int] NOT NULL,
 CONSTRAINT [PK_Member] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Member] ([ID], [CardID], [Point]) VALUES (N'S1', 1, 0)
INSERT [dbo].[Member] ([ID], [CardID], [Point]) VALUES (N'S2', 2, 20)
INSERT [dbo].[Member] ([ID], [CardID], [Point]) VALUES (N'S3', 3, 50)
/****** Object:  Table [dbo].[Employee]    Script Date: 11/09/2017 13:14:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employee](
	[ID] [varchar](10) NOT NULL,
	[Salary] [float] NOT NULL,
	[Username] [varchar](50) NULL,
	[Password] [varchar](50) NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Employee] ([ID], [Salary], [Username], [Password]) VALUES (N'A1', 300000, N'ooad', N'123456')
INSERT [dbo].[Employee] ([ID], [Salary], [Username], [Password]) VALUES (N'E1', 20000, N'abc', N'123')
INSERT [dbo].[Employee] ([ID], [Salary], [Username], [Password]) VALUES (N'E2', 30000, N'gfd', N'234')
INSERT [dbo].[Employee] ([ID], [Salary], [Username], [Password]) VALUES (N'E3', 40000, N'dsfs', N'123')
INSERT [dbo].[Employee] ([ID], [Salary], [Username], [Password]) VALUES (N'M1', 50000, N'jfds', N'6732')
INSERT [dbo].[Employee] ([ID], [Salary], [Username], [Password]) VALUES (N'M2', 74000, N'hfdsds', N'8323')
/****** Object:  Table [dbo].[Orders]    Script Date: 11/09/2017 13:14:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
	[QuantityOrdered] [int] NOT NULL,
 CONSTRAINT [PK_Table_1_1] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC,
	[ProductID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Orders] ([OrderID], [ProductID], [QuantityOrdered]) VALUES (1, 1, 2)
INSERT [dbo].[Orders] ([OrderID], [ProductID], [QuantityOrdered]) VALUES (1, 2, 5)
INSERT [dbo].[Orders] ([OrderID], [ProductID], [QuantityOrdered]) VALUES (1, 3, 3)
INSERT [dbo].[Orders] ([OrderID], [ProductID], [QuantityOrdered]) VALUES (2, 1, 3)
INSERT [dbo].[Orders] ([OrderID], [ProductID], [QuantityOrdered]) VALUES (3, 1, 4)
INSERT [dbo].[Orders] ([OrderID], [ProductID], [QuantityOrdered]) VALUES (3, 6, 4)
INSERT [dbo].[Orders] ([OrderID], [ProductID], [QuantityOrdered]) VALUES (4, 2, 5)
INSERT [dbo].[Orders] ([OrderID], [ProductID], [QuantityOrdered]) VALUES (4, 5, 3)
INSERT [dbo].[Orders] ([OrderID], [ProductID], [QuantityOrdered]) VALUES (4, 6, 6)
/****** Object:  ForeignKey [FK_Employee_Person]    Script Date: 11/09/2017 13:14:02 ******/
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Person] FOREIGN KEY([ID])
REFERENCES [dbo].[Person] ([PID])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Person]
GO
/****** Object:  ForeignKey [FK_Member_Person]    Script Date: 11/09/2017 13:14:02 ******/
ALTER TABLE [dbo].[Member]  WITH CHECK ADD  CONSTRAINT [FK_Member_Person] FOREIGN KEY([ID])
REFERENCES [dbo].[Person] ([PID])
GO
ALTER TABLE [dbo].[Member] CHECK CONSTRAINT [FK_Member_Person]
GO
/****** Object:  ForeignKey [FK_OrderDetails_Person]    Script Date: 11/09/2017 13:14:02 ******/
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Person] FOREIGN KEY([CustID])
REFERENCES [dbo].[Person] ([PID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Person]
GO
/****** Object:  ForeignKey [FK_Orders_OrderDetails]    Script Date: 11/09/2017 13:14:02 ******/
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_OrderDetails] FOREIGN KEY([OrderID])
REFERENCES [dbo].[OrderDetails] ([OrderID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_OrderDetails]
GO
/****** Object:  ForeignKey [FK_Orders_Product]    Script Date: 11/09/2017 13:14:02 ******/
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Product] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Product]
GO
