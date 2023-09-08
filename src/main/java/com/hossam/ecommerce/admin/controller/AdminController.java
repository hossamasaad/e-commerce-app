package com.hossam.ecommerce.admin.controller;


import com.hossam.ecommerce.admin.model.Admin;
import com.hossam.ecommerce.admin.service.AdminService;
import com.hossam.ecommerce.common.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController extends GenericController<Admin> {

    @Autowired
    public AdminController(AdminService adminService) {
        super(adminService);
    }
}
