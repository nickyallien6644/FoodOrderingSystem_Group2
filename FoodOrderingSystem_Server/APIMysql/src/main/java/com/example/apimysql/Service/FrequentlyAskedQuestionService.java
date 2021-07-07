package com.example.apimysql.Service;

import com.example.apimysql.DAO.FrequentlyAskedQuestionDAO;
import com.example.apimysql.Interface.FrequentlyAskedQuestionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FrequentlyAskedQuestionService implements FrequentlyAskedQuestionInterface {

    @Autowired
    FrequentlyAskedQuestionDAO frequentlyAskedQuestionDAO;

    @Override
    public List<Map<String, Object>> listFrequentlyAskedQuestion() {
        return frequentlyAskedQuestionDAO.listFrequentlyAskedQuestion();
    }
}
