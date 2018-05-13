package com.siperpus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param; 
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
 
import com.siperpus.model.PeminjamanModel;
@Mapper
public interface PeminjamanMapper {
	@Insert ("INSERT INTO peminjaman_literatur (id_literatur, username_peminjam, tanggal_peminjaman, tanggal_pengembalian, "
			+ " status_peminjaman, id_surat) VALUES (#{id_literatur}, #{username_peminjam}, #{tanggal_peminjaman}, #{tanggal_pengembalian}, "
			+ " #{status_peminjaman}, #{id_surat})")
 	void addPeminjaman (PeminjamanModel peminjaman);
 
 @Update("UPDATE peminjaman_literatur SET   judul=#{judul}, penulis=#{penulis}, penerbit=#{penerbit}, jenis_literatur=#{jenis_literatur}, jumlah=#{jumlah} WHERE id=#{id}")
    void updatePeminjaman (PeminjamanModel peminjaman);
	   
 @Delete ("DELETE FROM peminjaman_literatur WHERE id=#{id}")
 	void deletePeminjaman (Integer id);
 
 @Select("SELECT * FROM peminjaman_literatur")
 List<PeminjamanModel> selectAllPeminjaman();

 
 
@Select("select id, id_literatur, username_peminjam, tanggal_peminjaman, tanggal_pengembalian, id_surat, status_peminjaman from peminjaman_literatur where id = #{id}")
	PeminjamanModel selectPeminjaman (@Param("id") Integer id); 
 
@Select("select id, id_literatur, username_peminjam, tanggal_peminjaman, tanggal_pengembalian, id_surat, status_peminjaman from peminjaman_literatur where id_literatur = #{id_literatur}")
	PeminjamanModel selectPeminjamanByIdLiteratur (@Param("id_literatur") int id_literatur);  

@Select("select id, id_literatur, username_peminjam, tanggal_peminjaman, tanggal_pengembalian, id_surat, status_peminjaman from peminjaman_literatur where id_literatur = #{id_literatur}")
List<PeminjamanModel> selectPeminjamanByIdLiteraturList (@Param("id_literatur") int id_literatur);  


@Select("select id, id_literatur, username_peminjam, tanggal_peminjaman, tanggal_pengembalian, id_surat, status_peminjaman from peminjaman_literatur "
		+ "where username_peminjam = #{username_peminjam}")
List<PeminjamanModel> selectPeminjamanByUserPeminjam (@Param("username_peminjam") String username_peminjam);  
 
@Select("select id, id_literatur, username_peminjam, tanggal_peminjaman, tanggal_pengembalian, id_surat, status_peminjaman from peminjaman_literatur "
		+ " where status_peminjaman=#{status} and username_peminjam = #{npm}")
List<PeminjamanModel> selectPeminjamanByUserAccountAndStatus (@Param("npm") String npm, @Param("status") String status);  

@Update("UPDATE peminjaman_literatur SET status_peminjaman =#{status} WHERE id=#{id}")
	void updateStatusPeminjaman (PeminjamanModel peminjaman);

}
