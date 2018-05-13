package com.siperpus.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.siperpus.model.UserAccountModel;
 

@Mapper
public interface UserAccountMapper {
	@Select("select  username, role from user_account where username = #{username}")
	UserAccountModel selectUserAccount (@Param("username") String username);  
}
