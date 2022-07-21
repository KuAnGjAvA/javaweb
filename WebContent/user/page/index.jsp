<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.tedu.javaweb.po.Book" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>嘉应学院商城学子餐饮页</title>
    <link href="../css/item.food.css" rel="stylesheet" />
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
    <link href="../css/slide.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<%@include file="headernav.jsp"%>


<!-- nav主导航-->
<div>&nbsp;</div>
<!-- banner部分-->
<div class="ck-slide">
    <ul class="ck-slide-wrapper">
        <li>
            <a href="../action/DetailServlet?isbn=9787302383666"><img src="../img/banner/banner1.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="../action/DetailServlet?isbn=9787111563891"><img src="../img/banner/banner2.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="../action/DetailServlet?isbn=9787111564805"><img src="../img/banner/banner3.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="../action/DetailServlet?isbn=9787115353528"><img src="../img/banner/banner4.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="../action/DetailServlet?isbn=9787121291609"><img src="../img/banner/banner5.png" alt=""></a>
        </li>
    </ul>
    <a href="javascript:;" class="ctrl-slide ck-prev">上一张</a> <a href="javascript:;" class="ctrl-slide ck-next">下一张</a>
    <div class="ck-slidebox">
        <div class="slideWrap">
            <ul class="dot-wrap">
                <li class="current"><em>1</em></li>
                <li><em>2</em></li>
                <li><em>3</em></li>
                <li><em>4</em></li>
                <li><em>5</em></li>
            </ul>
        </div>
    </div>
</div>
<!-- 特推部分-->

<!--商品-->
<div class="store">
    <div class="store_top">
        <img src="../img/banner/icon.png" alt=""/>
        热搜排行
    </div>


		<%
ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("books");
for(int i=0;i<books.size();i++){
  Book book = books.get(i);
  if(i%4==0){
%>
<div class="store_content">
<%
  }
%>
<div>
  <a href="../action/DetailServlet?isbn=<%=book.getIsbn() %>"><img src="../img/goods/<%=book.getIsbn() %>/index.jpg" alt=""/></a>
  <p class="one"><%=book.getTitle() %></p>
  <p class="two">
    <span>
      价格：<span>￥<%=book.getPrice() %></span>
    </span>
  </p>
  <p class="three">
    <span>
    出版社：<span><%=book.getPress() %></span>
    </span>
  </p>
</div>
<%
if(i%4==3||i==books.size()-1){
%>
</div>
<%
}
}
%>
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
            <p class="footer1"><img src="../img/footer" alt="" class=" footLogo"/></p>
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
<script src="../js/index.js"></script>
<script src="../js/slide.js"></script>
<script>
    $('.ck-slide').ckSlide({
        autoPlay: true,//默认为不自动播放，需要时请以此设置
        dir: 'x',//默认效果淡隐淡出，x为水平移动，y 为垂直滚动
        interval:3000//默认间隔2000毫秒
    });
</script>
</body>
</html>
