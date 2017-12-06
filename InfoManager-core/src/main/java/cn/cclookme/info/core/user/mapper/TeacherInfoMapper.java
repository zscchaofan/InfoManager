package cn.cclookme.info.core.user.mapper;

import java.util.Map;

import cn.cclookme.info.model.user.TeacherInfo;

public interface TeacherInfoMapper {
    int deleteByPrimaryKey(String teacherCardid);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    TeacherInfo selectByPrimaryKey(String teacherCardid);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
    
    TeacherInfo selectByteachercardidAndPassword(Map<String ,Object> map);
}