<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link href="../css/order.css" rel="stylesheet">
<link href="../css/mycss.css" rel="stylesheet">
</head>
<body>
	<s:include value="header.jsp"></s:include>
	<div style="height: 445px">
		<div class="container"
			style="margin-top: 30px; background-color: white;">
			<br />
			<div class="smallBlock"></div>
			<span class="blueFont">注册</span>
			<div class="signupContent">
				<table border="0" style="margin-left:15%;width:70%" >
					<tr>
						<td><span style="font-size:14px">手机号码</span></td>
						<td><input type="text" class="inputSize"></td>
					</tr>
					<tr>
						<td><span style="font-size:14px">短信验证码</span></td>
						<td><input type="text" style="height:30px;width:150px">
						<button class="platButton">获取</button>
						</td>
						
					</tr>
					<tr>
						<td><span style="font-size:14px">密码</span></td>
						<td><input type="text" class="inputSize"></td>
					</tr>
					<tr>
						<td colspan="2"> <span style="font-size:14px;color:red">错误提示信息</span></td>
					</tr>
					<tr>
						<td colspan="2"><button class="wideButton">完成注册</button></td>
					</tr>
				</table>
				
			</div>

		</div>
	</div>

	<s:include value="footer.jsp"></s:include>

</body>
</html>