package com.siperpus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import com.siperpus.model.LiteratureModel;
import com.siperpus.model.MahasiswaModel;
 
@Mapper
public interface MahasiswaMapper {
	 @Select("SELECT * FROM student WHERE npm = #{npm}")
	    MahasiswaModel selectMahasiswa (@Param("npm") String npm);
	 
	
}
