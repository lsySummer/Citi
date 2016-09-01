<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link href="../css/order.css" rel="stylesheet">
<link href="../css/mycss.css" rel="stylesheet">
</head>
<body style="background-color: #EAEAEA; margin: 0">
	<s:include value="header.jsp"></s:include>
	<div class="main" style="height: 500px">
		<button class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">银行理财</button>

		<button class="btn btn-primary" data-toggle="modal"
			data-target="#mycModal">储蓄式债券</button>

		<button class="btn btn-primary" data-toggle="modal"
		data-target="#myjModal">记账式债券</button>

		<button class="btn btn-primary" data-toggle="modal"
			data-target="#mymModal">基金</button>

		<button class="btn btn-primary" data-toggle="modal"
			data-target="#mybModal">保险</button>

		<!-- 银行理财模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 550px; height: 800px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
					</div>
					<div class="modal-body" style="">
						<div style="height: 180px;">
							<div class="product-bigicon icon-manage">
								<span style="font-size: 35px"><b>2.95</b></span><br /> <span
									style="font-size: 8px;">年化收益率</span>
								<hr class="line" />
								<div style="margin-top: -10%;'">
									<span style="font-size: 20px"><b>银行理财</b></span>
								</div>
							</div>
							<div class="rightPart">
								<span style="font-size: 22px">稳添利80天公积金</span><br /> <span
									style="font-size: 14px">起购金额：￥10000</span><br /> <span
									style="font-size: 14px">开放日/到期日：2016.09.09</span><br />
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
							<div class="smallBlock"></div>
							<div style="float: left; width: 400px; height: 30px">
								<span class="blueFont">详细信息</span>
							</div>

							<div class="infoBlock">
								<div class="detailDiv">
									<span class="typeFont">基本信息</span><br /> <span>产品名称</span><br />
									<span>产品期次</span><br /> <span>管理机构</span><br /> <span>托管机构托管机构哦</span><br />
								</div>
								<div class="detailDiv">
									<br /> <span class="typeFont">稳添利80天公积金</span><br /> <span
										class="typeFont">1234567</span><br /> <span class="typeFont">XX基金公司</span><br />
									<span class="typeFont">XX银行</span><br />
								</div>
							</div>

							<div class="infoBlock">
								<div class="detailDiv">
									<span class="typeFont">风险收益</span><br /> <span>预计年化收益率</span><br />
									<span>收益类型</span><br /> <span>风险等级</span><br />
								</div>
								<div class="detailDiv">
									<br /> <span class="typeFont">2.44</span><br /> <span
										class="typeFont">$55.50</span><br /> <span class="typeFont">399</span><br />
								</div>
							</div>

							<div class="infoBlock">
								<div class="detailDiv">
									<span class="typeFont">申请赎回</span><br /> <span>是否净值型</span><br />
									<span>是否封闭</span><br /> <span>申购费率</span><br /> <span>赎回费率</span><br />
									<span>广义管理费率</span><br /> <span>起购金额</span><br /> <span>递增购买最小单位</span><br />
									<span>募集开始日</span><br /> <span>募集截止日</span><br /> <span>起息日</span><br />
									<span>开发日</span><br /> <span>期限</span><br /> <span>赎回速度</span><br />
								</div>
								<div class="detailDiv">
									<br /> <span class="typeFont">2.44</span><br /> <span
										class="typeFont">$55.50</span><br /> <span class="typeFont">399</span><br />
									<span class="typeFont">股票型</span><br /> <span class="typeFont">3.55</span><br />
									<span class="typeFont">399</span><br /> <span class="typeFont">2.44</span><br />
									<span class="typeFont">$55.50</span><br /> <span
										class="typeFont">399</span><br /> <span class="typeFont">399</span><br />
									<span class="typeFont">2.44</span><br /> <span
										class="typeFont">$55.50</span><br /> <span class="typeFont">399</span><br />
								</div>
							</div>

							<div class="infoBlock">
								<div class="detailDiv">
									<span class="typeFont">投资范围</span><br /> <span>理财币种</span><br />
									<span>投资范围</span><br /> <span>投资比例</span><br />
								</div>
								<div class="detailDiv">
									<br /> <span class="typeFont">人民币</span><br /> <span
										class="typeFont">1000</span><br /> <span class="typeFont">20%</span><br />
								</div>
							</div>

							<div class="infoBlock">
								<div class="detailDiv">
									<span class="typeFont">其他</span><br /> <span>产品编码</span><br />
									<span>等级编码</span><br /> <span>销售区域</span><br /> <span>运行规模上限</span><br />
									<span>理财本金及收益支付</span><br /> <span>发行对象</span><br />
								</div>
								<div class="detailDiv">
									<br /> <span class="typeFont">123545</span><br /> <span
										class="typeFont">10</span><br /> <span class="typeFont">全国</span><br />
									<span class="typeFont">123545</span><br /> <span
										class="typeFont">10</span><br /> <span class="typeFont">全国</span><br />
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 储蓄式债券模态框（Modal） -->
	<div class="modal fade" id="mycModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 550px; height: 600px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
				</div>
				<div class="modal-body" style="">
					<div style="height: 180px;">
						<div class="product-bigicon icon-bond">
							<span style="font-size: 35px"><b>7.00</b></span><br /> <span
								style="font-size: 8px;">年利率</span>
							<hr class="line" />
							<div style="margin-top: -10%;'">
								<span style="font-size: 20px"><b>债券</b></span>
							</div>
						</div>
						<div class="rightPart">
							<span style="font-size: 22px">2016年储蓄式附息(十七期)国债 160017</span><br />
							<span style="font-size: 14px">承保年龄：30-65周岁</span><br /> <span
								style="font-size: 14px">保险期限：20年</span><br />
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
						<div class="smallBlock"></div>
						<div style="float: left; width: 400px; height: 30px">
							<span class="blueFont">详细信息</span>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">基本信息</span><br /> <span>债券名称</span><br />
								<span>债券简称</span><br /> <span>债券代码</span><br /> <span>债券分类</span><br />
								<span>发行单位</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">2016年记账式附息(十七期)国债 </span><br />
								<span class="typeFont">21国债(7)</span><br /> <span
									class="typeFont">19423</span><br /> <span class="typeFont">储蓄式</span><br />
								<span class="typeFont">财政部</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">风险收益</span><br /> <span>票面利率</span><br />
								<span>调整后年利率</span><br /> <span>计息、付息方式</span><br /> <span>付息频率(整数次/年)</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">2.44</span><br /> <span
									class="typeFont">$55.50</span><br /> <span class="typeFont">399</span><br />
								<span class="typeFont">39</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">申请赎回</span><br /> <span>期限</span><br />
								<span>发行起始日</span><br /> <span>发行截止日</span><br /> <span>状态</span><br />
								<span>到期日</span><br /> <span>起息日</span><br /> <span>提前兑取开始日期</span><br />
								<span>提前兑现计息开始日期</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">2</span><br /> <span
									class="typeFont">2014.02.10</span><br /> <span
									class="typeFont">2014.06.10</span><br /> <span
									class="typeFont">发行中</span><br /> <span class="typeFont">2015.02.03</span><br />
								<span class="typeFont">2015.03.06</span><br /> <span
									class="typeFont">2016.09.03</span><br /> <span
									class="typeFont">2016.09.06</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">其他</span><br /> <span>面值(元)</span><br />
								<span>发行价(元)</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">12</span><br /> <span
									class="typeFont">10</span><br />
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->

	<!-- 记账式债券模态框（Modal） -->
	<div class="modal fade" id="myjModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 550px; height: 800px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
				</div>
				<div class="modal-body" style="">
					<div style="height: 180px;">
						<div class="product-bigicon icon-bond">
							<span style="font-size: 35px"><b>7.00</b></span><br /> <span
								style="font-size: 8px;">年利率</span>
							<hr class="line" />
							<div style="margin-top: -10%;'">
								<span style="font-size: 20px"><b>债券</b></span>
							</div>
						</div>
						<div class="rightPart">
							<span style="font-size: 22px">2016年记账式附息(十七期)国债 160017</span><br />
							<span style="font-size: 14px">承保年龄：30-65周岁</span><br /> <span
								style="font-size: 14px">保险期限：20年</span><br />
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
						<div class="smallBlock"></div>
						<div style="float: left; width: 400px; height: 30px">
							<span class="blueFont">详细信息</span>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">基本信息</span><br /> <span>债券名称</span><br />
								<span>债券简称</span><br /> <span>债券代码</span><br /> <span>债券分类</span><br />
								<span>发行单位</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">2016年记账式附息(十七期)国债 </span><br />
								<span class="typeFont">21国债(7)</span><br /> <span
									class="typeFont">19423</span><br /> <span class="typeFont">记账式</span><br />
								<span class="typeFont">财政部</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">风险收益</span><br /> <span>票面利率</span><br />
								<span>调整后年利率</span><br /> <span>计息、付息方式</span><br /> <span>付息频率(整数次/年)</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">2.44</span><br /> <span
									class="typeFont">$55.50</span><br /> <span class="typeFont">399</span><br />
								<span class="typeFont">39</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">申请赎回</span><br /> <span>期限</span><br />
								<span>发行起始日</span><br /> <span>发行截止日</span><br /> <span>状态</span><br />
								<span>到期日</span><br /> <span>起息日</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">2</span><br /> <span
									class="typeFont">2014.02.10</span><br /> <span
									class="typeFont">2014.06.10</span><br /> <span
									class="typeFont">发行中</span><br /> <span class="typeFont">2015.02.03</span><br />
								<span class="typeFont">2015.03.06</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">其他</span><br /> <span>面值(元)</span><br />
								<span>发行价(元)</span><br /> <span>上市地</span><br /> <span>发布时间</span><br />
								<span>上市流通日</span><br /> <span>发行额(亿元)</span><br /> <span>兑讨价(元)</span><br />
								<span>认购对象</span><br /> <span>债券价值</span><br /> <span>信用级别</span><br />
								<span>发行方式</span><br /> <span>发行对象</span><br /> <span>主乘销机构</span><br />
								<span>税收状况</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">100</span><br /> <span
									class="typeFont">100</span><br /> <span class="typeFont">南京</span><br />
								<span class="typeFont">2014.03.06</span><br /> <span
									class="typeFont">2014.05.03</span><br /> <span
									class="typeFont">20</span><br /> <span class="typeFont">100</span><br />
								<span class="typeFont">人民币</span><br /> <span class="typeFont">333</span><br />
								<span class="typeFont">5</span><br /> <span class="typeFont">发行方式</span><br />
								<span class="typeFont">发行对象</span><br /> <span class="typeFont">主乘销机构</span><br />
								<span class="typeFont">良好</span><br />
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->

	<!-- 基金模态框（Modal） -->
	<div class="modal fade" id="mymModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 550px; height: 800px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
				</div>
				<div class="modal-body" style="">
					<div style="height: 180px;">
						<div class="product-bigicon icon-fund">
							<span style="font-size: 35px"><b>2.95</b></span><br /> <span
								style="font-size: 8px;">收益率</span>
							<hr class="line" />
							<div style="margin-top: -10%;'">
								<span style="font-size: 20px"><b>基金</b></span>
							</div>
						</div>
						<div class="rightPart">
							<span style="font-size: 22px">一个基金</span><br /> <span
								style="font-size: 14px">最新净值：￥5000</span><br /> <span
								style="font-size: 14px">状态：认购中</span><br />
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
						<div class="smallBlock"></div>
						<div style="float: left; width: 400px; height: 30px">
							<span class="blueFont">详细信息</span>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">基本信息</span><br /> <span>法定名称</span><br />
								<span>基金编号</span><br /> <span>管理机构</span><br /> <span>托管机构</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">稳添利80天公积金 </span><br /> <span
									class="typeFont">123654</span><br /> <span class="typeFont">ab基金公司</span><br />
								<span class="typeFont">cd银行</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">风险收益</span><br /> <span>近一年收益率</span><br />
								<span>最新净值</span><br /> <span>份额净值</span><br /> <span>基金投资目标类型</span><br />
								<span>业绩比较基准</span><br /> <span>跟踪标的</span><br /> <span>风险等级</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">2.44</span><br /> <span
									class="typeFont">$55.50</span><br /> <span class="typeFont">399</span><br />
								<span class="typeFont">股票型</span><br /> <span class="typeFont">$55.50</span><br />
								<span class="typeFont">399</span><br /> <span class="typeFont">股票型</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">申购赎回</span><br /> <span>状态</span><br />
								<span>是否封闭</span><br /> <span>申购费率</span><br /> <span>赎回费率</span><br />
								<span>广义管理费率</span><br /> <span>起购金额</span><br /> <span>递增购买最小单位</span><br />
								<span>募集开始日</span><br /> <span>募集截止日</span><br /> <span>起息日</span><br />
								<span>开发日</span><br /> <span>期限</span><br /> <span>认购速度</span><br />
								<span>赎回速度</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">2</span><br /> <span
									class="typeFont">是</span><br /> <span class="typeFont">20%</span><br />
								<span class="typeFont">25%</span><br /> <span class="typeFont">2%</span><br />
								<span class="typeFont">30</span><br /> <span class="typeFont">2014.02.10</span><br />
								<span class="typeFont">2014.06.10</span><br /> <span
									class="typeFont">发行中</span><br /> <span class="typeFont">2015.02.03</span><br />
								<span class="typeFont">2015.03.06</span><br /> <span
									class="typeFont">发行中</span><br /> <span class="typeFont">2015.02.03</span><br />
								<span class="typeFont">2015.03.06</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">其他</span><br /> <span>基金经理</span><br />
								<span>基金规模</span><br /> <span>份额规模</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">100</span><br /> <span
									class="typeFont">100</span><br /> <span class="typeFont">100</span><br />
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->

	<!-- 保险模态框（Modal） -->
	<div class="modal fade" id="mybModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 550px; ">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
				</div>
				<div class="modal-body" style="">
					<div style="height: 180px;">
						<div class="product-bigicon icon-insurance">
							<span style="font-size: 35px"><b>12.95</b></span><br /> <span
								style="font-size: 8px;">预计收益率</span>
							<hr class="line" />
							<div style="margin-top: -10%;'">
								<span style="font-size: 20px"><b>保险</b></span>
							</div>
						</div>
						<div class="rightPart">
							<span style="font-size: 22px">养老保险</span><br /> <span
								style="font-size: 14px">承保年龄：30-65周岁</span><br /> <span
								style="font-size: 14px">保险期限：20年</span><br />
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
						<div class="smallBlock"></div>
						<div style="float: left; width: 400px; height: 30px">
							<span class="blueFont">详细信息</span>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">基本信息</span><br /> <span>险种名称</span><br />
								<span>产品发行公司</span><br /> <span>购偿金额</span><br /> <span>保险产品面额</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">xx万能两险 </span><br /> <span
									class="typeFont">保险公司</span><br /> <span class="typeFont">20万</span><br />
								<span class="typeFont">20万</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">保险收益</span><br /> <span>单位金额赔偿</span><br />
								<span>年化收益率</span><br /> <span>年结算利率/预计收益率</span><br /> <span>保证利率</span><br />
								<span>预期利率</span><br /> <span>日结算利率</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">2.44</span><br /> <span
									class="typeFont">$55.50</span><br /> <span class="typeFont">399</span><br />
								<span class="typeFont">股票型</span><br /> <span class="typeFont">$55.50</span><br />
								<span class="typeFont">399</span><br />
							</div>
						</div>

						<div class="infoBlock">
							<div class="detailDiv">
								<span class="typeFont">购买相关</span><br /> <span>交费方式</span><br />
								<span>保障年限</span><br /> <span>购买日</span><br /> <span>到期日</span><br />
								<span>期限</span><br />
							</div>
							<div class="detailDiv">
								<br /> <span class="typeFont">一次交清</span><br /> <span
									class="typeFont">终生</span><br /> <span class="typeFont">2016.09.13</span><br />
								<span class="typeFont">2016.09.13</span><br /><span class="typeFont">100</span><br />
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->



</body>
</html>