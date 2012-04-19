package com.jije.boh.module.demo.domain.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jije.boh.core.domain.model.BascBase;
/**
 * 初始化详情
 * @author nancy.zhou
 *
 */
@Entity
@Table(name = "boh_mpcpmpcinitdetail")
public class MpcpMPCInitDetail extends BascBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1945399647205286810L;
		
	/**
	 * 产品编号
	 */
	private String xmpcproductid;
	
	/**
	 * 时间段 对应数据字段id eg 5:00--5:30
	 */
	private String xtimeperioddicid;
	
	/**
	 * 需存量
	 */
	private Double xrequiredstock;
	
	/**
	 * manytoone
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private MpcpMPCInit mpcinit;
	
	public String getXmpcproductid() {
		return xmpcproductid;
	}
	public void setXmpcproductid(String xmpcproductid) {
		this.xmpcproductid = xmpcproductid;
	}
	public String getXtimeperioddicid() {
		return xtimeperioddicid;
	}
	public void setXtimeperioddicid(String xtimeperioddicid) {
		this.xtimeperioddicid = xtimeperioddicid;
	}
	public Double getXrequiredstock() {
		return xrequiredstock;
	}
	public void setXrequiredstock(Double xrequiredstock) {
		this.xrequiredstock = xrequiredstock;
	}
	public MpcpMPCInit getMpcinit() {
		return mpcinit;
	}
	public void setMpcinit(MpcpMPCInit mpcinit) {
		this.mpcinit = mpcinit;
	}

}
