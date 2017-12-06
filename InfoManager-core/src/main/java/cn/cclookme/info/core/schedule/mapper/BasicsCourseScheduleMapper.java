package cn.cclookme.info.core.schedule.mapper;

import java.util.List;
import java.util.Map;

import cn.cclookme.info.model.schedule.BasicsCourseSchedule;

public interface BasicsCourseScheduleMapper {
    int insert(BasicsCourseSchedule record);

    int insertExcelList(Map<String ,Object> map);
    
    int insertSelective(BasicsCourseSchedule record);
    
    List<BasicsCourseSchedule> selectbystartansendtime(Map<String ,Object> map);
    
    
    List<BasicsCourseSchedule> selectbystartansendtimeandcourse(Map<String ,Object> map);

    List<BasicsCourseSchedule> selectbyspecialty(Map<String ,Object> map);
    
    Integer selectcountbyspecialty(Map<String,Object> map);
}