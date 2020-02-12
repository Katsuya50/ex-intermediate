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
 * teamsテーブルを操作するリポジトリクラス.
 * 
 * @author katsuya.fujishima
 *
 */
@Repository
public class TeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**	テーブル名 */
	private static final String TABLE_NAME = "teams";
	
	/**	検索結果をドメインに格納するローマッパー */
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
	 * 全件検索をするメソッド.
	 * 
	 * @return 全チームの情報が格納されたリスト
	 */
	public List<Team> findAll() {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history "
					+ "FROM " + TABLE_NAME + " ORDER BY id";
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		return teamList;
	}
	
	public Team findById(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history "
					+ "FROM " + TABLE_NAME + " WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		return team;
	}

}
