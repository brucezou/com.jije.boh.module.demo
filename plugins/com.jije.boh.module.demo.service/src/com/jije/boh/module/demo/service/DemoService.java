package com.jije.boh.module.demo.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.jije.boh.core.service.inter.IOperateService;
import com.jije.boh.module.demo.service.productinit.DemoInitService;
import com.jije.boh.module.demo.service.productset.ProductSetService;

@Component("demoService")
public class DemoService implements IOperateService {
	@Autowired
	private ProductSetService productSetService;
	@Autowired
	private DemoInitService productInitService;

	@Override
	public Object getData(HttpServletRequest request) {
		int actid = 0;
		Map<String, Object> params = WebUtils.getParametersStartingWith(request,
				"");
		String actionid = (String) params.get("actionid");
		if (!StringUtils.isEmpty(actionid)) {
			actid = Integer.parseInt(actionid);
		}
		switch (actid){
		case ConstID.PRODUCTION_PRODUCT_SET:
			return productSetService.getServiceData(params);
			
		case ConstID.PRODUCTION_PRODUCT_INIT:
			return productInitService.getServiceData(params);
			
		default:
			return null;
		}
	}

}
