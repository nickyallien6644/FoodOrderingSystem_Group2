/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entity.Account;
import Models.Entity.Restaurant;
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
        listAccounts = new ArrayList<>();
        con = db.getConnect();
    }

    public ArrayList<Account> getAllAccount() {
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `account`");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setaID(rs.getInt("aID"));
                account.setrID(rs.getInt("rID"));
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

        return listAccounts;
    }

    public Account getAccountById(int id) {
        DBConnection db = new DBConnection();
        this.con = db.getConnect();
        Account account = null;
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `account` WHERE aID = ?");
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setaID(rs.getInt("aID"));
                account.setrId(rs.getInt("rID"));
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

    public boolean updateAccount(int id, String first_name, String last_name, String phone, String email, String address, int status, int restaurantId) {

        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("UPDATE `account` SET `aEmail`=?,`aFirstname`=?,`aLastname`=?,`aPhone`=?,`aAddress`=?,`aStatus`=?,`rID`=? WHERE `aID`=?");
            pst.setString(1, email);
            pst.setString(2, first_name);
            pst.setString(3, last_name);
            pst.setString(4, phone);
            pst.setString(5, address);
            pst.setInt(6, status);
            pst.setInt(7, restaurantId);
            pst.setInt(8, id);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateProfile(int id, String first_name, String last_name, String phone, String email, String address, int status, int restaurantId, String newPass) {

        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("UPDATE `account` SET `aEmail`=?, `aPassword`= MD5(?), `aFirstname`=?,`aLastname`=?,`aPhone`=?,`aAddress`=?,`aStatus`=?,`rID`=? WHERE `aID`=?");
            pst.setString(1, email);
            pst.setString(2, newPass);
            pst.setString(3, first_name);
            pst.setString(4, last_name);
            pst.setString(5, phone);
            pst.setString(6, address);
            pst.setInt(7, status);
            pst.setInt(8, restaurantId);
            pst.setInt(9, id);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insertAccount(String first_name, String last_name, String phone, String email, String address, int role, String password, int restaurantId) {

        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO `account`(`rID`, `roleID`, `aEmail`, `aPassword`, `aFirstname`, `aLastname`, `aPhone`, `aAddress`) VALUES (?,?,?,MD5(?),?,?,?,?)");
            pst.setInt(1, restaurantId);
            pst.setInt(2, role);
            pst.setString(3, email);
            pst.setString(4, password);
            pst.setString(5, first_name);
            pst.setString(6, last_name);
            pst.setString(7, phone);
            pst.setString(8, address);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }

        return false;
    }
}
