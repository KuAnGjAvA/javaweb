<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="cn.tedu.javaweb.po.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>左侧导航</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- page style -->
    <style>
        .my_content {
            padding-top: 18%;
            text-align: center;
            font-size: 28px;
            /*background: #f00;*/
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
<body>
<header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>书城</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg">学子书城管理系统</span>
    </a>
    <%--Header Navbar--%>
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">导航切换</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <!-- /.messages-menu -->
                <!-- User Account Menu -->
                <li class="dropdown user user-menu">
                    <!-- Menu Toggle Button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <!-- The user image in the navbar-->
                        <img src="../img/setting.png" class="user-image" alt="User Image">
                        <!-- hidden-xs hides the username on small devices so only the image appears. -->
                        <span class="hidden-xs">${sessionScope.user.uname }</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- The user image in the menu -->
                        <li class="user-header">
                            <img src="../img/word.jpg" class="img-circle" alt="User Image">
                            <p>让学习成为一种习惯</p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="../page/password-change.jsp" class="btn btn-default btn-flat">修改密码11</a>
                            </div>
                            <div class="pull-right">
                                <a href="../action/LogoutServlet" class="btn btn-default btn-flat">退出</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">&nbsp;</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="treeview">
                <a href="#"><i class="fa fa-link"></i> <span>订单管理</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="../page/order-list1.jsp">所有订单</a></li>
                    <li><a href="../page/order-list2.jsp">待处理</a></li>
                    <li><a href="../page/order-list3.jsp">处理中</a></li>
                    <li><a href="../page/order-list4.jsp">已发货</a></li>
                    <li><a href="../page/order-list5.jsp">已交付</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-link"></i> <span>商品管理</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="../page/product-list.jsp">所有商品</a></li>
                    <li><a href="../page/product-add.jsp">添加商品</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
</body>
</html>
