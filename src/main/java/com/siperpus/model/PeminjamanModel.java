package com.siperpus.model;

import com.siperpus.model.PeminjamanModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PeminjamanModel{
	private int id;
	private int id_literatur;
	private String username_peminjam;
	private String tanggal_peminjaman;
	private String tanggal_pengembalian;
	private int id_surat;
	private String status_peminjaman;

}

