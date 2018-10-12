package com.portfolio.jeung;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.portfolio.jeung.domain.DTOFile;
import com.portfolio.jeung.service.GoodsService;

@Controller
public class HomeController {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
//서비스의 메소드 호출해서 결과 저장
	public String home(Locale locale, Model model) {
		List<DTOFile> list = goodsService.list();
		// 모델에 저장
		model.addAttribute("list", list);
		// 결과 페이지로 포워딩- 일반 조회는 forwarding
		return "home";
	}

	@RequestMapping(value = "hybridapp", method = RequestMethod.GET)
	public String hybrid(Model model) {

		return "hybridapp";
	}

}
