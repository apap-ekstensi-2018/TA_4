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

<<<<<<< HEAD

import com.siperpus.model.LiteratureModel;
import com.siperpus.model.PeminjamanModel;

@Mapper
public interface PeminjamanMapper {

	 @Select("select id, id_literatur, username_peminjam, tanggal_peminjaman, tanggal_pengembalian, id_surat, status_peminjaman from peminjaman_literatur where id = #{id}")
	  PeminjamanModel selectPeminjaman (@Param("id") Integer id);
	 
@Select("SELECT * FROM peminjaman")
List<PeminjamanModel> selectAllPeminjaman();
=======
import com.siperpus.model.LiteratureModel;

@Mapper
public interface PeminjamanMapper {
	@Insert ("INSERT INTO peminjaman_literatur (judul, penulis, penerbit,jenis_literatur, jumlah) VALUES (#{judul}, #{penulis}, #{penerbit}, #{jenis_literatur}, #{jumlah})")
 	void addLiterature (LiteratureModel literature);
 
 @Update("UPDATE literatur SET   judul=#{judul}, penulis=#{penulis}, penerbit=#{penerbit}, jenis_literatur=#{jenis_literatur}, jumlah=#{jumlah} WHERE id=#{id}")
    void updateLiterature (LiteratureModel literature);
	   
 @Delete ("DELETE FROM literatur WHERE id=#{id}")
 	void deleteLiterature (Integer id);
 
 @Select("SELECT * FROM literatur")
 List<LiteratureModel> selectAllLiteratures();

@Select ("SELECT * FROM literatur WHERE id = #{id}")
	@Results (value= {
		@Result(property="id", column="id"),
		@Result(property="judul",column="judul"),
		@Result(property="penulis",column="penulis"),
		@Result(property="penerbit",column="penerbit"),
		@Result(property="jenis_literatur",column="jenis_literatur"),
		@Result(property="jumlah",column="jumlah")})
	LiteratureModel selectLiterature (@Param("id") Integer id); 
>>>>>>> 23f695539d594836ba4a2900ec3e59525d761d94


}
