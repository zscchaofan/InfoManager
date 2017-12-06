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
	<h3 >请填写查询信息:</h3>
</div>

<div>
     <form  class="form-horizontal" id="formadd" name="formadd" method="post" action="<%=path %>/score/toscorestudentlist/1">
	   <div class="form-group">
	    <label class="col-sm-2 control-label" for="studentCardId">学生学号:</label>
	   <div class="col-sm-2"> 
        <input id="studentCardId" name="studentCardId" class="form-control " type="text" value="${cardid} " onclick="JavaScript:this.value=''" />
	    </div>
	    <label class="col-sm-2 control-label" for="studentName">学生姓名:</label>
	     <div class="col-sm-2">
	    <input id="studentName" name="studentName" class="form-control" type="text"  value="${name} " onclick="JavaScript:this.value=''"/>
		</div>
		</div>
	   <div class="form-group">
	    <label class="col-sm-2 control-label" for="studentSpecialty">专业名:</label>
	     <div class="col-sm-2">
	    <input id="studentSpecialty" name="studentSpecialty" class="form-control" type="text"  value="${specialty}" onclick="JavaScript:this.value=''"/>
	    <input id="page" name="page" style="display: none" value="1">
	    </div>
	    
	   <label class="col-sm-2 control-label" for="enrollmentYear">入学年份:</label>
	     <div class="col-sm-2">
	    <input id="enrollmentYear" name="enrollmentYear" class="form-control" type="text"  value="${enrollmentYear} " onclick="JavaScript:this.value=''"/>
		</div>
	      <div class="col-sm-2">
     			 <button id="submitbutton" type="submit" class="btn btn-info" >查询</button>
    	  </div>
	    </div>
    </form>
  <hr >
  <div>
  
<table class="table table-hover">
  <thead>
    <tr>
      <th width="10%">学生卡号</th>
      <th width="10%">姓名</th>
      <th width="10%">性别</th>
      <th width="20%">学院</th>
      <th width="20%">专业</th>
      <th width="10%">班级</th>
      <th width="10%">入学年份</th>
      <th width="10%">状态</th>
    </tr>
  </thead>
  <tbody>
   	<c:forEach items="${studentList}" var="student" >
   		<tr>
   			<td><a href="<%=path%>/score/tomodifyscore/${student.studentCardid}/0">${student.studentCardid}</a> </td>
   			<td>${student.studentName}</td>
   			<c:choose>
   			<c:when test="${student.sexid=='1'}">
   			<td>男</td>
   			</c:when>
   			<c:when test="${student.sexid=='2'}">
   			<td>女</td>
   			</c:when>
   			</c:choose>
   			<td>${student.academy}</td>
   			<td>${student.specialty}</td>
   			<td>${student.classname}班</td>
   			<td>${student.enrollmentYear}</td>
   			<c:choose>
   			<c:when test="${student.status=='1'}">
   			<td>正常在读</td>
   			</c:when>
   			<c:when test="${student.status=='2'}">
   			<td>已毕业</td>
   			</c:when>
   			<c:when test="${student.status=='3'}">
   			<td>辍学</td>
   			</c:when>
   			</c:choose>
   		</tr>
   	</c:forEach>
  </tbody>
</table>
	<ul class="pager">
  	  <li id="preli" class="previous "><a type="button" >&larr; 上一页</a></li>
 	   <li id="nexli" class="next"><a type="button" >下一页 &rarr;</a></li>
	</ul>
  	<input id="cardid" style="display:none" value="${cardid}">
  	<input id="name" style="display:none" value="${ name}">
  	<input id="specialty" style="display:none" value="${specialty}">
  	<input id="pagenow" style="display:none" value="${pagenow}">
  	<input id="pagetotal" style="display:none" value="${pagetotal}">
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
	 $(".previous a").click(function(){
		 var pagenow=$("#pagenow").val();
			var numpagenow=parseInt(pagenow);
			numpagenow=numpagenow-1;
			if(numpagenow<=0){
				return ;
			}
			 $("#page").val(numpagenow);
			 $("#submitbutton").click();
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
			$("#page").val(numpagenow);
			$("#submitbutton").click();
	 });
 }); 
 

</script> 
</body>
</html>
