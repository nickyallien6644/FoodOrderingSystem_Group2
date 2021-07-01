package com.example.apimysql.Controller;

import com.example.apimysql.Service.PrivacyPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/privacyPolicy")
public class PrivacyPolicyController {
    @Autowired
    PrivacyPolicyService privacyPolicyService;

    @GetMapping("/listPrivacyPolicy")
    public List<Map<String, Object>> listPrivacyPolicy() {
        return privacyPolicyService.listPrivacyPolicy();
    }
}
