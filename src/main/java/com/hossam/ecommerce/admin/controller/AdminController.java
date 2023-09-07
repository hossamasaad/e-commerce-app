package com.hossam.ecommerce.admin.controller;


import com.hossam.ecommerce.admin.model.Admin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping
    public Admin addAdmin(@RequestBody Admin admin){
        return admin;
    }

    @PutMapping("/{adminId}")
    public Admin updateAdmin(@PathVariable int adminId, @RequestBody Admin admin){
        return admin;
    }

}
