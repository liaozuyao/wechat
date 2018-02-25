package com.czyl.dao;

import com.czyl.entity.Field;

import java.util.List;

public interface FieldMapper {

    Integer insertField(String name);

    Integer updateField(String name);

    List<Field> selectAll();

    Integer deleteField(Long id);

    String getNameById(Long id);
}
