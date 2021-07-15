/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class OrderDAO {
    public Order order = new Order();

    public Connection con;

    public boolean b = false;

    public ArrayList<Order> listOrders;
    
    public OrderDAO() {        
        listOrders = new ArrayList<>();
    }

    public ArrayList<Order> getAllOrder() {
        try {
            DBConnection db = new DBConnection();
            this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `order`");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setoID(rs.getInt("oID"));
                order.setaID(rs.getInt("aID"));
                order.setrID(rs.getInt("rID"));
                order.setoAmountTotal(rs.getInt("oAmountTotal"));
                order.setoDateCreate(rs.getDate("oDateCreate"));
                order.setoNote(rs.getString("oNote"));
                order.setoCode(rs.getString("oCode"));
                order.setoStatus(rs.getInt("oStatus"));
                listOrders.add(order);
            }

        } catch (SQLException e) {
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrders;
    }
    
    public ArrayList<Order> getAllOrderByrID(int rID) {
        try {
            DBConnection db = new DBConnection();
            this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `order` WHERE `rID` = ?");
            pst.setInt(1, rID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setoID(rs.getInt("oID"));
                order.setaID(rs.getInt("aID"));
                order.setrID(rs.getInt("rID"));
                order.setoAmountTotal(rs.getInt("oAmountTotal"));
                order.setoDateCreate(rs.getDate("oDateCreate"));
                order.setoNote(rs.getString("oNote"));
                order.setoCode(rs.getString("oCode"));
                order.setoStatus(rs.getInt("oStatus"));
                listOrders.add(order);
            }

        } catch (SQLException e) {
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrders;
    }

    public Order getOrderById(int id) {
        Order order = null;
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `order` WHERE oID = ?");
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                order = new Order();
                order.setoID(rs.getInt("oID"));
                order.setaID(rs.getInt("aID"));
                order.setrID(rs.getInt("rID"));
                order.setoAmountTotal(rs.getInt("oAmountTotal"));
                order.setoDateCreate(rs.getDate("oDateCreate"));
                order.setoNote(rs.getString("oNote"));
                order.setoCode(rs.getString("oCode"));
                order.setoStatus(rs.getInt("oStatus"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }
}
