package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Cloth;

/**
 * clothsテーブルを操作するリポジトリクラス.
 * 
 * @author katsuya.fujishima
 *
 */
@Repository
public class ClothRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**	テーブル名 */
	private static final String TABLE_NAME = "cloths";
	
	/**	ドメインに格納して返すローマッパー */
	private static final RowMapper<Cloth> CLOTH_ROW_MAPPER = (rs, i) -> {
		Cloth cloth = new Cloth();
		cloth.setId(rs.getInt("id"));
		cloth.setCategory(rs.getString("category"));
		cloth.setGenre(rs.getString("genre"));
		cloth.setGender(rs.getInt("gender"));
		cloth.setColor(rs.getString("color"));
		cloth.setPrice(rs.getInt("price"));
		cloth.setSize(rs.getString("size"));
		return cloth;
	};
	
	/**
	 * 受け取った性別と色に合致する服の情報をリストとして返す検索メソッド
	 * 
	 * @param gender 性別
	 * @param color 色
	 * @return 条件に合致した服の情報のリスト
	 */
	public List<Cloth> findByGenderAndColor(Integer gender, String color) {
		String sql = "SELECT id, category, genre, gender, color, price, size "
					+ "FROM " + TABLE_NAME + " "
					+ "WHERE gender = :gender AND color = :color "
					+ "ORDER BY id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("gender", gender).addValue("color", color);
		List<Cloth> clothList = template.query(sql, param, CLOTH_ROW_MAPPER);
		return clothList;
	}
	
	

}
