package com.example.apimysql.Interface;

import java.util.List;
import java.util.Map;

public interface AccountInterface {
    public List<Map<String, Object>> listAccounts();
    public List<Map<String, Object>>listAccounts(int aID);
}
