CREATE TABLE `akses` (
  `KodeAkses` int(11) NOT NULL AUTO_INCREMENT,
  `KodeUser` int(11) NOT NULL,
  `NamaFitur` varchar(200) CHARACTER SET latin1 NOT NULL,
  `Akses` int(11) NOT NULL,
  PRIMARY KEY (`KodeAkses`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `akun` (
  `NoAkun` varchar(100) NOT NULL,
  `NamaAkun` varchar(250) NOT NULL,
  `SN` int(11) NOT NULL,
  PRIMARY KEY (`NoAkun`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `barang` (
  `Barcode` varchar(150) CHARACTER SET latin1 NOT NULL,
  `NamaItem` varchar(150) CHARACTER SET latin1 NOT NULL,
  `JenisItem` int(11) NOT NULL,
  `KodeKategori` int(11) NOT NULL,
  `KodeMerek` int(11) NOT NULL,
  PRIMARY KEY (`Barcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `bisnis` (
  `KodeBisnis` int(11) NOT NULL AUTO_INCREMENT,
  `NamaBisnis` varchar(45) NOT NULL,
  PRIMARY KEY (`KodeBisnis`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `businesscontact` (
  `KodeBC` int(11) NOT NULL AUTO_INCREMENT,
  `NoMember` varchar(45) DEFAULT NULL,
  `NamaBC` varchar(150) CHARACTER SET latin1 NOT NULL,
  `JenisKontak` int(11) NOT NULL,
  `Alamat` varchar(300) CHARACTER SET latin1 NOT NULL,
  `Kelurahan` varchar(45) CHARACTER SET latin1 NOT NULL,
  `Kecamatan` varchar(45) CHARACTER SET latin1 NOT NULL,
  `Kota` varchar(45) CHARACTER SET latin1 NOT NULL,
  `Telpon1` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `Telpon2` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `NoHP1` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `NoHP2` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`KodeBC`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `expire` (
  `KodeExpire` int(11) NOT NULL AUTO_INCREMENT,
  `TglExpire` varchar(45) NOT NULL,
  `Keterangan` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`KodeExpire`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `fitur` (
  `KodeFitur` int(11) NOT NULL AUTO_INCREMENT,
  `NamaFitur` varchar(200) NOT NULL,
  PRIMARY KEY (`KodeFitur`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `identitas` (
  `NoIdentitas` varchar(100) CHARACTER SET latin1 NOT NULL,
  `KodeJenis` int(11) NOT NULL,
  `NamaLengkap` varchar(350) CHARACTER SET latin1 NOT NULL,
  `JenisKelamin` int(11) NOT NULL,
  `TempatLahir` varchar(250) CHARACTER SET latin1 NOT NULL,
  `TglLahir` date NOT NULL,
  `Alamat` varchar(500) CHARACTER SET latin1 NOT NULL,
  `RT` varchar(45) CHARACTER SET latin1 NOT NULL,
  `RW` varchar(45) CHARACTER SET latin1 NOT NULL,
  `Kelurahan` varchar(250) CHARACTER SET latin1 NOT NULL,
  `Kecamatan` varchar(250) CHARACTER SET latin1 NOT NULL,
  `Kabupaten` varchar(100) CHARACTER SET latin1 NOT NULL,
  `Agama` varchar(100) CHARACTER SET latin1 NOT NULL,
  `StatusPernikahan` varchar(100) CHARACTER SET latin1 NOT NULL,
  `Pekerjaan` varchar(100) CHARACTER SET latin1 NOT NULL,
  `Kewarganegaraan` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`NoIdentitas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `item` (
  `KodeItem` int(11) NOT NULL AUTO_INCREMENT,
  `Barcode` varchar(45) NOT NULL,
  `NamaItem` varchar(200) NOT NULL,
  `JenisItem` int(11) NOT NULL,
  `KodeKategori` int(11) NOT NULL,
  `KodeOutlet` int(11) NOT NULL,
  `KodeSatuan` int(11) NOT NULL,
  `Kuantitas` double NOT NULL,
  `Isi` double NOT NULL,
  `StokMinimum` double NOT NULL,
  `HargaModal` double NOT NULL,
  `HargaJual` double NOT NULL,
  `Diskon` double NOT NULL,
  PRIMARY KEY (`KodeItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `items` (
  `Barcode` varchar(150) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `NamaItem` varchar(150) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `JenisItem` int(11) NOT NULL,
  `KodeKategori` int(11) NOT NULL,
  `KodeMerek` int(11) NOT NULL,
  PRIMARY KEY (`Barcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `jenisidentitas` (
  `KodeJenis` int(11) NOT NULL AUTO_INCREMENT,
  `NamaJenis` varchar(150) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`KodeJenis`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `jenispekerjaan` (
  `KodeJob` int(11) NOT NULL AUTO_INCREMENT,
  `NamaPekerjaan` varchar(150) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`KodeJob`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `jenispembayaran` (
  `KodeJenis` int(11) NOT NULL AUTO_INCREMENT,
  `NamaJenis` varchar(150) CHARACTER SET utf32 NOT NULL,
  `KodePenyimpanan` int(11) NOT NULL,
  PRIMARY KEY (`KodeJenis`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `jenistransaksi` (
  `KodeJenis` int(11) NOT NULL AUTO_INCREMENT,
  `NamaJenis` varchar(150) NOT NULL,
  PRIMARY KEY (`KodeJenis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `kategori` (
  `KodeKategori` int(11) NOT NULL AUTO_INCREMENT,
  `NamaKategori` varchar(150) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`KodeKategori`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `kelarisan` (
  `KodeLaris` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` int(11) NOT NULL,
  `Barcode` varchar(45) NOT NULL,
  `Tanggal` int(11) NOT NULL,
  `Minggu` int(11) NOT NULL,
  `Bulan` int(11) NOT NULL,
  `Tahun` int(11) NOT NULL,
  `Kuantitas` double NOT NULL,
  PRIMARY KEY (`KodeLaris`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `keuangan` (
  `KodeFin` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` double NOT NULL,
  `Tanggal` date NOT NULL,
  `NoAkun` varchar(150) NOT NULL,
  `KodePenyimpanan` int(11) NOT NULL,
  `Debet` double NOT NULL,
  `Kredit` double NOT NULL,
  PRIMARY KEY (`KodeFin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `lababulanan` (
  `KodeLB` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` int(11) NOT NULL,
  `KodeJenis` int(11) NOT NULL,
  `KodeUser` int(11) NOT NULL,
  `Bulan` int(11) NOT NULL,
  `Tahun` int(11) NOT NULL,
  `TotalModal` double NOT NULL,
  `TotalJual` double NOT NULL,
  `TotalDiskon` double NOT NULL,
  `TotalVariance` double NOT NULL,
  `TotalNota` int(11) NOT NULL,
  PRIMARY KEY (`KodeLB`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `labaharian` (
  `KodeLB` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` int(11) NOT NULL,
  `KodeUser` int(11) NOT NULL,
  `KodeJenis` int(11) NOT NULL,
  `KodeSift` int(11) NOT NULL,
  `Tanggal` int(11) NOT NULL,
  `Bulan` int(11) NOT NULL,
  `Tahun` int(11) NOT NULL,
  `TotalModal` double NOT NULL,
  `TotalJual` double NOT NULL,
  `TotalDiskon` double NOT NULL,
  `KasAktual` double NOT NULL,
  `TotalVariance` double NOT NULL,
  `TotalNota` int(11) NOT NULL,
  PRIMARY KEY (`KodeLB`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `labaitem` (
  `KodeLB` int(11) NOT NULL AUTO_INCREMENT,
  `NoNota` int(200) NOT NULL,
  `Tanggal` date NOT NULL,
  `KodeOutlet` int(11) NOT NULL,
  `Barcode` varchar(45) NOT NULL,
  `KodeJenis` int(11) NOT NULL,
  `KodeSatuan` int(11) NOT NULL,
  `Kuantitas` double NOT NULL,
  `HargaModal` double NOT NULL,
  `TotalModal` double NOT NULL,
  `HargaJual` double NOT NULL,
  `TotalJual` double NOT NULL,
  `TotalDiskon` double NOT NULL,
  PRIMARY KEY (`KodeLB`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `labamingguan` (
  `KodeLB` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` int(11) NOT NULL,
  `KodeJenis` int(11) NOT NULL,
  `KodeUser` int(11) NOT NULL,
  `Minggu` int(11) NOT NULL,
  `Bulan` int(11) NOT NULL,
  `Tahun` int(11) NOT NULL,
  `TotalModal` double NOT NULL,
  `TotalJual` double NOT NULL,
  `TotalDiskon` double NOT NULL,
  `TotalVariance` double NOT NULL,
  `TotalNota` int(11) NOT NULL,
  PRIMARY KEY (`KodeLB`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `labatahunan` (
  `KodeLB` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` int(11) NOT NULL,
  `KodeJenis` int(11) NOT NULL,
  `KodeUser` int(11) NOT NULL,
  `Tahun` int(11) NOT NULL,
  `TotalModal` double NOT NULL,
  `TotalJual` double NOT NULL,
  `TotalDiskon` double NOT NULL,
  `TotalVariance` double NOT NULL,
  `TotalNota` int(11) NOT NULL,
  PRIMARY KEY (`KodeLB`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `larisbulanan` (
  `KodeLaris` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` int(11) NOT NULL,
  `Barcode` varchar(45) NOT NULL,
  `KodeKategori` int(11) NOT NULL,
  `Bulan` int(11) NOT NULL,
  `Tahun` int(11) NOT NULL,
  `KodeSatuan` int(11) NOT NULL,
  `Kuantitas` double NOT NULL,
  PRIMARY KEY (`KodeLaris`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `larisharian` (
  `KodeLaris` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` int(11) NOT NULL,
  `Barcode` varchar(45) CHARACTER SET latin1 NOT NULL,
  `KodeKategori` int(11) NOT NULL,
  `Tanggal` int(11) NOT NULL,
  `Bulan` int(11) NOT NULL,
  `Tahun` int(11) NOT NULL,
  `KodeSatuan` int(11) NOT NULL,
  `Kuantitas` double NOT NULL,
  PRIMARY KEY (`KodeLaris`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `larismingguan` (
  `KodeLaris` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` int(11) NOT NULL,
  `Barcode` varchar(45) CHARACTER SET latin1 NOT NULL,
  `KodeKategori` int(11) NOT NULL,
  `Minggu` int(11) NOT NULL,
  `Bulan` int(11) NOT NULL,
  `Tahun` int(11) NOT NULL,
  `KodeSatuan` int(11) NOT NULL,
  `Kuantitas` double NOT NULL,
  PRIMARY KEY (`KodeLaris`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `laristahunan` (
  `KodeLaris` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` int(11) NOT NULL,
  `Barcode` varchar(45) NOT NULL,
  `KodeKategori` int(11) NOT NULL,
  `Tahun` int(11) NOT NULL,
  `KodeSatuan` int(11) NOT NULL,
  `Kuantitas` double NOT NULL,
  PRIMARY KEY (`KodeLaris`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `member` (
  `KodeMember` int(11) NOT NULL AUTO_INCREMENT,
  `NoMember` varchar(100) NOT NULL,
  `KodeBC` int(11) NOT NULL,
  `Level` varchar(150) NOT NULL,
  `Diskon` double NOT NULL,
  `TglExpire` date NOT NULL,
  PRIMARY KEY (`KodeMember`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `merek` (
  `KodeMerek` int(11) NOT NULL AUTO_INCREMENT,
  `NamaMerek` varchar(100) NOT NULL,
  PRIMARY KEY (`KodeMerek`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `mobil` (
  `KodeMobil` int(11) NOT NULL AUTO_INCREMENT,
  `NoPolisi` varchar(45) NOT NULL,
  `JenisMobil` int(11) NOT NULL,
  `Merek` varchar(45) NOT NULL,
  `Warna` varchar(45) NOT NULL,
  PRIMARY KEY (`KodeMobil`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `orderan` (
  `KodeOrderan` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOutlet` int(11) NOT NULL,
  `KodeUser` int(11) NOT NULL,
  `KodeBC` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `JenisTransaksi` int(11) NOT NULL,
  `KodeJenis` int(11) NOT NULL,
  `SubTotal` double NOT NULL,
  `PPN` double NOT NULL,
  `GrandTotal` double NOT NULL,
  `StatusOrderan` int(11) NOT NULL,
  `TglExpire` date DEFAULT NULL,
  PRIMARY KEY (`KodeOrderan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `outlet` (
  `KodeOutlet` int(11) NOT NULL AUTO_INCREMENT,
  `NamaOutlet` varchar(250) NOT NULL,
  `Alamat` varchar(350) NOT NULL,
  `Kelurahan` varchar(150) NOT NULL,
  `Kecamatan` varchar(150) NOT NULL,
  `Kota` varchar(150) NOT NULL,
  `Provinsi` varchar(150) NOT NULL,
  PRIMARY KEY (`KodeOutlet`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `pekerjaan` (
  `KodeKerja` int(11) NOT NULL AUTO_INCREMENT,
  `NoIdentitas` varchar(45) CHARACTER SET latin1 NOT NULL,
  `KodeJob` int(11) NOT NULL,
  `KodeOutlet` int(11) NOT NULL,
  `JenisPembayaran` int(11) DEFAULT NULL,
  `Gaji` double NOT NULL,
  PRIMARY KEY (`KodeKerja`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `penyimpanan` (
  `KodePenyimpanan` int(11) NOT NULL AUTO_INCREMENT,
  `NamaPenyimpanan` varchar(45) CHARACTER SET latin1 NOT NULL,
  `Nomor` varchar(45) NOT NULL,
  PRIMARY KEY (`KodePenyimpanan`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `pesanan` (
  `NoPesanan` int(11) NOT NULL AUTO_INCREMENT,
  `Tanggal` date NOT NULL,
  `KodeOutlet` int(11) NOT NULL,
  `KodeUser` int(11) NOT NULL,
  PRIMARY KEY (`NoPesanan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `poin` (
  `KodePoin` int(11) NOT NULL AUTO_INCREMENT,
  `NoMember` varchar(100) NOT NULL,
  `KodeBC` int(11) NOT NULL,
  `JmlhPoin` int(11) NOT NULL,
  `TglExpire` date DEFAULT NULL,
  PRIMARY KEY (`KodePoin`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `rincianorderan` (
  `KodeRincian` int(11) NOT NULL AUTO_INCREMENT,
  `KodeOrderan` int(11) NOT NULL,
  `Barcode` varchar(45) CHARACTER SET latin1 NOT NULL,
  `Satuan` varchar(45) CHARACTER SET latin1 NOT NULL,
  `Kuantitas` double NOT NULL,
  `Harga` double NOT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`KodeRincian`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `rincianpesanan` (
  `KodeRincian` int(11) NOT NULL,
  `NoPesanan` int(11) NOT NULL,
  `Barcode` varchar(45) CHARACTER SET latin1 NOT NULL,
  `KodeSatuan` int(11) NOT NULL,
  `Kuantitas` double NOT NULL,
  PRIMARY KEY (`KodeRincian`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `rinciantransaksi` (
  `KodeRincian` int(11) NOT NULL AUTO_INCREMENT,
  `NoNota` int(11) NOT NULL,
  `Barcode` varchar(100) CHARACTER SET utf32 NOT NULL,
  `Satuan` varchar(45) CHARACTER SET utf32 NOT NULL,
  `Kuantitas` double NOT NULL,
  `Harga` double NOT NULL,
  `Diskon` double NOT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`KodeRincian`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin7;

CREATE TABLE `rinciantransfer` (
  `KodeRincian` int(11) NOT NULL AUTO_INCREMENT,
  `KodeTF` int(11) NOT NULL,
  `Barcode` varchar(150) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `Satuan` varchar(45) CHARACTER SET latin1 NOT NULL,
  `StokDikirim` double NOT NULL,
  `StokDiterima` double NOT NULL,
  `HargaModal` double NOT NULL,
  `TotalModal` double NOT NULL,
  PRIMARY KEY (`KodeRincian`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `satuan` (
  `KodeSatuan` int(11) NOT NULL AUTO_INCREMENT,
  `NamaSatuan` varchar(45) NOT NULL,
  PRIMARY KEY (`KodeSatuan`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `sift` (
  `KodeSift` int(11) NOT NULL AUTO_INCREMENT,
  `Sift` int(11) NOT NULL,
  `WaktuMulai` varchar(45) CHARACTER SET latin1 NOT NULL,
  `WaktuSelesai` varchar(45) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`KodeSift`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `stokbarang` (
  `KodeStok` int(11) NOT NULL AUTO_INCREMENT,
  `Barcode` varchar(45) CHARACTER SET latin1 NOT NULL,
  `KodeOutlet` int(11) NOT NULL,
  `KodeSatuan` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `StokMasuk` double NOT NULL,
  `StokKeluar` double NOT NULL,
  `SisaStok` double NOT NULL,
  `HargaModal` double NOT NULL,
  `TotalModal` double NOT NULL,
  `HargaJual` double NOT NULL,
  `TotalJual` double NOT NULL,
  PRIMARY KEY (`KodeStok`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `stokitem` (
  `KodeStok` int(11) NOT NULL AUTO_INCREMENT,
  `Barcode` varchar(45) NOT NULL,
  `KodeOutlet` int(11) NOT NULL,
  `KodeSatuan` int(11) NOT NULL,
  `Kuantitas` double NOT NULL,
  `Isi` double NOT NULL,
  `StokMax` double NOT NULL,
  `StokMin` double NOT NULL,
  `HargaModal` double NOT NULL,
  `HargaJual` double NOT NULL,
  `Diskon` double NOT NULL,
  PRIMARY KEY (`KodeStok`),
  KEY `Outlet_idx` (`KodeOutlet`),
  KEY `Satuan_idx` (`KodeSatuan`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `stokopname` (
  `KodeSO` int(11) NOT NULL AUTO_INCREMENT,
  `Barcode` varchar(45) NOT NULL,
  `KodeOutlet` int(11) NOT NULL,
  `KodeUser` int(11) DEFAULT NULL,
  `KodeSatuan` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `StokSistem` double NOT NULL,
  `StokAktual` double NOT NULL,
  `StokOpname` double NOT NULL,
  `HargaModal` double NOT NULL,
  `Kerugian` double NOT NULL,
  PRIMARY KEY (`KodeSO`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `transaksi` (
  `NoNota` int(200) NOT NULL AUTO_INCREMENT,
  `NoFaktur` varchar(150) DEFAULT NULL,
  `KodeOutlet` int(11) NOT NULL,
  `KodeUser` int(11) NOT NULL,
  `KodeBC` int(11) NOT NULL,
  `TglTransaksi` date NOT NULL,
  `JenisTransaksi` int(11) NOT NULL,
  `KodeJenis` int(11) NOT NULL,
  `Orderan` int(11) NOT NULL,
  `SubTotal` double NOT NULL,
  `PPN` double NOT NULL,
  `Diskon` double DEFAULT NULL,
  `GrandTotal` double NOT NULL,
  `JmlhPembayaran` double NOT NULL,
  `StatusPelunasan` int(11) NOT NULL,
  `TglLunas` date DEFAULT NULL,
  `Bayar` double DEFAULT NULL,
  `Kembali` double DEFAULT NULL,
  `TglJatuhTempo` date DEFAULT NULL,
  PRIMARY KEY (`NoNota`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `transferstok` (
  `KodeTF` int(11) NOT NULL AUTO_INCREMENT,
  `KodeUser` int(11) NOT NULL,
  `KodePenerima` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `KodeKerja` int(11) NOT NULL,
  `KodeMobil` int(11) NOT NULL,
  `OutletAsal` int(11) NOT NULL,
  `OutletTujuan` int(11) NOT NULL,
  `StatusDelivery` int(11) NOT NULL,
  `Biaya` double NOT NULL,
  `Keterangan` varchar(300) , PRIMARY KEY (KodeTF) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;

CREATE TABLE `user` (
  `KodeUser` int(11) NOT NULL AUTO_INCREMENT,
  `NoIdentitas` varchar(45) CHARACTER SET latin1 NOT NULL,
  `KodeOutlet` int(11) NOT NULL,
  `Username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `Password` varchar(300) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (KodeUser) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf32;
