package com.jije.boh.module.demo.jpa.dao;

import java.util.List;

import com.jije.boh.core.domain.model.BascDictionary;

public interface IBascDictionaryDao {
	List<BascDictionary> findByXparentid(String parentid);
	BascDictionary findByXid(String xid);
}
