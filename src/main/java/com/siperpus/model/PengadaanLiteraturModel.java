package com.siperpus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PengadaanLiteraturModel {
	private int id;
	private String username_requester;
	private String judul;
	private String penulis;
	private String penerbit;
	private String status;
	private String filename;
}
