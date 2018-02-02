package com.czyl.dao;

import com.czyl.entity.Constant;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liaozuyao on 2017/12/21.
 */
@Repository
public interface ConstantMapper {

    List<Constant> getAll(Integer type);

    Constant getName(Long id);

    Constant getQuestionStatus(Long id);
}
