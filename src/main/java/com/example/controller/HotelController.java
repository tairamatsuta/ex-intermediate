package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

/**
 * ホテル情報を表示するコントローラ.
 * 
 * @author taira.matsuta
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	/**
	 * ホテル情報検索画面を表示する.
	 * @return　ホテル検索画面
	 */
	@RequestMapping("/")
	public String index() {
		return "hotel/search";
	}
	
	/**
	 * ホテル情報を検索し表示する.
	 * 
	 * @param price　価格
	 * @param model　リクエストスコープ
	 * @return ホテル検索画面
	 */
	@RequestMapping("/search")
	public String search(Integer price, Model model) {
		List<Hotel> hotelList = hotelService.searchByLessThanPrice(price);
		model.addAttribute("hotelList", hotelList);
		model.addAttribute("price", price);
		return "hotel/search";
	}
	
}
