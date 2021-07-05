package com.example.apimysql.Controller;

import com.example.apimysql.Service.FrequentlyAskedQuestionService;
import com.example.apimysql.Service.PrivacyPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/frequentlyAskedQuestion")
public class FrequentlyAskedQuestionController {
    @Autowired
    FrequentlyAskedQuestionService frequentlyAskedQuestionService;

    @GetMapping("/listFrequentlyAskedQuestion")
    public List<Map<String, Object>> listFrequentlyAskedQuestion() {
        return frequentlyAskedQuestionService.listFrequentlyAskedQuestion();
    }
}
