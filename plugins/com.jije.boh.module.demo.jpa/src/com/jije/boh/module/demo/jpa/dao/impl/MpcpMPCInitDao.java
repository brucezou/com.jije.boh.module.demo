package com.jije.boh.module.demo.jpa.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jije.boh.module.demo.jpa.dao.IMpcpMPCInitDao;
import com.jije.boh.module.demo.jpa.repository.MpcpMPCInitDetailRepository;
import com.jije.boh.module.demo.jpa.repository.MpcpMPCInitRepository;
import com.jije.boh.module.demo.domain.model.MpcpMPCInit;
import com.jije.boh.module.demo.domain.model.MpcpMPCInitDetail;

@Component("mpcpMPCInitDao")
public class MpcpMPCInitDao implements IMpcpMPCInitDao {
	@Autowired
	private MpcpMPCInitRepository mpcpMPCInitRepository;

	@Autowired
	private MpcpMPCInitDetailRepository mpcpMPCInitDetailRepository;

	@Override
	public List<MpcpMPCInit> findByXinitbusinessdate(Date xinitbusinessdate) {
		return mpcpMPCInitRepository.findByXinitbusinessdate(xinitbusinessdate);
	}

	@Override
	public List<MpcpMPCInitDetail> findByXmpcproductid(String xmpcproductid) {
		return mpcpMPCInitDetailRepository.findByXmpcproductid(xmpcproductid);
	}

	@Override
	public void saveMPCInit(MpcpMPCInit entity) {
		mpcpMPCInitRepository.save(entity);
	}

	@Override
	public void saveMPCInitList(Iterable<MpcpMPCInit> entities) {
		mpcpMPCInitRepository.save(entities);
	}

	@Override
	public void saveMPCInitDetail(MpcpMPCInitDetail entity) {
		mpcpMPCInitDetailRepository.save(entity);
	}

	@Override
	public void saveMPCInitDetailList(Iterable<MpcpMPCInitDetail> entities) {
		mpcpMPCInitDetailRepository.save(entities);
	}
}
