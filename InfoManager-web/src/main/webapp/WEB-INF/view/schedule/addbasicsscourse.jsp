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
     <form  class="form-horizontal" id="formadd" name="formadd" enctype="multipart/form-data" method="post" action="<%=path %>/schedule/addscheduleinfo">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="file">添加文件:</label>

				<div class="col-sm-2">
					<input id="filename" name="filename"
						class="form-control span2" type="text" /> 
					<input
						id="file" type="file" name="file" style="display: none" />
				</div>

				<div class=" col-sm-2">
					<a href="<%=path%>/assets/excelmodel/course.xlsx">下载模板</a>
				</div>
				<div class=" col-sm-2">
					<button id="submitbutton" type="button" class="btn btn-info ">提交</button>
				</div>

			</div>
		</form>
  <input id="savesuccess" style="display : none" value="${savesuccess}">
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
	 var savesuc=$("#savesuccess").val();
	 if(savesuc=='1'){
		 $("#modalbodytext").empty();
		 $("#modalbodytext").text("导入成功");
		 $("#myModal").modal('show');
	 }else if(savesuc=='0'){
		 $("#modalbodytext").empty();
		 $("#modalbodytext").text("导入失败");
		 $("#myModal").modal('show');
	 }
	 $("#savesuccess").val('2');
	$("#file").change(function(){
		var filename=$("#file").val();
		var pos=filename.lastIndexOf("\\");
		var name=filename.substring(pos+1);  
		$("#filename").val(name);
	});
	$("#submitbutton").click(function(){
		var filename=$("#file").val();
		var pos=filename.lastIndexOf("\\");
		var name1=filename.substring(pos+1);
		var lastname=name1.split(".");
		if((lastname[1]!="xlsx")&&(lastname[1]!="xls")){
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
