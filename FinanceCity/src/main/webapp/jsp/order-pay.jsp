<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String url = request.getScheme() + "://" + request.getServerName() + request.getRequestURI() + "?"
			+ request.getQueryString();
	request.setAttribute("basePath", basePath);
%>
<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>订单付款</title>
    <link href="${basePath}css/order.css" rel="stylesheet">
    <link href="${basePath}css/common.css" rel="stylesheet">
</head>
<body>

<body>
<s:include value="header.jsp"></s:include>


<div class="main">
    <div class="container">
        <div class="top-bar white-bg">
            <a href="./" class="select-section">
                <span class="title">完成支付</span>
            </a>
        </div>

        <div class="order-info-pay white-bg">
            <div class="title-rect"></div>
            <div class="inside-container">
                <h2>订单信息</h2>
                <div class="total">
                    <span class="total-title">合计:</span>
                    <span class="total-sum">￥1200</span>
                </div>
                <div class="clear"></div>
                  <table>
                    <tr>
                        <th class="product-section">产品名称</th>
                        <th class="product-quantity">购买金额</th>
                    </tr>
                    <s:iterator value="#request.tradeInfoList">
                    <tr>
                        <td style="width:300px">
                            <div class="product-title">
                                <span class="main-title"><s:property value="productId" /></span>
                                </br>
                                <span class="sub-title"><s:property value="Type" /></span>
                            </div>
                            <div class="clear"></div>
                        </td>
                        <td >￥<s:property value="amount" /></td>
                    </tr>
                    </s:iterator>
                </table>
            </div>
            <div class="clear"></div>
        </div>

        <div class="pay-way white-bg">
            <div class="title-rect"></div>
            <div class="inside-container">
                <h2>支付方式</h2>
                <div class="clear"></div>
                <form>
                    <div class="pay-section">
                        <input id="radio1" type="radio" name="radio" value="1" checked="checked">
                        <label for="radio1"><span><span></span></span>支付方式1</label>
                    </div>
                    <div class="pay-section">
                        <input id="radio2" type="radio" name="radio" value="2">
                        <label for="radio1"><span><span></span></span>支付方式2</label>
                    </div>
                    <div class="pay-section">
                        <input id="radio3" type="radio" name="radio" value="3">
                        <label for="radio1"><span><span></span></span>支付方式3</label>
                    </div>
                </form>
                <button class="block-button">确认支付 ￥1200</button>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>

<s:include value="footer.jsp"></s:include>

</div>
</body>

</body>
</html>