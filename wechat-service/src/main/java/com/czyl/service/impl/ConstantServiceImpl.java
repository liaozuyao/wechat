package com.czyl.service.impl;

import com.czyl.dao.ConstantMapper;
import com.czyl.entity.Constant;
import com.czyl.service.ConstantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liaozuyao on 2017/12/21.
 */
@Service
public class ConstantServiceImpl implements ConstantService {

    @Resource
    ConstantMapper constantMapper;

    public List<Constant> getAll(Integer type) {
        return constantMapper.getAll(type);
    }

    public Constant getName(Long id) {
        return constantMapper.getName(id);
    }

    public Constant getQuestionStatus(Long id) {
        return constantMapper.getQuestionStatus(id);
    }
}
