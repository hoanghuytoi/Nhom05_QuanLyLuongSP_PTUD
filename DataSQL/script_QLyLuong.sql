USE [QLyLuongSP]
GO
/****** Object:  Table [dbo].[BangChamCongCongNhan]    Script Date: 11/6/2023 6:24:56 PM ******/
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
	[maPhanCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangChamCongNhanVien]    Script Date: 11/6/2023 6:24:56 PM ******/
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
/****** Object:  Table [dbo].[BangLuongCongNhan]    Script Date: 11/6/2023 6:24:56 PM ******/
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
/****** Object:  Table [dbo].[BangLuongNhanVien]    Script Date: 11/6/2023 6:24:56 PM ******/
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
/****** Object:  Table [dbo].[CongDoan]    Script Date: 11/6/2023 6:24:56 PM ******/
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
/****** Object:  Table [dbo].[CongNhan]    Script Date: 11/6/2023 6:24:56 PM ******/
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
	[maToNhom] [char](10) NULL,
 CONSTRAINT [PK_CongNhan] PRIMARY KEY CLUSTERED 
(
	[maCongNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDong]    Script Date: 11/6/2023 6:24:56 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/6/2023 6:24:56 PM ******/
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
/****** Object:  Table [dbo].[PhanCongCongNhan]    Script Date: 11/6/2023 6:24:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanCongCongNhan](
	[maPhanCong] [char](10) NOT NULL,
	[maCongNhan] [char](10) NOT NULL,
	[maNguoiPhanCong] [char](10) NULL,
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
/****** Object:  Table [dbo].[PhongBan]    Script Date: 11/6/2023 6:24:56 PM ******/
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
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/6/2023 6:24:56 PM ******/
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
/****** Object:  Table [dbo].[ToNhom]    Script Date: 11/6/2023 6:24:56 PM ******/
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
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Chiều', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'14h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Sáng', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100001', N'Sáng chủ nhật', CAST(N'2023-11-05' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Chiều', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'14h00', 2, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Sáng', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'7h00', 4, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100002', N'Sáng chủ nhật', CAST(N'2023-11-05' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Chiều', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'14h00', 2, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Sáng', CAST(N'2023-11-04' AS Date), N'Đi Làm', N'7h00', 8, N'PPNV100001')
INSERT [dbo].[BangChamCongNhanVien] ([maNhanVien], [caLam], [ngayChamCong], [trangThaiDiLam], [gioDiLam], [gioTangCa], [maNguoiCham]) VALUES (N'PPNV100003', N'Sáng chủ nhật', CAST(N'2023-11-05' AS Date), N'Đi Làm', N'7h00', 0, N'PPNV100001')
GO
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [maNhanVien], [soNgayDiLam], [soNgayNghi], [soPhepNghi], [ngayTinh], [luongTheoThang], [luongTangCa], [phuCap], [thucLanh], [donViTien]) VALUES (N'PPLN100001', N'PPNV100001', 2, 0, 0, CAST(N'2023-11-04' AS Date), N'11-2023', 0.0000, 669642.8571, 1741071.4286, N'VND       ')
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [maNhanVien], [soNgayDiLam], [soNgayNghi], [soPhepNghi], [ngayTinh], [luongTheoThang], [luongTangCa], [phuCap], [thucLanh], [donViTien]) VALUES (N'PPLN100002', N'PPNV100002', 2, 0, 0, CAST(N'2023-11-04' AS Date), N'11-2023', 357142.8571, 607142.8571, 2392857.1429, N'VND       ')
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [maNhanVien], [soNgayDiLam], [soNgayNghi], [soPhepNghi], [ngayTinh], [luongTheoThang], [luongTangCa], [phuCap], [thucLanh], [donViTien]) VALUES (N'PPLN100003', N'PPNV100003', 2, 0, 0, CAST(N'2023-11-04' AS Date), N'11-2023', 744047.6190, 892857.1429, 3422619.0476, N'VND       ')
GO
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100001', 1, N'Lên Khuôn', 1500, N'0%', CAST(N'2024-10-17' AS Date), N'PPSP100001', 1500000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100002', 2, N'Khâu dập', 1500, N'0%', CAST(N'2024-10-17' AS Date), N'PPSP100001', 2000000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100003', 3, N'May da', 1500, N'0%', CAST(N'2024-10-17' AS Date), N'PPSP100001', 1800000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100004', 1, N'Lên Khuôn', 1200, N'0%', CAST(N'2024-04-16' AS Date), N'PPSP100002', 1600000.0000)
INSERT [dbo].[CongDoan] ([maCongDoan], [thuTuCD], [tenCongDoan], [soLuongCan], [tinhTrang], [thoiHan], [maSanPham], [donGia]) VALUES (N'PPCD100005', 3, N'Khâu dập', 1200, N'0%', CAST(N'2024-04-16' AS Date), N'PPSP100002', 1700000.0000)
GO
INSERT [dbo].[CongNhan] ([maCongNhan], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [gioiTinh], [anhDaiDien], [diaChi], [ngayVaoLam], [maToNhom]) VALUES (N'PPCN100001', N'Hoàng Huy Bảo', CAST(N'2000-11-10' AS Date), N'064203003637', N'+84111111111', N'hoanghuybao@gmail.com', 1, N'congNhan1.png', N'HCM', CAST(N'2022-11-10' AS Date), N'PPTN100001')
INSERT [dbo].[CongNhan] ([maCongNhan], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [gioiTinh], [anhDaiDien], [diaChi], [ngayVaoLam], [maToNhom]) VALUES (N'PPCN100002', N'Nguyễn Thị Hạnh', CAST(N'2000-11-10' AS Date), N'064203003638', N'+84111112222', N'nguyenthihanh@gmail.com', 0, N'congNhan4.png', N'Hà Nội', CAST(N'2022-11-11' AS Date), N'PPTN100002')
INSERT [dbo].[CongNhan] ([maCongNhan], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [gioiTinh], [anhDaiDien], [diaChi], [ngayVaoLam], [maToNhom]) VALUES (N'PPCN100003', N'Nguyễn Đình Phát', CAST(N'2000-11-11' AS Date), N'064203009999', N'+84333333333', N'nguyendinhphat@gmail.com', 1, N'congNhan2.png', N'Quãng Nam', CAST(N'2022-11-10' AS Date), N'PPTN100003')
GO
INSERT [dbo].[HopDong] ([maHopDong], [tenHopDong], [tenKhachHang], [tienDatCoc], [triGiaHD], [ngayKyKetHD], [ngayKetThucHD], [yeuCau], [maNguoiKyKet]) VALUES (N'PPHD100001', N'Hợp đồng sản xuất Converse quý 3 2022', N'Hoàng Thi Hương', 100000000.0000, 150000000.0000, CAST(N'2023-10-10' AS Date), CAST(N'2023-12-20' AS Date), N'2 sản phẩm là: MLB Boston Red Sox size: 41, chất liệu vãi cotton, số lượng 1000; Gucci Chunky size: 44, Vải 210D, số lượng 400', N'PPNV100002')
INSERT [dbo].[HopDong] ([maHopDong], [tenHopDong], [tenKhachHang], [tienDatCoc], [triGiaHD], [ngayKyKetHD], [ngayKetThucHD], [yeuCau], [maNguoiKyKet]) VALUES (N'PPHD100002', N'Hợp đồng gia công Adidas tháng 11 2023', N'Nguyễn Văn Bình', 200000000.0000, 200000000.0000, CAST(N'2023-10-17' AS Date), CAST(N'2023-12-30' AS Date), N'3 sản phẩm là: Adidas Yeezy 350 size: 44, chất liệu nilon, số lượng 500; Adidas Prophere size: 39 số lượng: 1400, chất liệu: vải nỉ; Adidas NMD R1 size: vải cotton, size: 41, số lượng 390', N'PPNV100001')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [matKhau], [chucVu], [ngayVaoLam], [luongCoBan], [gioiTinh], [anhDaiDien], [diaChi], [maPhongBan]) VALUES (N'PPNV100001', N'Hoàng Huy Tới', CAST(N'2003-10-23' AS Date), N'064203003635', N'+84985484725', N'hoanghuytoi03@gmail.com', N'111111', N'Quản lý', CAST(N'2022-10-12' AS Date), 15000000.0000, 1, N'man.png', N'Gia Lai', N'PPPB100008')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [matKhau], [chucVu], [ngayVaoLam], [luongCoBan], [gioiTinh], [anhDaiDien], [diaChi], [maPhongBan]) VALUES (N'PPNV100002', N'Nguyễn Thị Hương', CAST(N'2003-08-05' AS Date), N'432514313151', N'+84325230839', N'nguyenthihuong13@gmail.com', N'111111', N'Nhân viên', CAST(N'2022-10-03' AS Date), 20000000.0000, 0, N'woman.png', N'Dak Nông', N'PPPB100002')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [maCCCD], [soDienThoai], [email], [matKhau], [chucVu], [ngayVaoLam], [luongCoBan], [gioiTinh], [anhDaiDien], [diaChi], [maPhongBan]) VALUES (N'PPNV100003', N'Hoàng Đình Bảo', CAST(N'2000-11-09' AS Date), N'064303001717', N'+84555555111', N'hoangdinhbao15@gmail.com', N'111111', N'Trưởng phòng', CAST(N'2022-11-09' AS Date), 25000000.0000, 1, N'man.png', N'Cà Mau', N'PPPB100002')
GO
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100001', N'Phòng kỹ thuật', NULL)
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100002', N'Phòng kế toán', NULL)
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100003', N'Phòng nhân sự', NULL)
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100004', N'Phòng tài chính', NULL)
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100005', N'Phòng đào tạo', NULL)
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100006', N'Phòng chăm sóc khách hàng', NULL)
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100007', N'Phòng giới thiệu', NULL)
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan], [soLuongNhanVien]) VALUES (N'PPPB100008', N'Phòng nhân sự', NULL)
GO
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100001', N'Adidas Prophere', 1400, 1000000.0000, N'Vải nỉ', N'39', N'giay1.png', NULL, N'PPHD100001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100002', N'MLB Boston Red Sox', 1000, 1500000.0000, N'Vải cotton', N'41', N'giay2.png', NULL, N'PPHD100001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100003', N'Adidas NMD R1', 2000, 2000000.0000, N'Vải cotton', N'42', N'giay4.png', NULL, N'PPHD100002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100004', N'Adidas Yeezy 350', 1700, 1900000.0000, N'Vải mềm', N'39', N'giay3.png', NULL, N'PPHD100002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuongSanPham], [donGia], [chatLieu], [kichThuoc], [anhSanPham], [soLuongCongDoan], [maHopDong]) VALUES (N'PPSP100005', N'Adidas NMD R1', 1500, 1500000.0000, N'Vải cottom', N'40', N'giay5.png', NULL, N'PPHD100001')
GO
INSERT [dbo].[ToNhom] ([maToNhom], [tenToNhom], [soLuongCongNhan]) VALUES (N'PPTN100001', N'Tổ 1', NULL)
INSERT [dbo].[ToNhom] ([maToNhom], [tenToNhom], [soLuongCongNhan]) VALUES (N'PPTN100002', N'Tổ 2', NULL)
INSERT [dbo].[ToNhom] ([maToNhom], [tenToNhom], [soLuongCongNhan]) VALUES (N'PPTN100003', N'Tổ 3', NULL)
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
ALTER TABLE [dbo].[CongNhan]  WITH CHECK ADD  CONSTRAINT [FK_CongNhan_ToNhom] FOREIGN KEY([maToNhom])
REFERENCES [dbo].[ToNhom] ([maToNhom])
ON UPDATE CASCADE
ON DELETE CASCADE
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
ON UPDATE CASCADE
ON DELETE CASCADE
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
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_HopDong] FOREIGN KEY([maHopDong])
REFERENCES [dbo].[HopDong] ([maHopDong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_HopDong]
GO
