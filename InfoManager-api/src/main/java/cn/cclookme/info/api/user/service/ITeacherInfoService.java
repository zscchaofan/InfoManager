package cn.cclookme.info.api.user.service;

import java.util.Map;

import cn.cclookme.info.model.user.TeacherInfo;

/**
 * @author zsc
 * @date 2017年3月28日
 * <p>Description: 教师信息相关接口</p>
 * 
 */
public interface ITeacherInfoService {
	
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param cardid
	 * @return
	 * <p>Description:根据教师卡id查询教师信息</p>
	 *
	 */
	 Map<String ,Object> getTeacherInfoByTeacherCardId(String cardid);
	Map<String,Object> saveTeacherInfoByTest(TeacherInfo teacherInfo);
	/**
	 * @author zsc
	 * @date 2017年3月28日
	 * @param teacherInfo
	 * @return
	 * <p>Description: 更新教师信息</p>
	 * 
	 */
	 Map<String ,Object> updateTeacherInfo(TeacherInfo teacherInfo);
	 /**
	  * 
	  * @author zsc
	  * @date 2017年4月15日
	  * @param teachercardid
	  * @param password
	  * @return
	  * <p>Description:根据卡号和密码查询是否有此人</p>
	  *
	  */
	 Map<String ,Object> getTeacherInfoByteachercardidAndpassword(String teachercardid,String password);
}
