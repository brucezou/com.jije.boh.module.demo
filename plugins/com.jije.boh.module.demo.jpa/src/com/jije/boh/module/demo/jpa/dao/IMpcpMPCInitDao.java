package com.jije.boh.module.demo.jpa.dao;

import java.util.Date;
import java.util.List;

import com.jije.boh.module.demo.domain.model.MpcpMPCInit;
import com.jije.boh.module.demo.domain.model.MpcpMPCInitDetail;

/**
 * MPC初始化dao
 * 
 * @author nancy.zhou
 * 
 */
public interface IMpcpMPCInitDao {

	List<MpcpMPCInit> findByXinitbusinessdate(Date xinitbusinessdate);

	List<MpcpMPCInitDetail> findByXmpcproductid(String xmpcproductid);

	public void saveMPCInit(MpcpMPCInit entity);

	public void saveMPCInitList(Iterable<MpcpMPCInit> entities);

	public void saveMPCInitDetail(MpcpMPCInitDetail entity);

	public void saveMPCInitDetailList(Iterable<MpcpMPCInitDetail> entities);

}
