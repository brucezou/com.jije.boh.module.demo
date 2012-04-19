package com.jije.boh.module.demo.jpa.dao;

import java.util.List;

import com.jije.boh.module.demo.domain.model.BascProduct;

/**
 * bascproduct dao
 * @author nancy.zhou
 *
 */
public interface IBascProductDao {
	List<BascProduct> findByXstatus(int xstatus);
	void saveBascProduct(BascProduct bascProduct);
	void deleteBascProducts(List<BascProduct> products);
	BascProduct findByXid(String xid);
	List<BascProduct> findByXname(String xname);
	List<BascProduct> findByXispromotion(boolean ispromotion);
}
