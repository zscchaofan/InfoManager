package cn.cclookme.info.controller.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cclookme.info.model.user.StudentInfo;

import com.alibaba.dubbo.common.json.JSON;

import org.apache.log4j.Logger;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cclookme.info.api.specialty.service.ISpecialtyService;
import cn.cclookme.info.api.user.service.IStudentInfoService;
import cn.cclookme.info.api.user.service.ITeacherInfoService;
import cn.cclookme.info.controller.comm.LoginSessionListener;
import cn.cclookme.info.model.user.TeacherInfo;


@Controller
@RequestMapping("/user")
public class LoginInController {
	private static final Logger log=Logger.getLogger(LoginInController.class);
	@Autowired
	private IStudentInfoService studentInfoService;
	@Autowired
	private ITeacherInfoService teacherInfoService;
	@Autowired
	private ISpecialtyService specialtyService;
	
	@RequestMapping("/login")
	public String toLogin(HttpServletRequest httpRequest,HttpServletResponse response){
		return "/login/login";
		//return "/mainpage/teacherMainPage";
	}
	@RequestMapping("/test")
	@ResponseBody
	public String toLoginBytest(HttpServletRequest httpRequest,HttpServletResponse response){

		TeacherInfo teacherInfo=new TeacherInfo();
		teacherInfo.setTeacherCardid("999999");
		teacherInfo.setName("zsc");
		StudentInfo studentInfo=new StudentInfo();
		studentInfo.setStudentCardid("8888888");
		studentInfo.setStudentName("sss");
		try {
			Map<String,Object> map=specialtyService.addByTest(studentInfo,teacherInfo);

		}catch (Exception e){
			return "0";
		}

		return "1";
		//return "/mainpage/teacherMainPage";
	}
	@RequestMapping("/loginin")
	@ResponseBody
	public String loginIn(HttpServletRequest request){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String myid=request.getParameter("myid");
		String twocode=request.getParameter("twocode");
		try {
		/*	String codetwo=(String) request.getSession().getAttribute("twocode");
			if(!codetwo.equalsIgnoreCase(twocode)){
				return "10002";
			}*/
			if(myid.equals("0")){
				Map<String ,Object> map=studentInfoService.getStudentInfoByStudentCardIdAndPassword(username, password);
				if(map.get("retCode").equals("0000")){
					request.getSession().setAttribute("user", map.get("retObject"));
					request.getSession().setAttribute("usertype", "student");
					LoginSessionListener.createUserSession(request.getSession(), username);
					return "10000";
				}else{
					return "10001";
				}
			}else{
				Map<String ,Object> map=teacherInfoService.getTeacherInfoByteachercardidAndpassword(username, password);
				if(map.get("retCode").equals("0000")){
					request.getSession().setAttribute("user", map.get("retObject"));
					request.getSession().setAttribute("usertype", "teacher");
					LoginSessionListener.createUserSession(request.getSession(), username);
					return "10000";
				}else{
					return "10001";
				}
			}
		
		} catch (Exception e) {
			
		}
		
		return "10003";
	}
	
	@RequestMapping("/loginindex")
	public String toLoginIndex(){
		
		return "/mainpage/studentMainPage";
	}
	@RequestMapping("/logout")
	public String toLoginOut(HttpServletRequest request){
		
		TeacherInfo teacherinfo=(TeacherInfo) request.getSession().getAttribute("user");
		LoginSessionListener.removeUserSession(teacherinfo.getTeacherCardid());;
		return "/login/login";
	}
}
