package com.example.apimysql.Service;

import com.example.apimysql.DAO.AccountDAO;
import com.example.apimysql.Interface.AccountInterface;
import com.example.apimysql.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountService implements AccountInterface {
    @Autowired
    AccountDAO dao;

    @Override
    public List<Map<String, Object>> listAccounts() {
        return dao.listAccounts();
    }

    @Override
    public List<Map<String, Object>> listAccounts(int aID) {
        return null;
    }

    @Override
    public int add(Account p) {
        return dao.add(p);
    }

    @Override
    public int updateConis(Account account) {
        return dao.updateConis(account);
    }



}
