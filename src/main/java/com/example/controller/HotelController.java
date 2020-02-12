package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

/**
 * ホテル検索アプリのコントローラークラス.
 * 
 * @author katsuya.fujishima
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	/**
	 * URL指定時に検索画面にフォワードするメソッド.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "search";
	}
	
	/**
	 * 検索結果を表示するメソッド.
	 * 
	 * @param price 価格
	 * @param model リクエストスコープ
	 * @return 検索結果を表示した検索画面
	 */
	@RequestMapping("/search")
	public String search(Integer price, Model model) {
		List<Hotel> hotelList = service.searchByLessThanPrice(price);
		model.addAttribute("hotelList", hotelList);
		return "search";
	}

}
