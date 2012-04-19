package com.jije.boh.module.demo.service.init;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jije.boh.core.domain.dto.MenuDto;
import com.jije.boh.core.service.inter.IOperateMessageService;
import com.jije.boh.core.service.inter.IOperateService;

@Component("demoInitMenuService")
public class DemoInitMenuService {

	@Autowired
	private IOperateMessageService operateMessageService;

	private MenuDto menuDto = new MenuDto();

	public void serviceRegistered(IOperateService serviceInstance,
			Map serviceProperties) {
		String symbolicName = (String) serviceProperties
				.get("Bundle-SymbolicName");
		menuDto.setSymbolicName(symbolicName);
		menuDto.setIcon("core.web/resources/images/b-menu-6.png");
		menuDto.setLink("module=module.demo.web");
		menuDto.setName("Demo");
		operateMessageService.serviceRegistered(menuDto);
	}

	public void serviceUnregistered(IOperateService serviceInstance,
			Map serviceProperties) {
		operateMessageService.serviceUnregistered(menuDto);
	}
}
