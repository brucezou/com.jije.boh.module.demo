package com.jije.boh.module.demo.jpa.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jije.boh.core.domain.model.BascStore;
import com.jije.boh.core.jpa.repository.BascStoreRepository;
import com.jije.boh.module.demo.jpa.dao.IBascStoreDao;

@Component("bascStoreDao")
public class BascStoreDao implements IBascStoreDao {

	@Autowired
	private BascStoreRepository bascStoreRepository;

	public void save(BascStore entity) {
		bascStoreRepository.save(entity);
	}

	public void delete(String id) {
		bascStoreRepository.delete(id);
	}

	public boolean exists(String id) {
		return bascStoreRepository.exists(id);
	}

	public BascStore findById(String id) {
		return bascStoreRepository.findOne(id);
	}
}
