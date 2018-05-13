package com.siperpus.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.siperpus.model.LiteratureModel;
import com.siperpus.model.PengadaanLiteraturModel;

@Mapper
public interface PengadaanLiteraturMapper {
	@Insert ("INSERT INTO pengadaan_literatur (username_requester, judul, penulis,penerbit, status, filename) "
			+ "VALUES (#{username_requester}, #{judul}, #{penulis}, #{penerbit}, #{status}, #{filename})")
 	void addLiterature (PengadaanLiteraturModel pengadaanLiteratur);
}
