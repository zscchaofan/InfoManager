package cn.cclookme.info.core.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.cclookme.info.api.user.service.ITeacherInfoService;
import cn.cclookme.info.model.user.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cclookme.info.api.user.service.IStudentInfoService;
import cn.cclookme.info.core.college.mapper.CollegeInfoMapper;
import cn.cclookme.info.core.specialty.mapper.SpecialtyInfoMapper;
import cn.cclookme.info.core.user.mapper.StudentInfoMapper;
import cn.cclookme.info.model.college.CollegeInfo;
import cn.cclookme.info.model.specialty.SpecialtyInfo;
import cn.cclookme.info.model.user.StudentInfo;
import cn.cclookme.info.util.Md5;
@Service("studentinfoservice")
public class StudentInfoServiceImpl implements IStudentInfoService{

	
	@Autowired
	private StudentInfoMapper studentInfoMapper;
	@Autowired
	private CollegeInfoMapper collegeInfomapper;
	@Autowired
	private SpecialtyInfoMapper specialtyInfoMapper; 
	@Autowired
	private ITeacherInfoService teacherInfoService;
	@Override
	public Map<String, Object> getStudentInfoByStudentCardId(String cardid) {
		Map<String ,Object> map=new HashMap<String ,Object>();
		StudentInfo info=studentInfoMapper.selectByPrimaryKey(cardid);
		map.put("retCode", "0000");
		map.put("retObject", info);
		return map;
	}

	@Override
	public Map<String, Object> updateStudentInfo(StudentInfo studentinfo) {
		Map<String ,Object> map=new HashMap<String ,Object>();
		try {
			studentInfoMapper.updateByPrimaryKeySelective(studentinfo);
			map.put("retCode", "0000");
		} catch (Exception e) {
			map.put("retCode", "0001");
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getStudentInfoByStudentCardIdAndPassword(
			String cardid, String password) {
		Map<String ,Object> map=new HashMap<String,Object>();
		Map<String ,Object> mapinto=new HashMap<String ,Object>();
		mapinto.put("studentCardid", cardid);
		mapinto.put("password", Md5.string2MD5(password));
		StudentInfo studentInfo=null;
		studentInfo=studentInfoMapper.selectByCardIdAndPassword(mapinto);
		if(studentInfo!=null){
			map.put("retCode", "0000");
			map.put("retObject", studentInfo);
		}else{
			map.put("retCode", "0001");
		}
		return map;
	}
	
	@Override
	public Map<String, Object> saveStudentInfo(StudentInfo studentInfo) {
		Map<String ,Object> retmap=new HashMap<String ,Object>();
		try {
			String enrollmentyear=studentInfo.getEnrollmentYear().substring(0, 4);
			String academy=studentInfo.getAcademy();
			String specialty=studentInfo.getSpecialty();
			Integer classnameint=Integer.parseInt(studentInfo.getClassname());
			String classname=String.format("%02d", classnameint);
			CollegeInfo collegeinfo=collegeInfomapper.selectcollegeinfobycollegename(academy);
			String acacode=collegeinfo.getCollegeCode();
			
			Map<String ,Object> map=new HashMap<String ,Object>();
			map.put("specialty", specialty);
			map.put("college", acacode);
			SpecialtyInfo specialtyInfo=specialtyInfoMapper.selectSpecialInfoBySpecialnameAndCollegecode(map);
			String specialcode=specialtyInfo.getSpecialtyCode();
			
			
			String studentidpre=enrollmentyear+acacode+specialcode+classname;
			String studentid="";
			List<StudentInfo> list=new ArrayList<StudentInfo>();
			list=studentInfoMapper.selectStudentInfoBystudentidpre(studentidpre+"%");
			if(list!=null&&list.size()>0){
				String nowstuid=list.get(0).getStudentCardid().substring(list.get(0).getStudentCardid().length()-2,list.get(0).getStudentCardid().length());
				Integer nowid=Integer.parseInt(nowstuid);
				nowid+=1;
				String nextidstr=String.format("%02d", nowid);
				studentid=studentidpre+nextidstr;
			}else {
				studentid=studentidpre+"01";
			}
			
			studentInfo.setStudentCardid(studentid);
			studentInfo.setPassword(Md5.string2MD5(studentid.substring(studentid.length()-6, studentid.length())));
			studentInfo.setStatus(1);
			studentInfoMapper.insertSelective(studentInfo);
			retmap.put("retCode", "0000");
		} catch (Exception e) {
			retmap.put("retCode", "0001");
		}
		return retmap;
	}

	@Override
	public Map<String, Object> saveStudentInfoByTest(StudentInfo studentInfo) {
		Map<String,Object> map=new HashMap<String, Object>();

		studentInfoMapper.insertSelective(studentInfo);
		//System.out.println(2/0);
		map.put("retCode","0000");
		return map;
	}

	public void saveone(StudentInfo studentinfo){
		
		
	} 

	@Override
	public Map<String, Object> getStudentList(String cardid, String name,
			String status, String specialty,String academy,Integer page) {
		Map<String ,Object> map=new HashMap<String ,Object>();
		try {
			Map<String ,Object> mm=new HashMap<String ,Object>();
			mm.put("cardid", null);
			mm.put("name", null);
			mm.put("status", null);
			mm.put("specialty", null);
			if(cardid!=null&&cardid!=""&&!cardid.trim().isEmpty()){
				mm.put("cardid", cardid);
			}
			if(name!=null&&name!=""&&!name.trim().isEmpty()){
				mm.put("name", name);
			}
			if(status!=null&&status!=""&&!status.trim().isEmpty()){
				mm.put("status", status);
			}
			if(specialty!=null&&specialty!=""&&!specialty.trim().isEmpty()){
				mm.put("specialty", specialty);
			}
			mm.put("academy", academy);
			mm.put("page", (page-1)*5);
			List<StudentInfo> list=new ArrayList<StudentInfo>();
			list=studentInfoMapper.selectBycardidAndnameAndstatusAndspecialty(mm);
			Integer pagetotal=studentInfoMapper.selectCountBycardidAndnameAndstatusAndspecialty(mm);
			Integer pagepage=0;
			if(pagetotal%5==0){
				pagepage=pagetotal/5;
			}else{
				pagepage=pagetotal/5+1;
			}
			map.put("retCode", "0000");
			map.put("retObject", list);
			map.put("pagetotal", pagepage);
		} catch (Exception e) {
			map.put("retCode", "0001");
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getScoreStudentList(String cardid, String name,
			String specialty,String academy,String year,Integer page) {
		Map<String ,Object> map=new HashMap<String ,Object>();
		try {
			Map<String ,Object> mm=new HashMap<String ,Object>();
			mm.put("cardid", null);
			mm.put("name", null);
			mm.put("specialty", null);
			if(cardid!=null&&cardid!=""&&!cardid.trim().isEmpty()){
				mm.put("cardid", cardid);
			}
			if(name!=null&&name!=""&&!name.trim().isEmpty()){
				mm.put("name", name);
			}
			if(specialty!=null&&specialty!=""&&!specialty.trim().isEmpty()){
				mm.put("specialty", specialty);
			}
			if(year!=null&&year!=""&&!year.trim().isEmpty()){
				mm.put("year", year);
			}
			mm.put("academy", academy);
			mm.put("page", (page-1)*5);
			List<StudentInfo> list=new ArrayList<StudentInfo>();
			list=studentInfoMapper.selectBycardidAndnameAndspecialty(mm);
			Integer pagetotal=studentInfoMapper.selectCountBycardidAndnameAndspecialty(mm);
			Integer pagepage=0;
			if(pagetotal%5==0){
				pagepage=pagetotal/5;
			}else{
				pagepage=pagetotal/5+1;
			}
			map.put("retCode", "0000");
			map.put("retObject", list);
			map.put("pagetotal", pagepage);
		} catch (Exception e) {
			map.put("retCode", "0001");
		}
		return map;
	}



}
