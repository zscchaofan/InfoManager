package cn.cclookme.info.core.specialty.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cclookme.info.api.specialty.service.ISpecialtyService;
import cn.cclookme.info.api.user.service.IStudentInfoService;
import cn.cclookme.info.api.user.service.ITeacherInfoService;
import cn.cclookme.info.core.specialty.mapper.SpecialtyInfoMapper;
import cn.cclookme.info.core.user.mapper.StudentInfoMapper;
import cn.cclookme.info.model.specialty.SpecialtyInfo;
import cn.cclookme.info.model.user.StudentInfo;
import cn.cclookme.info.model.user.TeacherInfo;
@Service("specialtyservice")
public class SpecialtyServiceImpl implements ISpecialtyService{

	
	@Autowired
	private SpecialtyInfoMapper specialtyInfoMapper;
	@Autowired
	private ITeacherInfoService teacherInfoService;
	@Autowired
	private IStudentInfoService studentInfoService;
	@Autowired
	private StudentInfoMapper studentInfoMapper;
	
	@Override
	public Map<String, Object> addSpecialtyInfo(SpecialtyInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateSpecialtyInfo(SpecialtyInfo specialtyInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getAllSpecialtyInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> addByTest(StudentInfo studentInfo, TeacherInfo teacherInfo) {


		studentInfoService.saveStudentInfoByTest(studentInfo);
		teacherInfoService.saveTeacherInfoByTest(teacherInfo);
		saveone1();
		saveone2();
		Map<String,Object> map=new HashMap<String, Object>();
		//System.out.println(2/0);
		map.put("retCode","0000");
		return map;
	}
	public void saveone1(){
		StudentInfo studentInfo=new StudentInfo();
		studentInfo.setStudentCardid("88888881");
		studentInfo.setStudentName("sss");
		studentInfoMapper.insertSelective(studentInfo);
	}
	public void saveone2(){
		StudentInfo studentInfo=new StudentInfo();
		studentInfo.setStudentCardid("88888882");
		studentInfo.setStudentName("sss");
		studentInfoMapper.insertSelective(studentInfo);
	}
	@Override
	public Map<String, Object> getSpecialtyInfoBySpecialtyCode(
			String specialtycode) {
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("specialty", specialtycode);
		SpecialtyInfo specialtyinfo = specialtyInfoMapper.selectSpecialInfoBySpecialname(map);
		map.put("retObject", specialtyinfo);
		return map;
	}

}
