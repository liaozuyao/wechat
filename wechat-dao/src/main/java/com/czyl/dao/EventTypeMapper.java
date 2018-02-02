package com.czyl.dao;

import com.czyl.entity.EventType;

import java.util.List;

/**
 * Created by liaozuyao on 2017/12/20.
 */
public interface EventTypeMapper {

    List<EventType> seletAll();

    EventType getName(Long id);
}
