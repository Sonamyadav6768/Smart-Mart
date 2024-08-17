
package jmart.dao;

import java.sql.*;
import java.util.*;
import jmart.dbutil.DBConnection;
import jmart.pojo.ReceptionistPojo;
import jmart.pojo.UserPojo;

public class ReceptionistDao {
    public static Map<String,String> getNonReceptionist()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select empid,empname from employees where job='Receptionist' and empid not in(Select empid from users where usertype='Receptionist')");
        Map<String,String> receptionistList=new HashMap<String,String>();
        while(rs.next())
        {
            receptionistList.put(rs.getString(1),rs.getString(2));
        }
        return receptionistList;
    }
    
    public static boolean addReceptionist(UserPojo user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?,?,?)");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getEmpId());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getUserType());
        ps.setString(5, user.getUserName());
        int row=ps.executeUpdate();
        return row==1;
    }
    
    public static List<ReceptionistPojo> getAllReceptionist() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select users.empid,empname,userid,job,salary from users,employees where usertype='Receptionist' and users.empid=employees.empid");
        List<ReceptionistPojo> receptionistList=new ArrayList<>();
        while(rs.next())
        {
            ReceptionistPojo rp=new ReceptionistPojo();
            rp.setEmpId(rs.getString(1));
            rp.setEmpName(rs.getString(2));
            rp.setUserId(rs.getString(3));
            rp.setJob(rs.getString(4));
            rp.setSalary(rs.getDouble(5));
            receptionistList.add(rp);
        }
        return receptionistList;
    }
    
    public static Map<String,String> getUserReceptionist() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select userid,username from users where usertype='Receptionist' order by userid");
        Map<String,String> receptionistList=new HashMap<>();
        while(rs.next())
        {
            receptionistList.put(rs.getString(1),rs.getString(2));
        }
        return receptionistList;
    }
    
    public static boolean updatePassword(String userid,String password) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update users set password=? where userid=?");
        ps.setString(1, password);
        ps.setString(2, userid);
        int row=ps.executeUpdate();
        return row==1;
    }
    
    public static List<String> getReceptionistId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select userid from users where usertype='Receptionist' order by userid");
        List<String> receptionistIdList=new ArrayList<>();
        while(rs.next())
            receptionistIdList.add(rs.getString(1));
        return receptionistIdList;
    }
    
    public static boolean deleteReceptionist(String userid) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from users where userid=?");
        ps.setString(1, userid);
        return ps.executeUpdate()==1;
    }
}
