create database qldatve
go



use qldatve

-- DROP TABLE IF EXISTS xe;
CREATE TABLE xe
(
	id INT NOT NULL AUTO_INCREMENT,
    so_hieu VARCHAR(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    loai VARCHAR(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
INSERT INTO xe (so_hieu, loai)
VALUES 
('LV-001', 'Xe bus Linh Vi'),
('LV-002', 'Xe bus Linh Vi'),
('LV-003', 'Xe bus Linh Vi'),
('LV-004', 'Xe bus Linh Vi'),
('LV-005', 'Xe bus Linh Vi'),
('LV-006', 'Xe bus Linh Vi');



-- DROP TABLE IF EXISTS tuyen_xe;
CREATE TABLE tuyen_xe
(
	`id` INT NOT NULL AUTO_INCREMENT ,
   `ten_tuyen` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `diem_di` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `diem_den` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `tan_suat` VARCHAR(50) COLLATE utf8mb4_unicode_ci NOT NULL,
   `khoang_cach` VARCHAR(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO tuyen_xe (ten_tuyen, diem_di, diem_den, tan_suat, khoang_cach)
VALUES 
('Tuyến 1', 'Bến xe Miền Tây', 'Bến xe Đà Lạt', '60 ', '310 km'),
('Tuyến 2', 'Bến xe Miền Tây', 'Bến xe Sóc Trăng', '30', '222 km'),
('Tuyến 3', 'Bến xe Miền Tây', 'Bến xe Châu Đốc', '30', '240 km'),
('Tuyến 4', 'Bến xe Miền Tây', 'Bến xe Bạc Liêu', '60', '271 km'),
('Tuyến 5', 'Bến xe Miền Tây', 'Bến xe Cà Mau ', '60', '302 km');


 -- bang thong ke 
-- DROP TABLE IF EXISTS thong_ke;
CREATE TABLE thong_ke
(
	`id` INT NOT NULL AUTO_INCREMENT ,
    `ngay_thong_ke` DATE NOT NULL UNIQUE, -- boi vi chi co dung 1 ngay do khong duoc trung
    `tong_so_ve_da_ban` INT NOT NULL DEFAULT 0,
    `doanh_thu_ngay` FLOAT NOT NULL DEFAULT 0.0,
    `tong_so_chuyen_xe` INT NOT NULL DEFAULT 0,
    `tong_xe_su_dung_ngay`  FLOAT NOT NULL DEFAULT 0.0,
	PRIMARY KEY (`id`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


INSERT INTO thong_ke (ngay_thong_ke, tong_so_ve_da_ban, doanh_thu_ngay, tong_so_chuyen_xe, tong_xe_su_dung_ngay)
VALUES
('2024-08-29', 150, 2500000.00, 5, 3.5),
('2024-08-28', 200, 3400000.00, 6, 4.0),
('2024-08-27', 180, 2900000.00, 4, 3.0);

-- DROP TABLE IF EXISTS nguoi_dung;
CREATE TABLE nguoi_dung
(	
	`id` INT NOT NULL AUTO_INCREMENT ,
  `ho` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `ten` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `username` VARCHAR(50) COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE,
    `password` VARCHAR(100) COLLATE utf8mb4_unicode_ci NOT NULL,
    `email` VARCHAR(50) COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE,
    `CCCD` VARCHAR(50) NOT NULL UNIQUE,
	`avatar` varchar(205) COLLATE utf8mb4_unicode_ci NOT NULL,
    `nam_sinh` INT NOT NULL,
    `SDT` VARCHAR(50) NOT NULL, 
    `role_name` VARCHAR(50) DEFAULT NULL,
	PRIMARY KEY (id) -- Dam bao co 1 khoa chinh duy nhat 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO nguoi_dung (ho, ten, username, password, email, CCCD, avatar, nam_sinh, SDT, role_name)
VALUES 
('Nguyễn', 'Văn A', 'nguyenvana', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'vana@gmail.com', '123456789012', 'avatar_a.jpg', 1990, '0912345678', 'ADMIN'),
('Trần', 'Thị B', 'tranthib', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'thib@gmail.com', '123456789013', 'avatar_b.jpg', 1992, '0912345679', 'KHACHHANG'),
('Lê', 'Văn C', 'levanc', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'vanc@gmail.com', '123456789014', 'avatar_c.jpg', 1988, '0912345680', 'KHACHHANG'),
('Phạm', 'Thị D', 'phamthid', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'thid@gmail.com', '123456789015', 'avatar_d.jpg', 1995, '0912345681', 'NHANVIEN'),
('Trần', 'Văn E', 'vovane', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'vane@gmail.com', '123456789016', 'avatar_e.jpg', 1993, '0912345682', 'NHANVIEN'),
('Hà', 'Văn E', 'havane', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'hane@gmail.com', '123456789017', 'avatar_e.jpg', 1993, '0912345682', 'NHANVIEN'),
('Huỳnh', 'Văn E', 'huynhvane', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'huynhvane@gmail.com', '123456789018', 'avatar_e.jpg', 1993, '0912345682', 'NHANVIEN'),
('Vũ', 'Văn E', 'vuvane', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'vuvane@gmail.com', '123456789019', 'avatar_e.jpg', 1993, '0912345682', 'NHANVIEN'),
('Diệp', 'Văn E', 'diepvane', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'diepvane@gmail.com', '123456789010', 'avatar_e.jpg', 1993, '0912345682', 'NHANVIEN'),
('Di', 'Văn E', 'divane', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'divane@gmail.com', '123456789021', 'avatar_e.jpg', 1993, '0912345682', 'TAIXE'),
('Dư', 'Văn E', 'duvane', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'duvane@gmail.com', '123456789022', 'avatar_e.jpg', 1993, '0912345682', 'TAIXE');

-- NhanVien
-- DROP TABLE if  EXISTS nhan_vien;
CREATE TABLE nhan_vien
(	`id` INT NOT NULL AUTO_INCREMENT ,
	`chuc_vu` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
	`chi_nhanh` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `nguoi_dung_nv_id` INT,
    PRIMARY KEY(id),
    KEY `nguoi_dung_nv_id` (`nguoi_dung_nv_id`),
	CONSTRAINT `nguoi_dung_nv_idfk_1` FOREIGN KEY (`nguoi_dung_nv_id`) REFERENCES `nguoi_dung` (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
SELECT id FROM nguoi_dung WHERE id IN (1, 2, 3, 4, 5);
INSERT INTO nhan_vien (nguoi_dung_nv_id, chuc_vu, chi_nhanh)
VALUES 
(4, 'Quản lý', 'Chi nhánh Sài Gòn'), 
(5, 'Quản lý', 'Chi nhánh Cà Mau'), 
(6, 'Quản lý', 'Chi nhánh Bạc Liêu'), 
(7, 'Quản lý', 'Chi nhánh An Giang'), 
(8, 'Nhân viên', 'Chi nhánh Sóc Trăng');
-- KhachHang
 -- DROP TABLE IF EXISTS khach_hang;
 CREATE TABLE khach_hang
 (
		`id` INT NOT NULL AUTO_INCREMENT ,
		`thong_tin_thanh_toan` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
        `nguoi_dung_kh_id` INT,
        PRIMARY KEY(id),
		KEY `nguoi_dung_kh_id` (`nguoi_dung_kh_id`),
		CONSTRAINT `nguoi_dung_kh_idfk_2` FOREIGN KEY (`nguoi_dung_kh_id`) REFERENCES `nguoi_dung` (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
  
INSERT INTO khach_hang (nguoi_dung_kh_id, thong_tin_thanh_toan) 
VALUES 
(2, 'Visa 1234 5678 9012 3456'), 
(3, 'MasterCard 9876 5432 1098 7654');

-- DROP TABLE IF EXISTS tai_xe;
 CREATE TABLE tai_xe
 (
	`id` INT NOT NULL AUTO_INCREMENT ,
    `bang_cap`  VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
	`nguoi_dung_tx_id` INT,
    PRIMARY KEY(id),
    KEY `nguoi_dung_tx_id` (`nguoi_dung_TX_id`),
	CONSTRAINT `nguoi_dung_tx_idfk_1` FOREIGN KEY (`nguoi_dung_tx_id`) REFERENCES `nguoi_dung` (`id`)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
 
 INSERT INTO tai_xe (nguoi_dung_tx_id, bang_cap) 
VALUES 
(10, 'Bằng lái xe hạng B'), 
(11, 'Bằng lái xe hạng C');
 
 -- Tao bang chuyen xe truoc bang lich trinh
-- DROP TAbLE IF EXISTS chuyen_xe;
CREATE TABLE `chuyen_xe`
(
	`id` INT NOT NULL AUTO_INCREMENT ,
	`tuyen_xe_id` INT ,
    `xe_id` INT,
    `tai_xe_id` INT, 
    `ngay_gio_khoi_hanh` DATETIME DEFAULT NULL,
    `gia_ve` DECIMAL(10, 2) NOT NULL,
    `so_cho` INT NOT  NULL,
    `trang_thai` ENUM('Đang hoạt đông', 'Đã hoàn thành', 'Hủy') NOT NULL,
	PRIMARY KEY (`id`),
	KEY `tuyen_xe_id` (`tuyen_xe_id`),
    KEY `xe_id` (`xe_id`),
    KEY `tai_xe_id` (`tai_xe_id`),
	CONSTRAINT `tuyen_xe_idfk_1` FOREIGN KEY (`tuyen_xe_id`) REFERENCES `tuyen_xe` (`id`),
    CONSTRAINT `xe_idfk_1` FOREIGN KEY (`xe_id`) REFERENCES `xe` (`id`),
    CONSTRAINT `tai_xe_idfk_1` FOREIGN KEY (`tai_xe_id`) REFERENCES `tai_xe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO chuyen_xe (tuyen_xe_id, xe_id, tai_xe_id, ngay_gio_khoi_hanh, gia_ve, so_cho, trang_thai) 
VALUES 
(1, 1, 1, '2024-08-30 08:00:00', 150000, 30, 'Đang hoạt động'),
(2, 2, 2, '2024-08-30 09:00:00', 200000, 40, 'Đã hoàn thành'),
(3, 3, 1, '2024-08-31 07:00:00', 170000, 35, 'Hủy');


-- DROP TABLE IF EXISTS lich_trinh;
CREATE TABLE lich_trinh
(
	`id` INT NOT NULL AUTO_INCREMENT,
    `chuyen_xe_id` INT,
    `ngay` DATE NOT NULL,
    `gio_khoi_hanh` TIME NOT NULL,
    `gio_den` TIME NOT NULL,
    PRIMARY KEY (id),
    KEY `chuyen_xe_id` (`chuyen_xe_id`),
	CONSTRAINT `chuyen_xe_idfk_1` FOREIGN KEY (`chuyen_xe_id`) REFERENCES `chuyen_xe` (`id`)
	)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
 
INSERT INTO lich_trinh (chuyen_xe_id, ngay, gio_khoi_hanh, gio_den)
VALUES 
(1, '2024-08-30', '08:00:00', '14:00:00'),
(2, '2024-08-30', '09:00:00', '15:00:00'),
(1, '2024-08-31', '07:00:00', '13:00:00');

-- DROP TABLE IF EXISTS dat_ve;
CREATE TABLE dat_ve
(
	`id` INT NOT NULL AUTO_INCREMENT ,
    `ngay_dat` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `so_cho_dat` INT NOT NULL,
    `trang_thai` ENUM('Đã đặt', 'Đã thanh toán','Hủy') NOT  NULL,
     `chuyen_xe_dv_id` INT,
    `khach_hang_id` INT,
    PRIMARY KEY (id), KEY `chuyen_xe_dv_id` (`chuyen_xe_dv_id`),
    KEY `khach_hang_id` (`khach_hang_id`),
    CONSTRAINT `chuyen_xe_dv_idfk_1` FOREIGN KEY (`chuyen_xe_dv_id`) REFERENCES `chuyen_xe` (`id`),
    CONSTRAINT `khach_hang_idfk_1` FOREIGN KEY (`khach_hang_id`) REFERENCES `khach_hang` (`id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO dat_ve (ngay_dat, so_cho_dat, trang_thai, chuyen_xe_dv_id, khach_hang_id)
VALUES 
('2024-08-25 14:30:00', 2, 'Đã đặt', 1, 1),
('2024-08-25 15:00:00', 1, 'Đã thanh toán', 2, 2),
('2024-08-25 16:00:00', 3, 'Đã đặt', 3, 1),
('2024-08-26 09:30:00', 1, 'Hủy', 1, 2),
('2024-08-26 10:00:00', 2, 'Đã thanh toán', 2,1);
-- DROP TABLE IF EXISTS thanh_toan;
CREATE TABLE thanh_toan
(
	`id` INT NOT NULL AUTO_INCREMENT,
    `so_tien` DECIMAL(10, 2) NOT NULL,
    `ngay_thanh_toan` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `hinh_thuc_thanh_toan`  ENUM('Tiền mặt', 'Chuyển khoản', 'Thẻ tín dụng') NOT NULL,
	`dat_ve_id` INT,
    PRIMARY KEY (id),
	KEY `dat_ve_id` (`dat_ve_id`),
    CONSTRAINT `dat_ve_idfk_1` FOREIGN KEY (`dat_ve_id`) REFERENCES `dat_ve` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


INSERT INTO thanh_toan (dat_ve_id, so_tien, ngay_thanh_toan, hinh_thuc_thanh_toan)
VALUES
    (1, 500000.00, '2024-08-25 17:00:00', 'Tiền mặt'),
    (2, 250000.00, '2024-08-25 18:00:00', 'Chuyển khoản'),
    (3, 750000.00, '2024-08-26 09:00:00', 'Thẻ tín dụng'),
    (4, 100000.00, '2024-08-26 10:30:00', 'Tiền mặt'),
    (1, 600000.00, '2024-08-26 11:00:00', 'Chuyển khoản');
 

 