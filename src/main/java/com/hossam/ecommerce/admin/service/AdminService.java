package com.hossam.ecommerce.admin.service;


import com.hossam.ecommerce.admin.model.Admin;
import com.hossam.ecommerce.admin.repository.AdminRepository;
import com.hossam.ecommerce.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends GenericService<Admin> {

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        super(adminRepository);
    }

}
