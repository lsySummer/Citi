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

    <script src= "https://cdn.zingchart.com/zingchart.min.js"></script>
    <script>
        ZC.LICENSE = ["569d52cefae586f634c54f86dc99e6a9","ee6b7db5b51705a13dc2339db3edaf6d"];
    </script>
    <link href='https://fonts.googleapis.com/css?family=Lato:100' rel='stylesheet' type='text/css'>

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
                    <div id="precentChart1-1" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart1-2" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart1-3" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart1-4" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart1-5" class="product-chart"></div>
                </li>
            </ul>

            <%--<h6 class="radar-title">预计收益曲线图</h6>--%>
            <div id="radarChart1" class="radar-chart"></div>

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
                    <div id="precentChart2-1" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart2-2" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart2-3" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart2-4" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart2-5" class="product-chart"></div>
                </li>
            </ul>

            <%--<h6 class="radar-title">预计收益曲线图</h6>--%>
            <div id="radarChart2" class="radar-chart"></div>

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
                    <div id="precentChart3-1" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart3-2" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart3-3" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart3-4" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart3-5" class="product-chart"></div>
                </li>
            </ul>

            <%--<h6 class="radar-title">预计收益曲线图</h6>--%>
            <div id="radarChart3" class="radar-chart"></div>

            <div class="recommendation-footer">

                <a>购买此组合 -></a>
            </div>
        </div>

    </div>
</div>


<s:include value="footer.jsp"></s:include>

</body>
</html>
