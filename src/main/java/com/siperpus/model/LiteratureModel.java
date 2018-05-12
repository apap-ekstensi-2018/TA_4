package com.siperpus.model;

import com.siperpus.model.LiteratureModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiteratureModel {
	private int id;
	private String judul;
	private String penulis;
	private String penerbit;
	private String jenis_literatur;
	private String jumlah;

	
}


