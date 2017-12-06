package cn.cclookme.info.core.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cclookme.info.api.user.service.ITeacherInfoService;
import cn.cclookme.info.core.user.mapper.TeacherInfoMapper;
import cn.cclookme.info.model.user.TeacherInfo;
import cn.cclookme.info.util.Md5;
@Service("teacherinfoservice")
public class TeacherInfoServiceImpl implements ITeacherInfoService{
	private static final Logger log =Logger.getLogger(TeacherInfoServiceImpl.class);
	
	@Autowired
	private TeacherInfoMapper teacherInfoMapper;
		
	@Override
	public Map<String, Object> getTeacherInfoByTeacherCardId(String cardid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> saveTeacherInfoByTest(TeacherInfo teacherInfo) {
		Map<String,Object> map=new HashMap<String, Object>();

		teacherInfoMapper.insertSelective(teacherInfo);
		//System.out.println(2/0);
		map.put("retCode","0000");
		return map;
	}

	@Override
	public Map<String, Object> updateTeacherInfo(TeacherInfo teacherInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> getTeacherInfoByteachercardidAndpassword(
			String teachercardid, String password) {
		Map<String ,Object> map=new HashMap<String ,Object>();
		TeacherInfo info=null;
		Map<String ,Object> mapin=new HashMap<String ,Object> ();
		mapin.put("cardid", teachercardid);
		mapin.put("password", Md5.string2MD5(password));
		info=teacherInfoMapper.selectByteachercardidAndPassword(mapin);
		if(info!=null){
			map.put("retObject", info);
			map.put("retCode", "0000");
		}else{
			map.put("retCode", "0001");
		}
		return map;
	}
}
