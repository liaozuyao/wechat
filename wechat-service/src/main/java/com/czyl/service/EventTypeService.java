package com.czyl.service;

import com.czyl.entity.EventType;

import java.util.List;

/**
 * Created by liaozuyao on 2017/12/20.
 */
public interface EventTypeService {

    List<EventType> seletAll();

    EventType getName(Long id);
}
