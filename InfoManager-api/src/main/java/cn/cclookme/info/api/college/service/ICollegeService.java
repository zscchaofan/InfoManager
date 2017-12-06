package cn.cclookme.info.api.college.service;

import java.util.Map;

import cn.cclookme.info.model.college.CollegeInfo;

/**
 * @author zsc
 * @date 2017年3月28日
 * <p>Description: 学院信息相关操作</p>
 * 
 */
public interface ICollegeService {
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param collegeInfo
	 * @return
	 * <p>Description:增加学院信息</p>
	 *
	 */
	 Map<String ,Object> addCollegeInfo(CollegeInfo collegeInfo);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param collegeInfo
	 * @return
	 * <p>Description:更新学院信息/p>
	 *
	 */
	 Map<String ,Object> updateCollegeInfo(CollegeInfo collegeInfo); 
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @return
	 * <p>Description:获取所有学院的信息</p>
	 *
	 */
	 Map<String ,Object> getAllCollegeInfo();
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param collegecode
	 * @return
	 * <p>Description:根据学院代码查询学院信息</p>
	 *
	 */
	 Map<String ,Object> getCollegeInfoByCollegeCode(String collegecode);
	 /**
	  * 
	  * @author zsc
	  * @date 2017年4月15日
	  * @param collegename
	  * @return
	  * <p>Description:根据学院名称查询学院信息</p>
	  *
	  */
	 CollegeInfo getCollegeInfoByCollegeName(String collegename);
}
