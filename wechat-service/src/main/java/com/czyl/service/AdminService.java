package com.czyl.service;

import com.czyl.entity.Admin;

public interface AdminService {

    Admin select(String name, String password);
}
