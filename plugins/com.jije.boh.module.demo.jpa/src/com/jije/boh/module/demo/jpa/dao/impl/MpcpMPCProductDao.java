package com.jije.boh.module.demo.jpa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jije.boh.module.demo.jpa.dao.IMpcpMPCProductDao;
import com.jije.boh.module.demo.jpa.repository.MpcpMPCProductRepository;
import com.jije.boh.module.demo.domain.model.MpcpMPCProduct;
@Component("mpcpMPCProductDao")
public class MpcpMPCProductDao implements IMpcpMPCProductDao {
	@Autowired
	private MpcpMPCProductRepository mpcpMPCProductRepository;

	@Override
	public List<MpcpMPCProduct> findByXstatus(int status) {
		return mpcpMPCProductRepository.findByXstatus(status);
	}

	@Override
	public void saveMpcpMPCProduct(MpcpMPCProduct mpcpMPCProduct) {
		mpcpMPCProductRepository.save(mpcpMPCProduct);
		
	}

	@Override
	public void deleteMpcpMPCProducts(List<MpcpMPCProduct> mpcpMPCProducts) {
		mpcpMPCProductRepository.delete(mpcpMPCProducts);
		
	}

	@Override
	public List<MpcpMPCProduct> findAll() {
		return mpcpMPCProductRepository.findAll();
	}

	@Override
	public MpcpMPCProduct findByXproductid(String xproductid) {
		return mpcpMPCProductRepository.findByXproductid(xproductid);
	}


}
