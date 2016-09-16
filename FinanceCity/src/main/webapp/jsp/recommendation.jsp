<%--
  Created by IntelliJ IDEA.
  User: Sorumi
  Date: 16/9/11
  Time: 下午2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="edu.nju.service.POJO.CommonPortfolio"%>
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
    <link href="${basePath}css/common.css" rel="stylesheet">
    <link href="${basePath}css/recommendation.css" rel="stylesheet">

    <script src= "https://cdn.zingchart.com/zingchart.min.js"></script>
    <script>
        ZC.LICENSE = ["569d52cefae586f634c54f86dc99e6a9","ee6b7db5b51705a13dc2339db3edaf6d"];
    </script>
    <link href='https://fonts.googleapis.com/css?family=Lato:100' rel='stylesheet' type='text/css'>

    <script src="${basePath}js/recommendation.js"></script>

</head>
<body>
<s:include value="header.jsp"></s:include>

<div class="main">
    <div class="container top-margin inline-container">
       <%List<CommonPortfolio> recArr=(List<CommonPortfolio>)request.getAttribute("recArr"); 
       int arraySize=recArr.size();
       for(int i=0;i<recArr.size();i++){ 
        		String divId = "radarChart"+i;
        		int flowScore=recArr.get(i).getFlow_score();
        		int lthScore=recArr.get(i).getLength_score();
        		int riskscore=recArr.get(i).getRisk_score();
        		int yieldscore=recArr.get(i).getYield_score();
        		int j=i+1;
        %>
     
        <div class="recommendation-container">
            <div class="recommendation-header">
                <h6>推荐<%=j %></h6>
                <h5><span>¥ &nbsp;</span>120,000</h5>
            </div>
            <ul>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart1-1" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart1-2" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart1-3" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart1-4" class="product-chart"></div>
                </li>
                <li class="product">
                    <div class="product-title">
                        <span>稳赚利38天</span>
                        <span>¥&nbsp;2000</span>
                    </div>
                    <div id="precentChart1-5" class="product-chart"></div>
                </li>
            </ul>

            <%--<h6 class="radar-title">预计收益曲线图</h6>--%>
            <div id=<%=divId %> class="radar-chart"></div>

			   <script type="text/javascript">
        zingchart.MODULESDIR = "https://cdn.zingchart.com/modules/"
        zingchart.THEME="classic";
        var myConfig =
        {
            "type": "radar",
            "plot": {
                "aspect": "line"
            },
            "background-color": "Transparent",

            "title": {
                "background-color": "none",
                "font-color": "000",
                //"font-size": "22px"
            },
            "tooltip": {
                //"text": "%t<br>%k Is %v",
                "shadow": 0,
                "border-radius": 3
            },
            "scale-k": {
                "background-color": "none",
                "values": [
                    "收益性",
                    "流动性",
                    "平均期限",
                    "风险性",
                ],
                "item": {
                    "font-color":"#808080",
                    "font-weight":"100",
                    "font-size": "10px",
                    "padding-left": "5px",
                    "padding-bottom": "5px"
                },
                "guide": {
                    "line-color": "",
                    "line-style": "solid",
                    "line-width": "2px",
                    "items": [
                        {
                            "background-color": "#fff"
                        }
                    ]
                },
                "tick": {
                    "visible": false
                }
            },
            "scale-v": {
                "values": [
                    30,40,60,80,100
                ],
                "item": {
                    "font-color":"Transparent",
                    "padding-left": "0px",
                    "font-size": "10px"
                },
                "ref-line": {
                    "line-color": ""
                },

                "tick": {
                    "line-color": ""
                }
            },
            "series": [
                {
                    "values": [
                        <%=yieldscore%>,<%=flowScore%>, <%=lthScore%>,<%=riskscore%>
                    ],
                    "aspect": "line",
                    "text": "ER",
                    "line-color": "#11b7f3",
                    "background-color": "none",
                    "line-width": "2px",
                    "alpha": "1",
                    "marker": {
                        "background-color": "#11b7f3",
                        "size": "3",
                        "border-color": "#11b7f3",
                        "alpha": "1"
                    }
                },
                {
                    "aspect": "line",
                    "text": "ENT",
                    "line-color": "#11b7f3",
                    "line-width": "4px",
                    "alpha": "0",
                    "marker": {
                        "background-color": "#666666",
                        "size": "4",
                        "border-color": "#666666",
                        "alpha": "0.55"
                    }
                }
            ]
        };

        zingchart.render({
            id : '<%=divId %>',
            data : myConfig,
            height: 300,
            width: 300
        });
        </script>
            <div class="recommendation-footer">

                <a>购买此组合 -></a>
            </div>
        </div>
		<%}%>
      

    </div>
</div>


<s:include value="footer.jsp"></s:include>
<script  type="text/javascript">
window.onload = function() {

        <!--
		    for (var i=0; i<<%=arraySize%>; i++) {
		    	for (var j=1; j<=5; j++) {
		            var id = "precentChart" + i + "-" + j;
		            initPrecentChart(id);
		        }
		        initRadarChart("radarChart" + i);
		    }
        -->

}


function initRadarChart(chartId) {
	
}
</script>

</body>
</html>
