USE [QLyLuongSP]
GO
/****** Object:  Table [dbo].[BangChamCongCongNhan]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangChamCongCongNhan](
	[maPhanCong] [char](10) NOT NULL,
	[caLam] [nvarchar](50) NOT NULL,
	[ngayChamCong] [date] NOT NULL,
	[soLuongLam] [int] NOT NULL,
	[trangThaiDiLam] [nvarchar](50) NULL,
	[gioDiLam] [nvarchar](50) NULL,
 CONSTRAINT [PK_BangChamCongCongNhan] PRIMARY KEY CLUSTERED 
(
	[maPhanCong] ASC,
	[caLam] ASC,
	[ngayChamCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangChamCongNhanVien]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangChamCongNhanVien](
	[maNhanVien] [char](10) NOT NULL,
	[caLam] [nvarchar](50) NOT NULL,
	[ngayChamCong] [date] NOT NULL,
	[trangThaiDiLam] [nvarchar](30) NOT NULL,
	[gioDiLam] [nvarchar](30) NULL,
	[gioTangCa] [int] NULL,
	[maNguoiCham] [char](10) NOT NULL,
 CONSTRAINT [PK_BangChamCongNhanVien_1] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC,
	[caLam] ASC,
	[ngayChamCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangLuongCongNhan]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangLuongCongNhan](
	[maBangLuong] [char](10) NOT NULL,
	[maCongNhan] [char](10) NOT NULL,
	[ngayTinh] [date] NOT NULL,
	[soLuongSanPhamLam] [int] NOT NULL,
	[soNgayDiLam] [int] NOT NULL,
	[soNgayNghi] [int] NOT NULL,
	[soNghiCoPhep] [int] NOT NULL,
	[tongLuong] [money] NULL,
	[donViTien] [nvarchar](50) NULL,
 CONSTRAINT [PK_BangLuongCongNhan] PRIMARY KEY CLUSTERED 
(
	[maBangLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangLuongNhanVien]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangLuongNhanVien](
	[maBangLuong] [char](10) NOT NULL,
	[maNhanVien] [char](10) NOT NULL,
	[soNgayDiLam] [int] NOT NULL,
	[soNgayNghi] [int] NOT NULL,
	[soPhepNghi] [int] NOT NULL,
	[ngayTinh] [date] NOT NULL,
	[luongTheoThang] [nvarchar](50) NULL,
	[luongTangCa] [money] NULL,
	[phuCap] [money] NULL,
	[thucLanh] [money] NULL,
	[donViTien] [nchar](10) NULL,
 CONSTRAINT [PK_BangLuongNhanVien] PRIMARY KEY CLUSTERED 
(
	[maBangLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongDoan]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongDoan](
	[maCongDoan] [char](10) NOT NULL,
	[thuTuCD] [int] NOT NULL,
	[tenCongDoan] [nvarchar](50) NOT NULL,
	[soLuongCan] [int] NOT NULL,
	[tinhTrang] [nvarchar](50) NULL,
	[thoiHan] [date] NOT NULL,
	[maSanPham] [char](10) NOT NULL,
	[donGia] [money] NULL,
 CONSTRAINT [PK_CongDoan] PRIMARY KEY CLUSTERED 
(
	[maCongDoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongNhan]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongNhan](
	[maCongNhan] [char](10) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[maCCCD] [char](12) NOT NULL,
	[soDienThoai] [char](12) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[gioiTinh] [bit] NULL,
	[anhDaiDien] [varchar](100) NULL,
	[diaChi] [nvarchar](100) NULL,
	[ngayVaoLam] [date] NULL,
	[toNhom] [char](10) NULL,
 CONSTRAINT [PK_CongNhan] PRIMARY KEY CLUSTERED 
(
	[maCongNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDong]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDong](
	[maHopDong] [char](10) NOT NULL,
	[tenHopDong] [nvarchar](100) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[tienDatCoc] [money] NOT NULL,
	[triGiaHD] [money] NOT NULL,
	[ngayKyKetHD] [date] NOT NULL,
	[ngayKetThucHD] [date] NOT NULL,
	[yeuCau] [nvarchar](1000) NULL,
	[maNguoiKyKet] [char](10) NOT NULL,
 CONSTRAINT [PK_HopDong] PRIMARY KEY CLUSTERED 
(
	[maHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [char](10) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[maCCCD] [char](12) NOT NULL,
	[soDienThoai] [char](12) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[matKhau] [varchar](30) NOT NULL,
	[chucVu] [nvarchar](50) NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
	[luongCoBan] [money] NULL,
	[gioiTinh] [bit] NULL,
	[anhDaiDien] [varchar](100) NULL,
	[diaChi] [nvarchar](100) NULL,
	[maPhongBan] [char](10) NOT NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanCongCongNhan]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanCongCongNhan](
	[maPhanCong] [char](10) NOT NULL,
	[maCongNhan] [char](10) NOT NULL,
	[maNguoiPhanCong] [char](10) NOT NULL,
	[maCongDoan] [char](10) NOT NULL,
	[ngayPhanCong] [date] NULL,
	[soLuongCanLam] [int] NULL,
	[maToNhom] [char](10) NOT NULL,
 CONSTRAINT [PK_PhanCongCongDoan] PRIMARY KEY CLUSTERED 
(
	[maPhanCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongBan]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongBan](
	[maPhongBan] [char](10) NOT NULL,
	[tenPhongBan] [nvarchar](50) NULL,
	[soLuongNhanVien] [int] NULL,
 CONSTRAINT [PK_PhongBan_1] PRIMARY KEY CLUSTERED 
(
	[maPhongBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [char](10) NOT NULL,
	[tenSanPham] [nvarchar](50) NOT NULL,
	[soLuongSanPham] [int] NOT NULL,
	[donGia] [money] NULL,
	[chatLieu] [nvarchar](50) NOT NULL,
	[kichThuoc] [nvarchar](50) NULL,
	[anhSanPham] [varchar](50) NULL,
	[soLuongCongDoan] [int] NULL,
	[maHopDong] [char](10) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ToNhom]    Script Date: 11/9/2023 4:19:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ToNhom](
	[maToNhom] [char](10) NOT NULL,
	[tenToNhom] [nvarchar](50) NOT NULL,
	[soLuongCongNhan] [int] NULL,
 CONSTRAINT [PK_ToNhom] PRIMARY KEY CLUSTERED 
(
	[maToNhom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BangChamCongCongNhan] ([maPhanCong], [caLam], [ngayChamCong], [soLuongLam], [trangThaiDiLam], [gioDiLam]) VALUES (N'PPPC100001', N'Sáng', CAST(N'2023-11-09' AS Date), 60, N'Đi Làm', N'6h00')
INSERT [dbo].[BangChamCongCongNhan] ([maPhanCong], [caLam], [ngayChamCong], [soLuongLam], [trangThaiDiLam], [gioDiLam]) VALUES (N'PPPC100004', N'Sáng', CAST(N'2023-11-09' AS Date), 80, N'Đi Làm', N'6h00')
INSERT [dbo].[BangChamCongCongNhan] ([maPhanCong], [caLam], [ngayChamCong], [soLuongLam], [trangThaiDiLam], [gioDiLam]) VALUES (N'PPPC100007', N'Sáng', CAST(N'2023-11-09' AS Date), 88, N'Đi Làm', N'6h00')
INSERT [dbo].[BangChamCongCongNhan] ([maPhanCong], [caLam], [ngayChamCong], [soLuongLam], [trangThaiDiLam], [gioDiLam]) VALUES (N'PPPC100009', N'Sáng', CAST(N'2023-11-09' AS Date), 70, N'Đi Làm', N'6h00')
INSERT [dbo].[BangChamCongCongNhan] ([maPhanCong], [caLam], [ngayChamCong], [soLuongLam], [trangThaiDiLam], [gioDiLam]) VALUES (N'PPPC100010', N'Sáng', CAST(N'2023-11-09' AS Date), 65, N'Đi Làm', N'6h00')
GO
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Chiều', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'14h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Chiều', CAST(N'2023-11-06' AS Date), N'Đi Làm', N'14h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Chiều', CAST(N'2023-11-08' AS Date), N'Đi Làm', N'14h00', 6, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Sáng', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Sáng', CAST(N'2023-11-06' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Sáng', CAST(N'2023-11-07' AS Date), N'Đi Làm', N'7h00', 6, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Sáng', CAST(N'2023-11-08' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Sáng', CAST(N'2023-11-09' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Sáng chủ nhật', CAST(N'2023-11-05' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Chiều', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'14h00', 2, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Chiều', CAST(N'2023-11-06' AS Date), N'Đi Làm', N'14h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Chiều', CAST(N'2023-11-08' AS Date), N'Đi Làm', N'14h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Sáng', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'7h00', 4, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Sáng', CAST(N'2023-11-06' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Sáng', CAST(N'2023-11-07' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Sáng', CAST(N'2023-11-08' AS Date), N'Đi Làm', N'7h00', 2, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Sáng', CAST(N'2023-11-09' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Sáng chủ nhật', CAST(N'2023-11-05' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Chiều', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'14h00', 2, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Chiều', CAST(N'2023-11-06' AS Date), N'Đi Làm', N'14h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Chiều', CAST(N'2023-11-08' AS Date), N'Đi Làm', N'14h00', 4, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Sáng', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'7h00', 8, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Sáng', CAST(N'2023-11-06' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Sáng', CAST(N'2023-11-07' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Sáng', CAST(N'2023-11-08' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Sáng', CAST(N'2023-11-09' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Sáng chủ nhật', CAST(N'2023-11-05' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100004', N'Chiều', CAST(N'2023-11-06' AS Date), N'Đi Làm', N'14h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100004', N'Chiều', CAST(N'2023-11-08' AS Date), N'Đi Làm', N'14h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100004', N'Sáng', CAST(N'2023-11-07' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100004', N'Sáng', CAST(N'2023-11-08' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100004', N'Sáng', CAST(N'2023-11-09' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100005', N'Chiều', CAST(N'2023-11-08' AS Date), N'Đi Làm', N'14h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100005', N'Sáng', CAST(N'2023-11-08' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100005', N'Sáng', CAST(N'2023-11-09' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100006', N'Sáng', CAST(N'2023-11-09' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
GO
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [maNhanVien], [soNgayDiLam], [soNgayNghi], [soPhepNghi], [ngayTinh], [luongTheoThang], [luongTangCa], [phuCap], [thucLanh], [donViTien]) VALUES (N'PPLN100001', N'PPNV100001', 9, 0, 0, CAST(N'2023-11-09' AS Date), N'11-2023', 892857.1429, 1116071.4286, 10044642.8571, N'VND       ')
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [maNhanVien], [soNgayDiLam], [soNgayNghi], [soPhepNghi], [ngayTinh], [luongTheoThang], [luongTangCa], [phuCap], [thucLanh], [donViTien]) VALUES (N'PPLN100002', N'PPNV100002', 9, 0, 0, CAST(N'2023-11-09' AS Date), N'11-2023', 404761.9048, 516071.4286, 6385119.0476, N'VND       ')
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [maNhanVien], [soNgayDiLam], [soNgayNghi], [soPhepNghi], [ngayTinh], [luongTheoThang], [luongTangCa], [phuCap], [thucLanh], [donViTien]) VALUES (N'PPLN100003', N'PPNV100003', 9, 0, 0, CAST(N'2023-11-09' AS Date), N'11-2023', 875000.0000, 787500.0000, 8412500.0000, N'VND       ')
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [maNhanVien], [soNgayDiLam], [soNgayNghi], [soPhepNghi], [ngayTinh], [luongTheoThang], [luongTangCa], [phuCap], [thucLanh], [donViTien]) VALUES (N'PPLN100004', N'PPNV100004', 5, 0, 0, CAST(N'2023-11-09' AS Date), N'11-2023', 0.0000, 425000.0000, 2925000.0000, N'VND       ')
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [maNhanVien], [soNgayDiLam], [soNgayNghi], [soPhepNghi], [ngayTinh], [luongTheoThang], [luongTangCa], [phuCap], [thucLanh], [donViTien]) VALUES (N'PPLN100005', N'PPNV100005', 3, 0, 0, CAST(N'2023-11-09' AS Date), N'11-2023', 0.0000, 985714.2857, 3450000.0000, N'VND       ')
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [maNhanVien], [soNgayDiLam], [soNgayNghi], [soPhepNghi], [ngayTinh], [luongTheoThang], [luongTangCa], [phuCap], [thucLanh], [donViTien]) VALUES (N'PPLN100006', N'PPNV100006', 1, 0, 0, CAST(N'2023-11-09' AS Date), N'11-2023', 0.0000, 400000.0000, 900000.0000, N'VND       ')
GO
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100001', 1, N'Lên Khuôn', 1500, N'4.00%', CAST(N'2024-10-17' AS Date), N'PPSP100001', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100002', 2, N'Khâu dập', 1500, N'0%', CAST(N'2024-10-17' AS Date), N'PPSP100001', 2000000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100003', 3, N'May da', 1500, N'0%', CAST(N'2024-10-17' AS Date), N'PPSP100001', 1800000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100004', 1, N'Lên Khuôn', 1200, N'6.67%', CAST(N'2024-04-16' AS Date), N'PPSP100002', 1600000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100005', 2, N'Khâu dập', 1200, N'0%', CAST(N'2024-04-16' AS Date), N'PPSP100002', 1700000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100006', 1, N'Lên khuôn', 700, N'31.86%', CAST(N'2023-11-30' AS Date), N'PPSP100003', 1600000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100007', 2, N'Khâu dập', 700, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100003', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100008', 3, N'Làm mũi giày', 700, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100003', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100009', 1, N'Làm khuôn', 1500, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100004', 1600000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100010', 2, N'Khâu dập', 1500, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100004', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100011', 3, N'Làm mũi giày', 1500, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100004', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100012', 4, N'Trang trí', 1500, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100004', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100013', 1, N'Làm khuôn', 600, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100005', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100014', 2, N'Khâu dập', 600, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100005', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100015', 3, N'Làm mũi giày', 600, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100005', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100016', 3, N'Làm mũi giày', 700, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100002', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100017', 4, N'Trang trí', 600, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100005', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100018', 1, N'Làm khuôn', 1100, N'0%', CAST(N'2023-11-30' AS Date), N'PPSP100006', 1500000.0000)
GO
INSERT [dbo].[CongNhan] ([maCongNhan], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [gioiTinh], [anhDaiDien], [diaChi], [ngayVaoLam], [maToNhom]) VALUES (N'PPCN100001', N'Hoàng Huy Bảo', CAST(N'2000-11-10' AS Date), N'064203003637', N'+84111111111', N'hoanghuybao@gmail.com', 1, N'congNhan1.png', N'HCM', CAST(N'2022-11-10' AS Date), N'PPTN100001')
INSERT [dbo].[CongNhan] ([maCongNhan], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [gioiTinh], [anhDaiDien], [diaChi], [ngayVaoLam], [maToNhom]) VALUES (N'PPCN100002', N'Nguyễn Thị Hạnh', CAST(N'2000-11-10' AS Date), N'064203003638', N'+84111112222', N'nguyenthihanh@gmail.com', 0, N'congNhan4.png', N'Hà Nội', CAST(N'2022-11-11' AS Date), N'PPTN100002')
INSERT [dbo].[CongNhan] ([maCongNhan], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [gioiTinh], [anhDaiDien], [diaChi], [ngayVaoLam], [maToNhom]) VALUES (N'PPCN100003', N'Nguyễn Đình Phát', CAST(N'2000-11-11' AS Date), N'064203009999', N'+84333333333', N'nguyendinhphat@gmail.com', 1, N'congNhan2.png', N'Quãng Nam', CAST(N'2022-11-10' AS Date), N'PPTN100003')
INSERT [dbo].[CongNhan] ([maCongNhan], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [gioiTinh], [anhDaiDien], [diaChi], [ngayVaoLam], [maToNhom]) VALUES (N'PPCN100004', N'Trần Thị Ngân', CAST(N'2000-11-29' AS Date), N'064203000101', N'+84222223331', N'tranthingan@gmail.com', 0, N'congNhan1.png', N'Quy Nhơn', CAST(N'2020-11-05' AS Date), N'PPTN100004')
GO
INSERT [dbo].[HopDong] ([maHopDong], [tenHopDong], [tenKhachHang], [tienDatCoc], [triGiaHD], [ngayKyKetHD], [ngayKetThucHD], [yeuCau], [maNguoiKyKet]) VALUES (N'PPHD100001', N'Hợp đồng sản xuất Cross-Training Shoes quý 2 2023', N'Hoàng Thị Hương', 100000000.0000, 150000000.0000, CAST(N'2023-10-10' AS Date), CAST(N'2023-12-20' AS Date), N'2 sản phẩm là: Nike Metcon Series size: 41, chất liệu vãi cotton, số lượng 1000; Reebok Nano Series size: 44, Vải mềm , số lượng 700', N'PPNV100002')
INSERT [dbo].[HopDong] ([maHopDong], [tenHopDong], [tenKhachHang], [tienDatCoc], [triGiaHD], [ngayKyKetHD], [ngayKetThucHD], [yeuCau], [maNguoiKyKet]) VALUES (N'PPHD100002', N'Hợp đồng gia công Adidas tháng 11 2023', N'Nguyễn Văn Bình', 200000000.0000, 200000000.0000, CAST(N'2023-10-17' AS Date), CAST(N'2023-12-30' AS Date), N'3 sản phẩm là: Adidas Yeezy 350 size: 42, chất liệu cotton, số lượng 500; Adidas Prophere size: 40 số lượng: 1400, chất liệu: vải nỉ; Adidas NMD R1: vải cotton, size: 41, số lượng 500', N'PPNV100001')
INSERT [dbo].[HopDong] ([maHopDong], [tenHopDong], [tenKhachHang], [tienDatCoc], [triGiaHD], [ngayKyKetHD], [ngayKetThucHD], [yeuCau], [maNguoiKyKet]) VALUES (N'PPHD100003', N'Hợp đồng sản xuất Mesh Sneakers quý 3 2023', N'Nguyễn Nhật Lệ', 150000000.0000, 150000000.0000, CAST(N'2023-11-01' AS Date), CAST(N'2024-11-15' AS Date), N'2 sản phẩm là: Nike Air Max 90 size: 41, chất liệu vãi cotton, số lượng 1000; Adidas Ultraboost size: 44, Vải 210D, số lượng 400', N'PPNV100004')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [matKhau], [chucVu], [ngayVaoLam], [luongCoBan], [gioiTinh], [anhDaiDien], [diaChi], [maPhongBan]) VALUES (N'PPNV100001', N'Hoàng Huy Tới', CAST(N'2003-10-23' AS Date), N'064203003635', N'+84985484725', N'hoanghuytoi03@gmail.com', N'111111', N'Quản lý', CAST(N'2022-10-12' AS Date), 25000000.0000, 0, N'man3.png', N'Gia Lai', N'PPPB100001')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [matKhau], [chucVu], [ngayVaoLam], [luongCoBan], [gioiTinh], [anhDaiDien], [diaChi], [maPhongBan]) VALUES (N'PPNV100002', N'Nguyễn Thị Hương', CAST(N'2003-08-05' AS Date), N'432514313151', N'+84325230839', N'nguyenthihuong13@gmail.com', N'111111', N'Nhân viên', CAST(N'2022-10-03' AS Date), 17000000.0000, 0, N'woman.png', N'Dak Nông', N'PPPB100004')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [matKhau], [chucVu], [ngayVaoLam], [luongCoBan], [gioiTinh], [anhDaiDien], [diaChi], [maPhongBan]) VALUES (N'PPNV100003', N'Hoàng Đình Bảo', CAST(N'2000-11-09' AS Date), N'064303001717', N'+84555555111', N'hoangdinhbao15@gmail.com', N'111111', N'Trưởng phòng', CAST(N'2022-11-09' AS Date), 21000000.0000, 0, N'woman3.png', N'Cà Mau', N'PPPB100002')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [matKhau], [chucVu], [ngayVaoLam], [luongCoBan], [gioiTinh], [anhDaiDien], [diaChi], [maPhongBan]) VALUES (N'PPNV100004', N'Nguyễn Văn Thuận', CAST(N'2000-11-10' AS Date), N'064203002625', N'+84985484726', N'nguyenvanthuan@gmail.com', N'111111', N'Nhân viên', CAST(N'2021-11-12' AS Date), 14000000.0000, 1, N'man.png', N'hcm', N'PPPB100001')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [matKhau], [chucVu], [ngayVaoLam], [luongCoBan], [gioiTinh], [anhDaiDien], [diaChi], [maPhongBan]) VALUES (N'PPNV100005', N'Lê Văn Khoa', CAST(N'2000-11-09' AS Date), N'064203001112', N'+84119999222', N'levankhoa@gmail.com', N'111111', N'Quản lý', CAST(N'2022-11-10' AS Date), 23000000.0000, 0, N'man.png', N'Hà Nội', N'PPPB100002')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [matKhau], [chucVu], [ngayVaoLam], [luongCoBan], [gioiTinh], [anhDaiDien], [diaChi], [maPhongBan]) VALUES (N'PPNV100006', N'Trần Anh Dũng', CAST(N'2000-11-09' AS Date), N'064203002611', N'+84985727221', N'trananhdung@gmail.com', N'111111', N'Nhân viên', CAST(N'2022-11-17' AS Date), 14000000.0000, 1, N'man.png', N'hcm', N'PPPB100004')
GO
INSERT [dbo].[PhanCongCongNhan] ([maPhanCong], [maCongNhan], [maNguoiPhanCong], [maCongDoan], [ngayPhanCong], [soLuongCanLam], [maToNhom]) VALUES (N'PPPC100001', N'PPCN100002', N'PPNV100001', N'PPCD100001', CAST(N'2023-11-08' AS Date), 1100, N'PPTN100001')
INSERT [dbo].[PhanCongCongNhan] ([maPhanCong], [maCongNhan], [maNguoiPhanCong], [maCongDoan], [ngayPhanCong], [soLuongCanLam], [maToNhom]) VALUES (N'PPPC100002', N'PPCN100002', N'PPNV100001', N'PPCD100002', CAST(N'2023-11-08' AS Date), 1100, N'PPTN100002')
INSERT [dbo].[PhanCongCongNhan] ([maPhanCong], [maCongNhan], [maNguoiPhanCong], [maCongDoan], [ngayPhanCong], [soLuongCanLam], [maToNhom]) VALUES (N'PPPC100003', N'PPCN100003', N'PPNV100001', N'PPCD100003', CAST(N'2023-11-08' AS Date), 1100, N'PPTN100003')
INSERT [dbo].[PhanCongCongNhan] ([maPhanCong], [maCongNhan], [maNguoiPhanCong], [maCongDoan], [ngayPhanCong], [soLuongCanLam], [maToNhom]) VALUES (N'PPPC100004', N'PPCN100001', N'PPNV100001', N'PPCD100004', CAST(N'2023-11-08' AS Date), 800, N'PPTN100001')
INSERT [dbo].[PhanCongCongNhan] ([maPhanCong], [maCongNhan], [maNguoiPhanCong], [maCongDoan], [ngayPhanCong], [soLuongCanLam], [maToNhom]) VALUES (N'PPPC100005', N'PPCN100002', N'PPNV100001', N'PPCD100005', CAST(N'2023-11-08' AS Date), 800, N'PPTN100002')
INSERT [dbo].[PhanCongCongNhan] ([maPhanCong], [maCongNhan], [maNguoiPhanCong], [maCongDoan], [ngayPhanCong], [soLuongCanLam], [maToNhom]) VALUES (N'PPPC100006', N'PPCN100003', N'PPNV100001', N'PPCD100016', CAST(N'2023-11-08' AS Date), 800, N'PPTN100003')
INSERT [dbo].[PhanCongCongNhan] ([maPhanCong], [maCongNhan], [maNguoiPhanCong], [maCongDoan], [ngayPhanCong], [soLuongCanLam], [maToNhom]) VALUES (N'PPPC100007', N'PPCN100001', N'PPNV100001', N'PPCD100006', CAST(N'2023-11-09' AS Date), 600, N'PPTN100001')
INSERT [dbo].[PhanCongCongNhan] ([maPhanCong], [maCongNhan], [maNguoiPhanCong], [maCongDoan], [ngayPhanCong], [soLuongCanLam], [maToNhom]) VALUES (N'PPPC100008', N'PPCN100002', N'PPNV100001', N'PPCD100006', CAST(N'2023-11-09' AS Date), 600, N'PPTN100002')
INSERT [dbo].[PhanCongCongNhan] ([maPhanCong], [maCongNhan], [maNguoiPhanCong], [maCongDoan], [ngayPhanCong], [soLuongCanLam], [maToNhom]) VALUES (N'PPPC100009', N'PPCN100003', N'PPNV100001', N'PPCD100006', CAST(N'2023-11-09' AS Date), 600, N'PPTN100003')
INSERT [dbo].[PhanCongCongNhan] ([maPhanCong], [maCongNhan], [maNguoiPhanCong], [maCongDoan], [ngayPhanCong], [soLuongCanLam], [maToNhom]) VALUES (N'PPPC100010', N'PPCN100004', N'PPNV100001', N'PPCD100006', CAST(N'2023-11-09' AS Date), 600, N'PPTN100004')
GO
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100001', N'Phòng kỹ thuật', 2)
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100002', N'Phòng kế toán', 2)
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100004', N'Phòng tài chính', 2)
GO
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100001', N'Nike Metcon Series', 1000, 1000000.0000, N'Vải cotton', N'41', N'giay1.png', NULL, N'PPHD100001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100002', N'Reebok Nano Series', 700, 1500000.0000, N'Vải mềm', N'44', N'giay2.png', NULL, N'PPHD100001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100003', N'Adidas Yeezy 350', 500, 2000000.0000, N'Vải cotton', N'39', N'giay4.png', NULL, N'PPHD100002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100004', N'Adidas Prophere size', 1400, 1500000.0000, N'Vải nỉ', N'42', N'giay9.png', NULL, N'PPHD100002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100005', N'Adidas NMD R1', 500, 1600000.0000, N'Vải cotton', N'41', N'giay5.png', NULL, N'PPHD100002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100006', N'Nike Air Max 90', 1000, 1700000.0000, N'Vải cotton', N'41', N'giay8.png', NULL, N'PPHD100003')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100007', N'Adidas Ultraboost', 400, 2000000.0000, N'Vải da', N'44', N'giay6.png', NULL, N'PPHD100003')
GO
INSERT [dbo].[ToNhom] ([maToNhom], [tenToNhom], [soLuongCongNhan]) VALUES (N'PPTN100001', N'Tổ 1', 1)
INSERT [dbo].[ToNhom] ([maToNhom], [tenToNhom], [soLuongCongNhan]) VALUES (N'PPTN100002', N'Tổ 2', 1)
INSERT [dbo].[ToNhom] ([maToNhom], [tenToNhom], [soLuongCongNhan]) VALUES (N'PPTN100003', N'Tổ 3', 1)
INSERT [dbo].[ToNhom] ([maToNhom], [tenToNhom], [soLuongCongNhan]) VALUES (N'PPTN100004', N'Tổ 4', 1)
GO
ALTER TABLE [dbo].[BangChamCongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK_BangChamCongCongNhan_PhanCongCongDoan] FOREIGN KEY([maPhanCong])
REFERENCES [dbo].[PhanCongCongNhan] ([maPhanCong])
GO
ALTER TABLE [dbo].[BangChamCongCongNhan] CHECK CONSTRAINT [FK_BangChamCongCongNhan_PhanCongCongDoan]
GO
ALTER TABLE [dbo].[BangChamCongNhanVien]  WITH CHECK ADD  CONSTRAINT [FK_BangChamCongNhanVien_NhanVien] FOREIGN KEY([maNguoiCham])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[BangChamCongNhanVien] CHECK CONSTRAINT [FK_BangChamCongNhanVien_NhanVien]
GO
ALTER TABLE [dbo].[BangChamCongNhanVien]  WITH CHECK ADD  CONSTRAINT [FK_BangChamCongNhanVien_NhanVien1] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[BangChamCongNhanVien] CHECK CONSTRAINT [FK_BangChamCongNhanVien_NhanVien1]
GO
ALTER TABLE [dbo].[BangLuongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK_BangLuongCongNhan_CongNhan] FOREIGN KEY([maCongNhan])
REFERENCES [dbo].[CongNhan] ([maCongNhan])
GO
ALTER TABLE [dbo].[BangLuongCongNhan] CHECK CONSTRAINT [FK_BangLuongCongNhan_CongNhan]
GO
ALTER TABLE [dbo].[BangLuongNhanVien]  WITH CHECK ADD  CONSTRAINT [FK_BangLuongNhanVien_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[BangLuongNhanVien] CHECK CONSTRAINT [FK_BangLuongNhanVien_NhanVien]
GO
ALTER TABLE [dbo].[CongDoan]  WITH CHECK ADD  CONSTRAINT [FK_CongDoan_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CongDoan] CHECK CONSTRAINT [FK_CongDoan_SanPham]
GO
ALTER TABLE [dbo].[CongNhan]  WITH CHECK ADD  CONSTRAINT [FK_CongNhan_ToNhom] FOREIGN KEY([ToNhom])
REFERENCES [dbo].[ToNhom] ([maToNhom])
GO
ALTER TABLE [dbo].[CongNhan] CHECK CONSTRAINT [FK_CongNhan_ToNhom]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [FK_HopDong_NhanVien] FOREIGN KEY([maNguoiKyKet])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [FK_HopDong_NhanVien]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_PhongBan] FOREIGN KEY([maPhongBan])
REFERENCES [dbo].[PhongBan] ([maPhongBan])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_PhongBan]
GO
ALTER TABLE [dbo].[PhanCongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK_PhanCongCongDoan_CongDoan] FOREIGN KEY([maCongDoan])
REFERENCES [dbo].[CongDoan] ([maCongDoan])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhanCongCongNhan] CHECK CONSTRAINT [FK_PhanCongCongDoan_CongDoan]
GO
ALTER TABLE [dbo].[PhanCongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK_PhanCongCongDoan_NhanVien] FOREIGN KEY([maNguoiPhanCong])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhanCongCongNhan] CHECK CONSTRAINT [FK_PhanCongCongDoan_NhanVien]
GO
ALTER TABLE [dbo].[PhanCongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK_PhanCongCongDoan_ToNhom] FOREIGN KEY([maToNhom])
REFERENCES [dbo].[ToNhom] ([maToNhom])
GO
ALTER TABLE [dbo].[PhanCongCongNhan] CHECK CONSTRAINT [FK_PhanCongCongDoan_ToNhom]
GO
ALTER TABLE [dbo].[PhanCongCongNhan]  WITH CHECK ADD  CONSTRAINT [FK_PhanCongCongNhan_CongNhan] FOREIGN KEY([maCongNhan])
REFERENCES [dbo].[CongNhan] ([maCongNhan])
GO
ALTER TABLE [dbo].[PhanCongCongNhan] CHECK CONSTRAINT [FK_PhanCongCongNhan_CongNhan]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_HopDong] FOREIGN KEY([maHopDong])
REFERENCES [dbo].[HopDong] ([maHopDong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_HopDong]
GO
