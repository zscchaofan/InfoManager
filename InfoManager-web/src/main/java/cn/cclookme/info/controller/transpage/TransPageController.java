package cn.cclookme.info.controller.transpage;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/transpage")
public class TransPageController {

	private static final Logger log=Logger.getLogger(TransPageController.class);
	
	@RequestMapping("/studentmain")
	public String reStudentMain(HttpServletRequest httpServletRequest){
		return "/mainpage/studentMainPage";
	}
	@RequestMapping("/teachermain")
	public String reTeacherMain(HttpServletRequest httpServletRequest){
		return "/mainpage/teacherMainPage";
	}
	@RequestMapping("/studenttop")
	public String reStudentTop(HttpServletRequest httpServletRequest){
		
		return "/mainpage/studenttop";
	}
	
	@RequestMapping("/studentleft")
	public String reStudentLeft(HttpServletRequest httpServletRequest){
		
		return "/mainpage/studentleft";
	}
	
	@RequestMapping("/studentindex")
	public String reStudentIndex(HttpServletRequest httpServletRequest){
		
		return "/mainpage/studentindex";
	}
	
	@RequestMapping("/teachertop")
	public String reTeacherTop(HttpServletRequest httpServletRequest){
		
		return "/mainpage/teachertop";
	}
	
	@RequestMapping("/teacherleft")
	public String reTeacherLeft(HttpServletRequest httpServletRequest){
		
		return "/mainpage/teacherleft";
	}
	
	@RequestMapping("/teacherindex")
	public String reTeacherIndex(HttpServletRequest httpServletRequest){
		
		return "/mainpage/teacherindex";
	}
}
