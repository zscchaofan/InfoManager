package cn.cclookme.info.api.courseschedule.service;

import java.util.List;
import java.util.Map;

import cn.cclookme.info.model.schedule.BasicsCourseSchedule;
import cn.cclookme.info.model.schedule.BasicsCourseScheduleExcel;

/**
 * @author zsc
 * @date 2017年3月28日
 * <p>Description: 基本课程表（按专业分的课程表）相关操作</p>
 * 
 */
public interface IBasicsCourseScheduleService {
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param basicsCourseSchedule
	 * @param prefixString
	 * @return
	 * <p>Description:保存基本课程表信息</p>
	 *
	 */
	 Map<String ,Object> saveBasicCourseSchedule(BasicsCourseSchedule basicsCourseSchedule,String prefixString);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param basicsCourseSchedule
	 * @param prefixString
	 * @return
	 * <p>Description:更新基本表信息</p>
	 *
	 */
	 Map<String ,Object> updateBasicCourseSchedule(BasicsCourseSchedule basicsCourseSchedule,String prefixString);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param specialty
	 * @param prefixString
	 * @return
	 * <p>Description:根据专业查询课程表</p>
	 *
	 */
	 Map<String ,Object> getBasicCourseSchedule(String specialty,String prefixString,String starttime,String endtime);
	 /**
	  * 
	  * @author zsc
	  * @date 2017年5月3日
	  * @param file
	  * @return
	  * <p>Description:根据excel添加课程信息</p>
	  *
	  */
	 Map<String ,Object> saveBasicCourseScheduleByExcle(List<BasicsCourseScheduleExcel> list,String academy);
	 /**
	  * 
	  * @author zsc
	  * @date 2017年5月5日
	  * @param specialty
	  * @param year
	  * @param pagenum
	  * @return
	  * <p>Description:根据专业年份查询课程信息</p>
	  *
	  */
	 Map<String ,Object> getBasicCourseScheduleBypage(String specialty, String year, String pagenum);
}
