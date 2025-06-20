package kr.co.ohgoodfood.controller.store;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ohgoodfood.dto.Review;
import kr.co.ohgoodfood.dto.Store;
import kr.co.ohgoodfood.service.store.StoreService;

@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;

	@GetMapping("/store/logout")
	public String logout(HttpSession sess, Model model) {
		sess.invalidate();
		model.addAttribute("msg", "로그아웃 성공");
		model.addAttribute("url", "/store/login");
		return "store/alert";
	}

	@GetMapping("/store/signup")
	public String signup() {
		return "store/signup";
	}

	@GetMapping("/store/review")
	public String getReviews(HttpSession sess, Model model) {
		Store login = (Store) sess.getAttribute("store");
		if (login == null) {
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/store/login");
			return "store/alert";
		}
		String storeId = login.getStore_id();
		List<Review> lists = storeService.getReviews(storeId);
		model.addAttribute("reviews", lists);
		
		return "store/review";
	}
	/*
	@PostMapping("/store/signup")
	public String signup(Store vo, Model model) {
		
		int res = storeService.insert(vo);
		String msg = "";
		String url = "";
		if (res > 0) {
			msg = "회원가입 성공";
			url = "/store/mypage";
		} else {
			msg = "회원가입 실패";
			url = "/store/signup";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "store/alert";
	
	}*/

	// 메인화면
	@GetMapping("/store/main")
	public String showMain(HttpSession sess, Model model) {
		Store login = (Store) sess.getAttribute("store");

		if (login == null) {
			// 로그인 안 되어 있으면 로그인 페이지로
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/store/login");
			return "store/alert";
		}

		// 로그인 되어 있으면 viewsales.jsp로
		return "store/main";
	}

	// 매출확인
	@GetMapping("/store/viewsales")
	public String showViewSales(HttpSession sess, Model model) {
		Store login = (Store) sess.getAttribute("store");

		if (login == null) {
			// 로그인 안 되어 있으면 로그인 페이지로
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/store/login");
			return "store/alert";
		}

		// 로그인 되어 있으면 viewsales.jsp로
		return "store/viewsales";
	}

	// 알람
	@GetMapping("/store/alarm")
	public String showAlarm(HttpSession sess, Model model) {
		Store login = (Store) sess.getAttribute("store");

		if (login == null) {
			// 로그인 안 되어 있으면 로그인 페이지로
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/store/login");
			return "store/alert";
		}

		// 로그인 되어 있으면 alarm.jsp로
		return "store/alarm";
	}
	//마이페이지
	@GetMapping("/store/mypage")
	public String showMypage(HttpSession sess, Model model) {
		Store login = (Store) sess.getAttribute("store");

		if (login == null) {
			// 로그인 안 되어 있으면 로그인 페이지로
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/store/login");
			return "store/alert";
		}

		// 로그인 되어 있으면 mypage.jsp로
		return "store/mypage";
	}
	//마이페이지 수정
	@GetMapping("/store/updatemypage")
	public String updateMyPage(HttpSession sess, Model model) {
		Store login = (Store) sess.getAttribute("store");

		if (login == null) {
			// 로그인 안 되어 있으면 로그인 페이지로
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/store/login");
			return "store/alert";
		}

		// 로그인 되어 있으면 updatemypage.jsp로
	    return "store/updatemypage";
	}

}
