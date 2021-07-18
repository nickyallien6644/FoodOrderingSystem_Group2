/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entity.OrderMonth;
import Models.Entity.OrderMostBranch;
import Models.Entity.OrderMostDay;
import Models.Entity.OrderShow;
import Models.Entity.OrderWeek;
import Models.Entity.OrderYear;
import Models.Entity.ShowProduct;
import Models.Entity.TotalRevenue;
import Models.Entity.GetProduct;
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
public class OrderDAO {

    public Connection con;
    ArrayList<OrderMostDay> orderMostDayList;
    ArrayList<OrderMostDay> orderMostYesterdayList;
    ArrayList<OrderWeek> orderWeekList;
    ArrayList<OrderMonth> orderMonthList;
    ArrayList<OrderYear> orderYearList;
    ArrayList<OrderMostBranch> orderMostBranchList;
    ArrayList<TotalRevenue> totalRevenueList;
    ArrayList<OrderShow> orderShowList;
   

    public OrderDAO() {
        DBConnection db = new DBConnection();
        this.con = db.getConnect();
    }

    public int[] countAllOrder() throws SQLException {

        int count[] = {0, 0};
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT `oStatus` FROM `order`");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int oStatus = rs.getInt("oStatus");
                if (oStatus == 1) {
                    count[0] += 1;
                } else if (oStatus == 0) {
                    count[1] += 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public ArrayList<OrderMostDay> getMostDay(int rID) {
        try {
            orderMostDayList = new ArrayList();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT p.pID, p.pName, p.pPrice, i.iURL FROM `order` AS o INNER JOIN `orderdetail` AS od on o.oID = od.oID INNER JOIN `product` AS p on p.pID = od.pID INNER JOIN `image` AS i ON i.pID = p.pID WHERE o.oStatus = 1 AND o.oDateCreate = CURDATE() AND p.rID = " + rID + " GROUP BY p.pID ORDER BY SUM(od.oQuantity) DESC LIMIT 3");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OrderMostDay orderMostDay = new OrderMostDay();
                orderMostDay.setpId(rs.getInt("pID"));
                orderMostDay.setpName(rs.getString("pName"));
                orderMostDay.setpPrice(rs.getDouble("pPrice"));
                orderMostDay.setImage(rs.getString("iURL"));

                orderMostDayList.add(orderMostDay);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderMostDayList;
    }

    public ArrayList<OrderMostDay> getMostYesterDay() {
        try {
            orderMostYesterdayList = new ArrayList();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT p.pID, p.pName, p.pPrice, i.iURL FROM `order` AS o INNER JOIN `orderdetail` AS od on o.oID = od.oID INNER JOIN `product` AS p on p.pID = od.pID INNER JOIN `image` AS i ON i.pID = p.pID WHERE o.oStatus = 1 AND o.oDateCreate <= CURDATE() GROUP BY p.pID ORDER BY SUM(od.oQuantity) DESC LIMIT 3");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OrderMostDay orderMostDay = new OrderMostDay();
                orderMostDay.setpId(rs.getInt("pID"));
                orderMostDay.setpName(rs.getString("pName"));
                orderMostDay.setpPrice(rs.getDouble("pPrice"));
                orderMostDay.setImage(rs.getString("iURL"));

                orderMostYesterdayList.add(orderMostDay);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderMostYesterdayList;
    }

    public ArrayList<OrderWeek> getOrderWeek(int day) {
        try {
            orderWeekList = new ArrayList();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT DATE_SUB( CURDATE(), INTERVAL " + day + " DAY ) AS oDateCreate, COUNT(oID) FROM `order` WHERE oDateCreate = DATE_SUB( CURDATE(), INTERVAL " + day + " DAY )");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OrderWeek orderWeek = new OrderWeek();
                orderWeek.setCount(rs.getInt("COUNT(oID)"));
                orderWeek.setDayOfWeek(rs.getDate("oDateCreate"));

                orderWeekList.add(orderWeek);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orderWeekList;
    }

    public ArrayList<OrderMonth> getOrderMonth(int month, int nextMonth) {
        try {
            orderMonthList = new ArrayList();
            PreparedStatement pst = null;
            if (month != 0) {
                pst = (PreparedStatement) con.prepareStatement("SELECT DATE_SUB( CURDATE(), INTERVAL " + month + " MONTH ) AS month, COUNT(oID) FROM `order` WHERE oDateCreate < DATE_SUB( CURDATE(), INTERVAL " + nextMonth + " MONTH ) AND oDateCreate >= DATE_SUB( CURDATE(), INTERVAL " + month + " MONTH )");
            } else if (month == 0) {
                pst = (PreparedStatement) con.prepareStatement("SELECT DATE_SUB( CURDATE(), INTERVAL " + month + " MONTH ) AS month, COUNT(oID) FROM `order` WHERE oDateCreate >= DATE_SUB( CURDATE(), INTERVAL " + month + " MONTH )");
            }

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OrderMonth orderMonth = new OrderMonth();
                orderMonth.setCount(rs.getInt("COUNT(oID)"));
                orderMonth.setMonth(rs.getDate("month"));

                orderMonthList.add(orderMonth);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orderMonthList;
    }

    public ArrayList<OrderYear> getOrderYear(int year, int nextYear) {
        try {
            orderYearList = new ArrayList();
            PreparedStatement pst = null;
            if (year != 0) {
                pst = (PreparedStatement) con.prepareStatement("SELECT DATE_SUB( CURDATE(), INTERVAL " + year + " YEAR ) AS year, COUNT(oID) FROM `order` WHERE oDateCreate >= DATE_SUB( CURDATE(), INTERVAL " + year + " YEAR ) AND oDateCreate < DATE_SUB( CURDATE(), INTERVAL " + nextYear + " YEAR )");
            } else if (year == 0) {
                pst = (PreparedStatement) con.prepareStatement("SELECT DATE_SUB( CURDATE(), INTERVAL " + year + " YEAR ) AS year, COUNT(oID) FROM `order` WHERE oDateCreate >= DATE_SUB( CURDATE(), INTERVAL " + year + " YEAR )");
            }

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OrderYear orderYear = new OrderYear();
                orderYear.setCount(rs.getInt("COUNT(oID)"));
                orderYear.setYear(rs.getDate("year"));

                orderYearList.add(orderYear);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orderYearList;
    }

    public ArrayList<OrderMostBranch> getOrderBranchDay() {
        try {
            orderMostBranchList = new ArrayList();
            PreparedStatement pst = null;
            pst = (PreparedStatement) con.prepareStatement("SELECT r.rName, r.rAddress, (100* od.oQuantity / SUM(od.oQuantity) OVER()) AS Percentage FROM `order` AS o INNER JOIN `orderdetail` AS od on o.oID = od.oID INNER JOIN `product` AS p on p.pID = od.pID INNER JOIN `restaurant` AS r ON r.rID = o.rID WHERE o.oStatus = 1 AND o.oDateCreate = CURDATE() GROUP BY p.pID ORDER BY SUM(od.oQuantity) DESC LIMIT 3");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OrderMostBranch orderMostBranch = new OrderMostBranch();
                orderMostBranch.setrName(rs.getString("rName"));
                orderMostBranch.setrAddress(rs.getString("rAddress"));
                orderMostBranch.setPercentage(rs.getDouble("Percentage"));

                orderMostBranchList.add(orderMostBranch);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orderMostBranchList;
    }

    public ArrayList<OrderMostBranch> getOrderBranchYesterDay() {
        try {
            orderMostBranchList = new ArrayList();
            PreparedStatement pst = null;
            pst = (PreparedStatement) con.prepareStatement("SELECT r.rName, r.rAddress, (100* od.oQuantity / SUM(od.oQuantity) OVER()) AS Percentage FROM `order` AS o INNER JOIN `orderdetail` AS od on o.oID = od.oID INNER JOIN `product` AS p on p.pID = od.pID INNER JOIN `restaurant` AS r ON r.rID = o.rID WHERE o.oStatus = 1 AND o.oDateCreate < CURDATE() GROUP BY p.pID ORDER BY SUM(od.oQuantity) DESC LIMIT 3");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OrderMostBranch orderMostBranch = new OrderMostBranch();
                orderMostBranch.setrName(rs.getString("rName"));
                orderMostBranch.setrAddress(rs.getString("rAddress"));
                orderMostBranch.setPercentage(rs.getDouble("Percentage"));

                orderMostBranchList.add(orderMostBranch);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orderMostBranchList;
    }

    public TotalRevenue getTotalRevenue() {
        TotalRevenue totalRevenue = new TotalRevenue();
        try {

            totalRevenueList = new ArrayList();

            /*
            DAY-------------------------
             */
            PreparedStatement pst1 = null, pstDay = null;

            pst1 = (PreparedStatement) con.prepareStatement("SELECT SUM(oAmountTotal) AS TotalSales FROM `order`WHERE oDateCreate = CURDATE() GROUP BY oDateCreate ORDER BY oDateCreate");
            ResultSet rs1 = pst1.executeQuery();
            while (rs1.next()) {
                totalRevenue.setPriceDay(rs1.getInt("TotalSales"));
            }

            pstDay = (PreparedStatement) con.prepareStatement("SELECT DAY(CURDATE()) AS SalesDay");
            ResultSet rs1Day = pstDay.executeQuery();
            while (rs1Day.next()) {
                totalRevenue.setDay(rs1Day.getString("SalesDay"));
            }

            /*
            MONTH-------------------------
             */
            PreparedStatement pst2 = null, pst2Month = null;
            pst2 = (PreparedStatement) con.prepareStatement("SELECT SUM(oAmountTotal) AS TotalSales FROM `order`WHERE MONTH(oDateCreate) = MONTH(CURDATE()) AND YEAR(oDateCreate) = YEAR(CURDATE()) GROUP BY MONTH(oDateCreate) ORDER BY MONTH(oDateCreate)");

            ResultSet rs2 = pst2.executeQuery();

            while (rs2.next()) {
                totalRevenue.setPriceMonth(rs2.getInt("TotalSales"));
            }

            pst2Month = (PreparedStatement) con.prepareStatement("SELECT MONTH(CURDATE()) AS SalesMonth");

            ResultSet rs2Month = pst2Month.executeQuery();

            while (rs2Month.next()) {
                totalRevenue.setMonth(rs2Month.getString("SalesMonth"));
            }

            /*
            YEAR-------------------------
             */
            PreparedStatement pst3 = null, pst3Year = null;
            pst3 = (PreparedStatement) con.prepareStatement("SELECT SUM(oAmountTotal) AS TotalSales FROM `order`WHERE YEAR(oDateCreate) = YEAR(CURDATE()) GROUP BY YEAR(oDateCreate) ORDER BY YEAR(oDateCreate)");
            ResultSet rs3 = pst3.executeQuery();
            while (rs3.next()) {
                totalRevenue.setPriceYear(rs3.getInt("TotalSales"));
            }

            pst3Year = (PreparedStatement) con.prepareStatement("SELECT YEAR(CURDATE()) AS SalesYear");
            ResultSet rs3Year = pst3Year.executeQuery();
            while (rs3Year.next()) {
                totalRevenue.setYear(rs3Year.getString("SalesYear"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return totalRevenue;
    }

    public ArrayList<OrderShow> showAllOrder(int rID) {
        orderShowList = new ArrayList();
        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT o.oID, a.aFirstname, a.aPhone, a.aAddress, o.oAmountTotal, o.oDateCreate, o.oStatus FROM `order` AS o INNER JOIN `account` AS a ON o.aID = a.aID WHERE o.rID = ?");
            pst.setInt(1, rID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OrderShow orderShow = new OrderShow();
                orderShow.setoID(rs.getInt("oID"));
                orderShow.setaFirstname(rs.getString("aFirstname"));
                orderShow.setaPhone(rs.getString("aPhone"));
                orderShow.setaAddress(rs.getString("aAddress"));
                orderShow.setoAmountTotal(rs.getInt("oAmountTotal"));
                orderShow.setoDateCreate(rs.getDate("oDateCreate"));
                orderShow.setoStatus(rs.getInt("oStatus"));

                orderShowList.add(orderShow);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderShowList;
    }

    public boolean updateStatusOrder(int oID, int oStatus) {

        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("UPDATE `order` SET `oStatus`= ? WHERE `oID`= ?");
            pst.setInt(1, oStatus);
            pst.setInt(2, oID);

            return pst.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }


}
