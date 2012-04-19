package com.jije.boh.module.demo.jpa.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import com.jije.boh.module.demo.domain.model.MpcpMPCInitDetail;


@Transactional
public interface MpcpMPCInitDetailRepository  extends JpaSpecificationExecutor<MpcpMPCInitDetail>,PagingAndSortingRepository<MpcpMPCInitDetail,Serializable>{
	@Transactional(readOnly = true)
	public List<MpcpMPCInitDetail> findByXstatus(int xstatus);

	@Transactional(readOnly = true)
	public MpcpMPCInitDetail findByXrefnumber(String xrefnumber);

	@Transactional(readOnly = true)
	public List<MpcpMPCInitDetail> findByXplugininfo(String xplugininfo);

	@Transactional(readOnly = true)
	public List<MpcpMPCInitDetail> findByXstoreid(String xstoreid);

	@Transactional(readOnly = true)
	public List<MpcpMPCInitDetail> findByXcreateby(String xcreateby);

	@Transactional(readOnly = true)
	public List<MpcpMPCInitDetail> findByXinsertby(String xinsertby);

	@Transactional(readOnly = true)
	public List<MpcpMPCInitDetail> findByXcreatetime(Date xcreatetime);

	@Transactional(readOnly = true)
	public List<MpcpMPCInitDetail> findByXinserttime(Date xinserttime);

	@Transactional(readOnly = true)
	public List<MpcpMPCInitDetail> findByXlastupdatetime(Date xlastupdatetime);

	@Transactional(readOnly = true)
	public List<MpcpMPCInitDetail> findByXlastupdateby(String xlastupdateby);
	
	@Transactional(readOnly = true)
	public List<MpcpMPCInitDetail> findByXmpcproductid(String xmpcproductid);
}
