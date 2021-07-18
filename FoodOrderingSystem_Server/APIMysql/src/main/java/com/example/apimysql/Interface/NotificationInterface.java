package com.example.apimysql.Interface;

import com.example.apimysql.Model.Account;

import java.util.List;
import java.util.Map;

public interface NotificationInterface {

    public List<Map<String, Object>> ListNofication(String ID);

}
