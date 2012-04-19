
	$("#produce1").click(function(){
		public_load_ajax(".b-mian-content", "/app/index", "module=module.production.web&template=html_produceSet.ftl");//生产信息设置
	});
	
	$("#produce2").click(function(){
		public_load_ajax(".b-mian-content", "/app/index", "module=module.production.web&template=html_produceInit.ftl");//MP&C初始化
	});
