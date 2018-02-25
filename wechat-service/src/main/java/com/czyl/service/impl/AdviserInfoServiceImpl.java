package com.czyl.service.impl;

import com.czyl.common.Constants;
import com.czyl.dao.AdviserInfoMapper;
import com.czyl.entity.AdviserInfo;
import com.czyl.service.AdviserInfoService;
import com.czyl.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdviserInfoServiceImpl implements AdviserInfoService{

    @Resource
    private AdviserInfoMapper adviserInfoMapper;

    public Integer insertAdviserInfo(String name, String phone, String mail, Integer type) {
        AdviserInfo adviserInfo = new AdviserInfo();
        adviserInfo.setName(name);
        adviserInfo.setPhone(phone);
        adviserInfo.setMail(mail);
        adviserInfo.setPassword(MD5Utils.EncoderByMd5(Constants.INIT_PASSWORD));
        adviserInfo.setType(type);
        return adviserInfoMapper.insertAdviserInfo(adviserInfo);
    }

    public List<AdviserInfo> getAllAdviser() {
        return adviserInfoMapper.getAllAdviser();
    }

    public Integer updateAdviserInfo(String name, String phone, String mail, Long id, Integer type) {
        AdviserInfo adviserInfo = new AdviserInfo();
        adviserInfo.setId(id);
        adviserInfo.setName(name);
        adviserInfo.setPhone(phone);
        adviserInfo.setMail(mail);
        adviserInfo.setType(type);
        return adviserInfoMapper.updateAdviserInfo(adviserInfo);
    }

    public AdviserInfo adviserOrDevlpLogin(String phone, String password) {
        return adviserInfoMapper.adviserOrDevlpLogin(phone, password);
    }

    public List<AdviserInfo> getAllByType(Integer type) {
        return adviserInfoMapper.getAllByType(type);
    }

    public String getNameById(Long id) {
        return adviserInfoMapper.getNameById(id);
    }
}
