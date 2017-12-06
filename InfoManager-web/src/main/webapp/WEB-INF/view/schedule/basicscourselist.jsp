<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
 <link href="<%=path %>/assets/css/bootstrap.css" type="text/css" rel="stylesheet"  />
<script type="text/javascript" src="<%=path %>/assets/js/jquery-2.0.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/bootstrap.js"></script>
<style type="text/css">
.cli {

}

</style>
</head>

<body >
<div>
	<h1 >请填写完整所有信息:</h1>
</div>
<div>
     <form  class="form-horizontal" id="formadd" name="formadd" enctype="multipart/form-data" method="post" action="<%=path %>/scheduleinfo/addscheduleinfo">
	   <div class="form-group">
	    <label class="col-sm-2 control-label" for="file">添加文件:</label>
	  	
	   <div class="col-sm-2"> 
        <input id="filename" name="filename" class="form-control span2  form_datetime" type="text"  />
        <input id="file" type="file" name="myfile"  style="display: none" />
	    </div>
	    
	      <div class=" col-sm-2">
				<a href="<%=path %>/assets/excelmodel/course.xlsx">下载模板</a>
    	  </div>
	      <div class=" col-sm-2">
     			 <button type="button" class="btn btn-info ">提交</button>
    	  </div>
	   
		</div>
    </form>
  
    <div class="modal fade" id="myModal" style="display:none" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">消息</h4>
            </div>
            <div id="modalbodytext" class="modal-body " style="font-size: 20px"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
	</div>
	  </div>
<script language="javascript">
$(document).ready(function () {
	$("#filename").click(function(){
		$("#file").click();
	});
	$("#file").change(function(){
		var filename=$("#file").val();
		var pos=filename.lastIndexOf("\\");
		var name=filename.substring(pos+1);  
		$("#filename").val(name);
	});
	$(".btn").click(function(){
		var filename=$("#file").val();
		var pos=filename.lastIndexOf("\\");
		var name1=filename.substring(pos+1);
		var lastname=name1.split(".");
		if(lastname!=("xlsx")||lasename!=("xls")){
			alert("文件格式不正确");
			return ;
		}else{
			$("#formadd").submit();
		}
	});
}); 
</script> 
</body>
</html>
