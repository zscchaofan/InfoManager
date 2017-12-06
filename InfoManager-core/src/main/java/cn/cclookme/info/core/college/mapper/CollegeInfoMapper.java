package cn.cclookme.info.core.college.mapper;

import cn.cclookme.info.model.college.CollegeInfo;

public interface CollegeInfoMapper {
    int insert(CollegeInfo record);

    int insertSelective(CollegeInfo record);
    
    CollegeInfo selectcollegeinfobycollegename(String collegename);
    
    CollegeInfo selectcollegeinfobycollegecode(String collegecode);
}