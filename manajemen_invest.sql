-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 09, 2017 at 04:13 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `manajemen_invest`
--

-- --------------------------------------------------------

--
-- Table structure for table `master_bskk`
--

CREATE TABLE IF NOT EXISTS `master_bskk` (
  `id_bskk` int(11) NOT NULL AUTO_INCREMENT,
  `kode_rekening` varchar(21) NOT NULL,
  `departemen` int(11) NOT NULL,
  `invest` varchar(50) DEFAULT NULL,
  `tanggal` date NOT NULL,
  `keterangan` text NOT NULL,
  `no_bpkk` varchar(50) NOT NULL,
  `debet` bigint(20) NOT NULL,
  PRIMARY KEY (`id_bskk`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `master_bskk`
--

INSERT INTO `master_bskk` (`id_bskk`, `kode_rekening`, `departemen`, `invest`, `tanggal`, `keterangan`, `no_bpkk`, `debet`) VALUES
(1, '1101.03', 2, '005/PNP-HLG/P-INV/II/2017', '2017-05-08', 'Beli Komputer Bu Tya', '001/test/bpkk/2017', 5000000),
(2, '1101.03', 1, '008/PNP-HLG/P-INV/III/2017', '2017-05-08', 'Beli Server', '001/test/bpkk/2017', 100000000);

-- --------------------------------------------------------

--
-- Table structure for table `master_credential`
--

CREATE TABLE IF NOT EXISTS `master_credential` (
  `privilege_code` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `privilege` enum('KABAG','LPB','BSKK') NOT NULL,
  `salt_key` varbinary(500) NOT NULL,
  `status` enum('AKTIF','NON AKTIF') NOT NULL,
  PRIMARY KEY (`privilege_code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_credential`
--

INSERT INTO `master_credential` (`privilege_code`, `username`, `password`, `privilege`, `salt_key`, `status`) VALUES
('ADM001', 'habibie', '1281531c11111491591d21eb1461491f91b81e31441801ac', 'KABAG', ' R!�દ��0����', 'NON AKTIF'),
('ADM002', 'rizaldi', '1d61d218315e1ba1501ad14616c1591821a913b104152136', 'LPB', '&�.B0�cq:|dk�I', 'NON AKTIF'),
('ADM003', 'aldi', '19a12d1fb1fc1561361ec1a61731741701e410a1571ca112', 'BSKK', '���F��\\���߱', 'NON AKTIF'),
('ADM004', 'ika_kusuma', '14d11f1fb1ec13d1b01021a219012515412214718f1b81e1', 'BSKK', '^�ά��N���_Y+�', 'AKTIF'),
('ADM005', 'bertyn_kristina', '1b418d1101061e71b21de11c17a1571721fc11d1dd1fb1e0', 'LPB', '2��h��I�5Z���\\�', 'AKTIF'),
('ADM006', 'lefran_at', '1f51a01f616117e16d12517019015e10e15e1921f31cd191', 'KABAG', '��h0J�Z^LS�Y', 'AKTIF');

-- --------------------------------------------------------

--
-- Table structure for table `master_departemen`
--

CREATE TABLE IF NOT EXISTS `master_departemen` (
  `id_departement` int(20) NOT NULL AUTO_INCREMENT,
  `kode_departement` varchar(50) NOT NULL,
  `nama_departement` varchar(50) NOT NULL,
  `kabag_departement` varchar(100) NOT NULL,
  `unit` varchar(10) NOT NULL,
  `alokasi` varchar(15) NOT NULL,
  PRIMARY KEY (`id_departement`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

--
-- Dumping data for table `master_departemen`
--

INSERT INTO `master_departemen` (`id_departement`, `kode_departement`, `nama_departement`, `kabag_departement`, `unit`, `alokasi`) VALUES
(1, '2P7', 'Internal Security', 'Petrus Henry', 'Holo II', '5A'),
(2, '2S2', 'Information Technology', 'Emanuel Vanny', 'Holo II', '5A'),
(3, '2A1', 'Demet/Coating', 'Clamet Azagaf', 'Holo II', '5A'),
(4, '2A2', 'Embos', 'Clamet Azagaf', 'Holo II', '5A'),
(5, '2A3', 'Sensitizing', 'Clamet Azagaf', 'Holo II', '5A'),
(6, '2A4', 'Slitter', 'Clamet Azagaf', 'Holo II', '5A'),
(7, '2B1', 'Stamping', 'Clamet Azagaf', 'Holo II', '5A'),
(8, '2B2', 'Sheet Cutter', 'Clamet Azagaf', 'Holo II', '5A'),
(9, '2C1', 'Polar', 'Clamet Azagaf', 'Holo II', '5A'),
(10, '2C2', 'Finishing/Sortir', 'Clamet Azagaf', 'Holo II', '5A'),
(11, '2P1', 'Galvanik', 'Purwiyana', 'Holo II', '5A'),
(12, '2P2', 'Gudang', 'Clamet Azagaf', 'Holo II', '5A'),
(13, '2P3', 'Kiriman', 'Clamet Azagaf', 'Holo II', '5A'),
(14, '2P4', 'Produksi', 'Clamet Azagaf', 'Holo II', '5A'),
(15, '2M1', 'Teknisi', 'Budi Prastyo', 'Holo II', '5A'),
(16, '2S1', 'Cost Control', 'Lefran A. Tohea', 'Holo II', '5A'),
(17, '2S3', 'Kalkulasi', 'Ivana K. Dewi', 'Holo II', '5A'),
(18, '2S4', 'Pembelian', 'Herry Djunadi', 'Holo II', '5A'),
(19, '2S5', 'Customer Service', 'Riwi Robert', 'Holo II', '5A'),
(20, '2U1', 'Human Resource', 'Petrus Henry', 'Holo II', '5A'),
(21, '2U2', 'Sekretariat', '-', 'Holo II', '5A'),
(22, '2U3', 'Umum', 'M. Kristianta', 'Holo II', '5A'),
(23, '2U4', 'Satpam', 'Petrus Henry', 'Holo II', '5A'),
(24, '2U5', 'Perwakilan/PWK', 'Soedharmadji', 'Holo II', '5A'),
(25, '2T1', 'Studio Tanjung', 'Karnadi Tjahyana', 'Holo II', '5A'),
(26, '2P6', 'Pengembangan R&D', 'Yahya Indarto', 'Holo II', '5A'),
(27, '1P1', 'Kor I/ Cetak', 'Budi Haryo', 'Holo I', '4A'),
(28, '1P2', 'Kor II', 'Budi Haryo', 'Holo I', '4A'),
(29, '1P3', 'Roto VB', 'Budi Haryo', 'Holo I', '4A'),
(30, '1C1', 'Emboss HR 3,4,5,6', 'Budi Haryo', 'Holo I', '4A'),
(31, '1C2', 'Solo/Coating', 'Budi Haryo', 'Holo I', '4A'),
(32, '1C3', 'PMF', 'Budi Haryo', 'Holo I', '4A'),
(33, '1C4', 'Pons Kipas I', 'Budi Haryo', 'Holo I', '4A'),
(34, '1C5', 'Pons Kipas II', 'Budi Haryo', 'Holo I', '4A'),
(35, 'IC6', 'Pons Kipas III', 'Budi Haryo', 'Holo I', '4A'),
(36, '1C7', 'Varnis', 'Budi Haryo', 'Holo I', '4A'),
(37, '1C8', 'Kalender', 'Budi Haryo', 'Holo I', '4A'),
(38, '1F1', 'Slitting', 'Budi Haryo', 'Holo I', '4A'),
(39, '1F2', 'Polar', 'Budi Haryo', 'Holo I', '4A'),
(40, '1F3', 'QC/Sortir', 'Budi Haryo', 'Holo I', '4A'),
(41, '1S1', 'Kiriman', 'Budi Haryo', 'Holo I', '4A'),
(42, '1S2', 'Gudang', 'Budi Haryo', 'Holo I', '4A'),
(43, '1S3', 'PPIC', 'Budi Haryo', 'Holo I', '4A'),
(44, '1S4', 'Expose', 'Budi Haryo', 'Holo I', '4A'),
(45, '1S5', 'Teknisi', 'Budi Prastyo', 'Holo I', '4A'),
(46, '1S6', 'Hidrolik', 'Budi Haryo', 'Holo I', '4A'),
(47, '1S7', 'UDIN', 'Budi Haryo', 'Holo I', '4A'),
(48, '1A1', 'Cetak', 'Budi Haryo', 'Holo I', '4A'),
(49, '1A2', 'Produksi', 'Budi Haryo', 'Holo I', '4A'),
(50, '1A3', 'Finishing', 'Budi Haryo', 'Holo I', '4A'),
(51, '1U1', 'IS', 'Petrus Henry', 'Holo I', '4A'),
(52, '1U2', 'Human resource', 'Petrus Henry', 'Holo I', '4A'),
(53, '1U3', 'Umum', 'M.Kristianta', 'Holo I', '4A'),
(54, '1U4', 'Satpam', 'Petrus Henry', 'Holo I', '4A'),
(55, '2P5', 'QC', 'Bu Anies Pratiwi', 'Holo II', '5A');

-- --------------------------------------------------------

--
-- Table structure for table `master_invest`
--

CREATE TABLE IF NOT EXISTS `master_invest` (
  `kode_invest` varchar(100) NOT NULL,
  `nomor_ijin_invest` varchar(100) NOT NULL,
  `jenis_invest` varchar(100) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `diajukan_oleh` int(11) NOT NULL,
  `rencana_biaya` bigint(255) NOT NULL,
  `pemohon` int(11) NOT NULL,
  `tanggal_ijin_invest` date NOT NULL,
  PRIMARY KEY (`kode_invest`),
  KEY `diajukan_oleh` (`diajukan_oleh`),
  KEY `pemohon` (`pemohon`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_invest`
--

INSERT INTO `master_invest` (`kode_invest`, `nomor_ijin_invest`, `jenis_invest`, `jumlah`, `diajukan_oleh`, `rencana_biaya`, `pemohon`, `tanggal_ijin_invest`) VALUES
('001/PNP-HLG/P-INV/I/2017', '002/PNP-HLG/INV/I/2017', 'SEMI ELECTRIC STACKER', 1, 22, 46734790, 22, '2017-01-10'),
('002/PNP-HLG/P-INV/I/2017', '001/PNP-HLG/IT/I/2017', 'LCD PROJECTOR', 1, 2, 5350000, 2, '2017-01-23'),
('004/PNP-HLG/P-INV/I/2017', '001/PNP-HLG/INV-QC2/I/2017', 'INFRARED THERMOGUN DUAL LASER', 1, 55, 978000, 55, '2017-01-24'),
('005/PNP-HLG/P-INV/II/2017', '03/PNP-HLG/IT/I/2017', 'KOMPUTER', 7, 2, 27460000, 2, '2017-02-17'),
('007/PNP-HLG/P-INV/III/2017', '001/PNP-HLG/INV-TEK/III/2017', 'COMPRESSOR DAN AIR DRYER', 1, 15, 32049400, 15, '2017-03-16'),
('008/PNP-HLG/P-INV/III/2017', '008/PNP-HLG/P-INV/III/2017', 'PEREMAJAAN SERVER', 1, 2, 122450000, 2, '2017-03-11'),
('009/PNP-HLG/P-INV/II/2017', '018/PNP-HLG/UM/INV/II/2017', 'RENOVASI EX RUANGAN EMBOSS', 0, 22, 76721000, 22, '2017-02-21'),
('010/PNP-HLG/P-INV/III/2017', '002/PNP-HLG/INV/TEK/III/2017', 'PEREMAJAAN AIR CONDITIONER', 4, 15, 34225000, 15, '2017-03-13'),
('013/PNP-HLG/P-INV/IV/2017', '003/PNP-HLG/INV-QC2/IV/2017 003/PNP-HLG/INV/TEK/IV/2017', 'PENGADAAN AC DAN MEJA MINI LAB LT 1', 2, 55, 15799500, 55, '2017-04-22'),
('014/PNP-HLG/P-INV/IV/2017', '013/PNP-HLG/MGR-PROD/IV/2017', 'MESIN HOTMELT COATER', 1, 14, 160000000, 14, '2017-04-03');

-- --------------------------------------------------------

--
-- Table structure for table `master_lpb`
--

CREATE TABLE IF NOT EXISTS `master_lpb` (
  `id_lpb` int(11) NOT NULL AUTO_INCREMENT,
  `kode_invest` varchar(100) DEFAULT NULL,
  `kode_rekening` varchar(50) NOT NULL,
  `alokasi_biaya` varchar(50) NOT NULL,
  `kode_departemen` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` text NOT NULL,
  `no_lpb_internal` varchar(50) NOT NULL,
  `no_lpb_eksternal` varchar(50) NOT NULL,
  `jumlah` double NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `harga_satuan` bigint(11) NOT NULL,
  `debet` bigint(11) NOT NULL,
  `status` enum('POLOS','RESMI') NOT NULL,
  `active_status` enum('ACTIVE','DELETED') NOT NULL,
  `sumber_barang` enum('LOKAL','IMPORT') NOT NULL,
  PRIMARY KEY (`id_lpb`),
  KEY `kode_invest` (`kode_invest`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `master_lpb`
--


-- --------------------------------------------------------

--
-- Table structure for table `master_lpj`
--

CREATE TABLE IF NOT EXISTS `master_lpj` (
  `id_lpj` int(11) NOT NULL AUTO_INCREMENT,
  `kode_invest` varchar(100) DEFAULT NULL,
  `kode_rekening` varchar(50) NOT NULL,
  `alokasi_biaya` varchar(50) NOT NULL,
  `kode_departemen` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` text NOT NULL,
  `no_lpj_internal` varchar(50) NOT NULL,
  `no_lpj_eksternal` varchar(50) NOT NULL,
  `jumlah` double NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `harga_satuan` bigint(20) NOT NULL,
  `debet` bigint(20) NOT NULL,
  `status` enum('POLOS','RESMI') NOT NULL,
  `active_status` enum('ACTIVE','DELETED') NOT NULL,
  PRIMARY KEY (`id_lpj`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `master_lpj`
--

INSERT INTO `master_lpj` (`id_lpj`, `kode_invest`, `kode_rekening`, `alokasi_biaya`, `kode_departemen`, `tanggal`, `keterangan`, `no_lpj_internal`, `no_lpj_eksternal`, `jumlah`, `satuan`, `harga_satuan`, `debet`, `status`, `active_status`) VALUES
(1, NULL, '1101.02', '5A', '1', '2017-05-02', 'Test 1', '001/test/lpj/05/2017', '001/ext/lpj/05/2017', 3, 'Meter', 13000, 39000, 'POLOS', 'ACTIVE'),
(2, NULL, '1101.02', '5A', '10', '2017-05-02', 'test 2', '001/test/lpj/05/2017', '001/ext/lpj/05/2017', 1, 'Orang', 23000, 23000, 'POLOS', 'ACTIVE'),
(3, NULL, '1101.02', '5A', '1', '2017-05-02', 'test 3', '001/test/lpj/05/2017', '001/ext/lpj/05/2017', 25, 'Pintu', 25000, 625000, 'POLOS', 'ACTIVE'),
(4, NULL, '1101.01', '5A', '1', '2017-05-02', 'fhfhf', 'fhfhfhfg', 'hfhfghfhfh', 3, 'hjgj', 13000, 39000, 'RESMI', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `master_rekening`
--

CREATE TABLE IF NOT EXISTS `master_rekening` (
  `no` int(11) NOT NULL,
  `no_rekening` varchar(50) NOT NULL,
  `keterangan` varchar(50) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_rekening`
--

INSERT INTO `master_rekening` (`no`, `no_rekening`, `keterangan`) VALUES
(461, '5313.31', 'BPS - ADVERTISING'),
(460, '5313.30', 'BPS - EKSPORT'),
(459, '5313.29', 'BPS - ANGKUT'),
(458, '5313.28', 'BPS - PENGIRIMAN & PAKET'),
(457, '5313.27', 'BPS - PEMELIHARAAN & PERAWATAN LAINNYA'),
(456, '5313.26', 'BPS - PEMELIHARAAN & PERAWATAN KENDARAN &'),
(455, '5313.25', 'BPS - PEMELIHARAAN & PERAWATAN PRLT. KANTOR'),
(454, '5313.24', 'BPS - PEMELIHARAAN & PERAWATAN BANGUNAN &'),
(453, '5313.23', 'BPS - REPRESENTASI'),
(452, '5313.22', 'BPS - LISTRIK & AIR'),
(11, '1101.08', 'KAS KECIL PWK FALATEHAN PM 7/8'),
(10, '1101.07', 'KAS KECIL PWK FALATEHAN HOLOGRAFI'),
(9, '1101.06', 'KAS KECIL MARKETING JATENG ( PM 7/8 )'),
(8, '1101.05', 'KAS KECIL MARKETING JATENG ( HOLO )'),
(7, '1101.04', 'KAS KECIL PM 7/8'),
(6, '1101.03', 'KAS KECIL HOLOGRAFI II'),
(5, '1101.02', 'KAS KECIL HOLOGRAFI I'),
(4, '1101.01', 'KAS KECIL PUSAT'),
(3, '1100.03', 'KAS PUSAT DALAM PERJALANAN'),
(2, '1100.02', 'DANA KAS TETAP'),
(1, '1100.01', 'KAS PUSAT'),
(451, '5313.21', 'BPS - FAX'),
(450, '5313.20', 'BPS - TELEX'),
(449, '5313.19', 'BPS - TELEPON'),
(448, '5313.18', 'BPS - SUPPLIES KANTOR'),
(447, '5313.17', 'BPS - PERJALANAN DINAS LUAR NEGERI'),
(446, '5313.16', 'BPS - PERJALANAN DINAS DALAM NEGERI'),
(445, '5313.15', 'BPS - PENGOBATAN'),
(444, '5313.14', 'BPS - KONSUMSI'),
(443, '5313.13', 'BPS - JAMSOSTEK'),
(442, '5313.12', 'BPS - SUMBANGAN KARYAWAN'),
(441, '5313.11', 'BPS - PESANGON'),
(440, '5313.10', 'BPS - UANG CUTI'),
(439, '5313.09', 'BPS - HT'),
(438, '5313.08', 'BPS - THR'),
(437, '5313.07', 'BPS - PREMI'),
(436, '5313.06', 'BPS - BONUS'),
(435, '5313.05', 'BPS - UANG MAKAN'),
(434, '5313.04', 'BPS - UPAH LEMBUR'),
(433, '5313.03', 'BPS - UPAH BORONGAN'),
(432, '5313.02', 'BPS - UPAH MINGGUAN'),
(431, '5313.01', 'BPS - GAJI BULANAN'),
(430, '5312.99', 'BPK - LAIN - LAIN'),
(429, '5312.35', 'BPK - SEWA'),
(428, '5312.34', 'BPK - RETRIBUSI'),
(427, '5312.33', 'BPK - KOMUNIKASI'),
(426, '5312.32', 'BPK - HANDPHONE'),
(425, '5312.31', 'BPK - ADVERTISING'),
(424, '5312.30', 'BPK - EKSPORT'),
(423, '5312.29', 'BPK - ANGKUT'),
(422, '5312.28', 'BPK - PENGIRIMAN & PAKET'),
(421, '5312.27', 'BPK - PEMELIHARAAN & PERAWATAN LAINNYA'),
(420, '5312.26', 'BPK - PEMELIHARAAN & PERAWATAN KENDARAAN &'),
(419, '5312.25', 'BPK - PEMELIHARAAN & PERAWATAN PRLT. KANTOR'),
(418, '5312.24', 'BPK - PEMELIHARAAN & PERAWATAN BANGUNAN &'),
(417, '5312.23', 'BPK - REPRESENTASI'),
(416, '5312.22', 'BPK - LISTRIK & AIR'),
(415, '5312.21', 'BPK - FAX'),
(414, '5312.20', 'BPK - TELEX'),
(413, '5312.19', 'BPK - TELEPON'),
(412, '5312.18', 'BPK - SUPPLIES KANTOR'),
(411, '5312.17', 'BPK - PERJALANAN DINAS LUAR NEGERI'),
(410, '5312.16', 'BPK - PERJALANAN DINAS DALAM NEGERI'),
(409, '5312.15', 'BPK - PENGOBATAN'),
(408, '5312.14', 'BPK - KONSUMSI'),
(407, '5312.13', 'BPK - JAMSOSTEK'),
(406, '5312.12', 'BPK - SUMBANGAN KARYAWAN'),
(405, '5312.11', 'BPK - PESANGON'),
(404, '5312.10', 'BPK - UANG CUTI'),
(403, '5312.09', 'BPK - HT'),
(402, '5312.08', 'BPK - THR'),
(401, '5312.07', 'BPK - PREMI'),
(400, '5312.06', 'BPK - BONUS'),
(399, '5312.05', 'BPK - UANG MAKAN'),
(398, '5312.04', 'BPK - UPAH LEMBUR'),
(397, '5312.02', 'BPK - UPAH MINGGUAN'),
(396, '5312.01', 'BPK - GAJI BULANAN'),
(395, '2150.05', 'HUTANG BUNGA KI'),
(394, '2150.04', 'HUTANG BUNGA KMK'),
(393, '1117.01', 'BANK NUSA NASIONAL'),
(392, '6210.01', 'RUGI SELISIH KURS'),
(391, '6112.01', 'LABA PENJUALAN AKTIVA TETAP'),
(390, '6111.01', 'PENDAPATAN SELISIH KURS'),
(389, '5312.03', 'BPK - UPAH BORONGAN '),
(388, '1121.01', 'DEPOSITO BNI 0239 - 20 - 1'),
(387, '1120.16', 'DEPOSITO BANK NIAGA 3084 - 20 - 3'),
(110, '1305.02', 'FORKLIFT'),
(111, '1310.01', 'AKUMULASI PENYUSUTAN TANAH'),
(112, '1311.01', 'AKUM PENY - BANGUNAN & PRASARANA'),
(113, '1312.01', 'AKUM PENY - MESIN'),
(114, '1313.01', 'AKUM PENY - PERALATAN PABRIK'),
(115, '1314.01', 'AKUM PENY - PERALATAN KANTOR'),
(116, '1315.01', 'AKUM PENY - MOBIL'),
(117, '1315.02', 'AKUM PENY - FORKLIFT'),
(118, '1400.01', 'HAK PATENT - NB'),
(119, '1401.01', 'MERK DAGANG - NB'),
(120, '1402.01', 'HAK LISENSI'),
(121, '1409.01', 'AKTIVA TAK BERWUJUD LAIN - LAIN - NB'),
(122, '1500.01', 'BIAYA PRA OPERASI'),
(123, '1503.01', 'RUGI SELISIH KURS DITANGGUHKAN'),
(124, '1509.01', 'BIAYA DITANGGUHKAN LAIN - LAIN'),
(125, '1510.01', 'BDP - BANGUNAN PABRIK'),
(126, '1510.02', 'BDP - BANGUNAN GUDANG'),
(127, '1510.03', 'BDP - BANGUNAN KANTOR'),
(128, '1510.99', 'BDP - BANGUNAN LAINNYA'),
(129, '1511.01', 'MDP - MESIN UTAMA'),
(130, '1511.02', 'MDP - MESIN PENDUKUNG'),
(131, '1520.01', 'JAMINAN SKBDN'),
(132, '1520.02', 'JAMINAN CASH COOL'),
(133, '1520.03', 'DEPOSITO YANG DIJAMINKAN'),
(134, '1520.04', 'BANK GARANSI'),
(135, '1520.99', 'JAMINAN SEMENTARA LAIN - LAIN'),
(136, '2100.02', 'HUTANG WDK BANK NIAGA'),
(137, '2100.03', 'HUTANG WESEL BAYAR'),
(138, '2100.99', 'HUTANG WESEL BAYAR LAIN - LAIN'),
(139, '2101.01', 'HUTANG USAHA LOKAL RUPIAH'),
(140, '2101.02', 'HUTANG USAHA LOKAL - SKBDN RUPIAH'),
(141, '2101.03', 'HUTANG USAHA LOKAL VALAS'),
(142, '2101.04', 'HUTANG USAHA LOKAL - SKBDN VALAS'),
(143, '2101.05', 'HUTANG USAHA PBT RUPIAH'),
(144, '2101.06', 'HUTANG USAHA PBT VALAS'),
(145, '2101.07', 'HUTANG USAHA IMPORT'),
(146, '2112.01', 'HUTANG FICORINVEST BANK'),
(147, '2114.02', 'HUTANG BNI KMK'),
(148, '2120.01', 'HUTANG ANGSURAN ACC'),
(149, '2120.02', 'HUTANG ANGSURAN SWADARMA'),
(150, '2120.99', 'HUTANG ANGSURAN LAIN - LAIN'),
(151, '2131.01', 'R/K UNIT HOLOGRAFI'),
(152, '2131.02', 'R/K UNIT PM 7/8'),
(153, '2131.03', 'R/K UNIT GROUP'),
(154, '2140.01', 'UANG MUKA PENJUALAN LOKAL RUPIAH'),
(155, '2140.02', 'UANG MUKA PENJUALAN LOKAL VALAS'),
(156, '2141.01', 'UANG MUKA PENJUALAN EKSPORT'),
(157, '2142.01', 'UANG MUKA PENJUALAN LAIN - LAIN'),
(158, '2150.01', 'HUTANG GAJI DAN UPAH'),
(159, '2150.02', 'HUTANG BUNGA'),
(160, '2150.03', 'BIAYA HARUS DIBAYAR LAIN - LAIN'),
(161, '2151.01', 'HUTANG DEVIDEN SAHAM BIASA'),
(162, '2151.02', 'HUTANG DEVIDEN SAHAM PRIORITAS'),
(163, '2152.01', 'HUTANG PEMEGANG SAHAM'),
(164, '2153.01', 'HUTANG KI JATUH TEMPO'),
(165, '2154.01', 'HUTANG MODAL KERJA UNIT HOLOGRAFI'),
(166, '2154.02', 'HUTANG MODAL KERJA UNIT PM 7/8'),
(167, '2154.03', 'HUTANG MODAL KERJA UNIT GROUP'),
(168, '2155.01', 'HUTANG BIAYA PBT'),
(169, '2155.02', 'HUTANG LAIN - LAIN PBT'),
(170, '2159.01', 'HUTANG LAIN - LAIN'),
(171, '2162.01', 'HUTANG UNIT HOLOGRAFI'),
(172, '2162.02', 'HUTANG UNIT PM 7/8'),
(173, '2162.03', 'HUTANG UNIT GROUP'),
(174, '2170.01', 'R/K PUSAT'),
(175, '2180.01', 'PPN KELUARAN I'),
(176, '2180.02', 'PPN KELUARAN II'),
(177, '2180.03', 'HUTANG SETORAN PPN'),
(178, '2190.01', 'HUTANG PPH 21'),
(179, '2190.02', 'HUTANG PPH 22'),
(180, '2190.03', 'HUTANG PPH 23'),
(181, '2190.04', 'HUTANG PPH 25'),
(182, '2190.05', 'HUTANG PPH 26'),
(183, '2190.06', 'HUTANG PPH 27'),
(184, '2190.07', 'HUTANG PPH 22 YANG AKAN DATANG'),
(185, '2202.01', 'HUTANG BFCE'),
(186, '2221.01', 'HUTANG JK. PANJANG - PBT'),
(187, '2221.02', 'HUTANG JK. PANJANG - KI'),
(188, '2221.99', 'HUTANG JK. PANJANG LAINNYA'),
(189, '3100.01', 'MODAL SAHAM DISETOR - SAHAM BIASA'),
(190, '3101.01', 'MODAL SAHAM DISETOR - SAHAM PRIORITAS'),
(191, '3400.01', 'SALDO LABA RUGI'),
(192, '3410.01', 'SALDO LABA/RUGI TAHUN BERJALAN'),
(193, '3411.01', 'SALDO LABA/RUGI BULAN BERJALAN'),
(194, '4100.01', 'PENJULAN LOKAL RUPIAH'),
(195, '4100.02', 'PENJUALAN LOKAL VALAS'),
(196, '4100.03', 'PENJUALAN EXPORT'),
(197, '4102.01', 'PENJUALAN LAIN - LAIN'),
(198, '4200.01', 'POTONGAN PENJUALAN LOKAL RUPIAH'),
(199, '4200.02', 'POTONGAN PENJUALAN LOKAL VALAS'),
(200, '4200.03', 'POTONGAN PENJUALAN EXPORT'),
(201, '4210.01', 'RETUR PENJUALAN LOKAL RUPIAH'),
(202, '4210.02', 'RETUR PENJUALAN LOKAL VALAS'),
(203, '4210.03', 'RETUR PENJUALAN EXPORT'),
(204, '4220.01', 'POTONGAN PENJUALAN LAIN - LAIN'),
(205, '5100.01', 'BEBAN POKOK PENJUALAN PRODUK UTAMA'),
(206, '5101.01', 'BEBAN POKOK PENJUALAN LAIN - LAIN'),
(207, '5110.01', 'HASIL BROKE'),
(208, '5200.01', 'BDP - BBB - KERTAS'),
(209, '5200.02', 'BDP - BBB - ALUFOIL'),
(210, '5200.03', 'BDP - BBB - OPP'),
(211, '5200.04', 'BDP - BBB - CHEMICAL'),
(212, '5200.05', 'BDP - BBB - PET'),
(213, '5200.06', 'BDP - BBB - PERTAMINA'),
(214, '5200.07', 'BDP - BBB - PULP'),
(215, '5200.08', 'BDP - BBB - AFVAL LOKAL'),
(216, '5200.09', 'BDP - BBB - AFVAL IMPORT'),
(217, '5200.99', 'BDP - BBB - LAIN - LAIN'),
(218, '5210.01', 'BDP - BTKL - GAJI BULANAN'),
(219, '5210.02', 'BDP - BTKL - UPAH MINGGUAN'),
(220, '5210.03', 'BDP - BTKL - UPAH BORONG'),
(221, '5210.04', 'BDP - BTKL - UPAH LEMBUR'),
(222, '5210.05', 'BDP - BTKL - UANG MAKAN'),
(223, '5210.06', 'BDP - BTKL - BONUS'),
(224, '5210.07', 'BDP - BTKL - PREMI'),
(225, '5210.08', 'BDP - BTKL - THR'),
(226, '5210.09', 'BDP - BTKL - HT'),
(227, '5210.10', 'BDP - BTKL - UANG CUTI'),
(228, '5210.11', 'BDP - BTKL - PESANGON'),
(229, '5210.11', 'BDP - BTKL - SUMBANGAN KARYAWAN'),
(230, '5210.13', 'BDP - BTKL - JAMSOSTEK'),
(231, '5211.01', 'BDP - BTKL - UANG KONSUMSI'),
(232, '5211.02', 'BDP - BTKL - PENGOBATAN'),
(233, '5211.99', 'BDP - BTKL - LAIN - LAIN'),
(234, '5220.01', 'BDP - BOP - GAJI BULANAN'),
(235, '5220.02', 'BDP - BOP - UPAH MINGGUAN'),
(236, '5220.03', 'BDP - BOP - UPAH BORONG'),
(237, '5220.04', 'BDP - BOP - UPAH LEMBUR'),
(238, '5220.05', 'BDP - BOP - UANG MAKAN'),
(239, '5220.06', 'BDP - BOP - BONUS'),
(240, '5220.07', 'BDP - BOP - PREMI'),
(241, '5220.08', 'BDP - BOP - THR'),
(242, '5220.09', 'BDP - BOP - HT'),
(243, '5220.10', 'BDP - BOP - UANG CUTI'),
(244, '5220.11', 'BDP - BOP - PESANGON'),
(245, '5220.12', 'BDP - BOP - SUMBANGAN KARYAWAN'),
(246, '5220.13', 'BDP - BOP - JAMSOSTEK'),
(247, '5221.01', 'BDP - BOP - UANG KONSUMSI'),
(248, '5221.02', 'BDP - BOP - PENGOBATAN'),
(249, '5222.01', 'BDP - BOP - SOLAR'),
(250, '5222.02', 'BDP - BOP - RESIDU'),
(251, '5222.03', 'BDP - BOP - BATU BARA'),
(252, '5222.04', 'BDP - BOP - LISTRIK'),
(253, '5223.01', 'BDP - BOP - RAWAT & PELIHARA BANGUNAN & PRSR'),
(254, '5223.02', 'BDP - BOP - RAWAT & PELIHARA MESIN'),
(255, '5223.03', 'BDP - BOP - RAWAT & PELIHARA PERALATAN PBRK'),
(256, '5223.04', 'BDP - BOP - RAWAT & PELIHARA KENDARAAN'),
(257, '5224.01', 'BDP - BOP - BAHAN PEMBANTU'),
(258, '5224.02', 'BDP - BOP - AIR'),
(259, '5224.03', 'BDP - BOP - ALAT KERJA TEKNISI'),
(260, '5224.04', 'BDP - BOP - SUPPLIES PABRIK'),
(261, '5224.99', 'BDP - BOP - BAHAN PEMBANTU LAIN - LAIN'),
(262, '5225.01', 'BDP - BOP - PENYUSUTAN TANAH'),
(263, '5225.02', 'BDP - BOP - PENYUSUTAN BANGUNAN & PRASARANA'),
(264, '5225.03', 'BDP - BOP - PENYUSUTAN MESIN'),
(265, '5225.04', 'BDP - BOP - PENYUSUTAN PERALATAN KANTOR'),
(266, '5225.05', 'BDP - BOP - PENYUSUTAN KENDARAAN'),
(267, '5226.01', 'BDP - BOP - ANGKUT MASUK'),
(268, '5226.02', 'BDP - BOP - BONGKAR & MUAT'),
(269, '5226.03', 'BDP - BOP - TRANSPORT PEMBELIAN'),
(270, '5226.04', 'BDP - BOP - TRANSPORT ANTAR UNIT'),
(271, '5227.01', 'BDP - BOP - ASURANSI KEBAKARAN'),
(272, '5227.02', 'BDP - BOP - ASURANSI PENGANGKUTAN'),
(273, '5227.03', 'BDP - BOP - ASURANSI KENDARAAN'),
(274, '5227.99', 'BDP - BOP - ASURANSI LAIN - LAIN'),
(275, '5229.01', 'BDP - BOP - FINISHING'),
(276, '5229.02', 'BDP - BOP - PENGOLAHAN LIMBAH'),
(277, '5229.03', 'BDP - BOP - IMPORT'),
(278, '5229.04', 'BDP - BOP - QC'),
(279, '5229.05', 'BDP - BOP - R & D'),
(280, '5229.99', 'BDP - BOP - LAIN - LAIN'),
(281, '5300.01', 'BAU - GAJI BULANAN'),
(282, '5300.02', 'BAU - UPAH MINGGUAN'),
(283, '5300.03', 'BAU - UPAH BORONG'),
(284, '5300.04', 'BAU - UPAH LEMBUR'),
(285, '5300.05', 'BAU - UANG MAKAN'),
(286, '5300.07', 'BAU - PREMI THR'),
(287, '5310.06', 'BAU - UANG BONUS'),
(288, '5310.07', 'BAU - PREMI KARYAWAN'),
(289, '5300.08', 'BAU - PREMI PIMPIN'),
(290, '5300.09', 'BAU - THR'),
(291, '5300.10', 'BAU - HT'),
(292, '5300.11', 'BAU - UANG CUTI'),
(293, '5300.12', 'BAU - PESANGON'),
(294, '5300.13', 'BAU - SUMBANGAN KARYAWAN'),
(295, '5300.14', 'BAU - JAMSOSTEK'),
(296, '5300.99', 'BAU - LAIN - LAIN'),
(297, '5301.01', 'BAU - KONSUMSI'),
(298, '5301.02', 'BAU - PENGOBATAN'),
(299, '5301.03', 'BAU - TELEPON'),
(300, '5301.04', 'BAU - TELEX'),
(301, '5301.05', 'BAU - FAX'),
(302, '5301.06', 'BAU - SUPPLIES KANTOR'),
(303, '5301.07', 'BAU - REPRESENTASI'),
(304, '5301.08', 'BAU - SUMBANGAN LUAR'),
(305, '5301.09', 'BAU - PEMELIHARAAN & PERAWATAN BANG & PRAS'),
(306, '5301.10', 'BAU - PEMELIHARAAN & PERAWATAN PRLT. KANTOR'),
(307, '5301.11', 'BAU - PEMELIHARAAN & PERAWATAN KEND. & ALAT '),
(308, '5301.12', 'BAU - HANDPHONE'),
(309, '5301.13', 'BAU - LISTRIK & AIR'),
(310, '5301.14', 'BAU - FOTO COPY'),
(311, '5301.15', 'BAU - PAKET & PENGIRIMAN'),
(312, '5301.16', 'BAU - RETRIBUSI'),
(313, '5301.99', 'BAU - LAIN - LAIN '),
(314, '5302.01', 'BAU - BEBAN PERJALANAN DINAS DALAM NEGERI'),
(315, '5302.02', 'BAU - BEBAN PERJALANAN DINAS LUAR NEGERI'),
(316, '5302.99', 'BAU - BEBAN PERJALANAN DINAS LAIN - LAIN'),
(317, '5306.01', 'BAU - PENYUSUTAN BANGUNAN & PRASARANA'),
(318, '5306.02', 'BAU - PENYUSUTAN KENDARAAN'),
(319, '5306.03', 'BAU - PENYUSUTAN PERALATAN KANTOR'),
(320, '5307.99', 'BAU - BEBAN LAIN - LAIN'),
(321, '5310.01', 'BP - BEBAN PENGIRIMAN SENDIRI'),
(322, '5310.02', 'BP - BEBAN PENGIRIMAN VIA KENDARAAN'),
(323, '5311.01', 'BPJ - GAJI BULANAN'),
(324, '5311.02', 'BPJ - UPAH MINGGUAN'),
(325, '5311.03', 'BPJ - UPAH BORONGAN'),
(326, '5311.04', 'BPJ - UPAH LEMBUR'),
(327, '5311.05', 'BPJ - UANG MAKAN'),
(328, '5311.06', 'BPJ - BONUS'),
(329, '5311.07', 'BPJ - PREMI'),
(330, '5311.08', 'BPJ - THR'),
(331, '5311.09', 'BPJ - HT'),
(332, '5311.10', 'BPJ - UANG CUTI'),
(333, '5311.11', 'BPJ - PESANGON'),
(334, '5311.12', 'BPJ - SUMBANGAN KARYAWAN'),
(335, '5311.13', 'BPJ - JAMSOSTEK'),
(336, '5311.14', 'BPJ - KONSUMSI'),
(337, '5311.15', 'BPJ - PENGOBATAN'),
(338, '5311.16', 'BPJ - PERJALANAN DINAS DALAM NEGERI'),
(339, '5311.17', 'BPJ - PERJALANAN DINAS LUAR NEGERI'),
(340, '5311.18', 'BPJ - SUPPLIES KANTOR'),
(341, '5311.19', 'BPJ - TELEPON'),
(342, '5311.20', 'BPJ - TELEX'),
(343, '5311.21', 'BPJ - FAX'),
(344, '5311.25', 'BPJ - PEMELIHARAAN & PERAWATAN PRLT. KANTOR'),
(345, '5311.99', 'BPJ - LAIN - LAIN'),
(346, '5311.28', 'BPJ - PAKET KIRIMAN'),
(347, '5311.22', 'BPJ - LISTRIK & AIR'),
(348, '5311.23', 'BPJ - REPRESENTASI'),
(349, '5300.16', 'BPJ - JAMSOSTEK'),
(350, '6113.01', 'PENDAPATAN DENDA'),
(351, '6199.99', 'PENDAPATAN LAIN - LAIN'),
(352, '6200.01', 'BEBAN BUNGA - BNI'),
(353, '5200.02', 'BEBAN BUNGA - BANK NIAGA'),
(354, '6200.03', 'BEBAN BUNGA - LIPPO BANK'),
(355, '6200.04', 'BEBAN BUNGA - DANAMON'),
(356, '6200.05', 'BEBAN BUNGA - FICORINVEST'),
(357, '6200.99', 'BEBAN BUNGA LAIN - LAIN'),
(358, '6201.01', 'BEBAN ADM. - BNI'),
(359, '6201.02', 'BEBAN ADM. - BANK NIAGA'),
(360, '6201.03', 'BEBAN ADM. - LIPPO BANK'),
(361, '6201.04', 'BEBAN ADM. - DANAMON'),
(362, '6201.05', 'BEBAN ADM. - FICORINVEST'),
(363, '6201.99', 'BEBAN ADM. - LAIN - LAIN'),
(364, '6202.01', 'BEBAN DENDA SUPPLIER'),
(365, '6203.01', 'BEBAN PAJAK PBB'),
(366, '6203.99', 'BEBAN PAJAK LAIN - LAIN'),
(367, '6209.99', 'BEBAN LAIN - LAIN'),
(368, '6210.01', 'RUGI SELISIH KURS'),
(369, '6297.01', 'RUGI PENURUNAN NILAI SURAT BERHARGA'),
(370, '6298.01', 'RUGI PENURUNAN NILAI PERSEDIAAN'),
(371, '6299.99', 'BEBAN/RUGI LAIN - LAIN'),
(372, '1113.01', 'STANDARD CHARTERED BANK'),
(373, '1120.02', 'DEPOSITO BANK NIAGA 2577 - 20 - 0'),
(374, '1120.03', 'DEPOSITO BANK NIAGA 2579 - 20 - 2'),
(375, '1120.04', 'DEPOSITO BANK NIAGA 2671 - 20 - 8'),
(376, '1120.05', 'DEPOSITO BANK NIAGA 2733 - 20 - 4'),
(377, '1120.06', 'DEPOSITO BANK NIAGA 2762 - 20 - 3'),
(378, '1120.07', 'DEPOSITO BANK NIAGA 0234 - 20 - 1'),
(379, '1120.08', 'DEPOSITO BANK NIAGA 0239 - 20 - 1'),
(380, '1120.09', 'DEPOSITO BANK NIAGA 2880 - 20 - 5'),
(381, '1120.10', 'DEPOSITO BANK NIAGA 2946 - 20 - 4'),
(382, '1120.11', 'DEPOSITO BANK NIAGA 2946 - 20 - 5'),
(383, '1120.12', 'DEPOSITO BANK NIAGA 0241 - 20 - 8'),
(384, '1120.13', 'DEPOSITO BANK NIAGA 0245 - 20 - 2'),
(385, '1120.14', 'DEPOSITO BANK NIAGA 3071 - 20 - 7'),
(386, '1120.15', 'DEPOSITO BANK NIAGA 3072 - 20 - 3'),
(109, '1305.01', 'MOBIL'),
(108, '1304.01', 'PERALATAN KANTOR'),
(107, '1303.01', 'PERALATAN PABRIK'),
(106, '1302.02', 'MESIN PENDUKUNG'),
(105, '1302.01', 'MESIN UTAMA'),
(104, '1301.01', 'BANGUNAN & PRASARANA'),
(103, '1300.01', 'TANAH'),
(102, '1193.99', 'PORSEKOT BIAYA LAIN - LAIN HT & THR'),
(101, '1193.03', 'PORSEKOT SEWA'),
(100, '1193.02', 'PORSEKOT BIAYA ASURANSI KEBAKARAN'),
(99, '1193.01', 'PORSEKOT BIAYA ASURANSI JAMSOSTEK'),
(98, '1192.01', 'PORSEKOT PEMBELIAN IMPORT'),
(97, '1192.02', 'PORSEKOT PEMBELIAN LOKAL VALAS'),
(96, '1191.01', 'PORSEKOT PEMBELIAN LOKAL RUPIAH'),
(95, '1190.05', 'PORSEKOT PPH 29'),
(94, '1190.04', 'PORSEKOT PPH 25'),
(93, '1190.03', 'PORSEKOT PPH 23'),
(92, '1190.02', 'PORSEKOT PPH 22'),
(91, '1190.01', 'PORSEKOT PPH 21'),
(90, '1180.04', 'RESTITUSI'),
(89, '1180.03', 'SURAT SETORAN PAJAK ( SSP )'),
(88, '1180.02', 'PPN - MASUKAN II'),
(87, '1180.01', 'PPN - MASUKAN I'),
(86, '1179.03', 'CADANGAN PENURUNAN NILAI PERSEDIAAN SC'),
(85, '1179.02', 'CADANGAN PENURUNAN NILAI PERSEDIAAN BP'),
(84, '1179.01', 'CADANGAN PENURUNAN NILAI PERSEDIAAN BB'),
(83, '1175.01', 'PERSEDIAAN SUKU CADANG'),
(82, '1174.02', 'PERSEDIAAN SUPPLIES PABRIK'),
(81, '1174.01', 'PERSEDIAAN SUPPLIES KANTOR'),
(80, '1173.99', 'PERSEDIAAN BAHAN PEMBANTU LAIN - LAIN'),
(79, '1173.05', 'PERSEDIAAN BAHAN PEMBANTU B. BKR BT. BARA'),
(78, '1173.04', 'PERSEDIAAN BAHAN PEMBANTU B. BKR RESIDU'),
(77, '1173.03', 'PERSEDIAAN BAHAN PEMBANTU B. BKR SOLAR'),
(76, '1173.02', 'PERSEDIAAN BAHAN PEMBANTU CHEMICAL'),
(75, '1173.01', 'PERSEDIAAN BAHAN PEMBANTU NON CHEMICAL'),
(74, '1172.99', 'PERSEDIAAN BAHAN BAKU LAIN - LAIN'),
(73, '1172.11', 'PERSEDIAAN BAHAN BAKU AFVAL LOKAL'),
(72, '1172.10', 'PERSEDIAAN BAHAN BAKU AFVAL IMPORT'),
(71, '1172.09', 'PERSEDIAAN BAHAN BAKU PULP'),
(70, '1172.08', 'PERSEDIAAN BAHAN BAKU PERTAMINA'),
(69, '1172.07', 'PERSEDIAAN BAHAN BAKU PVC'),
(68, '1172.06', 'PERSEDIAAN BAHAN BAKU PET'),
(67, '1172.05', 'PERSEDIAAN BAHAN BAKU OPP'),
(66, '1172.04', 'PERSEDIAAN BAHAN BAKU ALUFOIL'),
(65, '1172.03', 'PERSEDIAAN BAHAN BAKU CHEMICAL'),
(64, '1172.01', 'PERSEDIAAN BAHAN BAKU KERTAS'),
(63, '1171.01', 'PERSEDIAAN BARANG DALAM PROSES ( BDP )'),
(62, '1170.02', 'PERSEDIAAN BARANG JADI DALAM PERJALANAN'),
(61, '1170.01', 'PERSEDIAAN BARANG JADI'),
(60, '1169.03', 'CADANGAN KERUGIAN EKPORT'),
(59, '1169.01', 'CADANGAN KERUGIAN PIUTANG LOKAL'),
(58, '1168.04', 'PIUTANG LAIN - LAIN'),
(57, '1168.03', 'PIUTANG PENDAPATAN'),
(56, '1168.02', 'PIUTANG BIAYA'),
(55, '1168.01', 'PIUTANG KARYAWAN'),
(54, '1167.02', 'PIUTANG PBT LAIN - LAIN'),
(53, '1167.01', 'PIUTANG BIAYA PURA BARUTAMA'),
(52, '1166.99', 'PIUTANG MODAL KERJA LAIN - LAIN'),
(51, '1166.03', 'PIUTANG MODAL KERJA UNIT - GROUP'),
(50, '1166.02', 'PIUTANG MODAL KERJA UNIT - PM 7/8'),
(49, '1166.01', 'PIUTANG MODAL KERJA UNIT - HOLOGRAFI'),
(48, '1162.03', 'PIUTANG UNIT GROUP'),
(47, '1162.02', 'PIUTANG UNIT PM 7/8'),
(46, '1162.01', 'PIUTANG UNIT HOLOGRAFI'),
(45, '1161.01', 'PIUTANG DAGANG EKSPORT'),
(44, '1160.04', 'PIUTANG USAHA PURA BARUTAMA ( VALAS )'),
(43, '1160.03', 'PIUTANG USAHA PURA BARUTAMA ( RUPIAH )'),
(42, '1160.02', 'PIUTANG DAGANG LOKAL ( VALAS )'),
(41, '1160.01', 'PIUTANG DAGANG LOKAL ( RUPIAH )'),
(40, '1159.01', 'CADANGAN PENURUNAN NILAI SURAT BERHARGA '),
(39, '1151.01', 'SURAT BERHARGA - OBLIGASI'),
(38, '1150.01', 'SURAT BERHARGA - SAHAM'),
(37, '1140.01', 'R/K PUSAT'),
(36, '1131.03', 'R/K UNIT GROUP'),
(35, '1131.02', 'R/K UNIT PM 7/8'),
(34, '1131.01', 'UNIT HOLOGRAFI'),
(33, '1122.01', 'DEPOSITO LIPPO BANK KDS'),
(32, '1120.01', 'DEPOSITO BANK NIAGA 2420-20-9'),
(31, '1119.01', 'DANAMON A/C 464-000000-226'),
(30, '1116.01', 'BANK BII'),
(29, '1115.02', 'BNI KDS A/C 043-000634435-002 ( VALAS )'),
(28, '1115.01', 'BNI KDS A/C 043-000634435-001 ( GIRO )'),
(27, '1114.01', 'LIPPO BANK KDS A/C 546-30-00370-9'),
(26, '1112.07', 'NIAGA POOLING A/C 0400-10-6934-006'),
(25, '1112.06', 'NIAGA VALAS A/C 040-0206793-009'),
(24, '1112.05', 'NIAGA KMG A/C 63-1-0291-9-00'),
(23, '1112.04', 'NIAGA FLTH A/C 03-1-4157-00'),
(22, '1112.03', 'NIAGA KBS OPRS A/C 05-1-2920-9-00'),
(21, '1112.02', 'NIAGA KOS A/C 40-1-0540-4 ( PM 7/8 )'),
(20, '1112.01', 'NIAGA KOS A/C 40-1-0583-1 ( HOLO )'),
(19, '1102.01', 'SETORAN DALAM PERJALANAN'),
(18, '1101.15', 'KAS KECIL PWK DELTA'),
(17, '1101.14', 'KAS KECIL PWK SEMUT'),
(16, '1101.13', 'KAS KECIL PWK KEMANG - EDY PURNOMO'),
(15, '1101.12', 'KAS KECIL PWK KEMANG - MELINA'),
(14, '1101.11', 'KAS KECIL PWK KEMANG - SOEDARMADJI SWT'),
(13, '1101.10', 'KAS KECIL PWK KEMANG - SOEDARMADJI PMRTH'),
(12, '1101.09', 'KAS KECIL PWK KEBON SIRIH '),
(462, '5313.32', 'BPS - HANDPHONE'),
(463, '5313.33', 'BPS - KOMUNIKASI'),
(464, '5313.34', 'BPS - RETRIBUSI'),
(465, '5313.35', 'BPS - SEWA'),
(466, '5313.99', 'BPS - LAIN - LAIN'),
(467, '5314.01', 'BEBAN SDOD PERWAKILAN JAWA BARAT'),
(468, '5314.02', 'BEBAN SDOD PERWAKILAN JAWA TENGAH'),
(469, '5314.03', 'BEBAN SDOD PERWAKILAN JAWA TIMUR'),
(470, '5314.99', 'BEBAN SDOD LAIN - LAIN'),
(471, '5315.01', 'BEBAN KERUGIAN PIUTANG ( PPN )'),
(472, '5315.02', 'BEBAN KERUGIAN PIUTANG ( PPH 22 )'),
(473, '5315.03', 'RUGI PENGHAPUSAN PIUTANG'),
(474, '5316.01', 'CASH DISCOUNT'),
(475, '5316.02', 'DISCOUNT PEMBAYARAN'),
(476, '5316.03', 'DISCOUNT PENJUALAN'),
(477, '5317.01', 'BEBAN COLLECTION L/C PENJUALAN LOKAL'),
(478, '5317.02', 'BEBAN COLLECTION L/C PENJUALAN EKSPORT'),
(479, '5318.01', 'BPE - GAJI BULANAN'),
(480, '5318.02', 'BPE - UPAH MINGGUAN'),
(481, '5318.03', 'BPE - UPAH BORONG'),
(482, '5318.04', 'BPE - UPAH LEMBUR'),
(483, '5318.05', 'BPE - UANG MAKAN'),
(484, '5318.06', 'BPE - UANG MINUM'),
(485, '5318.07', 'BPE - UANG KONSUMSI'),
(486, '5318.08', 'BPE - PREMI'),
(487, '5318.09', 'BPE - THR'),
(488, '5318.10', 'BPE - HT'),
(489, '5318.11', 'BPE - PENGOBATAN'),
(490, '5318.12', 'BPE - KARYAWAN LAIN - LAIN'),
(491, '5318.13', 'BPE - BEBAN PERJALANAN'),
(492, '5318.14', 'BPE - BEBAN KANTOR'),
(493, '5318.15', 'BPE - BEBAN TELP/TLX/FAC/SP'),
(494, '5318.16', 'BPE - BEBAN LISTRIK'),
(495, '5318.17', 'BPE - BEBAN KENDARAAN/TRANSPORT'),
(496, '5318.18', 'BPE - BEBAN REPRESENTASI'),
(497, '5318.19', 'BPE - BEBAN SUMBANGAN'),
(498, '5318.20', 'BPE - BEBAN PERAWATAN'),
(499, '5318.21', 'BPE - BEBAN PAMERAN'),
(500, '5318.22', 'BPE - BEBAN KONSULTAN'),
(501, '5318.99', 'BPE - LAIN - LAIN'),
(502, '5319.99', 'BEBAN EKSPORT LAIN - LAIN/KOMISI');

-- --------------------------------------------------------

--
-- Table structure for table `master_terima_bskk`
--

CREATE TABLE IF NOT EXISTS `master_terima_bskk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jenis` varchar(100) NOT NULL,
  `jumlah` bigint(20) NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `master_terima_bskk`
--

INSERT INTO `master_terima_bskk` (`id`, `jenis`, `jumlah`, `tanggal`) VALUES
(1, 'Kas Pusat Test', 40000000, '2017-05-08'),
(2, 'Kas Pusat Test 2', 1000000, '2017-05-10'),
(3, 'Kas Pusat Test 3', 500000, '2017-05-26'),
(4, 'Kas Pusat Test 4', 600000, '2017-05-26'),
(5, 'Kas Pusat Test 5', 700000, '2017-05-26'),
(6, 'Kas Pusat Test 6', 700000, '2017-04-04'),
(7, 'Kas Pusat Test 6', 800000, '2017-04-11'),
(8, 'Kas Pusat Test 8', 56000, '2017-04-27'),
(9, 'Kas Pusat Test 9', 90000, '2017-04-27'),
(10, 'Kas Pusat Test 10', 45000, '2017-04-27'),
(11, 'Kas Pusat Test 11', 6300000, '2016-10-12'),
(12, 'Kas Pusat Test 12', 4800000, '2016-10-19'),
(13, 'Kas Pusat Test 13', 1230000, '2016-10-19'),
(14, 'Kas Pusat Test 14', 460000, '2016-09-18');

-- --------------------------------------------------------

--
-- Table structure for table `saldo_akhir_bskk`
--

CREATE TABLE IF NOT EXISTS `saldo_akhir_bskk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bulan` varchar(50) NOT NULL,
  `tahun` varchar(50) NOT NULL,
  `saldo` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `saldo_akhir_bskk`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
