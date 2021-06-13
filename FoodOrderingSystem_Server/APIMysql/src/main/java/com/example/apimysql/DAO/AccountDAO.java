package com.example.apimysql.DAO;

import com.example.apimysql.Interface.AccountInterface;
import com.example.apimysql.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AccountDAO implements AccountInterface {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Map<String, Object>> listAccounts() {
        //execute query select all user
        List<Map<String, Object>> query = template.queryForList("select * from account");
        return query;
    }
    @Override
    public List<Map<String, Object>> listAccounts(int aID) {
        return null;
    }

    @Override
    public int add(Account account) {
        String sql = "insert into account(roleID,aEmail,aPassword,aCoins,aFirstname,aLastname,aPhone,aAddress,aStatus)values(?,?,?,?,?,?,?,?,?)";
        return template.update(sql, account.getRoleID(), account.getaEmail(),account.getaPassword(), account.getaCoins(), account.getaFirstname(), "yy" ,account.getaPhone(), account.getaAddress(),account.getaStatus());
    }
}
