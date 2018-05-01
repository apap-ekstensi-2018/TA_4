package com.siperpus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.siperpus.model.LiteratureModel;
import com.siperpus.model.MahasiswaModel;
 
@Mapper
public interface MahasiswaMapper {
	 @Select("select * from student where npm = #{npm}")
	    MahasiswaModel selectMahasiswa (@Param("npm") String npm);
	 
	 @Select("select * from literatur")
	    List<LiteratureModel> selectAllLiteratures();
}
