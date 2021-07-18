package com.example.apimysql.DAO;

import com.example.apimysql.Interface.FrequentlyAskedQuestionInterface;
import com.example.apimysql.Interface.NotificationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class NotificationDAO implements NotificationInterface {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Map<String, Object>> ListNofication(String ID) {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM notification WHERE `aID`= "+ID);
        return query;
    }
}
