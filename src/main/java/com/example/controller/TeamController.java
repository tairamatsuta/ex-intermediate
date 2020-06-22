package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * 野球チーム一覧画面と詳細情報画面を表示するコントローラ.
 * 
 * @author taira.matsuta
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	/**
	 * 野球チーム一覧を表示する.
	 * 
	 * @param model リクエストスコープ
	 * @return 野球チーム一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Team> teamList = teamService.showList();
		model.addAttribute("teamList", teamList);
		return "team/list";
	}
	
	/**
	 * 野球チームの詳細情報を表示する.
	 * 
	 * @param id チームID
	 * @param model リクエストスコープ
	 * @return　野球チーム詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Team team = teamService.showDetail(Integer.parseInt(id));
		model.addAttribute("team", team);
		return "team/detail";
	}
	
}
