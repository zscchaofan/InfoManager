package cn.cclookme.info.api.user.service;

import java.util.Map;

import cn.cclookme.info.model.user.StudentInfo;
import cn.cclookme.info.model.user.TeacherInfo;

/**
 * @author zsc
 * @date 2017年3月28日
 *       <p>
 *       Description: 学生信息相关接口
 *       </p>
 * 
 */
public interface IStudentInfoService {
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param cardid
	 * @return <p>
	 *         Description: 通过学生卡id查询学生信息
	 *         </p>
	 * 
	 */
	Map<String, Object> getStudentInfoByStudentCardId(String cardid);

	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param studentinfo
	 * @return <p>
	 *         Description: 更新学生信息
	 *         </p>
	 * 
	 */
	Map<String, Object> updateStudentInfo(StudentInfo studentinfo);

	/**
	 * 
	 * @author zsc
	 * @date 2017年4月3日
	 * @param cardid
	 * @param password
	 * @return <p>
	 *         Description:根据cardID password 查询是否有此人
	 *         </p>
	 * 
	 */
	Map<String, Object> getStudentInfoByStudentCardIdAndPassword(String cardid,
			String password);

	/**
	 * 
	 * @author zsc
	 * @date 2017年4月12日
	 * @param studentInfo
	 * @return <p>
	 *         Description:保存学生信息
	 *         </p>
	 * 
	 */
	Map<String, Object> saveStudentInfo(StudentInfo studentInfo);
	Map<String, Object> saveStudentInfoByTest(StudentInfo studentInfo);

	/**
	 * 
	 * @author zsc
	 * @date 2017年4月15日
	 * @param cardid
	 * @param name
	 * @param status
	 * @param specialty
	 * @return
	 * <p>Description:根据这四个参数查询符合条件的学生</p>
	 *
	 */
	Map<String ,Object> getStudentList(String cardid,String name,String status,String specialty,String academy,Integer page);
	/**
	 * 
	 * @author zsc
	 * @date 2017年4月17日
	 * @param cardid
	 * @param name
	 * @param specialty
	 * @return
	 * <p>Description:查找为添加成绩显示的学生列表</p>
	 *
	 */
	Map<String ,Object> getScoreStudentList(String cardid ,String name,String specialty,String academy,String year,Integer page);

}
