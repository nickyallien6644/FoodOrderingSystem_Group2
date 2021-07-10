package com.example.apimysql.DAO;

import com.example.apimysql.Interface.FrequentlyAskedQuestionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FrequentlyAskedQuestionDAO implements FrequentlyAskedQuestionInterface {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Map<String, Object>> listFrequentlyAskedQuestion() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `frequently_asked_question`");
        return query;
    }
}
