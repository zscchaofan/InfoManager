<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery-2.0.js"></script>
</head>
<body style="background:url(<%=path%>/assets/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="<%=path %>/transpage/studentmain" target="_parent"><img src="<%=path %>/assets/images/loginlogo.png" title="系统首页" /></a>
    </div>
   
            
    <div class="topright">    
    <ul>
    <li><span><img src="<%=path %>/assets/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="adminLogout.action" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>${user.studentName}</span>
   
    </div>    

    </div>

</body>
</html>
