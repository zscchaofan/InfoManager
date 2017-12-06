package cn.cclookme.info.core.curriculavariable.mapper;

import cn.cclookme.info.model.curriculavariable.CurriculaVariable;

public interface CurriculaVariableMapper {
    int insert(CurriculaVariable record);

    int insertSelective(CurriculaVariable record);
}