<%--
  Created by IntelliJ IDEA.
  User: Hermit
  Date: 16/8/24
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <link type="text/css" rel="stylesheet" href="<c:url value="/plugins/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/buttons.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/plugins/font-awesome-4.6.3/css/font-awesome.min.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/common.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/searchResult.css"/>"/>

    <script type="text/javascript" rel="script" src="/js/jquery.min.js"></script>
    <script type="text/javascript" rel="script" src="/plugins/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="/js/searchResult.js"></script>

    <title>搜索结果</title>
</head>
<body>
<div class="main-content">
    <div class="selection-wrapper">
        <div class="keyword-wrapper">
            <label>关键字</label>
            <input type="text"/>
            <button id="sift_product_button" class="button button-3d button-primary button-rounded" type="button">筛选产品</button>
        </div>
        <div class="quota-wrapper">
            <div class="quota-item">
                <label>投资标的</label>
                <select class="selector input-add-on-field">
                    <option></option>
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
                <select class="selector input-add-on-field">
                    <option></option>
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
            </div>
            <div class="quota-item">
                <label>风险收益</label>
                <select class="selector input-add-on-field">
                    <option></option>
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
            </div>
            <div class="quota-item">
                <label>收益类型</label>
                <select class="selector input-add-on-field">
                    <option></option>
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
            </div>
        </div>
        <div class="quota-wrapper">
            <div class="quota-item">
                <label>投资期限</label>
                <select class="selector">
                    <option></option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
            </div>
            <div class="quota-item">
                <label>购买至生效时间</label>
                <select class="selector">
                    <option></option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
            </div>
            <div class="quota-item">
                <label>申请赎回到账时间</label>
                <select class="selector">
                    <option></option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
            </div>
        </div>
        <div class="quota-wrapper">
            <div class="quota-item">
                <label>数值范围</label>
                <input class="num-range" type="text"/>
                <label class="line"></label>
                <input class="num-range" type="text"/>
            </div>
        </div>
    </div>
    <div class="product-wrapper">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            模态框
                        </h4>
                    </div>
                    <div class="modal-body">
                        在这里添加一些文本
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
        <div class="product bank-financing" data-toggle="modal" data-target="#myModal">
            <div class="circle">
                <h1>2.95</h1>
                <h4>年化收益率</h4>
                <hr>
                <h3>银行理财</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">收益类型</span>
                    <span class="column-item info">非保本浮动收益型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">起购金额</span>
                    <span class="column-item info">¥500000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行银行</span>
                    <span class="column-item info">浦发银行</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行机构</span>
                    <span class="column-item info">浦发银行</span>
                </div>
            </div>
        </div>
        <div class="product fund" data-toggle="modal" data-target="#myModal">
            <div class="circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">产品状态</span>
                    <span class="column-item info">采购中</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">最新净值</span>
                    <span class="column-item info">¥200</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品编号</span>
                    <span class="column-item info">600000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">基金类型</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">管理费率</span>
                    <span class="column-item info">4.5</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">成立日</span>
                    <span class="column-item info">2016.08.20</span>
                </div>
            </div>
        </div>
        <div class="product insurance" data-toggle="modal" data-target="#myModal">
            <div class="circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">保障年限</span>
                    <span class="column-item info">终身</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">保障年龄</span>
                    <span class="column-item info">30岁</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">保额区间</span>
                    <span class="column-item info">¥0~¥500000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">缴费方式</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行机构</span>
                    <span class="column-item info">简单基金</span>
                </div>
            </div>
        </div>
        <div class="product bond" data-toggle="modal" data-target="#myModal">
            <div class="circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">票面利率</span>
                    <span class="column-item info">2.95</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">期限</span>
                    <span class="column-item info">2年</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">到期日</span>
                    <span class="column-item info">2016.08。20</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">债券类型</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">债券代码</span>
                    <span class="column-item info">390200</span>
                </div>
            </div>
        </div>
        <div class="product bank-financing" data-toggle="modal" data-target="#myModal">
            <div class="circle empty-circle">
                <h1>2.95</h1>
                <h4>年化收益率</h4>
                <hr>
                <h3>银行理财</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">收益类型</span>
                    <span class="column-item info">非保本浮动收益型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">起购金额</span>
                    <span class="column-item info">¥500000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品类型</span>
                    <span class="column-item info">开放式净值型</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行银行</span>
                    <span class="column-item info">浦发银行</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行机构</span>
                    <span class="column-item info">浦发银行</span>
                </div>
            </div>
        </div>
        <div class="product fund" data-toggle="modal" data-target="#myModal">
            <div class="circle empty-circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">产品状态</span>
                    <span class="column-item info">采购中</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">最新净值</span>
                    <span class="column-item info">¥200</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">产品编号</span>
                    <span class="column-item info">600000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">基金类型</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">管理费率</span>
                    <span class="column-item info">4.5</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">成立日</span>
                    <span class="column-item info">2016.08.20</span>
                </div>
            </div>
        </div>
        <div class="product insurance" data-toggle="modal" data-target="#myModal">
            <div class="circle empty-circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">保障年限</span>
                    <span class="column-item info">终身</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">保障年龄</span>
                    <span class="column-item info">30岁</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">保额区间</span>
                    <span class="column-item info">¥0~¥500000</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">缴费方式</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">发行机构</span>
                    <span class="column-item info">简单基金</span>
                </div>
            </div>
        </div>
        <div class="product bond" data-toggle="modal" data-target="#myModal">
            <div class="circle empty-circle">
                <h1>2.95</h1>
                <h4>收益率</h4>
                <hr>
                <h3>基金</h3>
            </div>
            <div class="more-info">
                <h3>稳添利公积金</h3>
                <br>
                <div class="column">
                    <span class="column-item u1of3 tag">票面利率</span>
                    <span class="column-item info">2.95</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">期限</span>
                    <span class="column-item info">2年</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">到期日</span>
                    <span class="column-item info">2016.08。20</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">债券类型</span>
                    <span class="column-item info">简单基金</span>
                </div>
                <div class="column">
                    <span class="column-item u1of3 tag">债券代码</span>
                    <span class="column-item info">390200</span>
                </div>
            </div>
        </div>
    </div>
    <div class="paging-wrapper">
        <hr class="fix">
        <span class="paging-item"><i class="fa fa-long-arrow-left"></i> 第一页</span>
        <span class="paging-item"><i class="fa fa-long-arrow-left"></i></span>
        <ul class="paging-item page-number">
            <li class="current">1</li>
            <li class="">2</li>
            <li class="">3</li>
            <li class="">...</li>
            <li class="">9</li>
        </ul>
        <span class="paging-item"><i class="fa fa-long-arrow-right"></i></span>
        <span class="paging-item">最后一页 <i class="fa fa-long-arrow-right"></i></span>
    </div>
</div>
</body>
</html>
