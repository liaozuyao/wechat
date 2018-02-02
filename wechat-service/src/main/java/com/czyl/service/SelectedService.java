package com.czyl.service;

import com.czyl.entity.Selected;

import java.util.List;

/**
 * Created by liaozuyao on 2017/12/19.
 */
public interface SelectedService {

    List<Selected> select(Long parentId);

    Selected getSelectName(Long id);

    List<Selected> getNodes(Long parentId);
}
