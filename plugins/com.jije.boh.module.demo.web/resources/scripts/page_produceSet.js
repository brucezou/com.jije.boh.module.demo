
	
	$(".b-last-page").click(function(){
		public_load_ajax(".b-mian-content", "/app/index", "module=module.production.web&template=html_produce.ftl");//生产控制
	});
	
	$(".b-navigation a").click(function(){
		public_load_ajax(".b-mian-content", "/app/index", "module=module.production.web&template=html_produce.ftl");//生产控制
	});
	

	var goodsList;
	var times = ["30分钟", "45分钟", "60分钟","90分钟", "120分钟"];
	
	for(var i = 0; i < 24; i++){
		var option1 = $("<option>").val(i + ":30").text(i + ":30");
		var option2 = $("<option>").val((i+1) + ":00").text((i+1) + ":00");
		$("#sel-start-time").append(option1, option2);		
	}
	$("#sel-end-time").append($("#sel-start-time").html());
	for(var i = 0; i < times.length; i++){
		var option = $("<option>").val(times[i]).text(times[i]);
		$("#sel-save-time").append(option);
	}
	
	$.ajax({
        type: "POST",
        url: "/app/ajax",
        data: "module=module.production.service&actionid=711&functionid=getGoodList",
        dataType: '',
        success: function(json)
        { 
			//乱码处理,后台请将dataType设为空
			json = decodeURIComponent(json);
			json = eval("(" + json + ")");
        	goodsList = json.goodsList;  
        	renderGoodsInfo(goodsList[0]);
        },
        error: function(e){
        	alert("Err!");
        }
	});
	
	
	
	$("#txt-goods").keydown(function(e){
		
		var searchlist = new Array();
		var search = $("#txt-goods").val();
		$(".b-public-search ul").html("");
		
//		alert(e.keyCode);
		if(e.keyCode == 13){
			if(search.length > 0){
				$.ajax({
			        type: "POST",
			        url: "/app/ajax",
			        data: "module=module.production.service&actionid=711&functionid=getGoodDetail&search="+search,
			        dataType: '',
			        success: function(json)
			        { 
						//乱码处理,后台请将dataType设为空
						json = decodeURIComponent(json);
						json = eval("(" + json + ")");
			        	if(json){
			        		renderGoodsInfo(json);
			        		$("#btn-submit")[0].disabled = false;
			        	}			        	
			        },
			        error: function(e){
			        	alert("Err!");
			        }
				});
			}else{
                this.style.border = "1px red solid";
                this.style.background = "#fbe2e2";
                this.style.color = "red";
			}			
			return false;
		}else{
			
			clearGoodsInfo();
			$("#btn-submit")[0].disabled = true;
			
			if (search.length < 1) 
			{					
				for (var i = 0; i < goodsList.length; i++) 
		         {
		             var option = document.createElement("li");
		             option.innerHTML = goodsList[i].name;
		             option.setAttribute("index",i);
		             option.onclick = function()
		             {
		            	 //根据选择的品项将相关信息载入当前页面，这里假设选择品项goodsList[2]  
		                 $(".b-public-search ul").hide();
		                 renderGoodsInfo(goodsList[$(this).attr("index")]);
		                 $("#btn-submit")[0].disabled = false;
		             }
		             $(".b-public-search ul").append(option);
		         }
				$(".b-public-search ul").show();
			}else{
				
				$.ajax({
			        type: "POST",
			        url: "/moduleresources/module.production.web/resources/scripts/json/data_produceSet.json",
			        data: "",
			        dataType: 'json',
			        success: function(json)
			        { 
			        	for (var i = 0; i < json.goodsList.length; i++) 
						{
							if (json.goodsList[i].id.indexOf(search) != -1 || json.goodsList[i].name.indexOf(search) != -1) 
							{
								searchlist[searchlist.length] = json.goodsList[i].name;
							}
						}
						if(searchlist.length>0){
							 for (var i = 0; i < searchlist.length; i++) 
					         {
					             var option = document.createElement("li");
					             option.innerHTML = searchlist[i];
					             option.onclick = function()
					             {
					            	 //根据选择的品项将相关信息载入当前页面，这里假设选择品项goodsList[1]            	           	 
					                 $(".b-public-search ul").hide();
					                 renderGoodsInfo(json.goodsList[1]);  
					                 $("#btn-submit")[0].disabled = false;
					             }
					             $(".b-public-search ul").append(option);
					         }	
							 $(".b-public-search ul").show();
						}else{
							$(".b-public-search ul").hide();
						}  
			        },
			        error: function(e){
			        	$(".b-reckon-mas").html(e.status+":"+e.statusText+"！<a href='javascript:void(0)' onclick='closeMasages()' >忽略</a>").slideDown(150);
						masagesTimer = setTimeout("closeMasages()",10000);
			        }
				});
			}	
		}		
	});

	function renderGoodsInfo(goods){
		
		$("#txt-goods").val(goods.name);
		$("#txt-goodsid").val(goods.id);
		$.each($("option", "#sel-start-time"), function(index, item){
			if(item.value == goods.sellstart){
				item.selected = "selected";
			}
		});
		
		$.each($("option", "#sel-end-time"), function(index, item){
			if(item.value == goods.sellend){
				item.selected = "selected";
			}
		});
		
		$("#p-goodsstatus").text(goods.goodsstatus);
		$("#p-goodstype").text(goods.goodstype);
		$("#p-usedate").text(goods.usedate);
		$("#p-madetime").text(goods.madetime);
		$("#p-saletype").text(goods.saletype);
		$("#p-startdate").text(goods.startdate);
		if(goods.saletype == "长期"){
			
			$("#p-enddate").text("");
		}else{
			$("#p-enddate").text(goods.enddate);
		}		
		$("#p-initcount").text(goods.initcount);
		
		$.each($("option", "#sel-save-time"), function(index, item){
			if(item.value == goods.needtime){
				item.selected = "selected";
			}
		});
	}
	
	function clearGoodsInfo(){		
		$("option", "#sel-start-time")[0].selected = "selected";
		$("option", "#sel-end-time")[0].selected = "selected";		
		$("#p-goodsstatus").text("");
		$("#p-goodstype").text("");
		$("#p-usedate").text("");
		$("#p-madetime").text("");
		$("#p-saletype").text("");
		$("#p-startdate").text("");
		$("#p-enddate").text("");
		$("#p-initcount").text("");
		$("option", "#sel-save-time")[0].selected = "selected";
	}
	
	$("#produce_set").submit(function(e)
    {    
        if (viladateForm()) 
		{
			//alert("这里假设提交成功！");
			var options = 
			{
				dataType: "",
				type:"post",
				url:"/app/ajax?module=module.production.service&actionid=711&functionid=saveGoodSet",
				success: function(json)
				{
					//乱码处理,后台请将dataType设为空
					json = decodeURIComponent(json);
					json = eval("(" + json + ")");
					alert("提交成功！");
				}
			}
			$(this).ajaxSubmit(options);			
		}
		return false;
    });
	
    //获得焦点
    $("#txt-goods").focus(function()
    {
        this.style.color = "#333";
        this.style.border = "1px #00aeef solid";
        this.style.background = "";
        this.select();
    });
    
    $("#txt-goods").blur(function()
    {
       this.style.border = "";
    });
	
	function viladateForm(){
		return true;
	}
	
    $(document).bind("click", function(e)
    {
        _$.toClick(e, [".b-public-search ul", "#txt-goods"]);
    });