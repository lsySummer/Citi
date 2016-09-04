<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
     <%@ page language="java" import="edu.nju.service.Sessions.FinanceCityUser"%>

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
        <s:form action="loginURL" method="post" name='loginURL'>
        <%if(session.getAttribute("user")==null) {%>
           <a href="${basePath}/jsp/signup_step1.jsp"><button class="button-style">注册</button></a>
            <a href="javascript:document.loginURL.submit();"><button class="button-style">登录</button></a>
       <% }else{
    	   FinanceCityUser user = (FinanceCityUser)session.getAttribute("user");
    	   String userName=user.getUserName();
       %>
       <span><%=userName %></span>
       <%} %>
       </s:form>
        </div>
    </div>

</div>

</body>
</html>