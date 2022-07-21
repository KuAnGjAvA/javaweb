<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>嘉应学院学子商城-订单详情页</title>
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
    <link href="../css/order.info.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<%@include file="headernav.jsp"%>
<%--<header id="top">--%>
<%--    <div id="logo" class="lf">--%>
<%--        <img class="animated jello" src="../img/header/" alt="logo"/>--%>
<%--    </div>--%>
<%--    <div id="top_input" class="lf">--%>
<%--        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>--%>

<%--        <a href="" class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>--%>
<%--    </div>--%>
<%--    <div class="rt">--%>
<%--        <ul class="lf">--%>
<%--            <li><a href="index.html" >首页</a><b>|</b></li>--%>
<%--            <li><a href="collect.html" >收藏</a><b>|</b></li>--%>
<%--            <li><a href="order.html" >订单</a><b>|</b></li>--%>
<%--            <li><a href="cart.html" >购物车</a><b>|</b></li>--%>
<%--            <li><a href="../page/password-change.jsp">设置</a><b>|</b></li>--%>
<%--            <li><a href="../action/LogoutServlet">退出</a><b>|</b></li>--%>
<%--            <li><a href="lookforward.jsp">帮助</a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</header>--%>
<!-- nav主导航-->

<!--详细信息-->
<div id="container">
  <!-- 导航 -->
  <div class="container_nav">
    首页&gt;订单管理&gt;订单 <span>${requestScope.orderinfo.orderId }</span>
  </div>
  <div class="orderInfo_icon">
    <p>订单：<span class="order-num">${requestScope.orderinfo.orderId }</span>&nbsp;&nbsp;&nbsp;当前状态：<span class="state">${requestScope.orderinfo.sta }</span></p>
  </div>
  <!-- 订单状态流程图-->
  <div id="orderStatusChart">
      <dl>
        <dt><img src="../img/orderinfo/orderinfo_img1_2.png" alt=""/></dt>
        <dd>
          <p>提交订单</p>
          <span><fmt:formatDate value="${requestScope.orderinfo.placed }" pattern="yyyy.MM.dd HH:mm"/></span>
        </dd>
      </dl>
      <dl>
      <dt class="point"><img src='../img/orderinfo/orderinfo_img6_${"待处理"!=requestScope.orderinfo.sta?"2":"1" }.png' alt=""/></dt>
      </dl>

      <dl>
        <dt><img src='../img/orderinfo/orderinfo_img3_${"待处理"!=requestScope.orderinfo.sta?"2":"1" }.png' alt=""/></dt>
        <dd>
        <c:if test="${'待处理'!=requestScope.orderinfo.sta }">
          <p>处理中</p>
          <span><fmt:formatDate value="${requestScope.orderinfo.receipt }" pattern="yyyy.MM.dd HH:mm"/></span>
        </c:if>
        </dd>
      </dl>
      <dl>
      <dt class="point"><img src='../img/orderinfo/orderinfo_img6_${"已发货"==requestScope.orderinfo.sta || "已交付"==requestScope.orderinfo.sta?"2":"1" }.png' alt=""/></dt>
      </dl>

      <dl>
        <dt><img src='../img/orderinfo/orderinfo_img4_${"已发货"==requestScope.orderinfo.sta || "已交付"==requestScope.orderinfo.sta?"2":"1" }.png' alt=""/></dt>
        <dd >
        <c:if test='${"已发货"==requestScope.orderinfo.sta || "已交付"==requestScope.orderinfo.sta }'>
          <p>已发货</p>
          <span><fmt:formatDate value="${requestScope.orderinfo.deliver }" pattern="yyyy.MM.dd HH:mm"/></span>
        </c:if>
        </dd>
      </dl>
      <dl>
      <dt class="point"><img src='../img/orderinfo/orderinfo_img6_${"已交付"==requestScope.orderinfo.sta?"2":"1" }.png' alt=""/></dt>
      </dl>

    <dl>
        <dt><img src='../img/orderinfo/orderinfo_img5_${"已交付"==requestScope.orderinfo.sta?"2":"1" }.png' alt=""/></dt>
        <dd>
        <c:if test='${"已交付"==requestScope.orderinfo.sta }'>
          <p>已交付</p>
          <span><fmt:formatDate value="${requestScope.orderinfo.handover }" pattern="yyyy.MM.dd HH:mm"/></span>
        </c:if>
        </dd>
      </dl>

  </div>
  <div class="clear">

  <!-- 详细信息-->
    <h1>详细信息</h1>
    收货人：<span class="consignee">${requestScope.address.receiver }</span>&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<span class="tel">${requestScope.address.receiverPhone }</span>
    <br/>
    <p>收货地址：<span>${requestScope.address.address }</span></p>
  </div>

  <!-- 商品信息-->
  <div style="width: 1000px; margin:0px auto">
    <h1 class="commodity">商品信息</h1>
    <div class="product_confirm">
      <ul class="item_title">
        <li class="p_info">商品信息</li>
        <li class="p_price">单价(元)</li>
        <li class="p_count">数量</li>
        <li class="p_tPrice">实付款</li>
      </ul>
      <div>
      订单编号：${requestScope.orderinfo.orderId }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      下单时间：<fmt:formatDate value="${requestScope.orderinfo.placed }" pattern="yyyy.MM.dd HH:mm"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      联系客服<img src="../img/orderinfo/kefuf.gif" alt=""/></div>
      <c:forEach var="item" items="${requestScope.orderitem }">
      <ul class="item_detail">
        <li class="p_info">
          <b><br/><img src="../img/goods/${item.book.isbn }/detail1.jpg" /></b>
          <p class="product_name lf" ><br/>${item.book.title }</p>
          <br/>
          <span class="product_color ">出版社：${item.book.press }</span>
        </li>
        <li class="p_price">
          <i>专属价</i>
          <br/>
          <span class="pro_price">￥${item.orderItem.price }</span>
        </li>
        <li class="p_count">${item.orderItem.count }</li>
        <li class="p_tPrice">￥${item.orderItem.price }</li>
      </ul>
      <div style="height: 10px;margin: 0;padding: 0;background: #f5f5f5;"></div>
      </c:forEach>
    </div>
  </div>

</div>
<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../img/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../img/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../img/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../img/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
            <p class="footer1"><img src="../img/footer/" alt="" class=" footLogo"/></p>
            <p class="footer2"><img src="../img/footer/footerFont.png"alt=""/></p>
            <!-- 页面底部-备案号 #footer -->
            <div class="record">
                2001-2016 版权所有 京ICP证8000853号-56
            </div>
        </div>
        <div class="foot_left lf" >
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于嘉应学院</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../img/footer/wechat.png" alt=""/>
                    <img src="../img/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>嘉应学院商城客户端</p>
            <img src="../img/footer/ios.png" class="lf">
            <img src="../img/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../img/footer/erweima.png">
        </div>
    </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
    //搜索下拉
    $('.seek').focus(function(){

        if($(this).hasClass('clickhover')){

            $(this).removeClass('clickhover');
            $(this).find('.seek_content').hide();
            $(this).find('img').attr('src','../img/header/header_normal.png');

        }else{
            $(this).addClass('clickhover');
            $(this).find('.seek_content').show();
            $(this).find('img').attr('src','../img/header/header_true.png');
        }
    })
    $('.seek_content>div').click(function(){
        $('.seek').removeClass('clickhover');
        var text=$(this).html();
        $('.seek span').html(text);
        $(this).parent().hide();
        $('.seek').find('img').attr('src','../img/header/header_normal.png');
        $('.seek').blur();

    })

    $('.seek').blur(function(){

        $('.seek').removeClass('clickhover');
        $('.seek_content').hide();

        $('.seek').find('img').attr('src','../img/header/header_normal.png');
        console.log(1);
    })
    //头部hover
    $(".care").hover(function(){
        $(this).attr('src',"../img/header/care1.png");
    },function(){
        $(this).attr('src',"../img/header/care.png");
    });
    $(".order").hover(function(){
        $(this).attr('src',"../img/header/order1.png");
    },function(){
        $(this).attr('src',"../img/header/order.png");
    });
    $(".shopcar").hover(function(){
        $(this).attr('src',"../img/header/shop_car1.png");
    },function(){
        $(this).attr('src',"../img/header/shop_car.png");
    });
</script>
</html>
