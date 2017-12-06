package cn.cclookme.info.core.specialty.mapper;

import java.util.Map;

import cn.cclookme.info.model.specialty.SpecialtyInfo;

public interface SpecialtyInfoMapper {
	
	SpecialtyInfo selectSpecialInfoBySpecialnameAndCollegecode(Map<String ,Object> map);
	SpecialtyInfo selectSpecialInfoBySpecialname(Map<String ,Object> map);
    
}