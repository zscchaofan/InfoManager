package cn.cclookme.info.core.course.mapper;

import cn.cclookme.info.model.course.CourseInfo;

public interface CourseInfoMapper {
    int deleteByPrimaryKey(String courseCode);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    CourseInfo selectByPrimaryKey(String courseCode);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);
}