package com.czyl.dao;

import com.czyl.entity.Field;

import java.util.List;

public interface FieldMapper {

    Integer insertField(Field field);

    Integer updateField(Field field);

    List<Field> selectAll();
}
