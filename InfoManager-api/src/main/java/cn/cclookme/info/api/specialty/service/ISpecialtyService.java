package cn.cclookme.info.api.specialty.service;

import java.util.Map;

import cn.cclookme.info.model.specialty.SpecialtyInfo;
import cn.cclookme.info.model.user.StudentInfo;
import cn.cclookme.info.model.user.TeacherInfo;

/**
 * @author zsc
 * @date 2017年3月28日
 * <p>Description: 专业信息相关操作</p>
 * 
 */
public interface ISpecialtyService {
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param info
	 * @return
	 * <p>Description:增加专业信息</p>
	 *
	 */
	 Map<String ,Object> addSpecialtyInfo(SpecialtyInfo info);
		Map<String, Object> addByTest(StudentInfo studentInfo, TeacherInfo teacherInfo);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param specialtyInfo
	 * @return
	 * <p>Description:更新专业信息</p>
	 *
	 */
	 Map<String ,Object> updateSpecialtyInfo(SpecialtyInfo specialtyInfo);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @return
	 * <p>Description:获取所有的专业信息</p>
	 *
	 */
	 Map<String ,Object> getAllSpecialtyInfo();
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param specialtycode
	 * @return
	 * <p>Description:根据专业代码获取专业名称</p>
	 *
	 */
	 Map<String ,Object> getSpecialtyInfoBySpecialtyCode(String specialtycode);
}
