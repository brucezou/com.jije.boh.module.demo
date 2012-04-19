(function(window) {

	$(".b-last-page")
			.click(
					function() {
						public_load_ajax(".b-mian-content", "/app/index",
								"module=module.production.web&template=html_produce.ftl");// 生产控制
					});

	$(".b-navigation a")
			.click(
					function() {
						public_load_ajax(".b-mian-content", "/app/index",
								"module=module.production.web&template=html_produce.ftl");// 生产控制
					});

	$("#date_produceInit").val(_$.getTime());

	$("#date_produceInit").click(function() {
		_$.date.exec({
			txtTime : "#date_produceInit"
		});
	})

	renderTh();
	var goodslist;
	$.ajax({
		type : "POST",
		url : "/app/ajax",
		data : "module=module.production.service&actionid=712&function=7121",
		dataType : '',
		success : function(json) {
			// 数据加载
			// 乱码处理,后台请将dataType设为空
			json = decodeURIComponent(json);
			json = eval("(" + json + ")");
			goodslist = json.goodslist;
			$("#p-now-date").text(json.time);
			$("#p-res-name").text(json.name);
			$("#p-operator")
					.text(
							json.operator.realname + "("
									+ json.operator.username + ")");

			$.each(goodslist, function(index, item) {

				if (index % 2 == 0) {
					renderGoods(item, "p-tr-bg");
				} else {
					renderGoods(item, "");
				}
			});
		},
		error : function(e) {
			alert("Err!");
		}
	});

	$("#btn-ok")
			.click(
					function() {

						var th1 = $("#table1 tr").eq(0);
						$("#table1").html("").append(th1);

						var th2 = $("#table2 tr").eq(0);
						$("#table2").html("").append(th2);

						$
								.ajax({
									type : "POST",
									url : "/app/ajax",
									data : "module=module.production.service&actionid=712&function=7121&date_produceInit="
											+ $('#date_produceInit').val(),
									dataType : '',
									success : function(json) {
										// 乱码处理,后台请将dataType设为空
										json = decodeURIComponent(json);
										json = eval("(" + json + ")");
										// 数据加载
										goodslist = json.goodslist;

										$.each(goodslist,
												function(index, item) {

													if (index % 2 == 0) {
														renderGoods(item,
																"p-tr-bg");
													} else {
														renderGoods(item, "");
													}
												});
									},
									error : function(e) {
										alert("Err!");
									}
								});
					});

	function renderTh() {
		var tr = $("<tr>");
		for ( var i = 0; i < 24; i++) {
			var th1 = $("<th>");
			var span1 = $("<span>").text(i + ":00");
			var span2 = $("<span>").text("-");
			var span3 = $("<span>").text(i + ":30");
			th1.append(span1, span2, span3);
			var th2 = $("<th>");
			var span4 = $("<span>").text(i + ":30");
			var span5 = $("<span>").text("-");
			var span6 = $("<span>").text((i + 1) + ":00");
			th2.append(span4, span5, span6);
			tr.append(th1, th2);
		}
		$("#table2").append(tr);
	}

	function renderGoods(goods, trClass) {

		var tr1 = $("<tr>").addClass(trClass);
		var td1 = $("<td>").attr({
			rowspan : "2",
			id : "goods_" + goods.id
		}).addClass("p-goods-name").append(goods.name, "<br>",
				"(" + goods.unit + ")");
		var td2 = $("<td>").text("初始预估值");
		td1[0].setAttribute("goodsId", goods.id);

		var td3 = $("<td>").text(goods.initaltotal);
		tr1.append(td1, td2, td3);
		var tr2 = $("<tr>").addClass(trClass);
		var td4 = $("<td>").text("需存量");
		var td5 = $("<td>").html("&nbsp;");
		tr2.append(td4, td5);
		$("#table1").append(tr1, tr2);
		td1
				.hover(
						function() {
							this.parentNode.style.background = "#e7f6ff";
							this.parentNode.nextElementSibling.style.background = "#e7f6ff";
							$("#table2 tr")[this.parentNode.rowIndex].style.background = "#e7f6ff";
							$("#table2 tr")[this.parentNode.rowIndex + 1].style.background = "#e7f6ff";
						},
						function() {
							this.parentNode.style.background = "";
							this.parentNode.nextElementSibling.style.background = "";
							$("#table2 tr")[this.parentNode.rowIndex].style.background = "";
							$("#table2 tr")[this.parentNode.rowIndex + 1].style.background = "";
						});

		td1.click(function() {
			var coord = _$.coord(this);
			$(".p-popup").css({
				top : coord.top - 35,
				left : coord.left + 100
			}).show();
			var goodsId = this.getAttribute("goodsId");
			bindOkbtn(goodsId);
		});

		td2
				.hover(
						function() {
							this.style.background = "#e7f6ff";
							this.nextElementSibling.style.background = "#e7f6ff";
							$("#table2 tr")[this.parentNode.rowIndex].style.background = "#e7f6ff";
						},
						function() {
							this.style.background = "";
							this.nextElementSibling.style.background = "";
							$("#table2 tr")[this.parentNode.rowIndex].style.background = "";
						});
		td3
				.hover(
						function() {
							this.style.background = "#e7f6ff";
							this.previousElementSibling.style.background = "#e7f6ff";
							$("#table2 tr")[this.parentNode.rowIndex].style.background = "#e7f6ff";
						},
						function() {
							this.style.background = "";
							this.previousElementSibling.style.background = "";
							$("#table2 tr")[this.parentNode.rowIndex].style.background = "";
						});
		td4
				.hover(
						function() {
							this.style.background = "#e7f6ff";
							this.nextElementSibling.style.background = "#e7f6ff";
							$("#table2 tr")[this.parentNode.rowIndex].style.background = "#e7f6ff";
						},
						function() {
							this.style.background = "";
							this.nextElementSibling.style.background = "";
							$("#table2 tr")[this.parentNode.rowIndex].style.background = "";
						});
		td5
				.hover(
						function() {
							this.style.background = "#e7f6ff";
							this.previousElementSibling.style.background = "#e7f6ff";
							$("#table2 tr")[this.parentNode.rowIndex].style.background = "#e7f6ff";
						},
						function() {
							this.style.background = "";
							this.previousElementSibling.style.background = "";
							$("#table2 tr")[this.parentNode.rowIndex].style.background = "";
						});
		var tr3 = $("<tr>").addClass(trClass);
		$
				.each(
						goods.initialtimes,
						function(index, item) {
							var td = $("<td>").text(item);
							td
									.hover(
											function() {
												this.parentNode.style.background = "#e7f6ff";
												$("#table1 tr")[this.parentNode.rowIndex].cells[1].style.background = "#e7f6ff";
												$("#table1 tr")[this.parentNode.rowIndex].cells[2].style.background = "#e7f6ff";
											},
											function() {
												this.parentNode.style.background = "";
												$("#table1 tr")[this.parentNode.rowIndex].cells[1].style.background = "";
												$("#table1 tr")[this.parentNode.rowIndex].cells[2].style.background = "";
											});
							tr3.append(td);
						});
		$("#table2").append(tr3);

		var tr4 = $("<tr>").addClass(trClass);
		$
				.each(
						goods.needtimes,
						function(index, item) {
							var td = $("<td>").text(item);
							td
									.hover(
											function() {
												this.parentNode.style.background = "#e7f6ff";
												$("#table1 tr")[this.parentNode.rowIndex].cells[0].style.background = "#e7f6ff";
												$("#table1 tr")[this.parentNode.rowIndex].cells[1].style.background = "#e7f6ff";
											},
											function() {
												this.parentNode.style.background = "";
												$("#table1 tr")[this.parentNode.rowIndex].cells[0].style.background = "";
												$("#table1 tr")[this.parentNode.rowIndex].cells[1].style.background = "";
											});
							tr4.append(td);
						});
		$("#table2").append(tr4);
	}

	function bindOkbtn(goodsId) {

		$("#btn-submit").unbind("click");
		$("#btn-submit")
				.click(
						function() {
							if (viladateData()) {
								$
										.ajax({
											type : "POST",
											url : "/app/ajax",
											data : "module=module.production.service&actionid=712&function=7122&goodsId="
													+ goodsId
													+ "&ttccount="
													+ $('#p-txt-count').val(),
											dataType : '',
											success : function(json) {

												json = decodeURIComponent(json);
												json = eval("(" + json + ")");
												
												$(".p-popup").hide();
												callBackGoods(json);
											},
											error : function(e) {
												alert("Err!");
											}
										});
							}
						});
	}

	function viladateData() {
		if ($("#p-txt-count").val() == "" || isNaN($("#p-txt-count").val())) {

			$("#p-txt-count")[0].style.border = "1px red solid";
			$("#p-txt-count")[0].style.background = "#fbe2e2";
			$("#p-txt-count")[0].style.color = "red";
			return false;
		}
		return true;
	}

	function callBackGoods(goods) {
		$
				.each(
						goods.initialtimes,
						function(index, item) {
							$("#table2 tr")[$("#goods_" + goods.id)[0].parentNode.rowIndex].cells[index].textContent = item;

						});
		$
				.each(
						goods.needtimes,
						function(index, item) {
							$("#table2 tr")[$("#goods_" + goods.id)[0].parentNode.rowIndex + 1].cells[index].textContent = item;
						});
		$("#table1 tr")[$("#goods_" + goods.id)[0].parentNode.rowIndex].cells[2].textContent = goods.initaltotal;
	}

	$("#p-txt-count").focus(function() {

		this.style.color = "#333";
		this.style.border = "1px #00aeef solid";
		this.style.background = "";
		this.select();
	});

	$("#p-txt-count").blur(function() {
		if (this.value.length == 0 || isNaN(this.value)) {
			this.style.border = "1px red solid";
			this.style.background = "#fbe2e2";
			this.style.color = "red";
		} else {
			this.style.border = "";
		}
	});

})(window);