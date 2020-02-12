package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * 野球チームの情報を操作するサービスクラス.
 * 
 * @author katsuya.fujishima
 *
 */
@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository repository;
	
	/**
	 * 野球チームの全件検索処理.
	 * 
	 * @return 全チームの情報が格納されたリスト
	 */
	public List<Team> findAll() {
		return repository.findAll();
	}
	
	/**
	 * 野球チームのidによる一件検索処理.
	 * 
	 * @return idが一致したチームの情報
	 */
	public Team findById(Integer id) {
		return repository.findById(id);
	}

}
