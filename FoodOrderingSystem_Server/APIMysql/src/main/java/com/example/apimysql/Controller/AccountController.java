package com.example.apimysql.Controller;

import com.example.apimysql.Model.Account;
import com.example.apimysql.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public String add(@RequestBody Account account) {
        int id=service.add(account);
        if(id==0) {
            return "Faile Add Account   ";
        }
        return "Add acount is success";
    }
}
