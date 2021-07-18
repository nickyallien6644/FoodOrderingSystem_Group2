package com.example.apimysql.Controller;

import com.example.apimysql.Model.Account;
import com.example.apimysql.Service.AccountService;
import com.example.apimysql.Service.NoficationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/nofication")
public class NoficationController {

    @Autowired
    NoficationService noficationService;

    //get all user when url to list
    @GetMapping("/list/{ID}")
    public List<Map<String, Object>> ListNofication(@PathVariable("ID") String ID) {
        return noficationService.ListNofication(ID);
    }

}
