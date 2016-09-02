<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString();
    request.setAttribute("basePath", basePath);
%>
<html>
 <base href="<%=basePath%>">
<body style="margin: 0">
<div class="header shadow">
    <div class="container">
        <div class="header-square"></div>
        <h1 class="header-title">Invest Go</h1>
        <div class="header-button">
           <a href="${basePath}/jsp/signup_step1.jsp"><button class="button-style">注册</button></a>
            <a href="${basePath}/jsp/login.jsp"><button class="button-style">登录</button></a>
        </div>
    </div>

</div>

</body>
</html>