package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル情報を操作するサービス.
 * 
 * @author taira.matsuta
 *
 */
@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * ホテル情報を取得する.
	 * 
	 * @param price 価格
	 * @return 入力が空（null）なら全件検索
	 * 　　　　　　　   そうでなければ価格で検索
	 */
	public List<Hotel> searchByLessThanPrice(Integer price){
		if(price == null) {
			return hotelRepository.findAll();
		}
		return hotelRepository.findByPrice(price);
	}
}
