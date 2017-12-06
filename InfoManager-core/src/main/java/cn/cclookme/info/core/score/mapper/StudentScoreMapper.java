package cn.cclookme.info.core.score.mapper;

import java.util.List;
import java.util.Map;

import cn.cclookme.info.model.score.StudentScore;

public interface StudentScoreMapper {
    int insert(StudentScore record);

    int insertSelective(Map<String ,Object> map);
    
    int deletebytimeandcodeandscore(Map<String ,Object> map);
    
    List<StudentScore> selectbycardid(Map<String ,Object> map);
    
    Integer selectcountbycardid(Map<String ,Object> map);
    
    List<StudentScore> selectbycardidandcoursecodeandstarttimeandendtime(Map<String ,Object> map);
}