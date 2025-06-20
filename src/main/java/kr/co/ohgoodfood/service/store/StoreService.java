package kr.co.ohgoodfood.service.store;

import java.util.List;

import kr.co.ohgoodfood.dto.Review;
import kr.co.ohgoodfood.dto.Store;

public interface StoreService {

	public Store login(Store vo);

	public Review viewRiew(Store vo);

	public List<Review> getReviews(String storeId);
	

}
