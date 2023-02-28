package com.admin.service;

import com.admin.entity.Admin;

public interface AdminService {

    public Admin findAdminByUserNameAndPassword(String userName, String password);
}
