package cn.cclookme.info.controller.score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cclookme.info.api.courseschedule.service.IBasicsCourseScheduleService;
import cn.cclookme.info.api.courseschedule.service.IOptionalCourseScheduleService;
import cn.cclookme.info.api.score.service.IStudentScoreService;
import cn.cclookme.info.api.specialty.service.ISpecialtyService;
import cn.cclookme.info.api.user.service.IStudentInfoService;
import cn.cclookme.info.model.schedule.BasicsCourseSchedule;
import cn.cclookme.info.model.schedule.OptionalCourseSchedule;
import cn.cclookme.info.model.score.StudentScore;
import cn.cclookme.info.model.specialty.SpecialtyInfo;
import cn.cclookme.info.model.user.StudentInfo;
import cn.cclookme.info.model.user.TeacherInfo;


@Controller
@RequestMapping("/score")
public class ScoreController {
	private static final Logger log=Logger.getLogger(ScoreController.class);
	
	@Autowired
	private IStudentScoreService studentScoreService;
	@Autowired
	private IStudentInfoService studentInfoService;
	@Autowired
	private IBasicsCourseScheduleService basicsCourseScheduleService;
	@Autowired
	private IOptionalCourseScheduleService optionalCourseScheduleService;
	@Autowired
	private ISpecialtyService specialtyService;
	
	@RequestMapping("/toaddscore")
	public String toAddscore(HttpServletRequest request,@PathVariable String cardid){
		Map<String ,Object> map=new HashMap<String ,Object>();
		
		return "/score/addscore";
	}
	/*@RequestMapping("/tomodifyscore/{cardid}/{type}/{pagenum}")
	public String tomodifyscore(HttpServletRequest request,
			@PathVariable String cardid,@PathVariable String type,
			@PathVariable String pagenum){
		Map<String ,Object> map=new HashMap<String ,Object>();
		Map<String ,Object> mm=studentInfoService.getStudentInfoByStudentCardId(cardid);
		StudentInfo studentinfo=(StudentInfo) mm.get("retObject");
		if(type.equals("1")){
		    map=basicsCourseScheduleService.getBasicCourseScheduleBypage(studentinfo.getSpecialty(), studentinfo.getEnrollmentYear().substring(0, 4), pagenum);	
			List<BasicsCourseSchedule> list=(List<BasicsCourseSchedule>) map.get("retObject");
		    Integer count=(Integer) map.get("count");
		    if(count%10==0){
		    	count=count/10;
			}else{
				count=count/10+1;
			}
			request.setAttribute("pagetotal", count);
		    request.setAttribute("CourseList", list);
		    request.setAttribute("type", type);
		}else{
			map=optionalCourseScheduleService.getOptionCourseScheduleByPage(studentinfo.getAcademy(), studentinfo.getStudentCardid(),studentinfo.getEnrollmentYear().substring(0, 4), pagenum);	
			List<OptionalCourseSchedule> list=(List<OptionalCourseSchedule>) map.get("retObject");
		    Integer count=(Integer) map.get("count");
		    if(count%10==0){
		    	count=count/10;
			}else{
				count=count/10+1;
			}
			request.setAttribute("pagetotal", count);
		    request.setAttribute("CourseList", list);
		    request.setAttribute("type", type);
		} 
		if(pagenum.equals("0")){
			pagenum="1";
		}
		request.setAttribute("pagenow", pagenum);
		request.setAttribute("studentname", studentinfo.getStudentName());
		request.setAttribute("studentcardid", studentinfo.getStudentCardid());
		return "/score/modifyscore";
	}*/
	@RequestMapping("/tomodifyscore/{cardid}/{pagenum}")
	public String tomodifyscore(HttpServletRequest request,
			@PathVariable String cardid,
			@PathVariable String pagenum){
		Map<String ,Object> map=new HashMap<String ,Object>();
		Map<String ,Object> mm=studentInfoService.getStudentInfoByStudentCardId(cardid);
		StudentInfo studentinfo=(StudentInfo) mm.get("retObject");
		Map<String ,Object> mm1=specialtyService.getSpecialtyInfoBySpecialtyCode(studentinfo.getSpecialty());
		SpecialtyInfo specialtyInfo=(SpecialtyInfo) mm1.get("retObject");
		String preString="college"+specialtyInfo.getCollege()+studentinfo.getEnrollmentYear().substring(0, 4);   
		map=studentScoreService.getStudentScoreByStudentId(studentinfo.getStudentCardid(),pagenum,preString);	
			List<StudentScore> list=(List<StudentScore>) map.get("retObject");
		    Integer count=(Integer) map.get("count");
		    if(count%10==0){
		    	count=count/10;
			}else{
				count=count/10+1;
			}
			request.setAttribute("pagetotal", count);
		    request.setAttribute("CourseList", list);
		Integer pagenumm=Integer.parseInt(pagenum);
		pagenumm++;
		request.setAttribute("pagenow", pagenumm);
		request.setAttribute("studentname", studentinfo.getStudentName());
		request.setAttribute("studentcardid", studentinfo.getStudentCardid());
		return "/score/modifyscore";
	}
	@RequestMapping("/toscorestudentlist/{num}")
	public String toScorelist(HttpServletRequest request,@PathVariable Integer num){
		String cardid=request.getParameter("studentCardId");
		String name=request.getParameter("studentName");
		String specialty=request.getParameter("studentSpecialty");
		String enrollmentYear=request.getParameter("enrollmentYear");
		String page=request.getParameter("page");
		TeacherInfo teacherInfo=new TeacherInfo();
		teacherInfo=(TeacherInfo) request.getSession().getAttribute("user");
		String academy=teacherInfo.getAcademy();
		Map<String ,Object> map=new HashMap<String ,Object>();
		if(num==0){
			request.setAttribute("pagenow", "1");
		}else{
			String enyear=enrollmentYear;
			if(enrollmentYear!=null&&!enrollmentYear.trim().isEmpty()){
				enrollmentYear=enrollmentYear.trim();
				enrollmentYear+="%";
			}
			map=studentInfoService.getScoreStudentList(cardid, name, specialty, academy, enrollmentYear,Integer.parseInt(page));
			request.setAttribute("cardid", cardid);
			request.setAttribute("name", name);
			request.setAttribute("specialty", specialty);
			request.setAttribute("pagenow", page);
			request.setAttribute("pagetotal", map.get("pagetotal"));
			request.setAttribute("studentList", map.get("retObject"));
			request.setAttribute("enrollmentYear",enyear);
		}
		return "/score/studentscorelist";
	}
	@RequestMapping("/addstudentscore")
	public String addStudentScore(HttpServletRequest request,StudentScore studentScore){
		Map<String ,Object>  map=new HashMap<String ,Object>();
		String cardid=request.getParameter("cardid");
		studentScore.setStudentId(cardid);
		map=studentScoreService.saveStudentScore(studentScore, "");
		String retcode=(String) map.get("retCode");
		if(retcode.equals("0000")){
			
		}else if(retcode.equals("0001")){
			
		}else{
			
		}
		return "/score/modifyscore";
	}
	@RequestMapping("/deletescore")
	@ResponseBody
	public String deletescore(HttpServletRequest request){
		Map<String ,Object> map=new HashMap<String ,Object>();
		String cardid=request.getParameter("id");
		String coursecode=request.getParameter("coursecode");
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		String score=request.getParameter("score");
		Map<String, Object> mm=new HashMap<String ,Object>();
		mm.put("cardid", cardid);
		mm.put("coursecode", coursecode);
		mm.put("starttime", starttime);
		mm.put("endtime", endtime);
		mm.put("score", score);
		map=studentScoreService.deleteStudentScore(mm);
		if(map.get("retCode").equals("0000")){
			return "1";
		}else{
			return "0";
		}
	}
}
