package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * 野球チーム情報を操作するサービス.
 * 
 * @author taira.matsuta
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 * 野球チーム情報を全件取得する.
	 * 
	 * @return 野球チーム情報
	 */
	public List<Team> showList(){
		return teamRepository.findAll();
	}
	
	/**
	 * 野球チーム情報を取得する.
	 * 
	 * @param id チームID
	 * @return　野球チーム情報
	 */
	public Team showDetail(Integer id) {
		return teamRepository.load(id);
	}
}
