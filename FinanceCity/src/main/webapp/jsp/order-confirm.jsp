<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>订单信息确认</title>
    <link href="../css/order.css" rel="stylesheet">
</head>
<body>

<body>
<s:include value="header.jsp"></s:include>


<div class="main">
    <div class="container">
        <div class="top-bar white-bg">
            <a href="./" class="select-section current">
                <div class="circle">1</div>
                <span class="title">确认订单信息</span>
            </a>
            <div class="line"></div>
            <a href="./" class="select-section">
                <div class="circle">2
                </div>
                <span class="title">完成支付</span>
            </a>
        </div>

        <div class="order-info-confirm white-bg">
            <div class="title-rect"></div>
            <div class="inside-container">
                <h2>订单信息</h2>
                <div class="clear"></div>
                <table>
                    <tr>
                        <th class="product-section">产品名称</th>
                        <th class="product-price">单价</th>
                        <th class="product-quantity">数量</th>
                        <th>小计</th>
                        <th>操作</th>
                    </tr>
                    <tr class="current">
                        <td>
                            <div class="product-icon icon-manage">理</div>
                            <div class="product-title">
                                <span class="main-title">稳赚利38天</span>
                                </br>
                                <span class="sub-title">银行理财-小分类</span>
                            </div>
                            <div class="clear"></div>
                        </td>
                        <td>￥300</td>
                        <td>1</td>
                        <td class="product-sum">￥300</td>
                        <td><button>删除</button></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="product-icon icon-fund">基</div>
                            <div class="product-title">
                                <span class="main-title">稳赚利38天</span>
                                </br>
                                <span class="sub-title">银行理财-小分类</span>
                            </div>
                            <div class="clear"></div>
                        </td>
                        <td>￥300</td>
                        <td>1</td>
                        <td class="product-sum">￥300</td>
                        <td><button>删除</button></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="product-icon icon-insurance">保</div>
                            <div class="product-title">
                                <span class="main-title">稳赚利38天</span>
                                </br>
                                <span class="sub-title">银行理财-小分类</span>
                            </div>
                            <div class="clear"></div>
                        </td>
                        <td>￥300</td>
                        <td>1</td>
                        <td class="product-sum">￥300</td>
                        <td><button>删除</button></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="product-icon icon-bond">债</div>
                            <div class="product-title">
                                <span class="main-title">稳赚利38天</span>
                                </br>
                                <span class="sub-title">银行理财-小分类</span>
                            </div>
                            <div class="clear"></div>
                        </td>
                        <td>￥300</td>
                        <td>1</td>
                        <td class="product-sum">￥300</td>
                        <td><button>删除</button></td>
                    </tr>

                </table>
            </div>
            <div class="clear"></div>
        </div>

        <div class="confirm-order white-bg">
            <div class="title-rect"></div>
            <div class="inside-container">
                <div class="total">
                    <span class="total-title">合计:</span>
                    <span class="total-sum">￥1200</span>
                </div>
                <button class="block-button">提交订单</button>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>

<s:include value="footer.jsp"></s:include>
</body>

</body>
</html>