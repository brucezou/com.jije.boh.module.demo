package com.jije.boh.module.demo.jpa.dao;

import java.util.List;

import com.jije.boh.core.domain.model.BascEmployee;
import com.jije.boh.core.domain.model.BascUser;

public interface IBascUserDao {

	List<BascUser> findByEmployeeId(String employeeId);

	BascUser findByLoginName(String loginName);

	BascUser findById(String id);

	/**
	 * 当前登录用户
	 * 
	 * @return
	 */
	BascUser findCurrentUser();

	/**
	 * 获取当前登录员工获
	 * 
	 * @return
	 */
	BascEmployee findCurrentEmployee();
	
}
