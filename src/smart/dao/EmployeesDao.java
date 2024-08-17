
package jmart.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jmart.dbutil.DBConnection;
import jmart.pojo.EmployeePojo;

public class EmployeesDao {
    public static String getEmpId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(empid) from employees");
        rs.next();
        String id=rs.getString(1);
        int num=Integer.parseInt(id.substring(1));
        return "E"+(num+1);
    }
    
    public static List<String> fetchAllEmployeeId() throws SQLException 
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select empid from employees order by empid");
        List<String> empIdList=new ArrayList<String>();
        while(rs.next())
            empIdList.add(rs.getString(1));
        return empIdList;
    }
    public static EmployeePojo getEmployeefromEmpId(String id) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from employees where empid=?");
        ps.setString(1, id);
        ResultSet rs=ps.executeQuery();
        EmployeePojo emp=null;
        if(rs.next())
        {
            emp=new EmployeePojo();
            emp.setEmpId(id);
            emp.setEmpName(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setSalary(rs.getDouble(4));
        }
        return emp;
    }
    
    public static boolean updateEmployee(EmployeePojo emp) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update employees set empname=?,job=?,salary=? where empid=?");
        ps.setString(1, emp.getEmpName());
        ps.setString(2, emp.getJob());
        ps.setDouble(3, emp.getSalary());
        ps.setString(4, emp.getEmpId());
        int row=ps.executeUpdate();
        if(row==0)
            return false;
        if(UserDao.isUserPresent(emp.getEmpId())==false)
            return true;
        ps=conn.prepareStatement("update users set username=?,usertype=? where empid=?");
        ps.setString(1,emp.getEmpName());
        ps.setString(2, emp.getJob());
        ps.setString(3,emp.getEmpId());
        row=ps.executeUpdate();
        return row==1;
            
    }
    
    public static boolean addEmployee(EmployeePojo emp) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareCall("insert into employees values(?,?,?,?)");
        ps.setString(1, emp.getEmpId());
        ps.setString(2, emp.getEmpName());
        ps.setString(3, emp.getJob());
        ps.setDouble(4, emp.getSalary());
        
        int row=ps.executeUpdate();
        return row==1;
    }
    
    public static List<EmployeePojo> getAllEmployee() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from employees order by empid");
        List<EmployeePojo> empList=new ArrayList<EmployeePojo>();
        while(rs.next())
        {
            EmployeePojo emp=new EmployeePojo();
            emp.setEmpId(rs.getString(1));
            emp.setEmpName(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setSalary(rs.getDouble(4));
            empList.add(emp);
        }
        return empList;
    }
    
    public static boolean deleteEmployee(String empid) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from employees where empid=?");
        ps.setString(1, empid);
        int row=ps.executeUpdate();
        if(row==0)
            return false;
        if(UserDao.isUserPresent(empid)==false)
            return true;
        ps=conn.prepareStatement("delete from users where empid=?");
        ps.setString(1, empid);
        row=ps.executeUpdate();
        return row==1;  
    }
}
