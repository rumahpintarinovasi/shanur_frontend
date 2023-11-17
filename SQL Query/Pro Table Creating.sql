CREATE TABLE `afiliasi` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `kode` int(10) DEFAULT NULL,
  `nm_depan` varchar(50) DEFAULT NULL,
  `nm_belakang` varchar(50) DEFAULT NULL,
  `jk` varchar(1) DEFAULT NULL,
  `alamat` varchar(250) DEFAULT NULL,
  `provinsi` int(11) DEFAULT NULL,
  `kota` int(11) DEFAULT NULL,
  `pekerjaan` varchar(100) DEFAULT NULL,
  `telp` char(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `foto` varchar(50) DEFAULT NULL,
  `komisi` int(20) DEFAULT NULL,
  `komisi_cair` int(20) DEFAULT NULL,
  `bank_cair` varchar(50) DEFAULT NULL,
  `rek_cair` varchar(50) DEFAULT NULL,
  `nm_rek` varchar(50) DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF32;

CREATE TABLE `akun_bantu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `bln` int(3) DEFAULT NULL,
  `tgl_active` date DEFAULT NULL,
  `waiting` int(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF32;

CREATE TABLE `angsuran` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_penjualan` int(11) unsigned DEFAULT NULL,
  `no_ref` varchar(50) DEFAULT NULL,
  `dp` int(5) DEFAULT NULL,
  `bunga` int(5) DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `jangka_waktu` int(3) DEFAULT NULL,
  `bayar_dp` int(20) DEFAULT NULL,
  `angsuran` int(20) DEFAULT NULL,
  `bayar` int(20) DEFAULT NULL,
  `jns_bayar` varchar(50) DEFAULT NULL,
  `id_rek` int(11) DEFAULT NULL,
  `bukti_tf` varchar(50) DEFAULT NULL,
  `no_kartu` varchar(50) DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_penjualan` (`id_penjualan`),
  CONSTRAINT `angsuran_ibfk_1` FOREIGN KEY (`id_penjualan`) REFERENCES `tr_penjualan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=UTF32;

CREATE TABLE `angsuran_trigger` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_bayar` int(11) DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `aset_bayar` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_aset` int(11) unsigned DEFAULT NULL,
  `id_akun_kas` int(11) DEFAULT NULL,
  `bayar_awal` int(1) DEFAULT 0,
  `tgl` date DEFAULT NULL,
  `jml` int(20) DEFAULT 0,
  `ket` varchar(150) DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_aset` (`id_aset`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `aset_bayar_trigger` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_bayar` int(11) unsigned DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_bayar` (`id_bayar`),
  CONSTRAINT `aset_bayar_trigger_ibfk_1` FOREIGN KEY (`id_bayar`) REFERENCES `aset_bayar` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `aset_jual_trigger` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_aset` int(11) DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `aset_tetap` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_warehouse` int(11) unsigned DEFAULT NULL,
  `id_akun` int(11) unsigned DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `jml` int(15) DEFAULT NULL,
  `nilai_sisa` int(15) DEFAULT NULL,
  `pajak` int(3) DEFAULT NULL,
  `ket` varchar(250) DEFAULT NULL,
  `nm_penjual` varchar(50) DEFAULT NULL,
  `nilai_susut` int(15) DEFAULT NULL,
  `masa_pakai` int(5) DEFAULT NULL,
  `status` varchar(50) DEFAULT 'Aktif',
  `id_akun_jual` int(11) DEFAULT NULL,
  `tgl_jual` date DEFAULT NULL,
  `harga_jual` int(20) DEFAULT NULL,
  `ket_jual` varchar(250) DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `aset_tetap_susut` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_aset` int(11) unsigned DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `jml` int(15) DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_aset` (`id_aset`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `bahan_baku` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_satuan_beli` int(11) DEFAULT NULL,
  `qty_beli` int(15) DEFAULT NULL,
  `id_satuan_pakai` int(11) DEFAULT NULL,
  `qty_pakai` int(15) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `modal` int(15) DEFAULT 0,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `bahan_baku_bantu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_satuan_beli` int(11) DEFAULT NULL,
  `qty_beli` int(15) DEFAULT NULL,
  `id_satuan_pakai` int(11) DEFAULT NULL,
  `qty_pakai` int(15) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `modal` int(15) DEFAULT 0,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `bantu_stok` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `warehouse` varchar(50) DEFAULT NULL,
  `kode_produk` varchar(50) DEFAULT NULL,
  `stok` int(15) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `barcode` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `jns` varchar(50) DEFAULT 'Barcode',
  `lebar_kertas` int(11) DEFAULT NULL,
  `tinggi_kertas` int(11) DEFAULT 0,
  `lebar` int(11) DEFAULT 0,
  `tinggi` int(11) DEFAULT 0,
  `font` int(11) DEFAULT 0,
  `margin_top` int(11) DEFAULT 0,
  `margin_bottom` int(11) DEFAULT 0,
  `margin_left` int(11) DEFAULT 0,
  `margin_right` int(11) DEFAULT 0,
  `qty_lembar` int(5) DEFAULT 0,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `base_url` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `bbl` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_daf_produk` int(11) unsigned DEFAULT NULL,
  `id_varian` varchar(11) DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_daf_produk` (`id_daf_produk`),
  CONSTRAINT `bbl_ibfk_1` FOREIGN KEY (`id_daf_produk`) REFERENCES `daftar_produk` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `bbl_bantu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_daf_produk` int(11) unsigned DEFAULT NULL,
  `id_varian` varchar(11) DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_daf_produk` (`id_daf_produk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `bbl_copy` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_daf_produk` int(11) unsigned DEFAULT NULL,
  `id_varian` varchar(11) DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_daf_produk` (`id_daf_produk`),
  CONSTRAINT `bbl_copy_ibfk_1` FOREIGN KEY (`id_daf_produk`) REFERENCES `daftar_produk` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

CREATE TABLE `buku_tamu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_warehouse` int(11) DEFAULT NULL,
  `id_cust` int(11) DEFAULT NULL,
  `tgl` datetime DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

