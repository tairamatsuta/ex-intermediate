package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * teamsテーブルを操作するリポジトリ.
 * 
 * @author taira.matsuta
 *
 */
@Repository
public class TeamRepository {
	
	/**
	 * テーブル名
	 */
	private static final String TABLE_NAME = "teams";

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Teamオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	/**
	 * 野球チーム情報を取得する（主キー検索）.
	 * 
	 * @param id　主キー
	 * @return　野球チーム情報
	 */
	public Team load(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM " + TABLE_NAME + " WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		return team;
	}
	
	/**
	 * 野球チーム情報を取得する（全件検索）.
	 * 
	 * @return 野球チーム情報の発足日の昇順（存在しなければ0件の野球チーム情報）
	 */
	public List<Team> findAll(){
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM " + TABLE_NAME + " ORDER BY inauguration;";
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		return teamList;
	}
}
