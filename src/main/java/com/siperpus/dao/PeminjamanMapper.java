package com.siperpus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.siperpus.model.LiteratureModel;
import com.siperpus.model.PeminjamanModel;

@Mapper
public interface PeminjamanMapper {

	 @Select("select id, id_literatur, username_peminjam, tanggal_peminjaman, tanggal_pengembalian, id_surat, status_peminjaman from peminjaman_literatur where id = #{id}")
	  PeminjamanModel selectPeminjaman (@Param("id") Integer id);
	 
@Select("SELECT * FROM peminjaman")
List<PeminjamanModel> selectAllPeminjaman();


}
