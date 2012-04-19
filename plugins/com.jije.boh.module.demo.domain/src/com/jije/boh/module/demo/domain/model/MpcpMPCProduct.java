package com.jije.boh.module.demo.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jije.boh.core.domain.model.BascBase;

@Entity
@Table(name = "boh_mpcpmpcproduct")
public class MpcpMPCProduct extends BascBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3919354872513637059L;
	
	/**
	 *产品id
	 */
	private String xproductid;
	
	/**
	 * 售卖起始时间
	 */
	private String xsellstarttime;
	
	/**
	 *售卖结束时间 
	 */
	private String xsellendtime;
	
	/**
	 * 售卖开始日期
	 */
	@Temporal(TemporalType.DATE)
	private Date xsellstartdate;

	/**
	 * 售卖结束日期
	 */
	@Temporal(TemporalType.DATE)
	private Date xsellenddate;
	
	/**
	 * 标准制作时间
	 */
	private Integer xproduceduration;
	
	/**
	 * 保质期
	 */
	private Integer xexpiration;
	
	/**
	 * 需求量时间
	 */
	private String xbascdictionarytimeid;
	
	/**
	 * 初始预估千次
	 */
	private Double  xorginalttc;

	public String getXproductid() {
		return xproductid;
	}

	public void setXproductid(String xproductid) {
		this.xproductid = xproductid;
	}

	public String getXsellstarttime() {
		return xsellstarttime;
	}

	public void setXsellstarttime(String xsellstarttime) {
		this.xsellstarttime = xsellstarttime;
	}

	public String getXsellendtime() {
		return xsellendtime;
	}

	public void setXsellendtime(String xsellendtime) {
		this.xsellendtime = xsellendtime;
	}

	public Date getXsellstartdate() {
		return xsellstartdate;
	}

	public void setXsellstartdate(Date xsellstartdate) {
		this.xsellstartdate = xsellstartdate;
	}

	public Date getXsellenddate() {
		return xsellenddate;
	}

	public void setXsellenddate(Date xsellenddate) {
		this.xsellenddate = xsellenddate;
	}

	public Integer getXproduceduration() {
		return xproduceduration;
	}

	public void setXproduceduration(Integer xproduceduration) {
		this.xproduceduration = xproduceduration;
	}

	public Integer getXexpiration() {
		return xexpiration;
	}

	public void setXexpiration(Integer xexpiration) {
		this.xexpiration = xexpiration;
	}

	public String getXbascdictionarytimeid() {
		return xbascdictionarytimeid;
	}

	public void setXbascdictionarytimeid(String xbascdictionarytimeid) {
		this.xbascdictionarytimeid = xbascdictionarytimeid;
	}

	public Double getXorginalttc() {
		return xorginalttc;
	}

	public void setXorginalttc(Double xorginalttc) {
		this.xorginalttc = xorginalttc;
	}

}
