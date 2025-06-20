package kr.co.ohgoodfood.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ohgoodfood.dao.StoreMapper;
import kr.co.ohgoodfood.dto.Review;
import kr.co.ohgoodfood.dto.Store;


@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreMapper mapper;
	
	@Override
	public Store login(Store vo) {
		return mapper.login(vo);
	}
	
	@Override
	public Review viewRiew(Store vo) {
		return mapper.viewReview(vo);
	}
	@Override
	public List<Review> getReviews(String storeId) {
		return mapper.getReviews(storeId);
	}
}
