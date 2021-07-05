package com.example.apimysql.DAO;

import com.example.apimysql.Interface.PrivacyPolicyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PrivacyPolicyDAO implements PrivacyPolicyInterface {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Map<String, Object>> listPrivacyPolicy() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `privacy_policy`");
        return query;
    }
}
