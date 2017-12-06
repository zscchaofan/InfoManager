<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<link href="<%=path%>/assets/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=path%>/assets/js/jquery-2.0.js"></script>
</head>
<body style="background:url(<%=path%>/assets/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="#"><img src="<%=path %>/assets/images/loginlogo.png" title="系统首页" /></a>
    </div>
    <div class="topright">    
    <ul>
    <li>
    <div class="user">
    <span>${user.name}</span>
    </div> </li>
    <li>
    <div>
    <a href="<%=path %>/user/logout" target="_parent">退出</a>
    </div>
    </li>

    </ul>
    </div>
</body>
</html>
