package cn.cclookme.info.controller.schedule;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.cclookme.info.api.courseschedule.service.IBasicsCourseScheduleService;
import cn.cclookme.info.model.schedule.BasicsCourseSchedule;
import cn.cclookme.info.model.schedule.BasicsCourseScheduleExcel;
import cn.cclookme.info.model.user.TeacherInfo;
import cn.cclookme.info.util.CheckFileData;


@Controller
@RequestMapping("/schedule")
public class BasicsCourseScheduleController {
	
	private static final Logger log=Logger.getLogger(BasicsCourseScheduleController.class);
	@Autowired
	private IBasicsCourseScheduleService basicsCourseScheduleService;
	
	@RequestMapping("/toaddbasicscourse")
	public String toAddBasicsCourseList(HttpServletRequest request){
		
		return "/schedule/addbasicsscourse";
	}
	@RequestMapping("/addscheduleinfo")
	public String addBasicsCourseList(HttpServletRequest request,
			@RequestParam("file") MultipartFile mf){
		TeacherInfo teacherInfo=(TeacherInfo) request.getSession().getAttribute("user");
		// 封装的结果信息
		String oriFileName = mf.getOriginalFilename();
		//检查文件格式
		String suffix = oriFileName.substring(oriFileName.lastIndexOf("."));
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = myFmt.format(new Date());
		Random ra = new Random();
		for(int i = 0; i < 3; i++){
			fileName = fileName + ra.nextInt(10);
		}
		//图片的绝对路径
		String realPath = request.getServletContext().getRealPath("file");
		File targetFile = new File(realPath, fileName + suffix);  
		if(!targetFile.exists()){  
			targetFile.mkdirs();  
		}  
		try {
			mf.transferTo(targetFile);
			//保存  
			CheckFileData checkFileData = new CheckFileData();
			List<BasicsCourseScheduleExcel> list=new ArrayList<BasicsCourseScheduleExcel>();
			list = checkFileData.getCheckFileData(targetFile);
			
			Map<String ,Object > map=basicsCourseScheduleService.saveBasicCourseScheduleByExcle(list,teacherInfo.getAcademy());
			if(map.get("retCode").equals("0000")){
				request.setAttribute("savesuccess", "1");
			}else{
				request.setAttribute("savesuccess", "0");
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return "/schedule/addbasicsscourse";
	}
	
}
