package com.czyl.service.impl;

import com.czyl.dao.SelectedMapper;
import com.czyl.entity.Selected;
import com.czyl.service.SelectedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liaozuyao on 2017/12/19.
 */
@Service
public class SelectedServiceImpl implements SelectedService {

    @Resource
    private SelectedMapper selectedMapper;

    public List<Selected> select(Long parentId) {
        return selectedMapper.select(parentId);
    }

    public Selected getSelectName(Long id) {
        return selectedMapper.getSelectName(id);
    }

    public List<Selected> getNodes(Long parentId) {
        return selectedMapper.getNodes(parentId);
    }

}
