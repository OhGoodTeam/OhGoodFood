package kr.co.ohgoodfood.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.co.ohgoodfood.dto.Account;
import kr.co.ohgoodfood.dto.Alarm;
import kr.co.ohgoodfood.dto.Store;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { kr.co.ohgoodfood.config.MvcConfig.class })
@WebAppConfiguration
@Slf4j

public class CommonMapperTest {
	@Autowired
	CommonMapper commonMapper;
	
	@Test
	@DisplayName("사용자 로그인 테스트")
	public void loginAccountTest() {
	    //given
	    String id = "parkhwajun1130";
	    String pwd = "1234"; 

	    //when
	    Account account = commonMapper.loginAccount(id, pwd);

	    //then
	    Assertions.assertNotNull(account);
	    Assertions.assertEquals(id, account.getUser_id());
	}
	
	@Test
	@DisplayName("가게 사장 로그인 테스트")
	public void loginStoreTest() {
	    //given
	    String id = "itaewonst1";
	    String pwd = "1234";

	    //when
	    Store store = commonMapper.loginStore(id, pwd);

	    //then
	    Assertions.assertNotNull(store);
	    Assertions.assertEquals(id, store.getStore_id());
	}
	
	@Test
	@DisplayName("알람 목록 조회(user=parkhwajun1130)")
	public void getAlarmTest() {
	    //given
	    String userId = "parkhwajun1130";

	    //when
	    List<Alarm> alarms = commonMapper.getAlarm(userId);

	    //then
	    Assertions.assertNotNull(alarms);
	    log.info("알람 개수: {}", alarms.size());
	}
	
	@Test
	@DisplayName("알람 읽음 처리(user=parkhwajun1130)")
	public void updateAlarmTest() {
	    //given
	    String userId = "parkhwajun1130";

	    //when
	    int updated = commonMapper.updateAlarm(userId);

	    //then
	    Assertions.assertTrue(updated >= 0); 
	}
	
	@Test
	@DisplayName("알람 숨김 처리")
	public void hideAlarmTest() {
	    //given
	    int alarmNo = 1;

	    //when
	    int result = commonMapper.hideAlarm(alarmNo);

	    //then
	    Assertions.assertEquals(1, result); // 숨김 성공
	}
	
	@Test
	@DisplayName("안 읽은 알람 개수 확인(user=parkhwajun1130)")
	public void checkUnreadAlarmTest() {
	    //given
	    String userId = "parkhwajun1130";

	    //when
	    int count = commonMapper.checkUnreadAlarm(userId);

	    //then
	    log.info("안 읽은 알람 수: {}", count);
	    Assertions.assertTrue(count >= 0);
	}
	
	@Test
	@DisplayName("유저 ID로 계정 조회(user=parkhwajun1130)")
	public void getAccountByIdTest() {
	    //given
	    String userId = "parkhwajun1130";

	    //when
	    Account account = commonMapper.getAccountById(userId);

	    //then
	    Assertions.assertNotNull(account);
	    Assertions.assertEquals(userId, account.getUser_id());
	}
}
