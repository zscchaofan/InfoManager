package cn.cclookme.info.core.schedule.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cclookme.info.api.courseschedule.service.IBasicsCourseScheduleService;
import cn.cclookme.info.core.college.mapper.CollegeInfoMapper;
import cn.cclookme.info.core.schedule.mapper.BasicsCourseScheduleMapper;
import cn.cclookme.info.core.specialty.mapper.SpecialtyInfoMapper;
import cn.cclookme.info.model.college.CollegeInfo;
import cn.cclookme.info.model.schedule.BasicsCourseSchedule;
import cn.cclookme.info.model.schedule.BasicsCourseScheduleExcel;
import cn.cclookme.info.model.specialty.SpecialtyInfo;
import cn.cclookme.info.util.DataMsg;
@Service("basicsCoursescheduleservice")
public class BasicsCourseScheduleImpl implements IBasicsCourseScheduleService{
	private static final Logger log=Logger.getLogger(BasicsCourseScheduleImpl.class);
	
	@Autowired
	private BasicsCourseScheduleMapper basicsCourseScheduleMapper;
	@Autowired
	private SpecialtyInfoMapper specialtyInfoMapper; 
	@Autowired
	private CollegeInfoMapper collegeInfoMapper;
	@Override
	public Map<String, Object> saveBasicCourseSchedule(
			BasicsCourseSchedule basicsCourseSchedule, String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateBasicCourseSchedule(
			BasicsCourseSchedule basicsCourseSchedule, String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> getBasicCourseScheduleBypage(String specialty,
			String year, String pagenum) {
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("specialty", specialty);
		SpecialtyInfo specialtyinfo = specialtyInfoMapper.selectSpecialInfoBySpecialname(map);
		String tablename="college"+specialtyinfo.getCollege()+year+"basics_course_schedule";
		map.put("tablename", tablename);
		map.put("page", (Integer.parseInt(pagenum))*10);
		List<BasicsCourseSchedule> list=basicsCourseScheduleMapper.selectbyspecialty(map);
		Integer num=basicsCourseScheduleMapper.selectcountbyspecialty(map);
		Map<String ,Object> mm=new HashMap<String ,Object>();
		mm.put("retObject", list);
		mm.put("count", num);
		return mm;
	}
	@Override
	public Map<String, Object> getBasicCourseSchedule(String specialty,
			String prefixString,String starttime ,String endtime) {
		Map<String ,Object> map=new HashMap<String, Object>();
		Map<String ,Object> mm=new HashMap<String ,Object>();
		mm.put("tablename", prefixString+"basics_course_schedule");
		mm.put("starttime", starttime);
		mm.put("endtime", endtime);
		List<BasicsCourseSchedule> list=basicsCourseScheduleMapper.selectbystartansendtime(mm);
		map.put("retCode", "0000");
		map.put("retObject", list);
		return map;
	}
	@Override
	public Map<String, Object> saveBasicCourseScheduleByExcle( List<BasicsCourseScheduleExcel> list,String academy) {
		Map<String ,Object> map=new HashMap<String ,Object>();
		try {
			CollegeInfo collegeInfo =collegeInfoMapper.selectcollegeinfobycollegename(academy);
			
			for(int i=0;i<list.size();i++){
				Map<String ,Object> mm=new HashMap<String ,Object>();
				String tablename ="college"+collegeInfo.getCollegeCode()+list.get(i).getYearin()+"basics_course_schedule";
				mm.put("tablename", tablename);
				mm.put("specialty", list.get(i).getSpecialty());
				mm.put("courseCode", list.get(i).getCourseCode());
				mm.put("courseStartTime", list.get(i).getCourseStartTime());
				mm.put("courseEndTime", list.get(i).getCourseEndTime());
				mm.put("courseTeacher", list.get(i).getCourseTeacher());
				mm.put("examinationTime", list.get(i).getExaminationTime());
				mm.put("schooltime", list.get(i).getSchooltime());
				List<BasicsCourseSchedule> listba=basicsCourseScheduleMapper.selectbystartansendtimeandcourse(mm);
				if(listba!=null&&listba.size()>0){
				}else{
					basicsCourseScheduleMapper.insertExcelList(mm);
				}
			}
			map.put("retCode", "0000");
		} catch (Exception e) {
			log.error("添加excel list 数据失败",e);
		}
		return map;
	}
	

}
