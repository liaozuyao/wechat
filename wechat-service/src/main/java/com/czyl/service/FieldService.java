package com.czyl.service;

import com.czyl.entity.Field;

import java.util.List;

public interface FieldService {

    Integer insertField(Field field);

    Integer updateField(Field field);

    List<Field> selectAll();
}
