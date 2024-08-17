
package jmart.dao;

import java.sql.*;
import javax.swing.JOptionPane;
import jmart.dbutil.DBConnection;
import jmart.pojo.UserPojo;
import jmart.pojo.UserProfile;

public class UserDao {
    public static boolean validateUser(UserPojo user) throws SQLException 
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select*from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3,user.getUserType() );
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            UserProfile.setUserName(rs.getString(5));
            return true;
        }
        return false;
    }
    
    public static boolean isUserPresent(String empid) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select 1 from users where empid=?");
        ps.setString(1, empid);
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
}
