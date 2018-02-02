package com.czyl.dao;

import com.czyl.entity.Selected;

import java.util.List;

public interface SelectedMapper {

    List<Selected> select(Long parentId);

    Selected getSelectName(Long id);

    List<Selected> getNodes(Long parentId);
}