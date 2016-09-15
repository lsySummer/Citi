<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>


		<!-- 银行理财模态框（Modal） -->
		<div class="modal fade" id="mymModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 550px; height: 1400px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
					</div>
					<div class="modal-body" style="">
				<div style="height: 180px;">
						<div class="product-bigicon fund-circle">
							<span style="font-size: 35px"><b><s:property value="#product.productFund.expectedRate"/></b></span><br /> <span
								style="font-size: 8px;">收益率</span>
							<hr class="line" />
							<div style="margin-top: -10%;'">
								<span style="font-size: 20px"><b>基金</b></span>
							</div>
						</div>
						<div class="rightPart">
							<span style="font-size: 22px"><s:property value="#product.name"/></span><br /> <span
								style="font-size: 14px">最新净值：¥<s:property value="#product.net_value"/></span><br /> <span
								style="font-size: 14px">状态：<s:property value="#product.state"/></span><br />
							<button class="block-button"
								style="font-size: 20px; margin-top: 10px">购 &nbsp
								&nbsp买</button>
						</div>
					</div>

					<div style="height: 180px; margin-top: 2%">
						<div class="smallBlock"></div>
						<span class="blueFont">收益曲线</span>
						<div class="income"></div>
					</div>
					<div style="height: 100%; margin-top: 2%">
					<table border="0"  style="margin-left: 5%; width: 90%;">
						<tr>
							<td><span class="typeFont">基本信息</span></td>
							<td><span style="font-size: 14px"></span></td>
						</tr>
						<tr>
							<td valign="top"><span style="font-size: 14px">法定名称</span></td>
							<td><span class="typeFont"><s:property value="#product.name"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">基金编号</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.productCode"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">管理机构</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.institutionManage"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">托管机构</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.custodian"/></span></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><span class="typeFont">风险收益</span></td>
							<td><span class="typeFont"></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">近一年收益率</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.yearlyRtnRate"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">最新净值</span></td>
							<td><span class="typeFont">¥<s:property value="#product.net_value"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">复权净值</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.adjustNav"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">基金投资目标类型</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.category"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">业绩比较基准</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.perfBenchmark"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">跟踪标的</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.targetId"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">风险等级</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.riskLevel"/></span></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><span class="typeFont">申购赎回</span></td>
							<td><span class="typeFont"></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">状态</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.state"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">是否封闭</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.operationMode"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">申购费率</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.ratePurchase"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">赎回费率</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.rateRedem"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">广义管理费率</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.rateManage"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">起购金额</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.purchaseThreshold"/></span></td>
						</tr>
							<tr>
							<td><span style="font-size: 14px">递增购买最小单位</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.increasingUnit"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">募集开始日</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.onPurchaseDate"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">募集截止日</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.offPurchaseDate"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">起息日</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.firstAccrDate"/></span></td>
						</tr>
							<tr>
							<td><span style="font-size: 14px">开放日</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.onRedemptionDate"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">期限</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.length"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">认购速度</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.subscribeSpeed"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">赎回速度</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.redemSpeed"/></span></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><span class="typeFont">其他</span></td>
							<td><span class="typeFont"></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">基金经理</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.managerName"/></span></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">基金规模</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.fundSize"/></span></td>
						</tr>
												<tr>
							<td><span style="font-size: 14px">份额规模</span></td>
							<td><span class="typeFont"><s:property value="#product.productFund.shareSize"/></span></td>
						</tr>
					
					</table>
					</div>

				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</html>