package Models.DAO;




import Models.Entity.User;
import java.sql.*;
import java.util.ArrayList;
import Models.utilize.SHA;


/**
 *
 * @author tú
 */
public class UserDAO extends DBConnection{

    /**
     *
     */
    public User bean = new User();

    /**
     *
     */
    public Connection con;

    /**
     *
     */
    public boolean b = false;
  
    /**
     *
     */
    public UserDAO() {
        DBConnection db = new DBConnection();
        this.con = db.getConnect();  
    }
    
    private boolean search(String aEmail) {

        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM `account` WHERE `aEmail` = ? ");
            pst.setString(1, aEmail);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                b = true;
            } else {
                b = false;
            }
              closeConnection();
        } catch (SQLException ex) {
           
            ex.printStackTrace();
        }

        return b;
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User signIn(String aEmail, String password) {

        User userSinIn = new User();
        userSinIn = null ;
        try {
            if (search(aEmail)) {
//                con = db.getConnect();
                String sql = "SELECT * FROM `account` WHERE `aEmail`=? AND `aPassword`=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, aEmail);
                pst.setString(2, SHA.encrypt(password));
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    userSinIn = new User(
                    rs.getInt("aID"),rs.getInt("roleID"),rs.getString("aEmail"),rs.getString("aPassword"),rs.getDouble("aCoins"),rs.getString("aFirstname"),rs.getString("aLastname"),rs.getString("aPhone"),rs.getString("aAddress"),rs.getString("aStatus"));
                    System.out.println("tú tú ");
                    System.out.println(userSinIn);
                }
                
                System.out.println(userSinIn);
                return userSinIn;
            }
               closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("tú tú 111");
        return null;
    }
    
}
