package kr.co.ohgoodfood.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.ohgoodfood.dto.Alarm;
import kr.co.ohgoodfood.dto.Orders;
import kr.co.ohgoodfood.dto.Review;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import kr.co.ohgoodfood.dto.Image;
import kr.co.ohgoodfood.dto.Product;
import kr.co.ohgoodfood.dto.Store;
import kr.co.ohgoodfood.dto.StoreSales;

@Mapper
public interface StoreMapper {

	// 내 가게 리뷰보기
	public List<Review> getReviews(String storeId);

	public int insert(Store vo);

	// 주문(미확정, 확정, 취소) 조회
	public List<Orders> getOrders(@Param("storeId") String storeId, @Param("type") String type, @Param("selectedDate") String selectedDate);

	// 내 가게 주문을 확정
	public int confirmOrders(@Param("id") int id, @Param("type") String type);

	// 내 가게 주문을 취소
	public int cancleOrders(@Param("id") int id, @Param("type") String type);

	// order_no로 주문 조회
	public Orders getOrderById(int no);

	// order_no로 스토어 이름 조회
	public Store getStoreNameByOrderNo(@Param("no") int no);

	// 알람 생성
	public int insertAlarm(Alarm alarm);

	// 주문을 픽업상태로 변경
	public int pickupOrders(@Param("id") int id, @Param("type") String type);

	// 내 가게 기간 매출 조회
	public StoreSales getSales(@Param("store_id") String store_id, @Param("start") String start, @Param("end") String end);

	// 주문 코드 생성
	public int createOrderCode(@Param("id") int id, @Param("type") String type, @Param("randomCode") int randomCode);
	
	// 아이디 중복 확인
	public Store findById(String store_id);

	public void insertImage(Image image);

	public void updateStore(Store vo);

	public List<Image> findImagesByStoreId(String store_id);
	
	public Product findProductByStoreId(String store_id);
	
	public void updateStoreStatus(Map<String, Object> param);
}
