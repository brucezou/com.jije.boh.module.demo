<link rel="stylesheet" type="text/css" href="/moduleresources/module.production.web/resources/css/page_produceSet.css"/>
<div class="b-content-border">
	<div class="b-main-title">
		<span class="b-last-page">MP&C</span>
		<span class="b-navigation">
		您当前的位置：
		<a href="javascript:void(0)">生产控制</a>
		<i>&gt;</i>
		<a href="javascript:void(0)">MP&C</a>
		<i>&gt;</i>
		<s class="b-span-current">生产信息设置</span>
		</s>
	</div>
	<div class="b-content-info">
		<form id="produce_set" action="" name="produce_set">
			<table class="p-table-produce">
				<tr>
					<td class="p-td-label">产品名称：</td>
					<td>
						<div class="b-public-search p-txt-search">
							<input id="txt-goods" type="text" value="美味鸡块"/><input id="txt-goodsid" name="goodsid" type="hidden" value=""/>
							<ul>
								
							</ul>
						</div>								
					</td>
					<td class="p-td-label">售卖时间：</td>
					<td>
						<select id="sel-start-time" name="selstarttime">
						</select>
						至
						<select id="sel-end-time" name="selendtime">
						</select>
					</td>
				</tr>
				<tr>
					<td class="p-td-label">产品状态：</td>
					<td><span id="p-goodsstatus">成品</span></td>
					<td class="p-td-label">产品类型：</td>
					<td><span id="p-goodstype">主食</span></td>
				</tr>
				<tr>
					<td class="p-td-label">保质期：</td>
					<td><span id="p-usedate">90分钟</span></td>
					<td class="p-td-label">标准制作时间：</td>
					<td><span id="p-madetime">17分钟</span></td>
				</tr>
				<tr>
					<td class="p-td-label">产品售卖类型：</td>
					<td><span id="p-saletype">长期</span></td>	
					<td class="p-td-label">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="p-td-label">售卖开始日期：</td>
					<td><span id="p-startdate">2012-02-16</span></td>
					<td class="p-td-label">售卖结束日期：</td>
					<td><span id="p-enddate">&nbsp;</span></td>
				</tr>
				<tr>
					<td class="p-td-label">初始预估千次：</td>
					<td><span id="p-initcount">580</span></td>
					<td class="p-td-label">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="p-td-label">需存量时间：</td>
					<td>
						<select id="sel-save-time" name="selneedtime">
						</select>
					</td>
					<td class="p-td-label">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4">
						<input id="btn-submit" type="submit" class="b-public-bigbtn" value="提交">
					</td>
				</tr>
			</table>					
		</form>
	</div>
</div>
<script type="text/javascript" src="/moduleresources/module.production.web/resources/scripts/page_produceSet.js" charset="utf-8"/>