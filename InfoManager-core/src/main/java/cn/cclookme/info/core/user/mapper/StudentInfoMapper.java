package cn.cclookme.info.core.user.mapper;

import java.util.List;
import java.util.Map;

import cn.cclookme.info.model.user.StudentInfo;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(String studentCardid);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(String studentCardid);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
    
    StudentInfo selectByCardIdAndPassword(Map<String ,Object> map);
    
    List<StudentInfo> selectStudentInfoBystudentidpre(String studentCardid);
    
    List<StudentInfo> selectBycardidAndnameAndstatusAndspecialty(Map<String ,Object>map);

    Integer selectCountBycardidAndnameAndstatusAndspecialty(Map<String ,Object> map);
   
    List<StudentInfo> selectBycardidAndnameAndspecialty(Map<String ,Object>map);
    
    Integer selectCountBycardidAndnameAndspecialty(Map<String ,Object> map);
}