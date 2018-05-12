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

import com.siperpus.model.PeminjamanModel;

@Mapper
public interface PeminjamanMapper {
	@Insert ("INSERT INTO peminjaman_literatur (judul, penulis, penerbit,jenis_literatur, jumlah) VALUES (#{judul}, #{penulis}, #{penerbit}, #{jenis_literatur}, #{jumlah})")
 	void addPeminjaman (PeminjamanModel peminjaman);
 
 @Update("UPDATE peminjaman_literatur SET   judul=#{judul}, penulis=#{penulis}, penerbit=#{penerbit}, jenis_literatur=#{jenis_literatur}, jumlah=#{jumlah} WHERE id=#{id}")
    void updatePeminjaman (PeminjamanModel peminjaman);
	   
 @Delete ("DELETE FROM peminjaman_literatur WHERE id=#{id}")
 	void deletePeminjaman (Integer id);
 
 @Select("SELECT * FROM peminjaman_literatur")
 List<PeminjamanModel> selectAllPeminjaman();

@Select ("SELECT * FROM peminjaman_literatur WHERE id = #{id}")
	@Results (value= {
		@Result(property="id", column="id"),
		@Result(property="judul",column="judul"),
		@Result(property="penulis",column="penulis"),
		@Result(property="penerbit",column="penerbit"),
		@Result(property="jenis_literatur",column="jenis_literatur"),
		@Result(property="jumlah",column="jumlah")})
	PeminjamanModel selectPeminjaman (@Param("id") Integer id); 


}
