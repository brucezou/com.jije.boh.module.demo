package com.jije.boh.module.demo.jpa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jije.boh.core.domain.model.BascDictionary;
import com.jije.boh.core.jpa.repository.BascDictionaryRepository;
import com.jije.boh.module.demo.jpa.dao.IBascDictionaryDao;

@Component("bascDictionaryDao")
public class BascDictionaryDao implements IBascDictionaryDao{
	@Autowired
	private BascDictionaryRepository bascDictionaryRepository;
	@Override
	public List<BascDictionary> findByXparentid(String parentid) {
		return bascDictionaryRepository.findByXparentid(parentid);
	}

	@Override
	public BascDictionary findByXid(String xid) {
		return bascDictionaryRepository.findOne(xid);
	}

}
