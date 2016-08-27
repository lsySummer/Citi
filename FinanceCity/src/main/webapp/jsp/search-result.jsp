<%--
  Created by IntelliJ IDEA.
  User: Hermit
  Date: 16/8/24
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString();
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link type="text/css" rel="stylesheet" href="plugins/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/buttons.css"/>
    <link type="text/css" rel="stylesheet" href="plugins/font-awesome-4.6.3/css/font-awesome.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/common.css"/>
    <link type="text/css" rel="stylesheet" href="css/searchResult.css"/>
    <link type="text/css" rel="stylesheet" href="css/order.css"/>
    <link type="text/css" rel="stylesheet" href="css/mycss.css"/>   

    <script type="text/javascript" rel="script" src="js/jquery.min.js"></script>
    <script type="text/javascript" rel="script" src="plugins/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="js/searchResult.js"></script>

    <title>搜索结果</title>
</head>
<body>
<div class="main-content">
    <div class="selection-wrapper">
        <div class="keyword-wrapper">
            <label>关键字</label>
            <input type="text"/>
            <button id="sift_product_button" class="button button-3d button-primary button-rounded" type="button">筛选产品</button>
        </div>
        <div class="quota-wrapper">
            <div class="quota-item">
                <label>投资标的</label>
                <select class="selector input-add-on-field">
                    <option class="display-none"></option>
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
                <select class="selector input-add-on-field">
                    <option class="display-none"></option>
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
            </div>
            <div class="quota-item">
                <label>风险收益</label>
                <select class="selector input-add-on-field">
                    <option class="display-none"></option>
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
            </div>
            <div class="quota-item">
                <label>收益类型</label>
                <select class="selector input-add-on-field">
                    <option class="display-none"></option>
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
            </div>
        </div>
        <div class="quota-wrapper">
            <div class="quota-item">
                <label>投资期限</label>
                <select class="selector">
                    <option class="display-none"></option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
            </div>
            <div class="quota-item">
                <label>购买至生效时间</label>
                <select class="selector">
                    <option class="display-none"></option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
            </div>
            <div class="quota-item">
                <label>申请赎回到账时间</label>
                <select class="selector">
                    <option class="display-none"></option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
            </div>
        </div>
        <div class="quota-wrapper">
            <div class="quota-item">
                <label>数值范围</label>
                <input class="num-range" type="text"/>
                <label class="line"></label>
                <input class="num-range" type="text"/>
            </div>
        </div>
    </div>
    <div class="product-wrapper">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
         <div class="modal-dialog" style="width:500px;height:800px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
					</div>
					<div class="modal-body" style="">
					<div style="height:180px;">
						<div class="product-bigicon icon-manage">
							<span style="font-size:35px"><b>2.95</b></span><br/>
							<span style="font-size: 8px;">年化收益率</span>
							<hr class="line"/>
							<div style="margin-top:-10%;'">
							<span style="font-size:20px"><b>银行理财</b></span>
							</div>
						</div>
						<div class="rightPart">
							<span style="font-size:22px">稳添利80天公积金</span><br/>
							<span style="font-size:14px">起购金额：￥10000</span><br/>
							<span style="font-size:14px">开放日/到期日：2016.09.09</span><br/>
							<button class="block-button" style="font-size:20px;margin-top:10px">购 &nbsp &nbsp买</button>
						</div>
					</div>
					
					<div style="height:180px;margin-top:2%">
					<div class="smallBlock"></div>
						<span class="blueFont">收益曲线</span>
						<div class="income"></div>
					</div>
					
					<div style="height:100%;margin-top:2%">
						<div class="smallBlock"></div>
						<div style="float:left;width:400px;height:30px">
							<span class="blueFont">详细信息</span>
						</div>
						
						<div class="infoBlock">
						<div class="detailDiv">
							<span class="typeFont">基本信息</span><br/>
							<span>产品名称</span><br/>
							<span>产品期次</span><br/>
							<span>管理机构</span><br/>
							<span>托管机构托管机构哦</span><br/>
						</div>
						<div class="detailDiv">
							<br/>
							<span class="typeFont">稳添利80天公积金</span><br/>
							<span class="typeFont">1234567</span><br/>
							<span class="typeFont">XX基金公司</span><br/>
							<span class="typeFont">XX银行</span><br/>
						</div>
						</div>
						
						<div class="infoBlock">
						<div class="detailDiv">
							<span class="typeFont">风险收益</span><br/>
							<span>预计年化收益率</span><br/>
							<span>收益类型</span><br/>
							<span>风险等级</span><br/>
						</div>
						<div class="detailDiv">
							<br/>
							<span class="typeFont">2.44</span><br/>
							<span class="typeFont">$55.50</span><br/>
							<span class="typeFont">399</span><br/>
						</div>
						</div>
						
						<div class="infoBlock">
						<div class="detailDiv">
							<span class="typeFont">申请赎回</span><br/>
							<span>是否净值型</span><br/>
							<span>是否封闭</span><br/>
							<span>申购费率</span><br/>
							<span>赎回费率</span><br/>
							<span>广义管理费率</span><br/>
							<span>起购金额</span><br/>
							<span>递增购买最小单位</span><br/>
							<span>募集开始日</span><br/>
							<span>募集截止日</span><br/>
							<span>起息日</span><br/>
							<span>开发日</span><br/>
							<span>期限</span><br/>
							<span>赎回速度</span><br/>
						</div>
						<div class="detailDiv">
							<br/>
							<span class="typeFont">2.44</span><br/>
							<span class="typeFont">$55.50</span><br/>
							<span class="typeFont">399</span><br/>
							<span class="typeFont">股票型</span><br/>
							<span class="typeFont">3.55</span><br/>
							<span class="typeFont">399</span><br/>
							<span class="typeFont">2.44</span><br/>
							<span class="typeFont">$55.50</span><br/>
							<span class="typeFont">399</span><br/>
							<span class="typeFont">399</span><br/>
							<span class="typeFont">2.44</span><br/>
							<span class="typeFont">$55.50</span><br/>
							<span class="typeFont">399</span><br/>
						</div>
						</div>
						
						<div class="infoBlock">
						<div class="detailDiv">
							<span class="typeFont">投资范围</span><br/>
							<span>理财币种</span><br/>
							<span>投资范围</span><br/>
							<span>投资比例</span><br/>
						</div>
						<div class="detailDiv">
							<br/>
							<span class="typeFont">人民币</span><br/>
							<span class="typeFont">1000</span><br/>
							<span class="typeFont">20%</span><br/>
						</div>
						</div>
						
							<div class="infoBlock">
						<div class="detailDiv">
							<span class="typeFont">其他</span><br/>
							<span>产品编码</span><br/>
							<span>等级编码</span><br/>
							<span>销售区域</span><br/>
							<span>运行规模上限</span><br/>
							<span>理财本金及收益支付</span><br/>
							<span>发行对象</span><br/>
						</div>
						<div class="detailDiv">
							<br/>
							<span class="typeFont">123545</span><br/>
							<span class="typeFont">10</span><br/>
							<span class="typeFont">全国</span><br/>
							<span class="typeFont">123545</span><br/>
							<span class="typeFont">10</span><br/>
							<span class="typeFont">全国</span><br/>
						</div>
						</div>
					</div>
					</div>
					
					</div>
					
				</div>
        </div>
        <div class="product bank-financing" data-toggle="modal" data-target="#myModal">
            <div class="circle">
                <h1>2.95</h1>
                <h4>年化收益率</h4>
                <hr>
                <h3>银行理财</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">收益类型</span>
                    <span class="column-item info">非保本浮动收益型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">起购金额</span>
                    <span class="column-item info">¥500000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行银行</span>
                    <span class="column-item info">浦发银行</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行机构</span>
                    <span class="column-item info">浦发银行</span>
                </div>
            </div>
        </div>
        <div class="product fund" data-toggle="modal" data-target="#myModal">
            <div class="circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">产品状态</span>
                    <span class="column-item info">采购中</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">最新净值</span>
                    <span class="column-item info">¥200</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品编号</span>
                    <span class="column-item info">600000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">基金类型</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">管理费率</span>
                    <span class="column-item info">4.5</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">成立日</span>
                    <span class="column-item info">2016.08.20</span>
                </div>
            </div>
        </div>
        <div class="product insurance" data-toggle="modal" data-target="#myModal">
            <div class="circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">保障年限</span>
                    <span class="column-item info">终身</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">保障年龄</span>
                    <span class="column-item info">30岁</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">保额区间</span>
                    <span class="column-item info">¥0~¥500000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">缴费方式</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行机构</span>
                    <span class="column-item info">简单基金</span>
                </div>
            </div>
        </div>
        <div class="product bond" data-toggle="modal" data-target="#myModal">
            <div class="circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">票面利率</span>
                    <span class="column-item info">2.95</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">期限</span>
                    <span class="column-item info">2年</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">到期日</span>
                    <span class="column-item info">2016.08。20</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">债券类型</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">债券代码</span>
                    <span class="column-item info">390200</span>
                </div>
            </div>
        </div>
        <div class="product bank-financing" data-toggle="modal" data-target="#myModal">
            <div class="circle empty-circle">
                <h1>2.95</h1>
                <h4>年化收益率</h4>
                <hr>
                <h3>银行理财</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">收益类型</span>
                    <span class="column-item info">非保本浮动收益型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">起购金额</span>
                    <span class="column-item info">¥500000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行银行</span>
                    <span class="column-item info">浦发银行</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行机构</span>
                    <span class="column-item info">浦发银行</span>
                </div>
            </div>
        </div>
        <div class="product fund" data-toggle="modal" data-target="#myModal">
            <div class="circle empty-circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">产品状态</span>
                    <span class="column-item info">采购中</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">最新净值</span>
                    <span class="column-item info">¥200</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品编号</span>
                    <span class="column-item info">600000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">基金类型</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">管理费率</span>
                    <span class="column-item info">4.5</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">成立日</span>
                    <span class="column-item info">2016.08.20</span>
                </div>
            </div>
        </div>
        <div class="product insurance" data-toggle="modal" data-target="#myModal">
            <div class="circle empty-circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">保障年限</span>
                    <span class="column-item info">终身</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">保障年龄</span>
                    <span class="column-item info">30岁</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">保额区间</span>
                    <span class="column-item info">¥0~¥500000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">缴费方式</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行机构</span>
                    <span class="column-item info">简单基金</span>
                </div>
            </div>
        </div>
        <div class="product bond" data-toggle="modal" data-target="#myModal">
            <div class="circle empty-circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">票面利率</span>
                    <span class="column-item info">2.95</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">期限</span>
                    <span class="column-item info">2年</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">到期日</span>
                    <span class="column-item info">2016.08。20</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">债券类型</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">债券代码</span>
                    <span class="column-item info">390200</span>
                </div>
            </div>
        </div>
    </div>
    <div class="paging-wrapper">
        <hr class="fix">
        <span class="paging-item"><i class="fa fa-long-arrow-left"></i> 第一页</span>
        <span class="paging-item"><i class="fa fa-long-arrow-left"></i></span>
        <ul class="paging-item page-number">
            <li class="current">1</li>
            <li class="">2</li>
            <li class="">3</li>
            <li class="">...</li>
            <li class="">9</li>
        </ul>
        <span class="paging-item"><i class="fa fa-long-arrow-right"></i></span>
        <span class="paging-item">最后一页 <i class="fa fa-long-arrow-right"></i></span>
    </div>
</div>
</body>
</html>
