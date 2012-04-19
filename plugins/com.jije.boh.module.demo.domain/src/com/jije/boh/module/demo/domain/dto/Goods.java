package com.jije.boh.module.demo.domain.dto;

public class Goods {

	private String id;
	private String name;
	private String unit;
	private Integer count;
	private Integer initaltotal;
	private Integer[] initialtimes;
	private Integer[] needtimes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getInitaltotal() {
		return initaltotal;
	}

	public void setInitaltotal(Integer initaltotal) {
		this.initaltotal = initaltotal;
	}

	public Integer[] getInitialtimes() {
		return initialtimes;
	}

	public void setInitialtimes(Integer[] initialtimes) {
		this.initialtimes = initialtimes;
	}

	public Integer[] getNeedtimes() {
		return needtimes;
	}

	public void setNeedtimes(Integer[] needtimes) {
		this.needtimes = needtimes;
	}

}
