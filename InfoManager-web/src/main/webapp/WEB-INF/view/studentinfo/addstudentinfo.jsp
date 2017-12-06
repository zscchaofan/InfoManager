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
 <link href="<%=path %>/assets/css/bootstrap.css" type="text/css" rel="stylesheet"  />
 <link href="<%=path %>/assets/css/bootstrapValidator.css" type="text/css" rel="stylesheet"  />
 <link href="<%=path %>/assets/css/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"  />
<script type="text/javascript" src="<%=path %>/assets/js/jquery-2.0.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
</head>

<body >
<input id="savesuccess" style="display : none" value="${savesuccess}">
<div>
	<h1 >请填写完整所有信息:</h1>
</div>
<div>
     <form  class="form-horizontal" id="formadd" name="formadd" method="post" action="<%=path %>/studentinfo/addstudentinfo">
	   <div class="form-group">
	    <label class="col-sm-2 control-label" for="enrollmentYear">入学年份:</label>
	  	
	   <div class="col-sm-3"> 
	        <div class="input-append date" id="datetimepicker" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
        <input id="enrollmentYear" name="enrollmentYear" class="form-control span2  form_datetime" type="text"  />
   		 </div>            
	    </div>
	    <label class="col-sm-2 control-label" for="studentName">学生姓名:</label>
	     <div class="col-sm-3">
	    <input id="studentName" name="studentName" class="form-control" type="text"  />
		</div>
		</div>
		<div class="form-group">
	    <label class="col-sm-2 control-label" for="sexid">学生性别:</label>
	     <div class="col-sm-3">
		  <select id="sexid" name="sexid" class="form-control">
			    <option value="1" >男</option>
			    <option value="2" >女</option>
		  </select>
		</div>
	    <label class="col-sm-2 control-label" for="birthday" >出生日期:</label>
	     <div class="col-sm-3">
	    <input id="birthday" name="birthday" class="form-control form_datetime" type="text"  />
	    </div>
	   </div>
	   <div class="form-group">
	    <label class="col-sm-2 control-label" for="nativePlace">籍贯:</label>
	     <div class="col-sm-3">
	    <input id="nativePlace" name="nativePlace" class="form-control" type="text"  />
	   </div>
	    <label class="col-sm-2 control-label" for="academy">学院名:</label>
	     <div class="col-sm-3">
	    <input id="academy" name="academy" class="form-control" type="text"  />
	    </div></div>
	   <div class="form-group">
	    <label class="col-sm-2 control-label" for="specialty">专业:</label>
	     <div class="col-sm-3">
	    <input id="specialty" name="specialty" class="form-control" type="text"  />
	    </div>
	    <label class="col-sm-2 control-label" for="classname">班级:</label>
	     <div class="col-sm-3">
	    <input id="classname" name="classname" class="form-control" type="text"  />
	    </div>
	    </div>
	      <div class="form-group">
	      <div class="col-sm-offset-2 col-sm-10">
     			 <button type="submit" class="btn btn-info">提交</button>
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
	 $('.form_datetime').datetimepicker({
		    minView: "month", //选择日期后，不会再跳转去选择时分秒 
		    language:  'zh-CN',
		    format: 'yyyy-mm-dd',
		    todayBtn:  1,
		    autoclose: 1,
		});
	 var savesuc=$("#savesuccess").val();
	 if(savesuc=='1'){
		 $("#modalbodytext").empty();
		 $("#modalbodytext").text("添加成功");
		 $("#myModal").modal('show');
	 }else if(savesuc=='0'){
		 $("#modalbodytext").empty();
		 $("#modalbodytext").text("添加失败");
		 $("#myModal").modal('show');
	 }
	 $("#savesuccess").val('2');
 }); 
</script> 
</body>
</html>
