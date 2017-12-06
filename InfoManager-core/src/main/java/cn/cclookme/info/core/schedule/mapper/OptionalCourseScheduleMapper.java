package cn.cclookme.info.core.schedule.mapper;

import java.util.List;
import java.util.Map;

import cn.cclookme.info.model.schedule.BasicsCourseSchedule;
import cn.cclookme.info.model.schedule.OptionalCourseSchedule;

public interface OptionalCourseScheduleMapper {
    int insert(OptionalCourseSchedule record);

    int insertSelective(OptionalCourseSchedule record);
    
    List<OptionalCourseSchedule> selectbystartandendtime(Map<String ,Object>map);

    List<OptionalCourseSchedule> selectbyspecialty(Map<String ,Object> map);
    
    Integer selectcountbyspecialty(Map<String,Object> map);
}