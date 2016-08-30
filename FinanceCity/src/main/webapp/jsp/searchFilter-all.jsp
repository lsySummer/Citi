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
    <link type="text/css" rel="stylesheet" href="plugins/jquery-slider/css/bootstrap-slider.min.css"/>
    <link type="text/css" rel="stylesheet" href="plugins/bootstrap-toggle-master/css/bootstrap-toggle.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/buttons.css"/>
    <link type="text/css" rel="stylesheet" href="css/common.css"/>
    <link type="text/css" rel="stylesheet" href="css/searchFilter.css"/>

    <script type="text/javascript" rel="script" src="js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" rel="script" src="plugins/jquery-slider/js/bootstrap-slider.min.js"></script>
    <script type="text/javascript" rel="script" src="plugins/bootstrap-toggle-master/js/bootstrap-toggle.min.js"></script>
    <script type="text/javascript" rel="script" src="js/searchFilter-all.js"></script>

    <title>InvestGO</title>
</head>
<body>
<div class="main-content">
    <div class="filter-container">
        <div class="input-add-on search-wrapper">
            <h1 class="input-add-on-item">关键字</h1>
            <input id="search_input" type="text" class="input-add-on-field"/>
            <button id="search_button" class="button button-3d button-primary button-rounded input-add-on-item" type="button">搜 索</button>
        </div>
        <div class="input-add-on filter-wrapper">
            <h1 class="input-add-on-item">筛&nbsp;&nbsp;&nbsp;选</h1>
            <div class="input-add-on-field input-add-on selections">
                <select class="input-add-on-field left">
                    <option class="display-none">银行理财</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
                <select class="input-add-on-field right">
                    <option class="display-none">——————</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
            </div>
            <button id="filter_button" class="button button-3d button-primary button-rounded input-add-on-item" type="button">筛 选</button>
        </div>
        <div class="income-wrapper">
            <div class="input-add-on income-item">
                <label>年化收益率</label>
                <div class="slider-wrapper">
                    <b class="slider-start">0</b><input id="annualized_return" type="text" class="span2" value="" data-slider-min="10" data-slider-max="1000" data-slider-step="5" data-slider-value="[250,450]"/><b class="slider-end">1000</b>
                </div>
            </div>
            <div class="input-add-on income-item">
                <label>期限</label>
                <div class="slider-wrapper">
                    <b class="slider-start">0</b><input id="range" type="text" class="span2" value="" data-slider-min="10" data-slider-max="1000" data-slider-step="5" data-slider-value="[250,450]"/><b class="slider-end">1000</b>
                </div>
            </div>
            <div class="input-add-on income-item u1of4">
                <label>是否封闭</label>
                &nbsp;
                <input type="checkbox" checked data-toggle="toggle" data-size="small" data-height="30px" data-on="是" data-off="否">
            </div>
        </div>
    </div>
</div>
</body>
</html>
