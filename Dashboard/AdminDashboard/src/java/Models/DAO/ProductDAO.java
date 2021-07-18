/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entity.Category;
import Models.Entity.GetProduct;
import Models.Entity.ShowProduct;
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
public class ProductDAO {

    public Connection con;
    ArrayList<ShowProduct> showProductList;
    ArrayList<GetProduct> getProductList;
    ArrayList<Category> categoryList;

    public ProductDAO() {
        DBConnection db = new DBConnection();
        this.con = db.getConnect();
    }

    public ArrayList<ShowProduct> showAllProduct(int rID) {
        showProductList = new ArrayList();
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT p.pID, p.pName, p.pPrice, p.pDescription, c.cName AS Category FROM `product` AS p INNER JOIN `category` AS c ON p.cID = c.cID WHERE p.rID = ?");
            pst.setInt(1, rID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ShowProduct showProduct = new ShowProduct();
                showProduct.setpID(rs.getInt("pID"));
                showProduct.setpName(rs.getString("pName"));
                showProduct.setCategory(rs.getString("Category"));
                showProduct.setPrice(rs.getInt("pPrice"));
                showProduct.setpDescription(rs.getString("pDescription"));

                showProductList.add(showProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return showProductList;
    }

    public GetProduct getProductById(int pID) {
        GetProduct getProduct = new GetProduct();
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT p.pID, p.pName, p.pPrice, p.pDescription, i.iURL, p.cID FROM `product` AS p INNER JOIN `image` AS i ON p.pID = i.pID WHERE p.pID= ?");
            pst.setInt(1, pID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                getProduct.setpID(rs.getInt("pID"));
                getProduct.setpName(rs.getString("pName"));
                getProduct.setCategory(rs.getInt("cID"));
                getProduct.setPrice(rs.getInt("pPrice"));
                getProduct.setpDescription(rs.getString("pDescription"));
                getProduct.setiURL(rs.getString("iURL"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getProduct;
    }

    public ArrayList<Category> getCategoryById() {
        categoryList = new ArrayList();
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT cID, cName FROM `category`");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setcID(rs.getInt("cID"));
                category.setcName(rs.getString("cName"));
                categoryList.add(category);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categoryList;
    }

    public boolean updateProduct(String pName, int pPrice, String pDescription, int cId, int pId, String image) {

        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("UPDATE `product` AS p INNER JOIN `image` AS i ON p.pID =i.pID SET p.pName=? ,p.pPrice= ?, p.pDescription=?, p.cID=?, i.iURL =? WHERE p.pID=?");
            pst.setString(1, pName);
            pst.setInt(2, pPrice);
            pst.setString(3, pDescription);
            pst.setInt(4, cId);
            pst.setString(5, image);
            pst.setInt(6, pId);

            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean updateProductNoImage(String pName, int pPrice, String pDescription, int cId, int pId) {

        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("UPDATE `product` SET pName=? ,pPrice= ?, pDescription=?, cID=? WHERE pID=?");
            pst.setString(1, pName);
            pst.setInt(2, pPrice);
            pst.setString(3, pDescription);
            pst.setInt(4, cId);
            pst.setInt(5, pId);

            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public int insertProduct(String pName, int pPrice, String pDescription, int cID, int rID) {
        int lastId = 0;
        try {
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement("INSERT INTO `product`(`pName`, `pPrice`, `pDescription`, `cID`, `rID`) VALUES (?,?,?,?,?)");
            pst1.setString(1, pName);
            pst1.setInt(2, pPrice);
            pst1.setString(3, pDescription);
            pst1.setInt(4, cID);
            pst1.setInt(5, rID);

            pst1.executeUpdate();

            PreparedStatement pst2 = (PreparedStatement) con.prepareStatement("SELECT MAX(`pID`) AS lastID FROM `product`");
            ResultSet rs2 = pst2.executeQuery();

            while (rs2.next()) {
                lastId = rs2.getInt("lastID");
            }
        } catch (Exception e) {
            System.out.println(e + "ERROR");
        }
        System.out.println("insert Product " + lastId);
        return lastId;
    }

    public boolean insertImage(int pId, String iURL) {

        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO `image`(`pID`, `iURL`) VALUES (?,?)");
            pst.setInt(1, pId);
            pst.setString(2, iURL);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }

        return false;
    }

}
