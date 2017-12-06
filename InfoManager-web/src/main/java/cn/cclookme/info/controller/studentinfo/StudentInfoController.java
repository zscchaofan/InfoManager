package cn.cclookme.info.controller.studentinfo;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cclookme.info.api.user.service.IStudentInfoService;
import cn.cclookme.info.model.user.StudentInfo;
import cn.cclookme.info.model.user.TeacherInfo;


@Controller
@RequestMapping("/studentinfo")
public class StudentInfoController {
	private static final Logger log=Logger.getLogger(StudentInfoController.class);
	@Autowired
	private IStudentInfoService studentInfoService;
	
	@RequestMapping("/toaddstudentinfo")
	public String toAddStudentInfo(HttpServletRequest request){
		request.setAttribute("savesuccess", "2");
		return "/studentinfo/addstudentinfo";
	}
	@RequestMapping("/tostudentlist/{num}")
	public String toStudentlist(HttpServletRequest request,@PathVariable Integer num){
		String cardid=request.getParameter("studentCardId");
		String name=request.getParameter("studentName");
		String status=request.getParameter("studentStatus");
		String specialty=request.getParameter("studentSpecialty");
		String page=request.getParameter("page");
		TeacherInfo teacherInfo=new TeacherInfo();
		teacherInfo=(TeacherInfo) request.getSession().getAttribute("user");
		String acasemy=teacherInfo.getAcademy();
		Map<String ,Object> map=new HashMap<String ,Object>();
		if(num==0){
			request.setAttribute("pagenow", "1");
		}else{
			map=studentInfoService.getStudentList(cardid, name, status, specialty,acasemy, Integer.parseInt(page));
			request.setAttribute("cardid", cardid);
			request.setAttribute("name", name);
			request.setAttribute("status", status);
			request.setAttribute("specialty", specialty);
			request.setAttribute("pagenow", page);
			request.setAttribute("pagetotal", map.get("pagetotal"));
			request.setAttribute("studentList", map.get("retObject"));
		}
		return "/studentinfo/studentlist";
	}
	
	@RequestMapping("/addstudentinfo")
	public String addstudentinfo(HttpServletRequest request,StudentInfo studentinfo){
		Map<String ,Object> map =new HashMap<String ,Object>();
		map=studentInfoService.saveStudentInfo(studentinfo);
		if(map.get("retCode").equals("0000")){
			request.setAttribute("savesuccess", "1");
		}else{
			request.setAttribute("savesuccess", "0");
		}
		return "/studentinfo/addstudentinfo";
	}
	@RequestMapping("/toupdatestudent/{cardid}")
	public String toUpdateStudentInfo(HttpServletRequest request,@PathVariable String cardid){
		Map<String ,Object> map=new HashMap<String ,Object>();
		map=studentInfoService.getStudentInfoByStudentCardId(cardid);
		StudentInfo info=(StudentInfo) map.get("retObject");
		request.setAttribute("student", info);
		return "/studentinfo/updatestudent";
	}
	@RequestMapping("/updatestudentinfo")
	public String UpdateStudentInfo(HttpServletRequest request,StudentInfo studentInfo){
		Map<String ,Object> map=new HashMap<String ,Object>();
		map=studentInfoService.updateStudentInfo(studentInfo);
		if(map.get("retCode").equals("0000")){
			request.setAttribute("upsusorfail", "1");
		}else{
			request.setAttribute("upsusorfail", "0");
		}
		request.setAttribute("student", studentInfo);
		return "/studentinfo/updatestudent";
	}
}
