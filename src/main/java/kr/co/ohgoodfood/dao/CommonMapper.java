package kr.co.ohgoodfood.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.ohgoodfood.dto.Account;
import kr.co.ohgoodfood.dto.Store;

@Mapper
public interface CommonMapper {

	public Account loginAccount(@Param("id") String id, @Param("pwd") String pwd);
	public Store loginStore(@Param("id") String id, @Param("pwd") String pwd);
}
