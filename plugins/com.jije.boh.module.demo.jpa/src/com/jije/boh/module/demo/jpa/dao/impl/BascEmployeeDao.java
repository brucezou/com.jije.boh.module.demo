package com.jije.boh.module.demo.jpa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jije.boh.core.domain.model.BascEmployee;
import com.jije.boh.core.jpa.repository.BascEmployeeRepository;
import com.jije.boh.module.demo.jpa.dao.IBascEmployeeDao;

@Component("bascEmployeeDao")
public class BascEmployeeDao implements IBascEmployeeDao {

	@Autowired
	private BascEmployeeRepository bascEmployeeRepository;

	public void save(BascEmployee entity) {
		bascEmployeeRepository.save(entity);
	}

	public void delete(String id) {
		bascEmployeeRepository.delete(id);
	}

	public boolean exists(String id) {
		return bascEmployeeRepository.exists(id);
	}

	public BascEmployee findById(String id) {
		return bascEmployeeRepository.findOne(id);
	}

	@Override
	public List<BascEmployee> findByDictionaryId(String dictionaryId) {
		return bascEmployeeRepository
				.findByXbascdictionarygroupid(dictionaryId);
	}

	@Override
	public List<BascEmployee> findByJobNameLike(String jobName) {
		return bascEmployeeRepository.findByBascjobXnameLike("%" + jobName
				+ "%");
	}

	@Override
	public BascEmployee findBySerialnumber(String serialnumber) {
		return bascEmployeeRepository.findByXrefnumber(serialnumber);
	}

	@Override
	public List<BascEmployee> findByBascjobXrefnumber(String xrefnumber) {
		return bascEmployeeRepository.findByBascjobXrefnumber(xrefnumber);
	}

}
