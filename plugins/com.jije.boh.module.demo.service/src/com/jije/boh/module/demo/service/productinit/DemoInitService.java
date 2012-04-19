package com.jije.boh.module.demo.service.productinit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jije.boh.core.domain.model.BascDictionary;
import com.jije.boh.core.domain.model.BascStore;
import com.jije.boh.core.domain.model.BascUser;
import com.jije.boh.module.forecast.domain.model.FctpForecastTTC;
import com.jije.boh.module.forecast.domain.model.FctpHourlyForecast;
import com.jije.boh.module.forecast.jpa.dao.IFctpForecastDao;
import com.jije.boh.module.forecast.jpa.dao.IFctpTTCDao;
import com.jije.boh.module.demo.domain.dto.Goods;
import com.jije.boh.module.demo.domain.dto.Operator;
import com.jije.boh.module.demo.domain.dto.ProduceInit;
import com.jije.boh.module.demo.domain.model.BascProduct;
import com.jije.boh.module.demo.domain.model.MpcpMPCInit;
import com.jije.boh.module.demo.domain.model.MpcpMPCInitDetail;
import com.jije.boh.module.demo.jpa.dao.IBascDictionaryDao;
import com.jije.boh.module.demo.jpa.dao.IBascEmployeeDao;
import com.jije.boh.module.demo.jpa.dao.IBascProductDao;
import com.jije.boh.module.demo.jpa.dao.IBascStoreDao;
import com.jije.boh.module.demo.jpa.dao.IBascUserDao;
import com.jije.boh.module.demo.jpa.dao.IMpcpMPCInitDao;
import com.jije.boh.module.demo.jpa.dao.IMpcpMPCProductDao;

@Component("demoInitService")
public class DemoInitService {

	@Autowired
	private IMpcpMPCInitDao mpcpMPCInitDao;
	@Autowired
	private IBascUserDao bascUserDao;
	@Autowired
	private IBascEmployeeDao bascEmployeeDao;
	@Autowired
	private IBascStoreDao bascStoreDao;
	@Autowired
	private IFctpTTCDao fctpTTCDao;
	@Autowired
	private IBascProductDao bascProductDao;
	@Autowired
	private IBascDictionaryDao bascDictionaryDao;
	@Autowired
	private IFctpForecastDao fctpForecastDao;
	@Autowired
	private IMpcpMPCProductDao mpcpMPCProductDao;

	private final static int FORECAST_PRODUCT_MPCPMPCINIT_LOAD = 7120;
	private final static int FORECAST_PRODUCT_MPCPMPCINIT_SUBMIT = 7121;
	private final static int FORECAST_PRODUCT_MPCPMPCINIT_ADJUST = 7122;

	public Object getServiceData(Map<String, Object> params) {

		String function = (String) params.get("function");
		int func = 0;
		if (!StringUtils.isEmpty("function")) {
			func = Integer.valueOf(function);
		}
		switch (func) {
		case FORECAST_PRODUCT_MPCPMPCINIT_LOAD:
			return loadMpcpMPCInitData(params);
		case FORECAST_PRODUCT_MPCPMPCINIT_SUBMIT:
			return submitMpcpMPCInitData(params);
		case FORECAST_PRODUCT_MPCPMPCINIT_ADJUST:
			return adjustMpcpMPCInitData(params);
		default:
			break;
		}
		return null;
	}

	/**
	 * Load init data for MpcpMPC
	 * 
	 * @param params
	 * @return
	 */
	public ProduceInit loadMpcpMPCInitData(Map<String, Object> params) {

		ProduceInit produceInit = new ProduceInit();
		produceInit.setTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

		BascUser user = bascUserDao.findByLoginName("wangmengxiang");
		BascStore store = bascStoreDao.findById(user.getXstoreid());

		produceInit.setOperator(getOperator(user));
		produceInit.setName(store.getXname());

		DateTime dateTime = new DateTime(new Date());
		List<Goods> goodslist = new ArrayList<Goods>();
		List<FctpForecastTTC> ttcs = fctpTTCDao.findByXbusinessdateTTC(dateTime
				.toDate());
		for (int i = 0; i < ttcs.size(); i++) {
			FctpForecastTTC ttc = ttcs.get(i);

			BascProduct product = bascProductDao.findByXid(ttc.getXproductid());

			Goods goods = new Goods();
			goods.setId(ttc.getXproductid());
			goods.setName(product.getXname());
		//	goods.setUnit("块");

			Integer[] initialtimes = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			goods.setInitialtimes(initialtimes);
			Integer[] needtimes = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			goods.setNeedtimes(needtimes);
			goods.setCount(0);
			goods.setInitaltotal(0);
			goodslist.add(goods);
		}

		produceInit.setGoodslist(goodslist);
		return produceInit;

	}

	/**
	 * Submit init data for MpcpMPC
	 * 
	 * @param params
	 * @return
	 */
	public ProduceInit submitMpcpMPCInitData(Map<String, Object> params) {

		String date = (String) params.get("date_produceInit");

		ProduceInit produceInit = new ProduceInit();
		produceInit.setTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

		BascUser user = bascUserDao.findByLoginName("wangmengxiang");
		BascStore store = bascStoreDao.findById(user.getXstoreid());

		produceInit.setOperator(getOperator(user));
		produceInit.setName(store.getXname());

		DateTime dateTime;
		if (StringUtils.isBlank(date))
			dateTime = new DateTime();
		else
			dateTime = new DateTime(date);
		List<Goods> goodslist = new ArrayList<Goods>();
		List<FctpForecastTTC> ttcs = fctpTTCDao.findByXbusinessdateTTC(dateTime
				.toDate());
		List<MpcpMPCInitDetail> mpcinitdetails = new ArrayList<MpcpMPCInitDetail>();
		for (int i = 0; i < ttcs.size(); i++) {
			FctpForecastTTC ttc = ttcs.get(i);
			Double xttc = ttc.getXttc();

			BascProduct product = bascProductDao.findByXid(ttc.getXproductid());
			Goods goods = new Goods();
			goods.setId(ttc.getXproductid());
			goods.setName(product.getXname());
		//	goods.setUnit("块");

			List<BascDictionary> dics = bascDictionaryDao
					.findByXparentid("00001");
			Integer[] initialtimes = new Integer[48];
			Integer[] needtimes = new Integer[48];
			Integer initaltotal = 0;
			Integer count = 0;
			for (int j = 0; j < dics.size(); j++) {
				BascDictionary basc = dics.get(i);
				FctpHourlyForecast timeForecast = fctpForecastDao
						.findByXbusinessdateAndXtimeperioddicid(
								dateTime.toDate(), basc.getXid());
				Double adjtc = 1.0;
				if (timeForecast != null) {
					adjtc = timeForecast.getXadjtc();
				}
				if (adjtc == null) {
					initialtimes[j] = 1;
				} else {
					initialtimes[j] = prepareInitialtime(xttc * adjtc / 1000.00);
				}
				initaltotal += initialtimes[j];

				// Init MpcpMPCInitDetail data
				MpcpMPCInitDetail initDetail = new MpcpMPCInitDetail();
				initDetail.setXmpcproductid(ttc.getXproductid());
				initDetail.setXtimeperioddicid(basc.getXid());
				initDetail.setXrequiredstock(adjtc);
				mpcinitdetails.add(initDetail);
			}
			for (int k = 0; k < dics.size(); k++) {
				if (k < k - 2)
					needtimes[k] = initialtimes[k] + initialtimes[k + 1]
							+ initialtimes[k + 2];
				else if (k < k - 1)
					needtimes[k] = initialtimes[k] + initialtimes[k + 1]
							+ initialtimes[0];
				else
					needtimes[k] = initialtimes[k] + initialtimes[0]
							+ initialtimes[1];
				count += needtimes[k];
			}
			goods.setInitialtimes(initialtimes);
			goods.setNeedtimes(needtimes);
			goods.setCount(count);
			goods.setInitaltotal(initaltotal);
			goodslist.add(goods);
		}

		MpcpMPCInit mpcInit = new MpcpMPCInit();
		mpcInit.setXinitemployeeid(user.getXid());
		mpcInit.setXinitbusinessdate(DateFormatUtils.format(new Date(),
				"yyyy-MM-dd"));
		mpcInit.setMpcinitdetails(mpcinitdetails);
		// Insert MpcpMPCInit and MpcpMPCInitDetail data
		mpcpMPCInitDao.saveMPCInit(mpcInit);
		produceInit.setGoodslist(goodslist);
		return produceInit;
	}

	public Goods adjustMpcpMPCInitData(Map<String, Object> params) {
		String goodsId = (String) params.get("goodsId");
		String ttccount = (String) params.get("ttccount");

		BascProduct product = bascProductDao.findByXid(goodsId);
		Goods goods = new Goods();
		goods.setId(goodsId);
		goods.setName(product.getXname());
	//	goods.setUnit("块");

		DateTime dateTime = new DateTime(new Date());
		List<BascDictionary> dics = bascDictionaryDao.findByXparentid("00001");
		Integer[] initialtimes = new Integer[48];
		Integer[] needtimes = new Integer[48];
		Integer initaltotal = 0;
		Integer count = 0;

		FctpForecastTTC fctpForecastTTC = fctpTTCDao.findByXproductid(goodsId);
		fctpForecastTTC.setXttc(Double.valueOf(ttccount));
		fctpTTCDao.save(fctpForecastTTC);

		List<MpcpMPCInitDetail> details = mpcpMPCInitDao
				.findByXmpcproductid(goodsId);
		for (int i = 0; i < dics.size(); i++) {
			BascDictionary basc = dics.get(i);
			FctpHourlyForecast timeForecast = fctpForecastDao
					.findByXbusinessdateAndXtimeperioddicid(dateTime.toDate(),
							basc.getXid());
			Double adjtc = 2.0;
			if (timeForecast != null) {
				adjtc = timeForecast.getXadjtc();
			}
			initialtimes[i] = prepareInitialtime(Double.valueOf(ttccount)
					* adjtc / 1000);
			initaltotal += initialtimes[i];

			MpcpMPCInitDetail detail = details.get(i);
			detail.setXrequiredstock(Double.valueOf(ttccount) * adjtc);
			details.add(detail);

		}
		// 暂时设置需存量时间为90分钟
		for (int k = 0; k < dics.size(); k++) {
			if (k < k - 2)
				needtimes[k] = initialtimes[k] + initialtimes[k + 1]
						+ initialtimes[k + 2];
			else if (k < k - 1)
				needtimes[k] = initialtimes[k] + initialtimes[k + 1]
						+ initialtimes[0];
			else
				needtimes[k] = initialtimes[k] + initialtimes[0]
						+ initialtimes[1];
			count += needtimes[k];
		}

		// Update MpcpMPCInitDetail
		mpcpMPCInitDao.saveMPCInitDetailList(details);

		goods.setInitialtimes(initialtimes);
		goods.setNeedtimes(needtimes);
		goods.setCount(count);
		goods.setInitaltotal(initaltotal);

		return goods;
	}

	private Operator getOperator(BascUser user) {

		Operator operator = new Operator();
	//	operator.setRealname("王梦香");
		operator.setUsername(user.getXid());
		return operator;
	}

	private int prepareInitialtime(double d) {
		int i = (int) Math.floor(d);
		return (i == d) ? i : i + 1;
	}
}
