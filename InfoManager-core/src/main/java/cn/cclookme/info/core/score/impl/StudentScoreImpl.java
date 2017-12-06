package cn.cclookme.info.core.score.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cclookme.info.api.courseschedule.service.IBasicsCourseScheduleService;
import cn.cclookme.info.api.courseschedule.service.IOptionalCourseScheduleService;
import cn.cclookme.info.api.score.service.IStudentScoreService;
import cn.cclookme.info.api.specialty.service.ISpecialtyService;
import cn.cclookme.info.api.user.service.IStudentInfoService;
import cn.cclookme.info.core.score.mapper.StudentScoreMapper;
import cn.cclookme.info.model.score.StudentScore;
import cn.cclookme.info.model.specialty.SpecialtyInfo;
import cn.cclookme.info.model.user.StudentInfo;
import cn.cclookme.info.util.DataMsg;
@Service("studentscoreservice")
public class StudentScoreImpl implements IStudentScoreService{
	private static final Logger log=Logger.getLogger(StudentScoreImpl.class);
	
	@Autowired
	private IStudentInfoService studentInfoService;
	@Autowired
	private IBasicsCourseScheduleService basicsCourseScheduleService;
	@Autowired
	private IOptionalCourseScheduleService optionalCourseScheduleService;
	@Autowired
	private StudentScoreMapper studentScoreMapper;
	@Autowired
	private ISpecialtyService specialtyService;
	@Override
	public Map<String, Object> getStudentScoreByStudentId(String cardid,String page,
			String prefixString) {
		Map<String ,Object> map=new HashMap<String ,Object>();
		String tablename=prefixString+"student_score";
			map.put("tablename", tablename);
			map.put("cardid", cardid);
			map.put("page", (Integer.parseInt(page))*10);
		List<StudentScore> list=studentScoreMapper.selectbycardid(map);
		Integer pagetotal =studentScoreMapper.selectcountbycardid(map);
		Map<String ,Object> mm=new HashMap<String ,Object>();
		mm.put("retObject", list);
		mm.put("count", pagetotal);
		return mm;
	}
	@Override
	public Map<String, Object> deleteStudentScore(Map<String, Object> map) {
		String cardid=(String) map.get("cardid");
		Map<String ,Object> mm1=studentInfoService.getStudentInfoByStudentCardId(cardid);
		StudentInfo studentInfo=(StudentInfo) mm1.get("retObject");
		
		Map<String ,Object> mm2=specialtyService.getSpecialtyInfoBySpecialtyCode(studentInfo.getSpecialty());
		SpecialtyInfo specialtyInfo=(SpecialtyInfo) mm2.get("retObject");
		
		String tablename="college"+specialtyInfo.getCollege()+studentInfo.getEnrollmentYear().substring(0, 4)+"student_score";
	
		map.put("tablename", tablename);
		
		Map<String ,Object> mm3=new HashMap<String ,Object>();
		try {
			studentScoreMapper.deletebytimeandcodeandscore(map);
			mm3.put("retCode", "0000");
		} catch (Exception e) {
			mm3.put("retCode", "0001");
		}
		return mm3;
	}
	@Override
	public Map<String, Object> getStudentScoreByMorethanthisScore(
			double thisscore, String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getStudentScoreByLowerthanthisScore(
			double thisscore, String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getStudentScoreByMorethanCoursetarttime(
			String thistime, String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getStudentScoreByLowerthanCourseendtime(
			String thistime, String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getStudentScoreByMiddleStarttimeandEndtime(
			String starttime, String endtime, String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getStudentScoreByispass(Integer pass,
			String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getStudentScoreByclassroomTeacher(
			String teachername, String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getStudentScoreByCourseCode(String coursecode,
			String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateStudentScore(StudentScore studentScore,
			String prefixString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> saveStudentScore(StudentScore score,
			String prefixString) {
		Map<String ,Object> mm1=studentInfoService.getStudentInfoByStudentCardId(score.getStudentId());
		StudentInfo studentInfo=(StudentInfo) mm1.get("retObject");
		
		Map<String ,Object> mm2=specialtyService.getSpecialtyInfoBySpecialtyCode(studentInfo.getSpecialty());
		SpecialtyInfo specialtyInfo=(SpecialtyInfo) mm2.get("retObject");
		
		String tablename="college"+specialtyInfo.getCollege()+studentInfo.getEnrollmentYear().substring(0, 4)+"student_score";
		String time=DataMsg.getNowDate();
		
		score.setWirteInTime(time);
		
		Double scorenum=score.getScore();
		if(scorenum<60){
			score.setIsPass(2);
		}else{
			score.setIsPass(1);
		}
		Map<String ,Object> mm3=new HashMap<String ,Object>();
		mm3.put("cardid", score.getStudentId());
		mm3.put("starttime", score.getStartTime());
		mm3.put("endtime", score.getEndTime());
		mm3.put("coursecode", score.getCourseCode());
		mm3.put("tablename", tablename);
		List<StudentScore> list=studentScoreMapper.selectbycardidandcoursecodeandstarttimeandendtime(mm3);
		Map<String ,Object> map=new HashMap<String ,Object>();
		if(list!=null&&list.size()>0){
			map.put("retCode", "0002");
		}else{
			Map<String ,Object> mm4=new HashMap<String ,Object>();
			mm4.put("studentId", score.getStudentId());
			mm4.put("score", score.getScore());
			mm4.put("wirteInTime", score.getWirteInTime());
			mm4.put("startTime", score.getStartTime());
			mm4.put("endTime", score.getEndTime());
			mm4.put("isPass", score.getIsPass());
			mm4.put("courseCode", score.getCourseCode());
			mm4.put("classroomTeacher", score.getClassroomTeacher());
			mm4.put("tablename", tablename);
			try {
				studentScoreMapper.insertSelective(mm4);
				map.put("retCode", "0000");
			} catch (Exception e) {
				map.put("retCode", "0001");
			}
		}
		return map;
	}

}
