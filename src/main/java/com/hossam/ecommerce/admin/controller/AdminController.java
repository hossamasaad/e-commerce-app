package com.hossam.ecommerce.admin.controller;


import com.hossam.ecommerce.admin.model.Admin;
import com.hossam.ecommerce.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;


    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

        @GetMapping("/{adminId}")
        public Admin getAdminById(@PathVariable int adminId){
            return adminService.getAdminById(adminId);
        }

        @GetMapping("/email/{adminEmail}")
        public Admin getAdminByEmail(@PathVariable String adminEmail){
            return adminService.getAdminByEmail(adminEmail);
        }

    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @PostMapping
    public Admin addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    @PutMapping
    public Admin updateAdmin(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }

}
