package com.czyl.service;

import com.czyl.entity.Constant;

import java.util.List;

/**
 * Created by liaozuyao on 2017/12/21.
 */
public interface ConstantService {

    List<Constant> getAll(Integer type);

    Constant getName(Long id);

    Constant getQuestionStatus(Long id);
}
