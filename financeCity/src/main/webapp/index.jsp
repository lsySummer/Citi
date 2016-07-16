<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>Login</title>
		
		<link href="/css/bootstrap.min.css" rel="stylesheet">

		<script src="/assignment7_client/js/jquery.min.js"></script>
		<script src="/assignment7_client/js/bootstrap.min.js"></script>
	</head>
<body>
<h2>Hello World!</h2>
<s:form action="test" method="post">
	<input type="text" name="txt">
	<input type="submit">
</s:form>
</body>
</html>
