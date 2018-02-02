package com.czyl.dao;

import com.czyl.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    Admin select(@Param("username") String name, @Param("password") String password);
}
