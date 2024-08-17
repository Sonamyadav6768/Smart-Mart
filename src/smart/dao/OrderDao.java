/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jmart.dbutil.DBConnection;
import jmart.pojo.ProductPojo;
import jmart.pojo.UserProfile;

public class OrderDao {
    
    public static String getNextOrderId() throws SQLException 
    {
         Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(order_id) from orders");
        rs.next();
        String orderId=rs.getString(1);
        if(orderId==null)
            return "O-101";
        int num=Integer.parseInt(orderId.substring(2));
        return "O-"+(num+1);
    }
    
    public static boolean addOrder(ArrayList<ProductPojo> item,String orderId) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into orders values(?,?,?,?)");
        int row=0;
        for(ProductPojo p:item)
        {
            ps.setString(1, orderId);
            ps.setString(2, p.getProductId());
            ps.setInt(3, p.getQuantity());
            ps.setString(4, UserProfile.getUserId());
            row+=ps.executeUpdate();
        }
        return row==item.size();
    }
    
    public static ArrayList<String> getOrderIdList() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select distinct order_id from orders where userid=? order by order_id");
        ps.setString(1, UserProfile.getUserId());
        ArrayList<String> orderIdList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next())
            orderIdList.add(rs.getString(1));
        return orderIdList;
    }
    
    public static ArrayList<String> getOrderIdListFromManager() throws SQLException
    {
         Connection conn=DBConnection.getConnection();
         Statement st=conn.createStatement();
        ArrayList<String> orderIdList=new ArrayList<>();
        ResultSet rs=st.executeQuery("select distinct order_id from orders order by order_id");
        while(rs.next())
            orderIdList.add(rs.getString(1));
        return orderIdList;
    }
    
    public static Map<String,Integer> productFromOrder(String id) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select p_id , quantity from orders where order_id=? order by p_id");
        ps.setString(1, id);
        ResultSet rs=ps.executeQuery();
        Map<String,Integer> productDetail =new HashMap<String,Integer>();
        while(rs.next())
        {
            productDetail.put(rs.getString(1),rs.getInt(2));
        }
        return productDetail;
        
    }
    
}
