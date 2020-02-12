package com.example.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.service.ClothService;

/**
 * 衣類検索画面のコントローラークラス.
 * 
 * @author katsuya.fujishima
 *
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {
	
	@Autowired
	private ClothService service;
	
	/**
	 * 衣類検索画面にフォワードするメソッド.
	 * 
	 * @param model リクエストスコープ
	 * @return 衣類検索画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		Map<Integer, String> genderMap = new LinkedHashMap<>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");
		List<String> colorList = new ArrayList<>();
		colorList.add("赤");
		colorList.add("青");
		colorList.add("白");
		colorList.add("黄");
		model.addAttribute("genderMap", genderMap);
		model.addAttribute("colorList", colorList);
		return "search-cloths";
	}
	
	/**
	 * 性別と色から服の情報を検索するメソッド.
	 * 
	 * @param gender 性別
	 * @param color 色
	 * @param model リクエストスコープ
	 * @return 検索結果を反映した衣類検索画面
	 */
	@RequestMapping("/search")
	public String search(Integer gender, String color, Model model) {
		List<Cloth> clothList = service.SearchByGenderAndColor(gender, color);
		model.addAttribute("clothList", clothList);
		return index(model);
	}

}
