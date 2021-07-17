/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entity.Account;
import Models.Entity.Restaurant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phuct
 */
public class RestaurantDAO {

    public Restaurant restaurant;

    public Connection conn;

    public boolean b = false;

    public ArrayList<Restaurant> listRestaurant;

    public RestaurantDAO() {
        restaurant = new Restaurant();
        listRestaurant = new ArrayList<>();
    }

    public ArrayList<Restaurant> getAllRestaurant() {
        try {
            DBConnection db = new DBConnection();
            this.conn = db.getConnect();
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("SELECT * FROM `restaurant`");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setrId(rs.getInt("rID"));
                restaurant.setrName(rs.getString("rName"));
                restaurant.setrTimeOpen(rs.getTime("rTimeOpen"));
                restaurant.setrTimeClose(rs.getTime("rTimeClose"));
                restaurant.setrAddress(rs.getString("rAddress"));
                restaurant.setrPhone(rs.getString("rPhone"));
                restaurant.setrImage(rs.getString("rImage"));
                listRestaurant.add(restaurant);
            }

        } catch (SQLException e) {
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRestaurant;

    }

    public boolean insertRestaurant(String name, Time timeOpen, Time timeClose, String address, String phone, String image) {

        try {
            DBConnection db = new DBConnection();
            this.conn = db.getConnect();
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("INSERT INTO `restaurant`(`rName`, `rTimeOpen`, `rTimeClose`, `rAddress`, `rPhone`, `rImage`) VALUES (?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setTime(2, timeOpen);
            pst.setTime(3, timeClose);
            pst.setString(4, address);
            pst.setString(5, phone);
            pst.setString(6, image);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Restaurant getRestaurantById(int id) {
        Restaurant restaurant = null;
        try {
            DBConnection db = new DBConnection();
            this.conn = db.getConnect();
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("SELECT * FROM `restaurant` WHERE rID = ?");
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                restaurant = new Restaurant();
                restaurant.setrId(rs.getInt("rID"));
                restaurant.setrName(rs.getString("rName"));
                restaurant.setrTimeOpen(rs.getTime("rTimeOpen"));
                restaurant.setrTimeClose(rs.getTime("rTimeClose"));
                restaurant.setrAddress(rs.getString("rAddress"));
                restaurant.setrPhone(rs.getString("rPhone"));
                restaurant.setrImage(rs.getString("rImage"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurant;
    }

    public boolean updateRestaurant(int id, String name, Time timeOpen, Time timeClose, String address, String phone, String image) {

        try {
            DBConnection db = new DBConnection();
            this.conn = db.getConnect();
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("UPDATE `restaurant` SET `rName`=?,`rTimeOpen`=?,`rTimeClose`=?,`rAddress`=?,`rPhone`=?,`rImage`=? WHERE `rID`=?");
            pst.setString(1, name);
            pst.setTime(2, timeOpen);
            pst.setTime(3, timeClose);
            pst.setString(4, address);
            pst.setString(5, phone);
            pst.setString(6, image);
            pst.setInt(7, id);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateRestaurantNoImage(int id, String name, Time timeOpen, Time timeClose, String address, String phone) {

        try {
            DBConnection db = new DBConnection();
            this.conn = db.getConnect();
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("UPDATE `restaurant` SET `rName`=?,`rTimeOpen`=?,`rTimeClose`=?,`rAddress`=?,`rPhone`=? WHERE `rID`=?");
            pst.setString(1, name);
            pst.setTime(2, timeOpen);
            pst.setTime(3, timeClose);
            pst.setString(4, address);
            pst.setString(5, phone);
            pst.setInt(6, id);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
