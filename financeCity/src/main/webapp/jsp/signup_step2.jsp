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
<link href="${basePath}css/order.css" rel="stylesheet">
<link href="${basePath}css/mycss.css" rel="stylesheet">

 <title>InvestGO</title>
</head>
<body>
<s:include value="header.jsp"></s:include>
	<div style="height: 560px">
		<div class="container"
			style="margin-top: 30px; background-color: white;">
			<br />
			<div class="smallBlock"></div>
			<span class="blueFont">个人信息</span>
			<div class="signup2Content">
				<span style="font-size:15px">您的生日</span><br/>
				 <select class="signSelector">
                    <option>1970</option>
                    <option>1971</option>
                    <option>1972</option>
                </select>
                <select class="signSelector">
                    <option>1月</option>
                    <option>2月</option>
                    <option>3月</option>
                </select>
                <select class="signSelector">
                    <option>1日</option>
                    <option>2日</option>
                    <option>3日</option>
                </select>
                <br/><br/>
                <span style="font-size:15px">您来自城市还是农村</span><br/>
                <select class="signLongSelector">
                    <option>城市</option>
                      <option>农村</option>
                </select>
                  <br/><br/>
                <span style="font-size:15px">您目前每月的收入是多少?(单位：元)</span><br/>
                <input type="text" style="height:26px;width:340px">
                  <br/><br/>
                <span style="font-size:15px">您目前每月的支出是多少?(单位：元)</span><br/>
                <input type="text" style="height:26px;width:340px">
                <br/><br/>
                <span style="font-size:15px;color:red">提示信息</span><br/>
                <button class="wideButton">确定</button>
			</div>

		</div>
	</div>

	<s:include value="footer.jsp"></s:include>

</body>
</html>