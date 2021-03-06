USE [master]
GO
/****** Object:  Database [User]    Script Date: 8/26/2020 2:59:41 PM ******/
CREATE DATABASE [User]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'User', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\User.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'User_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\User_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [User] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [User].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [User] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [User] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [User] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [User] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [User] SET ARITHABORT OFF 
GO
ALTER DATABASE [User] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [User] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [User] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [User] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [User] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [User] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [User] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [User] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [User] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [User] SET  DISABLE_BROKER 
GO
ALTER DATABASE [User] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [User] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [User] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [User] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [User] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [User] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [User] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [User] SET RECOVERY FULL 
GO
ALTER DATABASE [User] SET  MULTI_USER 
GO
ALTER DATABASE [User] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [User] SET DB_CHAINING OFF 
GO
ALTER DATABASE [User] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [User] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [User] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'User', N'ON'
GO
USE [User]
GO
/****** Object:  Table [dbo].[APP_ROLE]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[APP_ROLE](
	[ROLE_ID] [bigint] NOT NULL,
	[ROLE_NAME] [varchar](30) NOT NULL,
 CONSTRAINT [APP_ROLE_PK] PRIMARY KEY CLUSTERED 
(
	[ROLE_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[APP_USER]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[APP_USER](
	[USER_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[USER_NAME] [varchar](100) NOT NULL,
	[ENCRYTED_PASSWORD] [varchar](128) NOT NULL,
	[ENABLED] [bit] NOT NULL,
	[SDT_USER] [nchar](11) NULL,
	[CMND_USER] [nchar](11) NULL,
	[DIACHIGIAOHANG] [nvarchar](max) NULL,
 CONSTRAINT [APP_USER_PK] PRIMARY KEY CLUSTERED 
(
	[USER_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CHITIETKYTHUAT]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIETKYTHUAT](
	[IDCHITIETKT] [bigint] IDENTITY(1,1) NOT NULL,
	[TENKT] [nvarchar](max) NULL,
	[CHITIETKT] [nvarchar](max) NULL,
	[IDSP] [int] NULL,
 CONSTRAINT [PK_CHITIETKYTHUAT] PRIMARY KEY CLUSTERED 
(
	[IDCHITIETKT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CTHOADON]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHOADON](
	[IDCTHOADON] [int] IDENTITY(1,1) NOT NULL,
	[SOLUONG] [int] NULL,
	[TONGGIA] [float] NULL,
	[IDHD] [int] NOT NULL,
	[IDSP] [int] NOT NULL,
 CONSTRAINT [PK_CTHOADON_1] PRIMARY KEY CLUSTERED 
(
	[IDCTHOADON] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CTKHUYENMAI]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTKHUYENMAI](
	[IDCTKHUYENMAI] [int] IDENTITY(1,1) NOT NULL,
	[GIAGIAM] [int] NULL,
	[IDSP] [int] NOT NULL,
	[IDKM] [int] NOT NULL,
 CONSTRAINT [PK_CTKHUYENMAI_1] PRIMARY KEY CLUSTERED 
(
	[IDCTKHUYENMAI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DANHMUCSANPHAM]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DANHMUCSANPHAM](
	[IDDANHMUCSP] [int] IDENTITY(1,1) NOT NULL,
	[TENDANHMUCSP] [nvarchar](50) NULL,
 CONSTRAINT [PK_DANHMUCSANPHAM] PRIMARY KEY CLUSTERED 
(
	[IDDANHMUCSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HANGSANXUAT]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HANGSANXUAT](
	[IDHSX] [int] IDENTITY(1,1) NOT NULL,
	[TENHSX] [nvarchar](50) NULL,
 CONSTRAINT [PK_HANGSANXUAT] PRIMARY KEY CLUSTERED 
(
	[IDHSX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HINHANHTRANG]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HINHANHTRANG](
	[IDHINH] [int] IDENTITY(1,1) NOT NULL,
	[HINHSLIDESHOW1] [text] NULL,
	[HINHSLIDESHOW2] [text] NULL,
	[HINHSLIDESHOW3] [text] NULL,
	[HINHSLIDESHOW4] [text] NULL,
	[HINHHEADER1] [text] NULL,
	[HINHHEADER2] [text] NULL,
	[HINHFOOTER1] [text] NULL,
	[HINHFOOTER2] [text] NULL,
	[HINHFOOTER3] [text] NULL,
 CONSTRAINT [PK_HINHANHTRANG] PRIMARY KEY CLUSTERED 
(
	[IDHINH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HINHSANPHAM]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HINHSANPHAM](
	[IDHINHSP] [int] IDENTITY(1,1) NOT NULL,
	[URL_HINHSP] [text] NULL,
	[IDSP] [int] NULL,
 CONSTRAINT [PK_HINHSANPHAM] PRIMARY KEY CLUSTERED 
(
	[IDHINHSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HOADON]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[IDHD] [int] IDENTITY(1,1) NOT NULL,
	[TINHTRANG] [int] NULL,
	[NGAYMUA] [date] NULL,
	[IDTHANHTOAN] [int] NULL,
	[USER_ID] [bigint] NULL,
 CONSTRAINT [PK_HOADON] PRIMARY KEY CLUSTERED 
(
	[IDHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KHUYENMAI]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHUYENMAI](
	[IDKM] [int] IDENTITY(1,1) NOT NULL,
	[TENKM] [nvarchar](50) NULL,
	[TGBD] [date] NULL,
	[TGKT] [date] NULL,
	[MOTA] [nvarchar](50) NULL,
 CONSTRAINT [PK_KHUYENMAI] PRIMARY KEY CLUSTERED 
(
	[IDKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LOAITHANHTOAN]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAITHANHTOAN](
	[IDTHANHTOAN] [int] IDENTITY(1,1) NOT NULL,
	[LOAITHANHTOAN] [nvarchar](50) NULL,
 CONSTRAINT [PK_THANHTOAN] PRIMARY KEY CLUSTERED 
(
	[IDTHANHTOAN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Persistent_Logins]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Persistent_Logins](
	[username] [varchar](64) NOT NULL,
	[series] [varchar](64) NOT NULL,
	[token] [varchar](64) NOT NULL,
	[last_used] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[series] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SANPHAM]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SANPHAM](
	[IDSP] [int] IDENTITY(1,1) NOT NULL,
	[TENSP] [nvarchar](max) NULL,
	[GIASP] [float] NULL,
	[MOTASP] [nvarchar](max) NULL,
	[SOLUONGSP] [int] NULL,
	[IDDANHMUCSP] [int] NULL,
	[IDHSX] [int] NULL,
	[ANHCHINH] [nvarchar](max) NULL,
 CONSTRAINT [PK_SANPHAM] PRIMARY KEY CLUSTERED 
(
	[IDSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[USER_ROLE]    Script Date: 8/26/2020 2:59:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USER_ROLE](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[USER_ID] [bigint] NOT NULL,
	[ROLE_ID] [bigint] NOT NULL,
 CONSTRAINT [USER_ROLE_PK] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[APP_ROLE] ([ROLE_ID], [ROLE_NAME]) VALUES (1, N'ROLE_ADMIN')
INSERT [dbo].[APP_ROLE] ([ROLE_ID], [ROLE_NAME]) VALUES (2, N'ROLE_USER')
SET IDENTITY_INSERT [dbo].[APP_USER] ON 

INSERT [dbo].[APP_USER] ([USER_ID], [USER_NAME], [ENCRYTED_PASSWORD], [ENABLED], [SDT_USER], [CMND_USER], [DIACHIGIAOHANG]) VALUES (1, N'dbadmin1', N'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1, N'0941852721 ', N'0265412589 ', N'206 Nguyễn Tử Long, P15,Q.Tân Bình,TPHCM')
INSERT [dbo].[APP_USER] ([USER_ID], [USER_NAME], [ENCRYTED_PASSWORD], [ENABLED], [SDT_USER], [CMND_USER], [DIACHIGIAOHANG]) VALUES (2, N'dbuser1', N'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1, N'0364152777 ', N'0211454546 ', N'76 Yên Phổ, phường 7, Q.Tân Phú,TPHCM')
INSERT [dbo].[APP_USER] ([USER_ID], [USER_NAME], [ENCRYTED_PASSWORD], [ENABLED], [SDT_USER], [CMND_USER], [DIACHIGIAOHANG]) VALUES (3, N'tuanhoang', N'$2a$10$bdtvNMCY5noDS8xhi21DqOTqQNIKFyYx59X2liJJweSgsriOQIlvi', 0, N'012244514  ', N'012124412  ', N'211 Bùi Dương, p15, Q Tân Cảng')
INSERT [dbo].[APP_USER] ([USER_ID], [USER_NAME], [ENCRYTED_PASSWORD], [ENABLED], [SDT_USER], [CMND_USER], [DIACHIGIAOHANG]) VALUES (4, N'thucnguyen', N'$2a$10$fDDdEQmTyQS2caA.3qujC.TytzeeyTWBhEf/0LsTTnAwXYp47Abdu', 0, N'123123123  ', N'123123     ', N'12r124124124')
INSERT [dbo].[APP_USER] ([USER_ID], [USER_NAME], [ENCRYTED_PASSWORD], [ENABLED], [SDT_USER], [CMND_USER], [DIACHIGIAOHANG]) VALUES (5, N'thucnguyen1', N'$2a$10$7T4Sau5VUAIIEcB9Eu8w5uq7KXDjLu41d9Zq/At4wAdFTYBm76VIC', 0, N'123123123  ', N'123123     ', N'12r124124124')
INSERT [dbo].[APP_USER] ([USER_ID], [USER_NAME], [ENCRYTED_PASSWORD], [ENABLED], [SDT_USER], [CMND_USER], [DIACHIGIAOHANG]) VALUES (6, N'tuanhoang1', N'$2a$10$QKHG02ZJL8bDDDhtYMR6CuwndctqVZak3LgDgOvqowQRSEbexQtYm', 1, N'124124     ', N'123123     ', N'effsf')
INSERT [dbo].[APP_USER] ([USER_ID], [USER_NAME], [ENCRYTED_PASSWORD], [ENABLED], [SDT_USER], [CMND_USER], [DIACHIGIAOHANG]) VALUES (7, N'tuan1', N'$2a$10$iVBGZ6DCXYaY898redWiXukbPCVfeLYm95uYAbFdtBvThxa5xuMBq', 1, N'123123     ', N'1223123    ', N'asslfkjalfjalkjfklfj')
SET IDENTITY_INSERT [dbo].[APP_USER] OFF
SET IDENTITY_INSERT [dbo].[CHITIETKYTHUAT] ON 

INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (1, N'CPU hỗ trợ', N'AMD AM4 Socket 3rd and 2nd AMD Ryzen™/2nd and 1st Gen AMD Ryzen™ with Radeon™ Vega Graphics Processors', 2)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (2, N'Chipset', N'AMD X570', 2)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (3, N'Mạng', N'Intel® I211-AT
ASUS LAN Guard', 2)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (4, N'Kích thước', N'Dạng thiết kế ATX
12.0 inch x 9.6 inch ( 30.5 cm x 24.4 cm )', 2)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (5, N'Quy trình', N'14 nm', 1)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (6, N'Tên mã', N'Comet Lake', 1)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (7, N'Số nhân', N'4', 1)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (8, N'Xung gốc	', N'3.6 GHz', 1)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (9, N'Chuẩn RAM', N'DDR4, PC4-3000', 3)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (10, N'Dung lượng', N'16GB (1 x 16GB)', 3)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (11, N'Tốc độ chứng thực', N'3000MHz', 3)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (12, N'Kèm quạt', N'No', 3)
INSERT [dbo].[CHITIETKYTHUAT] ([IDCHITIETKT], [TENKT], [CHITIETKT], [IDSP]) VALUES (13, N'Tuanquen', N'12312412412', 6)
SET IDENTITY_INSERT [dbo].[CHITIETKYTHUAT] OFF
SET IDENTITY_INSERT [dbo].[CTHOADON] ON 

INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (1, 1, 2200000, 3, 3)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (2, 2, 5200000, 3, 1)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (3, 7, 15400000, 4, 3)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (4, 1, 2600000, 4, 1)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (5, 1, 6590000, 4, 2)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (6, 3, 7800000, 5, 1)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (7, 3, 7800000, 6, 1)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (8, 5, 13000000, 7, 1)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (9, 3, 19770000, 8, 2)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (10, 3, 6600000, 8, 3)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (11, 10, 65900000, 9, 2)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (12, 5, 11000000, 9, 3)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (13, 4, 10400000, 10, 1)
INSERT [dbo].[CTHOADON] ([IDCTHOADON], [SOLUONG], [TONGGIA], [IDHD], [IDSP]) VALUES (14, 3, 19770000, 10, 2)
SET IDENTITY_INSERT [dbo].[CTHOADON] OFF
SET IDENTITY_INSERT [dbo].[CTKHUYENMAI] ON 

INSERT [dbo].[CTKHUYENMAI] ([IDCTKHUYENMAI], [GIAGIAM], [IDSP], [IDKM]) VALUES (1, 20, 1, 1)
SET IDENTITY_INSERT [dbo].[CTKHUYENMAI] OFF
SET IDENTITY_INSERT [dbo].[DANHMUCSANPHAM] ON 

INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (1, N'CPU - Vi Xử Lý')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (2, N'Main board - Bo Mạch Chủ')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (3, N'RAM - Bộ nhớ')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (4, N'Graphics card - Card Đồ Họa')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (5, N'HDD - Ổ đĩa cứng')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (6, N'SSD - Ổ cứng thể rắn')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (7, N'PSU - Nguồn')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (8, N'Case - Vỏ Máy Tính')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (9, N'Monitor - Màn Hình')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (10, N'Keyboard - Bàn Phím')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (11, N'Mouse - Chuột')
INSERT [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP], [TENDANHMUCSP]) VALUES (12, N'')
SET IDENTITY_INSERT [dbo].[DANHMUCSANPHAM] OFF
SET IDENTITY_INSERT [dbo].[HANGSANXUAT] ON 

INSERT [dbo].[HANGSANXUAT] ([IDHSX], [TENHSX]) VALUES (1, N'INTEL')
INSERT [dbo].[HANGSANXUAT] ([IDHSX], [TENHSX]) VALUES (2, N'AMD')
INSERT [dbo].[HANGSANXUAT] ([IDHSX], [TENHSX]) VALUES (3, N'ASUS')
INSERT [dbo].[HANGSANXUAT] ([IDHSX], [TENHSX]) VALUES (4, N'ACER')
INSERT [dbo].[HANGSANXUAT] ([IDHSX], [TENHSX]) VALUES (5, N'DELL')
INSERT [dbo].[HANGSANXUAT] ([IDHSX], [TENHSX]) VALUES (6, N'CORSIAR')
INSERT [dbo].[HANGSANXUAT] ([IDHSX], [TENHSX]) VALUES (7, N'RAZER')
INSERT [dbo].[HANGSANXUAT] ([IDHSX], [TENHSX]) VALUES (8, N'LOGITECH')
SET IDENTITY_INSERT [dbo].[HANGSANXUAT] OFF
SET IDENTITY_INSERT [dbo].[HINHANHTRANG] ON 

INSERT [dbo].[HINHANHTRANG] ([IDHINH], [HINHSLIDESHOW1], [HINHSLIDESHOW2], [HINHSLIDESHOW3], [HINHSLIDESHOW4], [HINHHEADER1], [HINHHEADER2], [HINHFOOTER1], [HINHFOOTER2], [HINHFOOTER3]) VALUES (1, N'https://tanthanhdanh.vn/wp-content/uploads/2020/07/TTD_Featured_LG27GN950_WebBanner2000x500.jpg', N'https://tanthanhdanh.vn/wp-content/uploads/2020/07/TTD_Featured_LG27GN950_WebBanner2000x500.jpg', N'https://tanthanhdanh.vn/wp-content/uploads/2020/07/TTD_Featured_LG27GN950_WebBanner2000x500.jpg', N'https://tanthanhdanh.vn/wp-content/uploads/2020/07/TTD_Promotion_2007_PreorderCaseAsusRogZ11TangFigureRog_WebBanner2000x500-1400x350.jpg', N'https://tanthanhdanh.vn/wp-content/uploads/2020/07/TTD_Promotion_2007_PreorderCaseAsusRogZ11TangFigureRog_WebBanner2000x500-1400x350.jpg', N'https://tanthanhdanh.vn/wp-content/uploads/2020/07/TTD_Promotion_2007_PreorderCaseAsusRogZ11TangFigureRog_WebBanner2000x500-1400x350.jpg', N'https://tanthanhdanh.vn/wp-content/uploads/2020/07/TTD_Promotion_2007_PreorderCaseAsusRogZ11TangFigureRog_WebBanner2000x500-1400x350.jpg', N'https://tanthanhdanh.vn/wp-content/uploads/2020/07/TTD_Promotion_2007_RouterAsusTangAoMuaROG_BannerWeb1000x500.jpg', N'https://tanthanhdanh.vn/wp-content/uploads/2020/07/TTD_Promotion_2007_RouterAsusTangUSBWifi_WebBanner1000x500.jpg')
SET IDENTITY_INSERT [dbo].[HINHANHTRANG] OFF
SET IDENTITY_INSERT [dbo].[HINHSANPHAM] ON 

INSERT [dbo].[HINHSANPHAM] ([IDHINHSP], [URL_HINHSP], [IDSP]) VALUES (1, N'https://tanthanhdanh.vn/wp-content/uploads/2020/05/Intel-10th-Gen-Core-i3-Processor-2-768x768.jpg', 1)
INSERT [dbo].[HINHSANPHAM] ([IDHINHSP], [URL_HINHSP], [IDSP]) VALUES (2, N'https://tanthanhdanh.vn/wp-content/uploads/2020/05/Intel-10th-Gen-Core-i3-Processor-3-768x768.jpg', 1)
INSERT [dbo].[HINHSANPHAM] ([IDHINHSP], [URL_HINHSP], [IDSP]) VALUES (3, N'https://tanthanhdanh.vn/wp-content/uploads/2019/11/ASUS-Prime-X570-Pro-Mainboard-2-768x768.jpg', 2)
INSERT [dbo].[HINHSANPHAM] ([IDHINHSP], [URL_HINHSP], [IDSP]) VALUES (4, N'https://tanthanhdanh.vn/wp-content/uploads/2019/11/ASUS-Prime-X570-Pro-Mainboard-2-768x768.jpg', 2)
INSERT [dbo].[HINHSANPHAM] ([IDHINHSP], [URL_HINHSP], [IDSP]) VALUES (5, N'https://tanthanhdanh.vn/wp-content/uploads/2019/11/ASUS-Prime-X570-Pro-Mainboard-IO.jpg', 2)
INSERT [dbo].[HINHSANPHAM] ([IDHINHSP], [URL_HINHSP], [IDSP]) VALUES (6, N'https://tanthanhdanh.vn/wp-content/uploads/2019/11/ADATA-XPG-SPECTRIX-D80-1.jpg', 3)
INSERT [dbo].[HINHSANPHAM] ([IDHINHSP], [URL_HINHSP], [IDSP]) VALUES (10, N'https://tanthanhdanh.vn/wp-content/uploads/2019/12/Razer-Hammerhead-True-Wireless-Earbuds-3-768x768.jpg', 6)
INSERT [dbo].[HINHSANPHAM] ([IDHINHSP], [URL_HINHSP], [IDSP]) VALUES (11, N'', 6)
SET IDENTITY_INSERT [dbo].[HINHSANPHAM] OFF
SET IDENTITY_INSERT [dbo].[HOADON] ON 

INSERT [dbo].[HOADON] ([IDHD], [TINHTRANG], [NGAYMUA], [IDTHANHTOAN], [USER_ID]) VALUES (1, 1, CAST(N'2020-08-17' AS Date), 1, 1)
INSERT [dbo].[HOADON] ([IDHD], [TINHTRANG], [NGAYMUA], [IDTHANHTOAN], [USER_ID]) VALUES (2, 2, CAST(N'2020-08-17' AS Date), 2, 2)
INSERT [dbo].[HOADON] ([IDHD], [TINHTRANG], [NGAYMUA], [IDTHANHTOAN], [USER_ID]) VALUES (3, 1, CAST(N'2020-08-18' AS Date), 1, 2)
INSERT [dbo].[HOADON] ([IDHD], [TINHTRANG], [NGAYMUA], [IDTHANHTOAN], [USER_ID]) VALUES (4, 2, CAST(N'2020-08-19' AS Date), 1, 2)
INSERT [dbo].[HOADON] ([IDHD], [TINHTRANG], [NGAYMUA], [IDTHANHTOAN], [USER_ID]) VALUES (5, 1, CAST(N'2020-08-20' AS Date), 1, 1)
INSERT [dbo].[HOADON] ([IDHD], [TINHTRANG], [NGAYMUA], [IDTHANHTOAN], [USER_ID]) VALUES (6, 1, CAST(N'2020-08-20' AS Date), 2, 1)
INSERT [dbo].[HOADON] ([IDHD], [TINHTRANG], [NGAYMUA], [IDTHANHTOAN], [USER_ID]) VALUES (7, 1, CAST(N'2020-08-20' AS Date), 1, 2)
INSERT [dbo].[HOADON] ([IDHD], [TINHTRANG], [NGAYMUA], [IDTHANHTOAN], [USER_ID]) VALUES (8, 2, CAST(N'2020-08-20' AS Date), 2, 2)
INSERT [dbo].[HOADON] ([IDHD], [TINHTRANG], [NGAYMUA], [IDTHANHTOAN], [USER_ID]) VALUES (9, 2, CAST(N'2020-08-20' AS Date), 1, 1)
INSERT [dbo].[HOADON] ([IDHD], [TINHTRANG], [NGAYMUA], [IDTHANHTOAN], [USER_ID]) VALUES (10, 0, CAST(N'2020-08-21' AS Date), 1, 1)
SET IDENTITY_INSERT [dbo].[HOADON] OFF
SET IDENTITY_INSERT [dbo].[KHUYENMAI] ON 

INSERT [dbo].[KHUYENMAI] ([IDKM], [TENKM], [TGBD], [TGKT], [MOTA]) VALUES (1, N'Mừng Ngày Hết Covid-19', CAST(N'2020-08-06' AS Date), CAST(N'2020-12-09' AS Date), N'Ngày lễ kỷ niệm hằng năm')
SET IDENTITY_INSERT [dbo].[KHUYENMAI] OFF
SET IDENTITY_INSERT [dbo].[LOAITHANHTOAN] ON 

INSERT [dbo].[LOAITHANHTOAN] ([IDTHANHTOAN], [LOAITHANHTOAN]) VALUES (1, N'SHIP COD')
INSERT [dbo].[LOAITHANHTOAN] ([IDTHANHTOAN], [LOAITHANHTOAN]) VALUES (2, N'Tiền Mặt')
SET IDENTITY_INSERT [dbo].[LOAITHANHTOAN] OFF
SET IDENTITY_INSERT [dbo].[SANPHAM] ON 

INSERT [dbo].[SANPHAM] ([IDSP], [TENSP], [GIASP], [MOTASP], [SOLUONGSP], [IDDANHMUCSP], [IDHSX], [ANHCHINH]) VALUES (1, N'Intel 10th Gen Core i3-10100 Processor', 3250000, N'Chip Intel Core i3 th? h? th? 10 Comet Lake m?i nh?t hi?n nay
Ki?n trúc Mesh cho phép nhân x? lý ti?p c?n tr?c ti?p h? th?ng gi?m t?i da d? tr?
Khai thác Deep Learning Boost t?i uu hóa tác v? cho AI
T?n nhi?t t?t hon, ép xung hi?u qu? hon th? h? tru?c
Công ngh? siêu phân lu?ng cao c?p
Công ngh? Intel Turbo Boost Max 3.0
H? tr? Wi-Fi 6 AX200 và 2.5GbE', 89, 1, 1, N'https://tanthanhdanh.vn/wp-content/uploads/2020/05/Intel-10th-Gen-Core-i3-Processor-1-768x768.jpg')
INSERT [dbo].[SANPHAM] ([IDSP], [TENSP], [GIASP], [MOTASP], [SOLUONGSP], [IDDANHMUCSP], [IDHSX], [ANHCHINH]) VALUES (2, N'ASUS Prime X570-Pro Mainboard', 6590000, N'Cải thiện giải pháp điện năng: Linh kiện cao cấp cho dòng điện ổn định
Tối ưu 5 Chiều: Hiệu chỉnh tự động toàn hệ thống, cung cấp các hồ sơ ép xung và làm mát được tùy chỉnh cho hệ thống của bạn
Fan Xpert 4: Điều khiển linh hoạt cho khả năng làm mát yên tĩnh đỉnh cao
ASUS OptiMem: Định tuyến tỉ mỉ các vết và các via để đảm bảo sự toàn vẹn của tín hiệu giúp cải thiện ép xung bộ nhớ
Kết nối tương lai: PCIe thế hệ 4, dual M.2, USB 3.2 thế hệ 2 trước và sau
Bộ làm mát M.2 trên bo mạch: Làm mát ổ đĩa M.2 của bạn, cho hiệu năng lưu trữ ổn định và tăng cường độ tin cậy
Đồng bộ ánh sáng RGB với nhiều loại thiết bị máy tính hỗ trợ Aura Sync – giờ đây còn hỗ trợ các dải đèn LED thế hệ mới', 92, 2, 2, N'https://tanthanhdanh.vn/wp-content/uploads/2019/11/ASUS-Prime-X570-Pro-Mainboard-1-768x768.jpg')
INSERT [dbo].[SANPHAM] ([IDSP], [TENSP], [GIASP], [MOTASP], [SOLUONGSP], [IDDANHMUCSP], [IDHSX], [ANHCHINH]) VALUES (3, N'ADATA SPECTRIX D80 RGB Memory Kit – Black, 16GB (1 x 16GB) DDR4 3000MHz CL16, Liquid Cooling', 2200000, N'RAM tản nước độc đáo với màu RGB
Hàn kín khí tuyệt đối, không thể rò rỉ
Tản nhiệt kết hợp nhôm và dung dịch
Ánh sáng RGB có thể điều chỉnh
Khả năng ép xung cao độ, tin cậy', 92, 3, 6, N'https://tanthanhdanh.vn/wp-content/uploads/2019/11/ADATA-XPG-SPECTRIX-D80-1.jpg')
INSERT [dbo].[SANPHAM] ([IDSP], [TENSP], [GIASP], [MOTASP], [SOLUONGSP], [IDDANHMUCSP], [IDHSX], [ANHCHINH]) VALUES (6, N'TUAN ', 12000, N'asdlkajskldjaskldjlajsdjasljdlaskjdlkajslkjdas', 100, 1, 1, N'https://tanthanhdanh.vn/wp-content/uploads/2020/05/Razer-Huntsman-Gears-5-Edition-Gaming-Keyboard-%E2%80%93-Opto-Mechanical-Switch-1-768x768.jpg')
SET IDENTITY_INSERT [dbo].[SANPHAM] OFF
SET IDENTITY_INSERT [dbo].[USER_ROLE] ON 

INSERT [dbo].[USER_ROLE] ([ID], [USER_ID], [ROLE_ID]) VALUES (1, 1, 1)
INSERT [dbo].[USER_ROLE] ([ID], [USER_ID], [ROLE_ID]) VALUES (2, 1, 2)
INSERT [dbo].[USER_ROLE] ([ID], [USER_ID], [ROLE_ID]) VALUES (3, 2, 2)
INSERT [dbo].[USER_ROLE] ([ID], [USER_ID], [ROLE_ID]) VALUES (4, 7, 2)
SET IDENTITY_INSERT [dbo].[USER_ROLE] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [APP_ROLE_UK]    Script Date: 8/26/2020 2:59:41 PM ******/
ALTER TABLE [dbo].[APP_ROLE] ADD  CONSTRAINT [APP_ROLE_UK] UNIQUE NONCLUSTERED 
(
	[ROLE_NAME] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [APP_USER_UK]    Script Date: 8/26/2020 2:59:41 PM ******/
ALTER TABLE [dbo].[APP_USER] ADD  CONSTRAINT [APP_USER_UK] UNIQUE NONCLUSTERED 
(
	[USER_NAME] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [USER_ROLE_UK]    Script Date: 8/26/2020 2:59:41 PM ******/
ALTER TABLE [dbo].[USER_ROLE] ADD  CONSTRAINT [USER_ROLE_UK] UNIQUE NONCLUSTERED 
(
	[USER_ID] ASC,
	[ROLE_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CHITIETKYTHUAT]  WITH CHECK ADD  CONSTRAINT [FK_CHITIETKYTHUAT_SP] FOREIGN KEY([IDSP])
REFERENCES [dbo].[SANPHAM] ([IDSP])
GO
ALTER TABLE [dbo].[CHITIETKYTHUAT] CHECK CONSTRAINT [FK_CHITIETKYTHUAT_SP]
GO
ALTER TABLE [dbo].[CTHOADON]  WITH CHECK ADD  CONSTRAINT [FK_CTHOADON_HOADON] FOREIGN KEY([IDHD])
REFERENCES [dbo].[HOADON] ([IDHD])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[CTHOADON] CHECK CONSTRAINT [FK_CTHOADON_HOADON]
GO
ALTER TABLE [dbo].[CTHOADON]  WITH CHECK ADD  CONSTRAINT [FK_CTHOADON_SANPHAM] FOREIGN KEY([IDSP])
REFERENCES [dbo].[SANPHAM] ([IDSP])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[CTHOADON] CHECK CONSTRAINT [FK_CTHOADON_SANPHAM]
GO
ALTER TABLE [dbo].[CTKHUYENMAI]  WITH CHECK ADD  CONSTRAINT [FK_CTKHUYENMAI_KHUYENMAI] FOREIGN KEY([IDKM])
REFERENCES [dbo].[KHUYENMAI] ([IDKM])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[CTKHUYENMAI] CHECK CONSTRAINT [FK_CTKHUYENMAI_KHUYENMAI]
GO
ALTER TABLE [dbo].[CTKHUYENMAI]  WITH CHECK ADD  CONSTRAINT [FK_CTKHUYENMAI_SANPHAM] FOREIGN KEY([IDSP])
REFERENCES [dbo].[SANPHAM] ([IDSP])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[CTKHUYENMAI] CHECK CONSTRAINT [FK_CTKHUYENMAI_SANPHAM]
GO
ALTER TABLE [dbo].[HINHSANPHAM]  WITH CHECK ADD  CONSTRAINT [FK_HINHSANPHAM_IDSP] FOREIGN KEY([IDSP])
REFERENCES [dbo].[SANPHAM] ([IDSP])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HINHSANPHAM] CHECK CONSTRAINT [FK_HINHSANPHAM_IDSP]
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_LOAITHANHTOAN] FOREIGN KEY([IDTHANHTOAN])
REFERENCES [dbo].[LOAITHANHTOAN] ([IDTHANHTOAN])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HOADON] CHECK CONSTRAINT [FK_HOADON_LOAITHANHTOAN]
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_USER] FOREIGN KEY([USER_ID])
REFERENCES [dbo].[APP_USER] ([USER_ID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HOADON] CHECK CONSTRAINT [FK_HOADON_USER]
GO
ALTER TABLE [dbo].[SANPHAM]  WITH CHECK ADD  CONSTRAINT [FK_SANPHAM_DANHMUC] FOREIGN KEY([IDDANHMUCSP])
REFERENCES [dbo].[DANHMUCSANPHAM] ([IDDANHMUCSP])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[SANPHAM] CHECK CONSTRAINT [FK_SANPHAM_DANHMUC]
GO
ALTER TABLE [dbo].[SANPHAM]  WITH CHECK ADD  CONSTRAINT [FK_SANPHAM_HSX] FOREIGN KEY([IDHSX])
REFERENCES [dbo].[HANGSANXUAT] ([IDHSX])
GO
ALTER TABLE [dbo].[SANPHAM] CHECK CONSTRAINT [FK_SANPHAM_HSX]
GO
ALTER TABLE [dbo].[USER_ROLE]  WITH CHECK ADD  CONSTRAINT [USER_ROLE_FK1] FOREIGN KEY([USER_ID])
REFERENCES [dbo].[APP_USER] ([USER_ID])
GO
ALTER TABLE [dbo].[USER_ROLE] CHECK CONSTRAINT [USER_ROLE_FK1]
GO
ALTER TABLE [dbo].[USER_ROLE]  WITH CHECK ADD  CONSTRAINT [USER_ROLE_FK2] FOREIGN KEY([ROLE_ID])
REFERENCES [dbo].[APP_ROLE] ([ROLE_ID])
GO
ALTER TABLE [dbo].[USER_ROLE] CHECK CONSTRAINT [USER_ROLE_FK2]
GO
USE [master]
GO
ALTER DATABASE [User] SET  READ_WRITE 
GO
