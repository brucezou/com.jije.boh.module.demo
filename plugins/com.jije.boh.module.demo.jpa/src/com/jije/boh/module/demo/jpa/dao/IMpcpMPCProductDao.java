package com.jije.boh.module.demo.jpa.dao;

import java.util.List;

import com.jije.boh.module.demo.domain.model.MpcpMPCProduct;

/**
 * MPC品項dao
 * 
 * @author nancy.zhou
 * 
 */
public interface IMpcpMPCProductDao {
	List<MpcpMPCProduct> findByXstatus(int status);

	void saveMpcpMPCProduct(MpcpMPCProduct mpcpMPCProduct);

	void deleteMpcpMPCProducts(List<MpcpMPCProduct> mpcpMPCProducts);

	List<MpcpMPCProduct> findAll();

	MpcpMPCProduct findByXproductid(String xproductid);

}
