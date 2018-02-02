package com.czyl.dao;

import com.czyl.entity.ChangeList;

import java.util.List;

/**
 * Created by liaozuyao on 2017/12/21.
 */
public interface ChangeListMapper {

    Integer insertChangeList(ChangeList changeList);

    List<ChangeList> getChangeListByUserId(Long userId);

    ChangeList getChangeListDetail(Long id);

    List<ChangeList> getAllChangeList();

    Integer countChangeList();
}
