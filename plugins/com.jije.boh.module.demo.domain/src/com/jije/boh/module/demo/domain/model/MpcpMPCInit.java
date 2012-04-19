package com.jije.boh.module.demo.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jije.boh.core.domain.model.BascBase;
/**
 * 初始化
 * @author nancy.zhou
 *
 */
@Entity
@Table(name = "boh_mpcpmpcinit")
public class MpcpMPCInit extends BascBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3680798629575013507L;
	
	/**
	 *执行初始化员工id 
	 */
	private String xinitemployeeid;
	
	/**
	 * 初始化日期
	 */
	private String xinitbusinessdate;
	
	/**
	 * mpcpMPCInitDetails
	 */
	@OneToMany(mappedBy = "mpcinit")
	private List<MpcpMPCInitDetail> mpcinitdetails;
	
	public String getXinitemployeeid() {
		return xinitemployeeid;
	}
	public void setXinitemployeeid(String xinitemployeeid) {
		this.xinitemployeeid = xinitemployeeid;
	}
	public String getXinitbusinessdate() {
		return xinitbusinessdate;
	}
	public void setXinitbusinessdate(String xinitbusinessdate) {
		this.xinitbusinessdate = xinitbusinessdate;
	}
	public List<MpcpMPCInitDetail> getMpcinitdetails() {
		return mpcinitdetails;
	}
	public void setMpcinitdetails(List<MpcpMPCInitDetail> mpcinitdetails) {
		this.mpcinitdetails = mpcinitdetails;
	}
	
}
