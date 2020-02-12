package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル情報の業務処理をするサービスクラス.
 * 
 * @author katsuya.fujishima
 *
 */
@Service
@Transactional
public class HotelService {
	
	@Autowired
	private HotelRepository repository;
	
	/**
	 * 受け取った価格以下のホテル情報を参照する処理.
	 * 価格が未入力であれば全件検索する
	 * 
	 * @param price 価格
	 * @return 条件に合致したホテル情報のリスト
	 */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		if(price == null) {
			return repository.findAll();
		}
		return repository.findByLessThanPrice(price);
	}
}