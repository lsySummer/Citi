<%--
  Created by IntelliJ IDEA.
  User: Hermit
  Date: 16/8/24
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
    <link type="text/css" rel="stylesheet" href="plugins/bootstrap-toggle-master/css/bootstrap-toggle.min.css"/>
    <link type="text/css" rel="stylesheet" href="plugins/ion.rangeSlider-master/css/ion.rangeSlider.css"/>
    <link type="text/css" rel="stylesheet" href="plugins/ion.rangeSlider-master/css/ion.rangeSlider.skinFlat.css"/>
    <link type="text/css" rel="stylesheet" href="css/buttons.css"/>
    <link type="text/css" rel="stylesheet" href="css/common.css"/>
    <link type="text/css" rel="stylesheet" href="css/searchFilter.css"/>

    <script type="text/javascript" rel="script" src="js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" rel="script" src="../plugins/ion.rangeSlider-master/js/ion.rangeSlider.min.js"></script>
    <script type="text/javascript" rel="script" src="plugins/bootstrap-toggle-master/js/bootstrap-toggle.min.js"></script>
    <script type="text/javascript" rel="script" src="js/searchFilter-all.js"></script>

    <title>InvestGO</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
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
                <span class="tag">年化收益率</span>
                <div class="slider-wrapper input-add-on-field">
                    <input type="text" id="annualized_return" name="annualized_return" value="" class="input-add-on-field"/>
                </div>
            </div>
            <div class="input-add-on income-item">
                <span class="tag">期限</span>
                <div class="slider-wrapper input-add-on-field">
                    <input type="text" id="range" name="range" value="" class="input-add-on-field"/>
                </div>
            </div>
            <div class="input-add-on income-item u1of4">
                <span class="tag">是否封闭</span>
                &nbsp;&nbsp;
                <div class="toggle-wrapper">
                    <input id="open" type="checkbox" checked data-toggle="toggle" data-size="small" data-height="30px" data-on="是" data-off="否" data-onstyle="info">
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
