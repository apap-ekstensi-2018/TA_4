package com.siperpus.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.siperpus.model.MahasiswaModel;
 

public interface MahasiswaMapper {
	 @Select("select * from student where npm = #{npm}")
	    MahasiswaModel selectMahasiswa (@Param("npm") String npm);
}
