package com.jije.boh.module.demo.jpa.dao;

import java.util.List;

import com.jije.boh.core.domain.model.BascEmployee;

/**
 * Employee dao
 * 
 * @author eric.zhang
 * 
 */
public interface IBascEmployeeDao {

	/**
	 * 根据id获取employee
	 * 
	 * @param id
	 * @return
	 */
	BascEmployee findById(String id);

	List<BascEmployee> findByDictionaryId(String dictionaryId);

	List<BascEmployee> findByJobNameLike(String jobName);

	BascEmployee findBySerialnumber(String serialnumber);
	
	List<BascEmployee> findByBascjobXrefnumber(String xrefnumber);
}
