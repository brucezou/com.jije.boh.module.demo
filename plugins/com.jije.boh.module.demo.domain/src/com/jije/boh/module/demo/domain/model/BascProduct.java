package com.jije.boh.module.demo.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jije.boh.core.domain.model.BascBase;
/**
 * 产品
 * @author nancy.zhou
 *
 */
@Entity
@Table(name = "boh_bascproduct")
public class BascProduct extends BascBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2053722922498083533L;

	/**
	 * 产品名称
	 */
	private String xname;
	
	/**
	 * 产品售卖类型
	 */
	private String xbascdictionarycategoryid;
	
	/**
	 * 产品类型
	 */
	private String xbascdictionarytypeid;
	
	/**
	 * 产品状态
	 */
	private String xbascdictionarystatusid;
	
	/**
	 * 产品价格
	 */
	private Double xprice;
	
	/**
	 * 是否需要库存盘点
	 */
	private boolean xneedcashierinventory;
	
	/**
	 * 是否促销
	 */
	private boolean xispromotion;
	
	private String xserialnumber;

	public String getXname() {
		return xname;
	}

	public void setXname(String xname) {
		this.xname = xname;
	}

	public String getXbascdictionarycategoryid() {
		return xbascdictionarycategoryid;
	}

	public void setXbascdictionarycategoryid(String xbascdictionarycategoryid) {
		this.xbascdictionarycategoryid = xbascdictionarycategoryid;
	}

	public String getXbascdictionarytypeid() {
		return xbascdictionarytypeid;
	}

	public void setXbascdictionarytypeid(String xbascdictionarytypeid) {
		this.xbascdictionarytypeid = xbascdictionarytypeid;
	}

	public String getXbascdictionarystatusid() {
		return xbascdictionarystatusid;
	}

	public void setXbascdictionarystatusid(String xbascdictionarystatusid) {
		this.xbascdictionarystatusid = xbascdictionarystatusid;
	}

	public Double getXprice() {
		return xprice;
	}

	public void setXprice(Double xprice) {
		this.xprice = xprice;
	}

	public boolean isXneedcashierinventory() {
		return xneedcashierinventory;
	}

	public void setXneedcashierinventory(boolean xneedcashierinventory) {
		this.xneedcashierinventory = xneedcashierinventory;
	}

	public boolean isXispromotion() {
		return xispromotion;
	}

	public void setXispromotion(boolean xispromotion) {
		this.xispromotion = xispromotion;
	}

	public String getXserialnumber() {
		return xserialnumber;
	}

	public void setXserialnumber(String xserialnumber) {
		this.xserialnumber = xserialnumber;
	}


}
