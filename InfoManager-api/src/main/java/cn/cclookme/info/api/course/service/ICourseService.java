package cn.cclookme.info.api.course.service;

import java.util.Map;

import cn.cclookme.info.model.college.CollegeInfo;
import cn.cclookme.info.model.course.CourseInfo;

/**
 * @author zsc
 * @date 2017年3月28日
 * <p>Description: 课程信息相关操作</p>
 * 
 */
public interface ICourseService {
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param CourseInfo
	 * @return
	 * <p>Description:增加课程信息</p>
	 *
	 */
	 Map<String ,Object> addCourseInfo(CourseInfo courseInfo);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param CourseInfo
	 * @return
	 * <p>Description:更新课程信息/p>
	 *
	 */
	 Map<String ,Object> updateCourseInfo(CourseInfo courseInfo); 
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @return
	 * <p>Description:获取所有课程信息</p>
	 *
	 */
	 Map<String ,Object> getAllCourseInfo();
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param coursecode
	 * @return
	 * <p>Description:根据课程代码查询课程名称</p>
	 *
	 */
	 Map<String ,Object> getCourseInfoByCourseCode(String coursecode);
}
