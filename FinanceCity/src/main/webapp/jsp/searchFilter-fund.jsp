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
    <link type="text/css" rel="stylesheet" href="plugins/bootstrap-toggle-master/css/bootstrap-toggle.min.css"/>
    <link type="text/css" rel="stylesheet" href="plugins/ion.rangeSlider-master/css/ion.rangeSlider.css"/>
    <link type="text/css" rel="stylesheet" href="plugins/ion.rangeSlider-master/css/ion.rangeSlider.skinFlat.css"/>
    <link type="text/css" rel="stylesheet" href="css/buttons.css"/>
    <link type="text/css" rel="stylesheet" href="css/common.css"/>
    <link type="text/css" rel="stylesheet" href="css/searchFilter.css"/>

    <script type="text/javascript" rel="script" src="js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" rel="script" src="plugins/bootstrap-toggle-master/js/bootstrap-toggle.min.js"></script>
    <script type="text/javascript" rel="script" src="plugins/ion.rangeSlider-master/js/ion.rangeSlider.min.js"></script>
    <script type="text/javascript" rel="script" src="js/searchFilter-fund.js"></script>

    <title>InvestGO</title>
</head>
<body>

</body>
</html>
