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
    <span><img src="<%=path%>/assets/images/leftico01.png" /></span>学生信息管理
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="<%=path %>/studentinfo/toaddstudentinfo" target="rightFrame">学生注册</a><i></i></li>
        <li class=""><cite></cite><a href="<%=path %>/studentinfo/tostudentlist/0" target="rightFrame">学生列表</a><i></i></li>
        
        </ul>    
    </dd>
        
    <dd>
    <div class="title">
    <span><img src="<%=path%>/assets/images/leftico02.png" /></span>学生成绩管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/score/toscorestudentlist/0" target="rightFrame">学生列表</a><i></i></li>
        </ul>     
    </dd> 
    
    <dd>
    <div class="title">
    <span><img src="<%=path%>/assets/images/leftico02.png" /></span>学生课程管理
    </div>
    <ul class="menuson">
        <li class="active"><cite></cite><a href="<%=path %>/schedule/toaddbasicscourse" target="rightFrame">批量导入课程</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title">
    <span><img src="<%=path%>/assets/images/leftico03.png" /></span>选课信息管理
    </div>
    <ul class="menuson">
        <li class="active"><cite></cite><a href="#" target="rightFrame" >成绩查询</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">成绩导出</a><i></i></li>
    </ul>    
    </dd>  
   
    </dl>
</body>
</html>
