package com.jije.boh.module.demo.jpa.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jije.boh.module.demo.domain.model.MpcpMPCProduct;


@Transactional
public interface MpcpMPCProductRepository extends JpaSpecificationExecutor<MpcpMPCProduct>,JpaRepository<MpcpMPCProduct,Serializable>{
	@Transactional(readOnly = true)
	public List<MpcpMPCProduct> findByXstatus(int xstatus);

	@Transactional(readOnly = true)
	public MpcpMPCProduct findByXrefnumber(String xrefnumber);

	@Transactional(readOnly = true)
	public List<MpcpMPCProduct> findByXplugininfo(String xplugininfo);

	@Transactional(readOnly = true)
	public List<MpcpMPCProduct> findByXstoreid(String xstoreid);

	@Transactional(readOnly = true)
	public List<MpcpMPCProduct> findByXcreateby(String xcreateby);

	@Transactional(readOnly = true)
	public List<MpcpMPCProduct> findByXinsertby(String xinsertby);

	@Transactional(readOnly = true)
	public List<MpcpMPCProduct> findByXcreatetime(Date xcreatetime);

	@Transactional(readOnly = true)
	public List<MpcpMPCProduct> findByXinserttime(Date xinserttime);

	@Transactional(readOnly = true)
	public List<MpcpMPCProduct> findByXlastupdatetime(Date xlastupdatetime);

	@Transactional(readOnly = true)
	public List<MpcpMPCProduct> findByXlastupdateby(String xlastupdateby);
	
	@Transactional(readOnly = true)
	public MpcpMPCProduct findByXproductid(String xproductid);
}
