<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.tedu.javaweb.po.Book" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>嘉应学院商城学子餐饮页</title>
    <link href="../css/item.food.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/slide.css" rel="stylesheet"/>
</head>
<body>

<!-- 页面顶部-->
<header id="top">
<%--    <div id="logo" class="lf">--%>
<%--        <img src="" alt="logo"/>--%>
<%--    </div>--%>
    <div id="logo" class="lf">
        <img src="../img/logo.png" alt="logo"/>
    </div>

    <%--    ../action/SearchBookServlet--%>
<%--    <div id="top_input" class="lf">--%>
<%--        <form  action="../action/SearchBookServlet">--%>
<%--            <input id="input" name="search" type="text"  placeholder="请输入您要搜索的内容2"/>--%>
<%--            &lt;%&ndash;            <a  onclick="document:select.submit()" class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/>&ndash;%&gt;--%>
<%--            <a class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>--%>
<%--            &lt;%&ndash;            onclick="document:select.submit()"&ndash;%&gt;--%>
<%--        </form>--%>
<%--    </div>--%>

<%--    <div id="top_input" class="lf">--%>
<%--        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>--%>

<%--        <a href="" class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>--%>
<%--    </div>--%>
    <div id="top_input" class="lf">
        <form id="lzk"  action="../action/SearchBookServlet" name="select" id="select">
            <input id="input" name="search" type="text"  placeholder="请输入您要搜索的内容"/>
<%--            <a onclick="document:select.submit();" class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>--%>

            <a  onclick="abc(event)" href="#"  class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>
        </form>
    </div>


    <div class="rt">
        <ul class="lf">
            <li><a href="../action/AllBookServlet">首页</a><b>|</b></li>
            <li><a href="../action/MyCollectServlet">收藏</a><b>|</b></li>
            <li><a href="../action/ShowOrderServlet?pageIndex=1&start=0&length=10">订单</a><b>|</b></li>
            <li><a href="../action/ShowCartServlet">购物车</a><b>|</b></li>
            <li><a href="../page/password-change.jsp">设置</a><b>|</b></li>
            <li><a href="../action/LogoutServlet">退出</a><b>|</b></li>
            <li><a href="../page/lookforward.jsp">帮助</a></li>
        </ul>
    </div>
</header>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/slide.js"></script>
<script>
    function abc(event){
        event.preventDefault();
        var elementById = document.getElementById("lzk");
        elementById.submit();
    }

      // function closelogin(){
      //     if(confirm("是否退出")){
      //         window.location.href="login.jsp";
      //         return true;
      //     }
      //     return false;
      // }
</script>
</body>
</html>
