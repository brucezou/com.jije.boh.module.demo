package com.jije.boh.module.demo.jpa.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jije.boh.module.demo.domain.model.MpcpMPCInit;

@Transactional
public interface MpcpMPCInitRepository extends
		JpaSpecificationExecutor<MpcpMPCInit>,
		PagingAndSortingRepository<MpcpMPCInit, Serializable> {
	@Transactional(readOnly = true)
	public List<MpcpMPCInit> findByXstatus(int xstatus);

	@Transactional(readOnly = true)
	public MpcpMPCInit findByXrefnumber(String xrefnumber);

	@Transactional(readOnly = true)
	public List<MpcpMPCInit> findByXplugininfo(String xplugininfo);

	@Transactional(readOnly = true)
	public List<MpcpMPCInit> findByXstoreid(String xstoreid);

	@Transactional(readOnly = true)
	public List<MpcpMPCInit> findByXcreateby(String xcreateby);

	@Transactional(readOnly = true)
	public List<MpcpMPCInit> findByXinsertby(String xinsertby);

	@Transactional(readOnly = true)
	public List<MpcpMPCInit> findByXcreatetime(Date xcreatetime);

	@Transactional(readOnly = true)
	public List<MpcpMPCInit> findByXinserttime(Date xinserttime);

	@Transactional(readOnly = true)
	public List<MpcpMPCInit> findByXlastupdatetime(Date xlastupdatetime);

	@Transactional(readOnly = true)
	public List<MpcpMPCInit> findByXlastupdateby(String xlastupdateby);

	@Transactional(readOnly = true)
	public List<MpcpMPCInit> findByXinitbusinessdate(Date xinitbusinessdate);
}
