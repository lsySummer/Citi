<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String url = request.getScheme() + "://" + request.getServerName() + request.getRequestURI() + "?"
			+ request.getQueryString();
	request.setAttribute("basePath", basePath);
%>
<title>InvestGO</title>
<base href="<%=basePath%>">
	<link href="${basePath}css/common.css" rel="stylesheet">
	   <script type="text/javascript" rel="script" src="js/jquery.min.js"></script>
	<%--<link href="${basePath}css/order.css" rel="stylesheet">--%>
	<link href="${basePath}css/mycss.css" rel="stylesheet">
	<script type="text/javascript">
	$(function() {
		$("#getVerify").click(function() {
			//提交的参数，name和inch是和struts action中对应的接收变量
			var params = {
				phone:$("#mobile").val()
			};
			$.ajax({
				type : "POST",
				url : "getVerify",
				data : params,
				dataType : "text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
				success : function(json) {
					document.getElementById('getVerify').value='已发送';
					return true;
				},
				error : function(json) {
					document.getElementById('getVerify').value='发送失败';
					return false;
				}
			});
		});
	});
</script>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"/>

	<div class="main" style="height: 480px">
		<div class="container"
			style="margin-top: 30px; background-color: white;">
			<br />
			<div class="smallBlock"></div>
			<span class="blueFont">注册</span>
			<div class="signupContent">
				<s:form action="register" method="post">
					<table border="0" style="margin-left: 15%; width: 70%">
						<tr>
							<td><span style="font-size: 14px">手机号码</span></td>
							<td><input type="text" class="inputSize" name="mobile" id="mobile"></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">短信验证码</span></td>
							<td><input type="text" style="height: 30px; width: 150px"
								name="verify">
								<input type="button" class="platButton" id="getVerify" name="getVerify" value="获取"></td>

						</tr>
						<tr>
							<td><span style="font-size: 14px">昵称</span></td>
							<td><input type="text" class="inputSize" name="nickname"></td>
						</tr>
						<tr>
							<td><span style="font-size: 14px">密码</span></td>
							<td><input type="password" class="inputSize" name="password">
							</td>
						</tr>
						<tr>
							<td colspan="2"><span style="font-size: 14px; color: red"
								id="error"></span></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" class="wideButton"
								value="完成注册"></td>
						</tr>
					</table>
				</s:form>
			</div>
		</div>
	</div>
	<s:include value="footer.jsp"></s:include>
<script type="text/javascript">
	var msg = "${requestScope.message}";
	if (msg != "") {
		document.getElementById('error').innerHTML=msg;
	}
</script>
</body>
</html>