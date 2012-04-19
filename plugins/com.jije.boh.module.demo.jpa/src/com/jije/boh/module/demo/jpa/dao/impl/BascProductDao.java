package com.jije.boh.module.demo.jpa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jije.boh.module.demo.jpa.dao.IBascProductDao;
import com.jije.boh.module.demo.jpa.repository.BascProductRepository;
import com.jije.boh.module.demo.domain.model.BascProduct;
@Component("bascProductDao")
public class BascProductDao implements IBascProductDao {
	@Autowired
	private BascProductRepository bascProductRepository;

	@Override
	public List<BascProduct> findByXstatus(int xstatus) {
		return bascProductRepository.findByXstatus(xstatus);
	}

	@Override
	public void saveBascProduct(BascProduct bascProduct) {
		bascProductRepository.save(bascProduct);
		
	}

	@Override
	public void deleteBascProducts(List<BascProduct> products) {
		bascProductRepository.delete(products);
		
	}

	@Override
	public BascProduct findByXid(String xid) {
		return bascProductRepository.findOne(xid);
	}

	@Override
	public List<BascProduct> findByXname(String xname) {
		return bascProductRepository.findByXname(xname);
	}

	@Override
	public List<BascProduct> findByXispromotion(boolean ispromotion) {
		return bascProductRepository.findByXispromotion(ispromotion);
	}
	
}
