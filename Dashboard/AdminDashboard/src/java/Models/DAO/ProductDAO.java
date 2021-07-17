/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entity.Image;
import Models.Entity.Product;
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
public class ProductDAO {

    public Product product = new Product();

    public Connection con;

    public boolean b = false;

    public ArrayList<Product> listProducts;

    public ProductDAO() {
        listProducts = new ArrayList<>();
    }

    public ArrayList<Product> getAllProduct() {
        try {
            DBConnection db = new DBConnection();
            this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `product`");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setpID(rs.getInt("pID"));
                product.setcID(rs.getInt("cID"));
                product.setrID(rs.getInt("rID"));
                product.setpName(rs.getString("pName"));
                product.setpPrice((int) rs.getDouble("pPrice"));
                product.setpDescription(rs.getString(" pDescription "));
                listProducts.add(product);
            }

        } catch (SQLException e) {
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProducts;
    }

    public Product getProductById(int id) {
        Product product = null;
        try {
            DBConnection db = new DBConnection();
            this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `product` WHERE pID = ?");
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setpID(rs.getInt("pID"));
                product.setcID(rs.getInt("cID"));
                product.setrID(rs.getInt("rID"));
                product.setpName(rs.getString("pName"));
                product.setpPrice((int) rs.getDouble("pPrice"));
                product.setpDescription(rs.getString(" pDescription "));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    public boolean updateProduct(int id, int rID, int cID, String pName, String pDescription, int pPrice) {

        try {
            DBConnection db = new DBConnection();
            this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("UPDATE `product` SET `rID`=?,`cID`=?,`pName`=?,`pDescription`=?,`pPrice`=? WHERE `pID`=?");
            pst.setInt(1, rID);
            pst.setInt(2, cID);
            pst.setString(3, pName);
            pst.setString(4, pDescription);
            pst.setDouble(5, pPrice);
            pst.setInt(6, id);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean insertProduct(int rID, int cID, String pName, String pDescription, int pPrice, String image) {

        try {
            DBConnection db = new DBConnection();
            this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO `product`((SELECT p.rID, p.cID, p.pName, p.pDescription, p.pPrice, i.iURL FROM `product` as p INNER JOIN `image` as i on i.pID = p.pID) as tmp)VALUES (?,?,?,?,?,?)");
            pst.setInt(1, rID);
            pst.setInt(2, cID);
            pst.setString(3, pName);
            pst.setString(4, pDescription);
            pst.setDouble(5, pPrice);
            pst.setString(6, image);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }

        return false;
    }

    public ArrayList<Product> getAllProductByrID(int rID) {
        try {
            DBConnection db = new DBConnection();
            this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `product` WHERE `rID` = ?");
            pst.setInt(1, rID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setpID(rs.getInt("pID"));              
                product.setpName(rs.getString("pName"));
                product.setpPrice((int) rs.getDouble("pPrice"));
                product.setpDescription(rs.getString("pDescription"));
                product.setcID(rs.getInt("cID"));
                product.setrID(rs.getInt("rID"));
                listProducts.add(product);
            }

        } catch (SQLException e) {
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProducts;
    }

    public Image getImageBypID(int pID) {
        Image image = null;
        try {
            DBConnection db = new DBConnection();
            this.con = db.getConnect();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `image` WHERE pID = ? LIMIT 1");
            pst.setInt(1, pID);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                image = new Image();
                image.setiID(rs.getInt("iID"));
                image.setpID(rs.getInt("pID"));
                image.setiURL(rs.getString("iURL"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

}
