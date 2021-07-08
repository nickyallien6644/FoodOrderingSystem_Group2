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
    @RequestMapping(value="/updateCoins/{aID}", method=RequestMethod.PUT)
    public @ResponseBody Account update(@PathVariable("aID") int id ,@RequestBody Account account){
        account.setaID(id);
        service.updateConis(account);

        return account;
    }
//    @PostMapping("/updateCoins/{aID}")
//    public String updateCoins(@RequestBody Account account , @PathVariable int id) {
//        account.setaID(id);
//        int coins = service.updateConis(account);
//        if(coins==0) {
//            return "Faile update       ";
//        }
//        return "update coins is success";
//    }
}
