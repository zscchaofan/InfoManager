package cn.cclookme.info.api.courseschedule.service;

import java.util.Map;

import cn.cclookme.info.model.schedule.OptionalCourseSchedule;

/**
 * @author zsc
 * @date 2017年3月28日
 * <p>Description: 选修课程表相关操作</p>
 * 
 */
public interface IOptionalCourseScheduleService {
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param courseSchedule
	 * @param prefixString
	 * @return
	 * <p>Description:保存选修课程信息</p>
	 *
	 */
	 Map<String ,Object> saveOptionalCourseSchedule(OptionalCourseSchedule courseSchedule,String prefixString);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param courseSchedule
	 * @param prefixString
	 * @return
	 * <p>Description:更新选修课程信息</p>
	 *
	 */
	 Map<String ,Object> updateOptinalCourseSchedule(OptionalCourseSchedule courseSchedule,String prefixString);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param studentcardid
	 * @param prefixString
	 * @return
	 * <p>Description:根据学生cardid查询课程信息</p>
	 *
	 */
	 Map<String ,Object> getOptiomCourseSchedule(String studentcardid,String prefixString,String starttime ,String endtime);
	 /**
	  * 
	  * @author zsc
	  * @date 2017年5月5日
	  * @param cardid
	  * @param year
	  * @param pagenum
	  * @return
	  * <p>Description:根据页数查询课程信息</p>
	  *
	  */
	 Map<String ,Object> getOptionCourseScheduleByPage(String specialty,String cardid,String year ,String pagenum);
}
