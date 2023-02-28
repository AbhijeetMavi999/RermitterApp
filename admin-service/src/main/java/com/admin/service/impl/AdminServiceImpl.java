package com.admin.service.impl;

import com.admin.entity.Admin;
import com.admin.exception.AdminNotFoundException;
import com.admin.repository.AdminRepository;
import com.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findAdminByUserNameAndPassword(String userName, String password) {
        Admin admin = adminRepository.findAdminByUserNameAndPassword(userName, password);
        if(admin == null) {
            log.info("Admin not found by username: "+userName+" and password: "+password);
            throw new AdminNotFoundException("Admin not found by username: "+userName+" and password: "+password);
        }
        return admin;
    }
}
