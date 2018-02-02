package com.czyl.service.impl;

import com.czyl.dao.EventTypeMapper;
import com.czyl.entity.EventType;
import com.czyl.service.EventTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liaozuyao on 2017/12/20.
 */
@Service
public class EventTypeServiceImpl implements EventTypeService{

    @Resource
    EventTypeMapper eventTypeMapper;

    public List<EventType> seletAll() {
        return eventTypeMapper.seletAll();
    }

    public EventType getName(Long id) {
        return eventTypeMapper.getName(id);
    }
}
