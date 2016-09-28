<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="edu.nju.service.Sessions.FinanceCityUser"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String url = request.getScheme() + "://" + request.getServerName() + request.getRequestURI() + "?"
			+ request.getQueryString();
	request.setAttribute("basePath", basePath);
%>
<html>
<base href="<%=basePath%>">
    <link href="${basePath}css/nav.css" rel="stylesheet">
<script type="text/javascript">
	function assets() {
		document.getAsset.action = "investment";
		document.getAsset.submit();
	}

	function newQuestion() {
		document.getAsset.action = "newQuestion";
		document.getAsset.submit();
	}

	function product() {
		document.getAsset.action = "search";
		document.getAsset.submit();
	}
</script>

<div class="header shadow">
	<div class="container">
		<div class="header-square"></div>
		<h1 class="header-title"></h1>
		<div class="header-button">
			<%
				if (session.getAttribute("user") == null) {
			%>
			<div style="float: left;">
				<a href="${basePath}/jsp/signup_step1.jsp"><button
						class="button-style">注册</button></a>
			</div>
			<div style="float: left;">
				<s:form action="loginURL" method="post" name='loginURL'
					theme="simple">
					<a href="javascript:document.loginURL.submit();"
						style="float: left"><button class="button-style">登录</button></a>
				</s:form>
			</div>
			<%
				} else {
					FinanceCityUser user = (FinanceCityUser) session.getAttribute("user");
					String userName = user.getUserName();
			%>
		
		<div style="width:100px;float:left">
		<s:form name="getAsset" method="post">	 
	        <ul id="nav">
	        <li style="margin-top:10px"><a href="javascript:void(0);" onclick="product()">产品</a></li>
	            <li style="margin:10px"><a href="javascript:void(0)">资产</a>
	                <div>
	                    <ul>
	                        <li style="background-color: white; border-bottom: solid 1px darkgray"><a href="javascript:void(0);" onclick="assets()">我的资产</a></li>
	                        <li style="background-color: white;"><a href="javascript:void(0);" onclick="newQuestion()">资产推荐</a></li>
	                    </ul>
	                </div>
	            </li>
	        </ul>
	    </s:form>
	    </div>
	    <div style="float:left;">
	    <a href="logout"><button class="button-style">注销</button></a>
	    </div>
			<%
				}
			%>

		</div>
		   
	</div>

</div>

</html>