package com.jije.boh.module.demo.jpa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jije.boh.core.domain.model.BascEmployee;
import com.jije.boh.core.domain.model.BascUser;
import com.jije.boh.core.jpa.repository.BascEmployeeRepository;
import com.jije.boh.core.jpa.repository.BascUserRepository;
import com.jije.boh.module.demo.jpa.dao.IBascUserDao;

@Component("bascUserDao")
public class BascUserDao implements IBascUserDao {

	@Autowired
	private BascUserRepository bascUserRepository;

	@Autowired
	private BascEmployeeRepository bascEmployeeRepository;

	@Override
	public List<BascUser> findByEmployeeId(String employeeId) {
		return bascUserRepository.findByXemployeeid(employeeId);
	}

	@Override
	public BascUser findByLoginName(String loginName) {
		return bascUserRepository.findByXloginname(loginName);
	}

	@Override
	public BascUser findById(String id) {
		return bascUserRepository.findOne(id);
	}

	@Override
	public BascUser findCurrentUser() {
		return bascUserRepository.findOne(prepareCurrentUserId());
	}

	@Override
	public BascEmployee findCurrentEmployee() {
		BascUser user = findCurrentUser();
		return bascEmployeeRepository.findOne(user.getXemployeeid());
	}

	private String prepareCurrentUserId() {
		return "boh123456";
	}
}
