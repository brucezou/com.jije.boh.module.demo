package com.jije.boh.module.demo.jpa.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jije.boh.module.demo.domain.model.BascProduct;

@Transactional
public interface BascProductRepository extends JpaSpecificationExecutor<BascProduct>,PagingAndSortingRepository<BascProduct,Serializable>{
	@Transactional(readOnly = true)
	public List<BascProduct> findByXstatus(int xstatus);

	@Transactional(readOnly = true)
	public BascProduct findByXrefnumber(String xrefnumber);

	@Transactional(readOnly = true)
	public List<BascProduct> findByXplugininfo(String xplugininfo);

	@Transactional(readOnly = true)
	public List<BascProduct> findByXstoreid(String xstoreid);

	@Transactional(readOnly = true)
	public List<BascProduct> findByXcreateby(String xcreateby);

	@Transactional(readOnly = true)
	public List<BascProduct> findByXinsertby(String xinsertby);

	@Transactional(readOnly = true)
	public List<BascProduct> findByXcreatetime(Date xcreatetime);

	@Transactional(readOnly = true)
	public List<BascProduct> findByXinserttime(Date xinserttime);

	@Transactional(readOnly = true)
	public List<BascProduct> findByXlastupdatetime(Date xlastupdatetime);

	@Transactional(readOnly = true)
	public List<BascProduct> findByXlastupdateby(String xlastupdateby);
	
	@Transactional(readOnly = true)
	public List<BascProduct> findByXname(String xname);
	
	@Transactional(readOnly = true)
	public List<BascProduct> findByXispromotion(boolean xispromotion);
}
