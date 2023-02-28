package com.admin.controller;

import com.admin.entity.Admin;
import com.admin.exception.AdminPropertiesCanNotBeNull;
import com.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/get/{userName}/{password}")
    public ResponseEntity<Admin> findAdminByEmailAndPassword(@PathVariable("userName") String userName,
                                                             @PathVariable("password") String password) {
        if(userName.equals("") || password.equals("")) {
            log.info("Admin properties can not be null");
            throw new AdminPropertiesCanNotBeNull("Admin properties can not be null");
        }
        Admin admin1 = adminService.findAdminByUserNameAndPassword(userName, password);
        return new ResponseEntity<>(admin1, HttpStatus.OK);
    }
}
