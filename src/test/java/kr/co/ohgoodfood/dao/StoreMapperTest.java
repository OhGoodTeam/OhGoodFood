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

import kr.co.ohgoodfood.dto.Orders;
import kr.co.ohgoodfood.dto.Review;
import kr.co.ohgoodfood.dto.Store;
import kr.co.ohgoodfood.dto.StoreSales;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { kr.co.ohgoodfood.config.MvcConfig.class })
@WebAppConfiguration
@Slf4j

public class StoreMapperTest {
	@Autowired
    StoreMapper storeMapper;
	
	@Test
	@DisplayName("가게 리뷰 조회")
	public void getReviewsTest() {
	    //given
	    String storeId = "itaewonst1";

	    //when
	    List<Review> reviews = storeMapper.getReviews(storeId);

	    //then
	    log.info("리뷰 목록: {}", reviews);
	    Assertions.assertFalse(reviews.isEmpty());
	}
	
	@Test
	@DisplayName("가게 주문 조회(order_status='confirmed')")
	public void getConfirmedOrdersTest() {
	    //given
	    String storeId = "itaewonst1";
	    String type = "confirmed";
	    String selectedDate = "2025-07";

	    //when
	    List<Orders> orders = storeMapper.getOrders(storeId, type, selectedDate);

	    //then
	    Assertions.assertNotNull(orders);
	    for (Orders order : orders) {
	        log.info("주문상태: {}", order.getOrder_status());
	    }
	}
	
	@Test
	@DisplayName("가게 주문 조회(order_status='reservation')")
	public void getReservationOrdersTest() {
	    //given
	    String storeId = "itaewonst1";
	    String type = "reservation";
	    String selectedDate = "2025-07";

	    //when
	    List<Orders> orders = storeMapper.getOrders(storeId, type, selectedDate);

	    //then
	    Assertions.assertNotNull(orders);
	    for (Orders order : orders) {
	        log.info("주문상태: {}", order.getOrder_status());
	    }
	}
	
	@Test
	@DisplayName("가게 주문 조회(order_status='cancel')")
	public void getCancelOrdersTest() {
	    //given
	    String storeId = "itaewonst1";
	    String type = "cancel";
	    String selectedDate = "2025-07";

	    //when
	    List<Orders> orders = storeMapper.getOrders(storeId, type, selectedDate);

	    //then
	    Assertions.assertNotNull(orders);
	    for (Orders order : orders) {
	        log.info("주문상태: {}", order.getOrder_status());
	    }
	}
	
	@Test
	@DisplayName("가게 주문 조회(order_status='pickup')")
	public void getPickupOrdersTest() {
	    //given
	    String storeId = "itaewonst1";
	    String type = "pickup";
	    String selectedDate = "2025-07";

	    //when
	    List<Orders> orders = storeMapper.getOrders(storeId, type, selectedDate);

	    //then
	    Assertions.assertNotNull(orders);
	    for (Orders order : orders) {
	        log.info("주문상태: {}", order.getOrder_status());
	    }
	}
	
	@Test
	@DisplayName("주문 확정 클릭 시 주문 확정(order_status='confirmed'로 되돌리는 로직)")
	public void confirmOrdersTest() {
	    //given
	    int orderNo = 1;
	    String newStatus = "confirmed";

	    //when
	    int result = storeMapper.confirmOrders(orderNo, newStatus);

	    //then
	    Assertions.assertEquals(1, result);  
	}
	
	@Test
	@DisplayName("주문 취소 클릭 시 주문 취소")
	public void cancleOrdersTest() {
	    //given
	    int orderNo = 2;
	    String newStatus = "cancel";

	    //when
	    int result = storeMapper.cancleOrders(orderNo, newStatus);

	    //then
	    Assertions.assertEquals(1, result);
	}
	
	@Test
	@DisplayName("주문 상세 조회")
	public void getOrderByIdTest() {
	    //given
	    int orderNo = 1;

	    //when
	    Orders order = storeMapper.getOrderById(orderNo);

	    //then
	    Assertions.assertNotNull(order);
	    log.info("주문 정보: {}", order);
	    Assertions.assertEquals(orderNo, order.getOrder_no());
	}
	
	@Test
	@DisplayName("주문번호로 가게 조회")
	public void getStoreNameByOrderNoTest() {
	    //given
	    int orderNo = 1;

	    //when
	    Store store = storeMapper.getStoreNameByOrderNo(orderNo);

	    //then
	    Assertions.assertNotNull(store);
	    log.info("가게 이름: {}", store.getStore_name());
	}
	
	@Test
	@DisplayName("주문을 픽업 상태로 변경")
	public void pickupOrdersTest() {
	    //given
	    int orderNo = 3;
	    String type = "pickup";

	    //when
	    int result = storeMapper.pickupOrders(orderNo, type);

	    //then
	    Assertions.assertEquals(1, result);
	}
	
	@Test
	@DisplayName("매출 조회: 'itaewonst1', 2025-07-01 ~ 2025-07-31")
	public void getSalesTest() {
	    //given
	    String storeId = "itaewonst1";
	    String start = "2025-07-01";
	    String end = "2025-07-31";

	    //when
	    StoreSales sales = storeMapper.getSales(storeId, start, end);

	    //then
	    Assertions.assertNotNull(sales);
	    log.info("매출 총합: {}", sales.getSales());
	}
	
	@Test
	@DisplayName("order_code 생성")
	public void createOrderCodeTest() {
	    //given
	    int orderNo = 4;
	    String type = "reservation";
	    int randomCode = 123456;

	    //when
	    int result = storeMapper.createOrderCode(orderNo, type, randomCode);

	    //then
	    Assertions.assertEquals(1, result);
	}
}
