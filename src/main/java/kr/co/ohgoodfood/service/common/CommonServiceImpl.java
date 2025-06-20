package kr.co.ohgoodfood.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ohgoodfood.dao.CommonMapper;
import kr.co.ohgoodfood.dto.Account;
import kr.co.ohgoodfood.dto.Store;

@Service
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	private CommonMapper commonMapper;
	
	@Override
	public Account loginAccount(String id, String pwd) {
		return commonMapper.loginAccount(id, pwd);
	}
	@Override
	public Store loginStore(String id, String pwd) {
		return commonMapper.loginStore(id, pwd);
	}
}
