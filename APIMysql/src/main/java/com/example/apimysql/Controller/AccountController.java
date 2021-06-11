package com.example.apimysql.Controller;

import com.example.apimysql.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService service;
    //get all user when url to list
    @GetMapping("/list")
    public List<Map<String, Object>> listAccounts() {
        return service.listAccounts();
    }

    @GetMapping("/getid")
    public List<Map<String, Object>> listAccounts(int aID) {
        return service.listAccounts();
    }
}
