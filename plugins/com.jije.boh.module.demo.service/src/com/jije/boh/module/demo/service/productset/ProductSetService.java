package com.jije.boh.module.demo.service.productset;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jije.boh.core.domain.model.BascDictionary;
import com.jije.boh.module.demo.domain.dto.GoodSetDto;
import com.jije.boh.module.demo.domain.model.BascProduct;
import com.jije.boh.module.demo.domain.model.MpcpMPCProduct;
import com.jije.boh.module.demo.jpa.dao.IBascDictionaryDao;
import com.jije.boh.module.demo.jpa.dao.IBascProductDao;
import com.jije.boh.module.demo.jpa.dao.IMpcpMPCProductDao;

@Component("productSetService")
public class ProductSetService {
	@Autowired
	private IBascProductDao bascProductDao;

	@Autowired
	private IMpcpMPCProductDao mpcpMPCProductDao;

	@Autowired
	private IBascDictionaryDao bascDictionaryDao;

	public Object getServiceData(Map<String, Object> params) {
		String functionid = (String) params.get("functionid");
		if ("getGoodList".equals(functionid)) {
			return this.getGoodList(params);
		}
		if ("getGoodDetail".equals(functionid)) {
			return this.getGoodDetail(params);
		}
		if ("saveGoodSet".equals(functionid)) {
			return this.saveGoodSet(params);
		}
		return null;
	}

	private Map<String, Object> getGoodList(Map<String, Object> params) {
		List<GoodSetDto> goodList = new ArrayList<GoodSetDto>();
		List<MpcpMPCProduct> mpcproductList = mpcpMPCProductDao.findAll();
		for (MpcpMPCProduct mpcproduct : mpcproductList) {
			BascProduct bascProduct = bascProductDao.findByXid(mpcproduct
					.getXproductid());
			GoodSetDto goodsetDto = new GoodSetDto();
			goodsetDto.setId(mpcproduct.getXproductid());
			goodsetDto.setName(bascProduct.getXname());
			goodsetDto.setSellstart(mpcproduct.getXsellstarttime());
			goodsetDto.setSellend(mpcproduct.getXsellendtime());
			goodsetDto.setGoodsstatus(getDictionaryName(bascProduct
					.getXbascdictionarystatusid()));
			goodsetDto.setGoodstype(getDictionaryName(bascProduct
					.getXbascdictionarytypeid()));
			goodsetDto
					.setUsedate(mpcproduct.getXexpiration().toString() + "分钟");
			goodsetDto.setMadetime(mpcproduct.getXproduceduration().toString()
					+ "分钟");
			goodsetDto.setSaletype(getDictionaryName(bascProduct
					.getXbascdictionarycategoryid()));
			goodsetDto.setStartdate(new SimpleDateFormat("yyyy-MM-dd")
					.format(mpcproduct.getXsellstartdate()));
			if (mpcproduct.getXsellenddate() != null) {
				goodsetDto.setEnddate(new SimpleDateFormat("yyyy-MM-dd")
						.format(mpcproduct.getXsellenddate()));
			}
			goodsetDto.setInitcount(mpcproduct.getXorginalttc().toString());
			goodsetDto.setNeedtime(mpcproduct.getXbascdictionarytimeid());

			goodList.add(goodsetDto);
		}

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("goodsList", goodList);
		return result;
	}

	private String getDictionaryName(String xid) {
		BascDictionary dic = bascDictionaryDao.findByXid(xid);
		return dic.getXname();
	}

	private Object getGoodDetail(Map<String, Object> params) {
		String searchtext = (String) params.get("search");
		List<BascProduct> bascproducts = bascProductDao.findByXname(searchtext);
		GoodSetDto goodsetDto = new GoodSetDto();
		if (bascproducts != null && bascproducts.size() > 0) {
			BascProduct bascProduct = bascproducts.get(0);
			MpcpMPCProduct mpcpMPCProduct = mpcpMPCProductDao
					.findByXproductid(bascProduct.getXid());
			goodsetDto.setId(mpcpMPCProduct.getXproductid());
			goodsetDto.setName(bascProduct.getXname());
			goodsetDto.setSellstart(mpcpMPCProduct.getXsellstarttime());
			goodsetDto.setSellend(mpcpMPCProduct.getXsellendtime());
			goodsetDto.setGoodsstatus(getDictionaryName(bascProduct
					.getXbascdictionarystatusid()));
			goodsetDto.setGoodstype(getDictionaryName(bascProduct
					.getXbascdictionarytypeid()));
			goodsetDto.setUsedate(mpcpMPCProduct.getXexpiration().toString()
					+ "分钟");
			goodsetDto.setMadetime(mpcpMPCProduct.getXproduceduration()
					.toString() + "分钟");
			goodsetDto.setSaletype(getDictionaryName(bascProduct
					.getXbascdictionarycategoryid()));
			goodsetDto.setStartdate(new SimpleDateFormat("yyyy-MM-dd")
					.format(mpcpMPCProduct.getXsellstartdate()));
			if (mpcpMPCProduct.getXsellenddate() != null) {
				goodsetDto.setEnddate(new SimpleDateFormat("yyyy-MM-dd")
						.format(mpcpMPCProduct.getXsellenddate()));
			}
			goodsetDto.setInitcount(mpcpMPCProduct.getXorginalttc().toString());
			goodsetDto.setNeedtime(mpcpMPCProduct.getXbascdictionarytimeid());

		}
		return goodsetDto;
	}

	private Map<String, Object> saveGoodSet(Map<String, Object> params) {
		String goodsid = (String) params.get("goodsid");
		String selstarttime = (String) params.get("selstarttime");
		String selendtime = (String) params.get("selendtime");
		String selneedtime = (String) params.get("selneedtime");
		MpcpMPCProduct mpcpMPCProduct = mpcpMPCProductDao
				.findByXproductid(goodsid);
		mpcpMPCProduct.setXsellstarttime(selstarttime);
		mpcpMPCProduct.setXsellendtime(selendtime);
		mpcpMPCProduct.setXbascdictionarytimeid(selneedtime);
		mpcpMPCProductDao.saveMpcpMPCProduct(mpcpMPCProduct);
		return getGoodList(params);
	}
}
