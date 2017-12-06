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
 <link href="<%=path %>/assets/css/bootstrapValidator.css" type="text/css" rel="stylesheet"  />
 <link href="<%=path %>/assets/css/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"  />
<script type="text/javascript" src="<%=path %>/assets/js/jquery-2.0.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
<style type="text/css">
.cli {
	
}
.mosco{

}
</style>
</head>

<body >
<div>
<div id="myTabContent" class="">
  <div>
<table class="table table-hover">
  <thead>
    <tr>
      <th width="10%">学生卡号</th>
      <th width="10%">姓名</th>
      <th width="10%">课程名称</th>
      <th width="15%">课程开始时间</th>
      <th width="15%">课程结束时间</th>
      <th width="10%">任课老师</th>
      <th width="10%">成绩</th>
      <th width="10%">录入时间</th>
      <th width="10%">操作</th>
    </tr>
  </thead>
  <tbody>
   	<c:forEach items="${CourseList}" var="course" varStatus="status">
   		<tr>
   			<td>${studentcardid}</td>
   			<td>${studentname}</td>
   			<td>${course.courseCode}</td>
   			<td>${course.startTime}</td>
   			<td>${course.endTime}</td>
   			<td>${course.classroomTeacher}</td>
   			<td>${course.score}</td>
   			<td>${course.wirteInTime}</td>
   			<td><a id="delsco${status.index}" name="delsco${status.index}" class="mosco" type="button" >删除</a></td>
   		</tr>
   	</c:forEach>
  </tbody>
</table>
<div  >
<a id="glyphicona">
  <span  class="glyphicon-plus" style="font-size: 20px;margin-left: 80px;">新增成绩</span>
</a>
</div>
	<ul class="pager">
  	  <li id="preli" class="previous "><a type="button" >&larr; 上一页</a></li>
 	   <li id="nexli" class="next"><a type="button" >下一页 &rarr;</a></li>
	</ul>
  	<input id="name" style="display:none" value="${ studentname}">
  	<input id="pagenow" style="display:none" value="${pagenow}">
  	<input id="pagetotal" style="display:none" value="${pagetotal}">
  </div>
  </div>
		<div class="modal fade" id="myModal" style="display:none" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">新增成绩</h4>
            </div>
            <div id="modalbodytext" class="modal-body " style="font-size: 20px">
	<form  class="form-horizontal" id="formadd" name="formadd" method="post" action="<%=path %>/score/addstudentscore">
	  	<input id="cardid" name="cardid" style="display:none" value="${studentcardid}">
	   <div class="form-group">
	    <label class="col-sm-2 control-label" for="courseCode">课程名称:</label>
	   <div class="col-sm-3"> 
	        <input id="courseCode" name="courseCode" class="form-control" type="text"  />
	    </div>
	    <label class="col-sm-2 control-label" for="classroomTeacher">任课老师:</label>
	     <div class="col-sm-3">
	    <input id="classroomTeacher" name="classroomTeacher" class="form-control" type="text"  />
		</div>
		</div>
		<div class="form-group">
	    <label class="col-sm-2 control-label" for="startTime">课程开始时间:</label>
	     <div class="col-sm-3">
		  <div class="input-append date" id="datetimepicker" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
        <input id="startTime" name="startTime" class="form-control span2  form_datetime" type="text"  />
   		 </div> 
		</div>
	    <label class="col-sm-2 control-label" for="endTime" >课程结束时间:</label>
	     <div class="col-sm-3">
	    <div class="input-append date" id="datetimepicker" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
        <input id="endTime" name="endTime" class="form-control span2  form_datetime" type="text"  />
   		 </div>  </div>
	   </div>
	   <div class="form-group">
	    <label class="col-sm-2 control-label" for="score">分数:</label>
	     <div class="col-sm-3">
	    <input id="score" name="score" class="form-control" type="text"  />
	   </div>
	    </div>
	      <div class="form-group">
	      <div class="col-sm-offset-2 col-sm-10">
     			 <button type="submit" class="btn btn-info">提交</button>
    	  </div>
	      </div>
    </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
	</div>
</div>

<script language="javascript">
 $(document).ready(function () {
	 var pagenow1=$("#pagenow").val();
	 var pagetotal1=$("#pagetotal").val();
	 if(pagenow1=='1'||pagenow1==""){
		 $("#preli").addClass("disabled");
	 }
	 if(pagenow1==pagetotal1||pagetotal1==""){
		 $("#nexli").addClass("disabled");
	 } 
	 $("#glyphicona").click(function(){
		 $("#myModal").modal('show');
	 });
	 $(".mosco").click(function(){
		 var name=$(this).attr('name');
		 var num=name.substring(6,name.length);	
		 var id=$("tbody").find("tr").eq(parseInt(num)).find("td").eq(0).text();
		 var code=$("tbody").find("tr").eq(parseInt(num)).find("td").eq(2).text();
		 var starttime=$("tbody").find("tr").eq(parseInt(num)).find("td").eq(3).text();
		 var endtime=$("tbody").find("tr").eq(parseInt(num)).find("td").eq(4).text();
		 var score=$("tbody").find("tr").eq(parseInt(num)).find("td").eq(6).text();
	 	$.ajax({
	 		 type: 'POST',
	 		 url:"<%=path%>/score/deletescore",
	 		 data: {id:id,coursecode:code,starttime:starttime,endtime:endtime,score:score},
	 		 success: function(date){
				if(date==1){
					alert("删除成功");
					window.location.href="<%=path%>/score/tomodifyscore/"+id+"/0";
				}else{
					alert("删除失败");
				}
	 		 }
	 });
	 });
	 $(".previous a").click(function(){
		 var pagenow=$("#pagenow").val();
			var numpagenow=parseInt(pagenow);
			numpagenow=numpagenow-1;
			if(numpagenow<=0){
				return ;
			}
			 var cardnum=$("#cardid").val();
			 window.location.href="<%=path %>/score/tomodifyscore/" +cardnum+"/"+numpagenow;
	 });
	 $(".next a").click(function(){
		 var pagenow=$("#pagenow").val();
			var numpagenow=parseInt(pagenow);
			numpagenow=numpagenow+1;
			var pagetotal=$("#pagetotal").val();
			var pagetotalnum=parseInt(pagetotal);
			if(numpagenow>pagetotalnum){
				return ;
			}
			numpagenow=numpagenow-1;
			 var cardnum=$("#cardid").val();
			 window.location.href="<%=path %>/score/tomodifyscore/" +cardnum+"/"+numpagenow;
	 });
	 $('.form_datetime').datetimepicker({
		    minView: "month", //选择日期后，不会再跳转去选择时分秒 
		    language:  'zh-CN',
		    format: 'yyyy-mm-dd',
		    todayBtn:  1,
		    autoclose: 1,
		});
	 $("#optioncourse").click(function(){
		 window.location.href="<%=path %>/score/";
	 });
	 $("#basicscourse").click(function(){
		 
	 });
 }); 
 
</script> 
</body>
</html>
