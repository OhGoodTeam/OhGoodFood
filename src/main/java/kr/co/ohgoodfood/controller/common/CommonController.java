package kr.co.ohgoodfood.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ohgoodfood.dto.Account;
import kr.co.ohgoodfood.dto.Store;
import kr.co.ohgoodfood.service.common.CommonService;

@Controller
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	
	@GetMapping("/login")
	public String login() {
		return "store/login";
	}
	@PostMapping("/login")
	public String login(HttpServletRequest request, HttpSession sess, Model model) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Account account = commonService.loginAccount(id, pwd);
		if(account != null) {
			sess.setAttribute("user", account);
			model.addAttribute("msg", "사용자 로그인 성공");
	        model.addAttribute("url", "/user/main");
	        return "store/alert";
		}
		Store store = commonService.loginStore(id, pwd);
		if(store != null) {
			sess.setAttribute("store", store);
			model.addAttribute("msg", "사장님 로그인 성공");
			model.addAttribute("url", "/store/main");
			return "store/alert";
		}
		model.addAttribute("msg", "로그인 실패");
		model.addAttribute("url", "/store/login");
		return "store/alert";
	}
}
