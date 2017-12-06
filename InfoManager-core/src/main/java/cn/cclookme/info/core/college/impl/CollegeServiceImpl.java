package cn.cclookme.info.core.college.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cclookme.info.api.college.service.ICollegeService;
import cn.cclookme.info.core.college.mapper.CollegeInfoMapper;
import cn.cclookme.info.model.college.CollegeInfo;
@Service("collegeservice")
public class CollegeServiceImpl implements ICollegeService {
	private static final Logger log=Logger.getLogger(CollegeServiceImpl.class);
	
	@Autowired
	private CollegeInfoMapper collegeInfoMapper;
	
	@Override
	public Map<String, Object> addCollegeInfo(CollegeInfo collegeInfo) {
		return null;
	}

	@Override
	public Map<String, Object> updateCollegeInfo(CollegeInfo collegeInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getAllCollegeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getCollegeInfoByCollegeCode(String collegecode) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CollegeInfo getCollegeInfoByCollegeName(String collegename) {
		CollegeInfo collegeinfo=new CollegeInfo();
		collegeinfo=collegeInfoMapper.selectcollegeinfobycollegename(collegename);
		return collegeinfo;
	}
}
