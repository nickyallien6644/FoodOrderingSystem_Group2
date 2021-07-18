/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class CategoryDAO {
    public Category category = new Category();

    public Connection con;

    public boolean b = false;

    public ArrayList<Category> listCategorys;
    
    public CategoryDAO() {
        listCategorys = new ArrayList<>();
    }

    public ArrayList<Category> getAllCategory() {
        try {
            DBConnection db = new DBConnection();
            this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `category`");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setcID(rs.getInt("cID"));
                category.setcName(rs.getString("cName"));
                category.setiURL(rs.getString("cURL"));
                listCategorys.add(category);
            }

        } catch (SQLException e) {
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCategorys;
    }

    public Category getCategoryById(int id) {
        Category category = null;
        try {
            DBConnection db = new DBConnection();
        this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `category` WHERE cID = ?");
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                category = new Category();
                category.setcID(rs.getInt("cID"));
                category.setcName(rs.getString("cName"));
                category.setiURL(rs.getString("cURL"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }
    
    public boolean updateCategory(int id, String cName, String cURL){
    
        try {
            DBConnection db = new DBConnection();
        this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement)con.prepareStatement("UPDATE `category` SET `cName`=?,`cURL`=? WHERE `cID`=?");
            pst.setString(1, cName);
            pst.setString(2, cURL);
            pst.setInt(3, id);
            return pst.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean insertCategory(String cName, String cURL){
    
        try {
            DBConnection db = new DBConnection();
        this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement)con.prepareStatement("INSERT INTO `category`(`cName`, `cURL`) VALUES (?,?)");
            pst.setString(1, cName);
            pst.setString(2, cURL);
            return pst.executeUpdate()>0;
        } catch (Exception e) {
        }
 
    return false;
    }
}
