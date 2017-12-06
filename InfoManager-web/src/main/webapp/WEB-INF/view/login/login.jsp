<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">   
 <title>欢迎使用学生信息管理系统</title>
 <link href="<%=path %>/assets/css/style.css" rel="stylesheet" type="text/css" />
 <link href="<%=path %>/assets/css/select.css" rel="stylesheet" type="text/css" />
 <link href="<%=path %>/assets/css/smoothness/jquery-ui.css" type="text/css" rel="stylesheet"  />
<script type="text/javascript" src="<%=path %>/assets/js/jquery-2.0.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/cloud.js" ></script>
<script type="text/javascript" src="<%=path %>/assets/js/select-ui.min.js"></script>
<script language="javascript">
 $(document).ready(function () {
	  $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		
		$(window).resize(function(){  
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		});
		
	    $(".select1").uedSelect({
			width : 300		  
		});
	//帮助提示
	$("#helpInfo").dialog({  
           autoOpen:false,  //设置对话框打开的方式 不是自动打开  
           show:"blind",    //打开时的动画效果  
           hide:"explode",    //关闭是的动画效果  
           modal:true,          //true代表运用遮罩效果  
            buttons:[  
                {  
                    text:"OK",  
                    click:function (){  
                        $(this).dialog("close");            //关闭对话框  
                    }  
                }],  
  
            closeOnEscape:false,    
            position:"top",  //对话框打开的位置，默认center，有top、left、right、center、bottom  
            width:500,      //设置对话框的宽度  
            height:300,     //设置对话框的高度  
            resizable:false,//是否可以改变对话框的尺寸的操作，默认true           
            zIndex:9999
             
        }).parent().find('.ui-widget-header').hide();  
             
       $("#showHelp").click(function(){
       
       		$("#helpInfo").dialog("open"); 
       		
       });
       $("#imgcode").click(function(){
    	   $("#imgcode").attr("src","<%=path%>/twocode/getcode?"+Math.random()); 
       });
		$("#submit").click(function(){
			$.ajax({
				url:"<%=path%>/user/loginin",
				type:"POST",
				data:{
					username:$("#username").val(),
					password:$("#password").val(),
					twocode:$("#twocode").val(),
					myid:$("#myid").val()
				},
				success:function(data){
					if(data=="10001"){
						alert("用户名或者密码不正确！");
					}else if(data=="10002"){
						alert("验证码不正确");
					}else if($("#myid").val()=='0'&&data=="10000"){
						window.location.href="<%=path%>/transpage/studentmain"; 
					}else if($("#myid").val()=='1'&&data=="10000"){
						window.location.href="<%=path%>/transpage/teachermain"; 
					}
				}
			});
		});
 });  
	
 
 	
</script> 
<style type="text/css">
	#helpInfo{
		 width:200px;
		 height:300px;
		 padding: 10px 50px;
		 display: none;
	}
	#helpInfo h2{
		text-align: center;
		font-size:22px;
		color:#333;
		font-family: 新宋体;
		border-bottom: 1px solid #ccc;
		margin: 0 0 5px 0;
	}
	#helpInfo p{
		font-size:13px;
		color:#666;
		line-height: 22px;
		text-indent: 2em;
		padding: 3px 0;
	}
	#helpInfo b{
		color:#333;
		font-weight: bold;
		width:50px;
		text-align: right;
	}
</style>
</head>

<body style="background-color:#1c77ac; background-image:url(<%=path%>/assets/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="helpInfo">
    	<h2>帮助信息</h2>
    	<p><b>系统角色</b> : 使用本系统有两种身份: 1.学生  2.老师 </p>
    	<p><b>关于登陆</b> : 注意考生的登陆名为: <b>学号</b> 初始密码为 :<b>学号后六位</b> ,学生登录请下拉选择"我是学生" </p>
    	<p><b>关于注册 </b>:  请联系管理员创建账号录入实际信息</p>
    </div>
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎使用学生信息管理系统</span>    
    <ul>
    <li><a href="javascript:;" id="showHelp">帮助</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
     <form id="form1" name="form1" method="post" action="<%=path %>/user/logininto">
	    <ul>
	    <li><input id="username" name="username" type="text" class="loginuser"   value="111" placeholder="请输入用户名"/></li>
	    <li><input id="password" name="password" type="password" class="loginpwd" value="111111" placeholder="请输入密码"/></li>
	   	<li>
	   	<input id="twocode" name="twocode" placeholder="请输入验证码" type="text" style="width:100px;height: 30px" class="loginuser"/>
	   	<img id="imgcode" name="imgcode" style="height: 30px" src="<%=path %>/twocode/getcode" onclick="changecode()"></li>
	    <li>
	    	<div class="vocation" >
			    <select id="myid" class="select1" name="myId" style="background:#ecf5fa" >
			    <option value="0" >我是学生</option>
			    <option value="1" >我是老师</option>
			    </select>
	    	</div>
	    </li>
	    
	    <li><input id="submit" name="submit" type="button" class="loginbtn" value="登 录"  /></li>
	    </ul>
    </form>
    
    </div>
    </div>
   <!--  </div>
    <div class="loginbm">Copyright © 2015-2016 </div> -->
</body>
</html>
