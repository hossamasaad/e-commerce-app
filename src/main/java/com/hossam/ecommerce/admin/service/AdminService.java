package com.hossam.ecommerce.admin.service;


import com.hossam.ecommerce.admin.model.Admin;
import com.hossam.ecommerce.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin getAdminById(int adminId){
        Optional<Admin> admin = adminRepository.findById(adminId);

        if (admin.isPresent())
            return admin.get();

        throw new RuntimeException("There is no Admin with id = " + adminId);
    }

    public Admin getAdminByEmail(String adminEmail){
        Optional<Admin> admin = adminRepository.findByEmail(adminEmail);

        if (admin.isPresent())
            return admin.get();

        throw new RuntimeException("There is no Admin with email = " + adminEmail);
    }

    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    public Admin addAdmin(Admin admin) {
        try {
            admin.setAdminId(0); // force to save
            admin.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            admin.setModifiedAt(new Timestamp(System.currentTimeMillis()));
            return adminRepository.save(admin);
        } catch (DataIntegrityViolationException e) {
            // Handle the case where the email is duplicated
            throw new IllegalArgumentException("Email is already registered");
        }
    }

    public Admin updateAdmin(Admin admin) {
        if (admin.getAdminId() == 0) {
            throw new IllegalArgumentException("Admin ID cannot be null");
        }

        Optional<Admin> existingAdmin = adminRepository.findById(admin.getAdminId());
        if (existingAdmin.isEmpty()) {
            throw new IllegalArgumentException("Admin with ID " + admin.getAdminId() + " does not exist");
        }

        admin.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        return adminRepository.save(admin);
    }

}
