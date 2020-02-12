package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * hotelsテーブルを操作するリポジトリクラス.
 * 
 * @author katsuya.fujishima
 *
 */
@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate templete;
	
	/**	使用するテーブル名 */
	private static final String TABLE_NAME = "hotels";
	
	/**	ドメインにホテル情報を詰めて返すローマッパー */
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};
	
	/**
	 * 受け取った価格以下のホテル情報を検索するメソッド.
	 * 
	 * @param price 価格
	 * @return ホテル情報のリスト
	 */
	public List<Hotel> findByPrice(Integer price) {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking "
					+ "FROM " + TABLE_NAME + " WHERE price <= :price ORDER BY id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotelList = templete.query(sql, param, HOTEL_ROW_MAPPER);
		return hotelList;
	}
	
	/**
	 * ホテル情報の全件検索.
	 * 
	 * @return ホテルの全件リスト
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking "
				+ "FROM " + TABLE_NAME + " ORDER BY id";
	List<Hotel> hotelList = templete.query(sql, HOTEL_ROW_MAPPER);
	return hotelList;
	}

}
