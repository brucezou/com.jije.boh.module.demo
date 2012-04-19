package com.jije.boh.module.demo.jpa.dao;

import com.jije.boh.core.domain.model.BascStore;

/**
 * 店铺 dao
 * 
 * @author eric.zhang
 * 
 */
public interface IBascStoreDao {

	/**
	 * 根据id获取store
	 * 
	 * @param id
	 * @return
	 */
	BascStore findById(String id);
}
