package cn.cclookme.info.api.curriculavariable.service;

import java.util.Map;

import cn.cclookme.info.model.curriculavariable.CurriculaVariable;

/**
 * @author zsc
 * @date 2017年3月28日
 * <p>Description: 选修课相关操作</p>
 * 
 */
public interface ICurriculaVariableService {
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param curriculaVariable
	 * @return
	 * <p>Description:添加选修课信息</p>
	 *
	 */
	 Map<String ,Object> saveCurriculaVariable(CurriculaVariable curriculaVariable);
	/**
	 * 
	 * @author zsc
	 * @date 2017年3月28日
	 * @param curriculaVariable
	 * @return
	 * <p>Description:更新选修课信息</p>
	 *
	 */
	 Map<String ,Object> updateCurriculaVariable(CurriculaVariable curriculaVariable);
	
}
