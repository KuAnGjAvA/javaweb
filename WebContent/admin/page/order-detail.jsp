<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>订单详情</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- page style-->
  <style>
  .my_itemtitle{
    font-size: 20px;
  }
  .my_info{
    width: 50% !important;
  }
  .my_print{
    text-align: right;
  }
  </style>
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../css/font-awesome/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../css/Ionicons/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../css/AdminLTE/AdminLTE.min.css">
  <!-- AdminLTE Skin -->
  <link rel="stylesheet" href="../css/AdminLTE/skin/skin-blue.min.css">
  <!-- Google Font -->
  <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
<%--  <header class="main-header">--%>

<%--    <!-- Logo -->--%>
<%--    <a href="#" class="logo">--%>
<%--      <!-- mini logo for sidebar mini 50x50 pixels -->--%>
<%--      <span class="logo-mini"><b>书城</b></span>--%>
<%--      <!-- logo for regular state and mobile devices -->--%>
<%--      <span class="logo-lg">学子书城管理系统</span>--%>
<%--    </a>--%>

    <!-- Header Navbar -->
<%--    <%@include file="headernav.jsp"%>--%>
<%--    <nav class="navbar navbar-static-top" role="navigation">--%>
<%--      <!-- Sidebar toggle button-->--%>
<%--      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">--%>
<%--        <span class="sr-only">导航切换</span>--%>
<%--      </a>--%>
<%--      <!-- Navbar Right Menu -->--%>
<%--      <div class="navbar-custom-menu">--%>
<%--        <ul class="nav navbar-nav">--%>
<%--          <!-- Messages: style can be found in dropdown.less-->--%>
<%--          <!-- /.messages-menu -->--%>
<%--          <!-- User Account Menu -->--%>
<%--          <li class="dropdown user user-menu">--%>
<%--            <!-- Menu Toggle Button -->--%>
<%--            <a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
<%--              <!-- The user image in the navbar-->--%>
<%--              <img src="../img/setting.png" class="user-image" alt="User Image">--%>
<%--              <!-- hidden-xs hides the username on small devices so only the image appears. -->--%>
<%--              <span class="hidden-xs">${sessionScope.user.uname }</span>--%>
<%--            </a>--%>
<%--            <ul class="dropdown-menu">--%>
<%--              <!-- The user image in the menu -->--%>
<%--              <li class="user-header">--%>
<%--                <img src="../img/word.jpg" class="img-circle" alt="User Image">--%>
<%--                <p>让学习成为一种习惯</p>--%>
<%--              </li>--%>
<%--              <!-- Menu Footer-->--%>
<%--              <li class="user-footer">--%>
<%--                <div class="pull-left">--%>
<%--                  <a href="../page/password-change.jsp" class="btn btn-default btn-flat">修改密码</a>--%>
<%--                </div>--%>
<%--                <div class="pull-right">--%>
<%--                  <a href="../action/LogoutServlet" class="btn btn-default btn-flat">退出</a>--%>
<%--                </div>--%>
<%--              </li>--%>
<%--            </ul>--%>
<%--          </li>--%>
<%--        </ul>--%>
<%--      </div>--%>
<%--    </nav>--%>
<%--  </header>--%>
  <!-- Left side column. contains the logo and sidebar -->
  <%@include file="leftnav.jsp"%>
<%--  <aside class="main-sidebar">--%>

<%--    <!-- sidebar: style can be found in sidebar.less -->--%>
<%--    <section class="sidebar">--%>
<%--      <!-- Sidebar Menu -->--%>
<%--      <ul class="sidebar-menu" data-widget="tree">--%>
<%--        <li class="header">&nbsp;</li>--%>
<%--        <!-- Optionally, you can add icons to the links -->--%>
<%--        <li class="treeview">--%>
<%--          <a href="#"><i class="fa fa-link"></i> <span>订单管理</span>--%>
<%--            <span class="pull-right-container">--%>
<%--                <i class="fa fa-angle-left pull-right"></i>--%>
<%--              </span>--%>
<%--          </a>--%>
<%--          <ul class="treeview-menu">--%>
<%--            <li><a href="order-list.html">所有订单</a></li>--%>
<%--            <li><a href="#">待处理</a></li>--%>
<%--            <li><a href="#">处理中</a></li>--%>
<%--            <li><a href="#">已发货</a></li>--%>
<%--            <li><a href="#">已交付</a></li>--%>
<%--          </ul>--%>
<%--        </li>--%>
<%--        <li class="treeview">--%>
<%--          <a href="#"><i class="fa fa-link"></i> <span>商品管理</span>--%>
<%--            <span class="pull-right-container">--%>
<%--                <i class="fa fa-angle-left pull-right"></i>--%>
<%--              </span>--%>
<%--          </a>--%>
<%--          <ul class="treeview-menu">--%>
<%--            <li><a href="product-list.html">所有商品</a></li>--%>
<%--            <li><a href="product-add.html">添加商品</a></li>            --%>
<%--          </ul>--%>
<%--        </li>--%>
<%--      </ul>--%>
<%--      <!-- /.sidebar-menu -->--%>
<%--    </section>--%>
<%--    <!-- /.sidebar -->--%>
<%--  </aside>--%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1><small></small></h1>
      <ol class="breadcrumb">
        <li><i class="fa fa-dashboard">&nbsp;订单管理</i></li>
        <li><a href="../page/order-list1.jsp"><i class="fa"></i>所有订单</a></li>
        <li class="active">查看订单</li>
      </ol>
    </section>
    <!-- Main content -->
    <section class="invoice">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header">
            <i class="fa"></i>订单详情
            <small class="pull-right">日期: <jsp:useBean id="now" class="java.util.Date" /><fmt:formatDate value="${now }" pattern="yyyy.MM.dd"/></small>
          </h2>
        </div>
        <!-- /.col -->
      </div>
      <!-- info row -->
      <div class="row invoice-info">
        <div class="col-sm-4 invoice-col my_info">
            <b class="my_itemtitle">收件人</b><br>
            <br>

            <b>姓名：</b>${requestScope.address.receiver }<br>
            <b>地址：</b>${requestScope.address.address }<br>
            <b>电话：</b>${requestScope.address.receiverPhone }<br>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col my_info">
          <b class="my_itemtitle">#${requestScope.orderinfo.orderId }</b><br>
          <br>
          <b>创建时间：</b><fmt:formatDate value="${requestScope.orderinfo.placed }" pattern="yyyy.MM.dd HH:mm"/><br>
          <b>订单总额：</b>￥${requestScope.orderinfo.payment }<br>
          <b>订单状态：</b>  ${requestScope.orderinfo.sta }
<%--          <b>订单状态：</b>  ==  ${requestScope.orderinfo.orderId}--%>

        </div>
        <!-- /.col -->
      </div>
      <hr>
      <!-- /.row -->
      <!-- Table row -->
      <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
            <thead>
            <tr>
              <th>数量</th>
              <th>名称</th>
              <th>商品编号</th>
              <th>商品描述</th>
              <th>单价</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${requestScope.orderitem }">
            <tr>
              <td>${item.orderItem.count }</td>
              <td>${item.book.title }</td>
              <td>${item.book.isbn }</td>
              <td>${item.book.press }</td>
              <td>￥${item.orderItem.price }</td>
            </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
      <hr>
      <!-- this row will not appear when printing -->
      <div class="row no-print">
        <div class="col-xs-12 my_print">
<%--          <a href="../servlet/order-print?orderId=${requestScope.orderinfo.orderId }" target="_blank" class="btn btn-default"><i class="fa fa-print"></i> Print</a>--%>
          <a href="../action/OrderPrintServlet?orderId=${requestScope.orderinfo.orderId}" target="_blank" class="btn btn-default"><i class="fa fa-print"></i> Print</a>
        </div>
      </div>
    </section>
    <!-- /.content -->
    <div class="clearfix"></div>
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      年轻人的中国梦
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2021 <a href="http://www.xxx.cn">嘉应学院教育</a>.</strong> All rights reserved.
  </footer>

  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../js/bootstrap/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../js/datatables.net/jquery.dataTables.min.js"></script>
<script src="../js/datatables.net-bs/dataTables.bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../js/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../js/AdminLTE/adminlte.min.js"></script>
<!-- page script -->
<script>

</script>
</body>
</html>
