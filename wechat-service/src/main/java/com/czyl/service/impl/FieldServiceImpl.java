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

    public Integer insertField(String name) {
        return fieldMapper.insertField(name);
    }

    public Integer updateField(String name) {
        return fieldMapper.updateField(name);
    }

    public List<Field> selectAll() {
        return fieldMapper.selectAll();
    }

    public Integer deleteField(Long id) {
        return fieldMapper.deleteField(id);
    }
}
