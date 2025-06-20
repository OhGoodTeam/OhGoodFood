package kr.co.ohgoodfood.service.common;

import kr.co.ohgoodfood.dto.Account;
import kr.co.ohgoodfood.dto.Store;

public interface CommonService {

	public Account loginAccount(String id, String pwd);
	public Store loginStore(String id, String pwd);
}
