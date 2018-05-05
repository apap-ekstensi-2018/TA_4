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

@Mapper
public interface LiteraturMapper {
	@Insert ("INSERT INTO literatur (judul, penulis, penerbit,jenis_literatur, jumlah) VALUES (#{judul}, #{penulis}, #{penerbit}, #{jenis_literatur}, #{jumlah})")
 	void addLiterature (LiteratureModel literature);
 
 @Update("UPDATE literatur SET id=#{id}, judul=#{judul}, penulis=#{penulis}, penerbit=#{penerbit}, jenis_literatur=#{jenis_literatur}, jumlah=#{jumlah} WHERE id=#{id}")
    void updateLiterature (Integer id);
	   
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


}
