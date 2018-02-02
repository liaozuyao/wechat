package com.czyl.service.impl;

import com.czyl.dao.ChangeListMapper;
import com.czyl.entity.ChangeList;
import com.czyl.service.ChangeListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaozuyao on 2017/12/21.
 */
@Service
public class ChangeListServiceImpl implements ChangeListService {

    @Resource
    ChangeListMapper changeListMapper;

    public Integer insertChangeList(ChangeList changeList) {
        return changeListMapper.insertChangeList(changeList);
    }

    public List<ChangeList> getChangeListByUserId(Long userId) {
        List<ChangeList> changeListByUserId = changeListMapper.getChangeListByUserId(userId);
        return changeTypes(changeListByUserId);
    }

    private List<ChangeList> changeTypes(List<ChangeList> changeListss){
        List<ChangeList> changeLists  = new ArrayList<ChangeList>();
        for (ChangeList changeList : changeListss) {
            if(changeList.getTitle().length() >= 5){
                StringBuilder sb = new StringBuilder();
                sb.append(changeList.getTitle().substring(0, 5)).append("...");
                changeList.setTitle(sb.toString());
            }
            changeLists.add(changeList);
        }
        return changeLists;
    }

    public ChangeList getChangeListDetail(Long id) {
        return changeListMapper.getChangeListDetail(id);
    }

    public List<ChangeList> getAllChangeList() {
        List<ChangeList> allChangeList = changeListMapper.getAllChangeList();
        return changeTypes(allChangeList);
    }

    public Integer countChangeList() {
        return changeListMapper.countChangeList();
    }
}
