<%--
  Created by IntelliJ IDEA.
  User: Sorumi
  Date: 16/9/11
  Time: 下午2:32
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
    <link href="${basePath}css/recommendation.css" rel="stylesheet">

    <script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
    <script src="https://www.amcharts.com/lib/3/serial.js"></script>
    <script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

    <script src="${basePath}js/recommendation.js"></script>

</head>
<body>
<s:include value="header.jsp"></s:include>

<div class="main">
    <div class="container top-margin inline-container">
        <div class="recommendation-container">
            <div class="recommendation-header">
                <h6>推荐一</h6>
                <h5><span>¥ &nbsp;</span>120,000</h5>
            </div>
            <ul>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
            </ul>

            <h6 class="income-title">预计收益曲线图</h6>
            <div id="chartdiv1" class="income-chart"></div>

            <div class="recommendation-footer">

                <a>购买此组合 -></a>
            </div>
        </div>

        <div class="recommendation-container">
            <div class="recommendation-header">
                <h6>推荐二</h6>
                <h5><span>¥ &nbsp;</span>120,000</h5>
            </div>
            <ul>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
            </ul>

            <h6 class="income-title">预计收益曲线图</h6>
            <div id="chartdiv2" class="income-chart"></div>

            <div class="recommendation-footer">

                <a>购买此组合 -></a>
            </div>
        </div>

        <div class="recommendation-container no-margin-right">
            <div class="recommendation-header">
                <h6>推荐三</h6>
                <h5><span>¥ &nbsp;</span>120,000</h5>
            </div>
            <ul>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div class="product-chart">
                        这个表以后补
                    </div>
                </li>
            </ul>

            <h6 class="income-title">预计收益曲线图</h6>
            <div id="chartdiv3" class="income-chart"></div>

            <div class="recommendation-footer">

                <a>购买此组合 -></a>
            </div>
        </div>

    </div>
</div>

<s:include value="footer.jsp"></s:include>

</body>
</html>
