package com.czyl.service.impl;

import com.czyl.dao.FieldMapper;
import com.czyl.entity.Field;
import com.czyl.service.FieldService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FieldServiceImpl implements FieldService {

    @Resource
    private FieldMapper fieldMapper;

    public Integer insertField(Field field) {
        return fieldMapper.insertField(field);
    }

    public Integer updateField(Field field) {
        return fieldMapper.updateField(field);
    }

    public List<Field> selectAll() {
        return fieldMapper.selectAll();
    }
}
