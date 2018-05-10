package com.siperpus.model;

import java.time.LocalDate;

import com.siperpus.model.PeminjamanModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeminjamanModel {
	private int id;
	private int id_literatur;
	private String username_peminjam;
	private LocalDate tanggal_peminjaman;
	private LocalDate tanggal_pengembalian;
	private String status_peminjaman;
	private int id_status;
}
