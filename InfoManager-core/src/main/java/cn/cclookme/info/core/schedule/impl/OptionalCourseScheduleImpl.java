package cn.cclookme.info.core.schedule.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cclookme.info.api.courseschedule.service.IOptionalCourseScheduleService;
import cn.cclookme.info.api.specialty.service.ISpecialtyService;
import cn.cclookme.info.core.schedule.mapper.OptionalCourseScheduleMapper;
import cn.cclookme.info.core.specialty.mapper.SpecialtyInfoMapper;
import cn.cclookme.info.model.schedule.BasicsCourseSchedule;
import cn.cclookme.info.model.schedule.OptionalCourseSchedule;
import cn.cclookme.info.model.specialty.SpecialtyInfo;
@Service("optionalcoursescheduleservice")
public class OptionalCourseScheduleImpl implements IOptionalCourseScheduleService{
	private static final Logger log=Logger.getLogger(OptionalCourseScheduleImpl.class);
	
	@Autowired
	public OptionalCourseScheduleMapper optionalCourseScheduleMapper;
	@Autowired
	private SpecialtyInfoMapper specialtyInfoMapper;
	@Override
	public Map<String, Object> saveOptionalCourseSchedule(
			OptionalCourseSchedule courseSchedule, String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateOptinalCourseSchedule(
			OptionalCourseSchedule courseSchedule, String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> getOptionCourseScheduleByPage(String specialty,String cardid,
			String year, String pagenum) {
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("specialty", specialty);
		SpecialtyInfo specialtyinfo = specialtyInfoMapper.selectSpecialInfoBySpecialname(map);
		String tablename="college"+specialtyinfo.getCollege()+year+"optional_course_schedule";
		map.put("tablename", tablename);
		map.put("page", (Integer.parseInt(pagenum)-1)*10);
		map.put("cardid", cardid);
		List<OptionalCourseSchedule> list=optionalCourseScheduleMapper.selectbyspecialty(map);
		Integer num=optionalCourseScheduleMapper.selectcountbyspecialty(map);
		Map<String ,Object> mm=new HashMap<String ,Object>();
		mm.put("retObject", list);
		mm.put("count", num);
		return mm;
	}
	@Override
	public Map<String, Object> getOptiomCourseSchedule(String studentcardid,
			String prefixString,String starttime ,String endtime) {
		Map<String ,Object> map=new HashMap<String, Object>();
		Map<String ,Object> mm=new HashMap<String ,Object>();
		mm.put("tablename", prefixString+"optional_course_schedule");
		mm.put("starttime", starttime);
		mm.put("endtime", endtime);
		List<OptionalCourseSchedule> list=optionalCourseScheduleMapper.selectbystartandendtime(mm);
		map.put("retCode", "0000");
		map.put("retObject", list);
		return map;
	}

}
