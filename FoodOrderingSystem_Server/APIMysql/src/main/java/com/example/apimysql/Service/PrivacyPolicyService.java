package com.example.apimysql.Service;

import com.example.apimysql.DAO.PrivacyPolicyDAO;
import com.example.apimysql.Interface.PrivacyPolicyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PrivacyPolicyService implements PrivacyPolicyInterface {

    @Autowired
    PrivacyPolicyDAO privacyPolicyDAO;

    @Override
    public List<Map<String, Object>> listPrivacyPolicy() {
        return privacyPolicyDAO.listPrivacyPolicy();
    }
}
