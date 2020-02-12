package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;

/**
 * 服の情報に関する業務処理を行うサービスクラス.
 * 
 * @author katsuya.fujishima
 *
 */
@Service
@Transactional
public class ClothService {
	
	@Autowired
	private ClothRepository repository;
	
	/**
	 * 性別と色から服の情報を検索する処理.
	 * 
	 * @param gender 性別
	 * @param color 色
	 * @return 条件に合致した服の情報のリスト
	 */
	public List<Cloth> SearchByGenderAndColor(Integer gender, String color) {
		return repository.findByGenderAndColor(gender, color);
	}

}
