package cn.cclookme.info.api.score.service;

import java.util.Map;

import cn.cclookme.info.model.score.StudentScore;
import cn.cclookme.info.model.user.StudentInfo;

/**
 * @author zsc
 * @date 2017年3月28日
 *       <p>
 *       Description: 学生分数相关接口
 *       </p>
 * 
 */
public interface IStudentScoreService {

	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param cardid
	 * @param prefixString
	 * @return <p>
	 *         Description:根据学生卡id查询学生的分数
	 *         </p>
	 * 
	 */
	 Map<String, Object> getStudentScoreByStudentId(String cardid,String page,String prefixString);

	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param thiscore
	 * @param prefixString
	 * @return <p>
	 *         Description:查询大于该分数的所有课程的分数
	 *         </p>
	 * 
	 */
	 Map<String, Object> getStudentScoreByMorethanthisScore(
			double thisscore,String prefixString);

	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param thisscore
	 * @param prefixString
	 * @return <p>
	 *         Description:查询小于该分数的所有课程的分数
	 *         </p>
	 * 
	 */
	 Map<String, Object> getStudentScoreByLowerthanthisScore(
			double thisscore,String prefixString);

	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param thistime
	 * @param prefixString
	 * @return <p>
	 *         Description:查询晚于这个开课时间的课程的分数
	 *         </p>
	 * 
	 */
	 Map<String, Object> getStudentScoreByMorethanCoursetarttime(
			String thistime,String prefixString);

	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param thistime
	 * @param prefixString
	 * @return <p>
	 *         Description:查询早于这个开课时间的课程的分数
	 *         </p>
	 * 
	 */
	 Map<String, Object> getStudentScoreByLowerthanCourseendtime(
			String thistime,String prefixString);

	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param starttime
	 * @param prefixString
	 * @param endtime
	 * @return <p>
	 *         Description:查询介于两个时间之间的所有课程的分数
	 *         </p>
	 * 
	 */
	 Map<String, Object> getStudentScoreByMiddleStarttimeandEndtime(
			String starttime, String endtime,String prefixString);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param pass
	 *  @param prefixString
	 * @return
	 * <p>Description:查詢是否通过的成绩</p>
	 *
	 */
	 Map<String ,Object> getStudentScoreByispass(Integer pass,String prefixString);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param prefixString
	 * @param teachername
	 * @return
	 * <p>Description:查询该任课老师的课程的成绩</p>
	 *
	 */
	 Map<String ,Object> getStudentScoreByclassroomTeacher(String teachername,String prefixString);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param coursecode
	 * @param prefixString
	 * @return
	 * <p>Description: 根据课程代码查询成绩</p>
	 *
	 */
	 Map<String ,Object> getStudentScoreByCourseCode(String coursecode,String prefixString);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param studentScore
	 * @param prefixString
	 * @return
	 * <p>Description:更新分数</p>
	 *
	 */
	 Map<String ,Object> updateStudentScore(StudentScore studentScore,String prefixString);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param score
	 * @param prefixString
	 * @return
	 * <p>Description:添加学生成绩信息</p>
	 *
	 */
	 Map<String ,Object> saveStudentScore(StudentScore score,String prefixString);
	 /**
	  * 
	  * @author zsc
	  * @date 2017年5月10日
	  * @param map
	  * @return
	  * <p>Description:删除信息</p>
	  *
	  */
	 Map<String ,Object> deleteStudentScore(Map<String ,Object> map);
}
