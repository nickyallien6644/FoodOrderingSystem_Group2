/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entity.Account;
import Models.Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phuct
 */
public class AccountDAO {

    public Account account = new Account();

    public Connection con;

    public boolean b = false;

    public ArrayList<Account> listAccounts;

    public AccountDAO() {
        DBConnection db = new DBConnection();
        this.con = db.getConnect();
        listAccounts = new ArrayList<>();
    }

    public ArrayList<Account> getAllAccount() {
        try {

            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `account`");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setaID(rs.getInt("aID"));
                account.setaFirstname(rs.getString("aFirstname"));
                account.setAemail(rs.getString("aEmail"));
                account.setRoleID(rs.getInt("roleID"));
                account.setaPassword(rs.getString("aPassword"));
                account.setaLastname(rs.getString("aLastname"));
                account.setaPhone(rs.getString("aPhone"));
                account.setaAddress(rs.getString("aAddress"));
                account.setaStatus(rs.getInt("aStatus"));
                account.setaCoins(rs.getDouble("aCoins"));
                listAccounts.add(account);
            }

        } catch (SQLException e) {
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAccounts;
    }

    public Account getAccountById(int id) {
        Account account = null;
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `account` WHERE aID = ?");
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setaID(rs.getInt("aID"));
                account.setaFirstname(rs.getString("aFirstname"));
                account.setAemail(rs.getString("aEmail"));
                account.setRoleID(rs.getInt("roleID"));
                account.setaPassword(rs.getString("aPassword"));
                account.setaLastname(rs.getString("aLastname"));
                account.setaPhone(rs.getString("aPhone"));
                account.setaAddress(rs.getString("aAddress"));
                account.setaStatus(rs.getInt("aStatus"));
                account.setaCoins(rs.getDouble("aCoins"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }
}
