<%--
  Created by IntelliJ IDEA.
  User: Sorumi
  Date: 16/9/11
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
        String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString();
        request.setAttribute("basePath", basePath);
    %>
    <title>InvestGO</title>
    <base href="<%=basePath%>">
    <link href="${basePath}css/common.css" rel="stylesheet">
    <link href="${basePath}css/asset.css" rel="stylesheet">

    <script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
    <script src="https://www.amcharts.com/lib/3/pie.js"></script>
    <script src="https://www.amcharts.com/lib/3/serial.js"></script>
    <script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

    <script src="${basePath}js/asset.js"></script>

</head>
<body>
<s:include value="header.jsp"></s:include>

<div class="main">
    <div class="container top-margin inline-container">

        <div class="asset-allocation asset-block">
            <h5 class="title">资产配置</h5>
            <div id="allocation-chart"></div>
        </div>

        <div class="asset-price asset-block">
            <h5 class="title">资产价值曲线</h5>
            <div id="price-chart"></div>
        </div>

        <div class="asset-product asset-block">
            <h5 class="title">投资产品</h5>
            <table>
                <tr>
                    <th class="product-name">产品</th>
                    <th class="product-price">投资金额(￥)</th>
                    <th class="product-total">本利和(￥)</th>
                    <th></th>
                </tr>
                <tr>
                    <td>稳添利38天</td>
                    <td>2000</td>
                    <td>2200</td>
                    <td><a>卖出</a></td>
                </tr>
                <tr>
                    <td>一个很短的基金名字</td>
                    <td>2300</td>
                    <td>2330</td>
                    <td><a>卖出</a></td>
                </tr>
                <tr>
                    <td>大长腿保险</td>
                    <td>3400</td>
                    <td>3440</td>
                    <td><a>卖出</a></td>
                </tr>
                <tr>
                    <td>你就说我美不美债券</td>
                    <td>2300</td>
                    <td>2388</td>
                    <td><a>卖出</a></td>
                </tr>
            </table>
        </div>

        <div class="asset-timeline asset-block">
            <h5 class="title">投资时间线</h5>
            <table>

                <tr>
                    <td>
                        <div class="opeartion-block timeline-due">到期</div>
                    </td>
                    <td>2016-09-13</td>
                    <td>稳添利38天</td>
                    <td>获利￥400</td>
                </tr>
                <tr>
                    <td>
                        <div class="opeartion-block timeline-buy">买入</div>
                    </td>
                    <td>2016-09-01</td>
                    <td>大长腿保险</td>
                    <td></td>
                </tr>
                <tr>
                    <td>
                        <div class="opeartion-block timeline-pay">付息</div>
                    </td>
                    <td>2016-08-30</td>
                    <td>付息是什么意思</td>
                    <td></td>
                </tr>

            </table>
        </div>
    </div>
</div>

<s:include value="footer.jsp"></s:include>

</body>
</html>
