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

    @GetMapping("/listbyid")
    public List<Map<String, Object>> listAccounts(int aID) {
        return service.listAccounts();
    }

    @PostMapping("/add")
    public String add(@RequestBody Account account) {
        int id=service.add(account);
        if(id==0) {
            return "Faile Add Account";
        }
        return "Add acount is success";
    }

    @RequestMapping ("/updateCoins")
    public String updateConis(@RequestBody Account account) {
        int coins = service.updateConis(account);
        if(coins==0) {
            return "Faile update";
        }
        return "update coins is success";
    }
    @RequestMapping ("/forgotPassword")
    public String forgotPassword(@RequestBody Account account) {
        int id = service.forgotPassword(account);
        if(id==0) {
            return "Faile ";
        }
        return "Create new password is success";
    }
}
