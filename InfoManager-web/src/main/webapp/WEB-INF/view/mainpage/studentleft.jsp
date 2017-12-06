<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="<%=path %>/assets/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=path%>/assets/js/jquery-2.0.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active");
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
});
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>后台管理</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="<%=path%>/assets/images/leftico01.png" /></span>题库管理
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="#" target="rightFrame">系统首页</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">管理题库</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">创建题库</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">管理试题</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">增加试题</a><i></i></li>
        </ul>    
    </dd>
        
    <dd>
    <div class="title">
    <span><img src="<%=path%>/assets/images/leftico02.png" /></span>考试管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#" target="rightFrame">试卷列表</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">创建试卷</a><i></i></li>
        </ul>     
    </dd> 
    
    <dd>
    <div class="title">
    <span><img src="<%=path%>/assets/images/leftico02.png" /></span>考生管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#" target="rightFrame">考生列表</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">添加考生</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">分组管理</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">创建分组</a><i></i></li>
        <li><cite></cite><a href="#" >批量导入</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title">
    <span><img src="<%=path%>/assets/images/leftico03.png" /></span>成绩管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#" target="rightFrame" >成绩查询</a><i></i></li>
        <li><cite></cite><a href="#">成绩导出</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span>
    <img src="<%=path%>/assets/images/leftico04.png" /></span>系统设置</div>
    <ul class="menuson">
        <li><cite></cite><a href="#"  target="rightFrame" >系统设置</a><i></i></li>
        <li><cite></cite><a href="#">其他设置</a><i></i></li>
    </ul>   
    </dd>   
    </dl>
</body>
</html>
