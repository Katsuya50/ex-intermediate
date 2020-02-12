package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * 野球チームの情報に関するコントロールクラス.
 * 
 * @author katsuya.fujishima
 *
 */
@Controller
@RequestMapping("/")
public class TeamController {
	
	@Autowired
	private TeamService service;
	
	/**
	 * 野球チームのリストを詰めてリスト画面にフォワードするメソッド.
	 * 
	 * @param model リクエストスコープ
	 * @return リスト画面
	 */
	@RequestMapping("/")
	public String index(Model model) {
		List<Team> teamList = service.showList()
		model.addAttribute("teamList", teamList);
		return "list";
	}
	
	/**
	 * 受け取ったidに紐づいたチーム詳細画面にフォワードするメソッド.
	 * 
	 * @param id チームid
	 * @param model リクエストスコープ
	 * @return チーム詳細画面
	 */
	@RequestMapping("/detail")
	public String detail(Integer id, Model model) {
//		Team team = new Team();
		Team team = service.showDetail(id);
		model.addAttribute("team", team);
		return "detail";
	}

}
