package jmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jmart.dbutil.DBConnection;
import jmart.pojo.ProductPojo;
import jmart.pojo.UserProfile;

public class ProductDao {
    public static String getProductId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(p_id) from products");
        rs.next();
        String productId=rs.getString(1);
        if(productId==null)
            return "P101";
        int num=Integer.parseInt(productId.substring(1));
        return "P"+(num+1);
    }
    
    public static boolean addProduct(ProductPojo p) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into products values(?,?,?,?,?,?,?,'Y')");
        ps.setString(1, p.getProductId());
        ps.setString(2, p.getProductName());
        ps.setString(3, p.getProductCompanyName());
        ps.setDouble(4, p.getProductPrice());
        ps.setDouble(5, p.getOurPrice());
        ps.setInt(6, p.getProductTax());
        ps.setInt(7, p.getQuantity());
        return ps.executeUpdate()==1;
    }
    
    public static List<ProductPojo> getProductDetails()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from products where status='Y'");
        List<ProductPojo> productList=new ArrayList<>();
        while(rs.next())
        {
            ProductPojo p=new ProductPojo();
            p.setProductId(rs.getString(1));
            p.setProductName(rs.getString(2));
            p.setProductCompanyName(rs.getString(3));
            p.setProductPrice(rs.getDouble(4));
            p.setOurPrice(rs.getDouble(5));
            p.setProductTax(rs.getInt(6));
            p.setQuantity(rs.getInt(7));
            productList.add(p);
        }
        return productList;
    }
    
    public static boolean deleteProduct(String productId) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update products set status='N'where p_id=?");
        ps.setString(1, productId);
        return ps.executeUpdate()==1;
    }
    
    public static boolean updateProduct(ProductPojo p) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update products set p_name=?,p_companyname=?,p_price=?,our_price=?,p_tax=?,quantity=? where p_id=? ");
        ps.setString(1, p.getProductName());
        ps.setString(2, p.getProductCompanyName());
        ps.setDouble(3, p.getProductPrice());
        ps.setDouble(4, p.getOurPrice());
        ps.setInt(5, p.getProductTax());
        ps.setInt(6, p.getQuantity());
        ps.setString(7,p.getProductId());
        return ps.executeUpdate()==1;
    }
    
    public static ProductPojo getProductDetails(String productId) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from products where p_id=? and status='Y'");
        ps.setString(1, productId);
        ResultSet rs=ps.executeQuery();
        ProductPojo p=new ProductPojo();
        if(rs.next()==true)
        {
            p.setProductId(rs.getString(1));
            p.setProductName(rs.getString(2));  
            p.setProductCompanyName(rs.getString(3));
            p.setProductPrice(rs.getDouble(4));
            p.setOurPrice(rs.getDouble(5));
            p.setProductTax(rs.getInt(6));
            p.setQuantity(rs.getInt(7));
        }
        return p;
    }
    public static boolean updateStock(List<ProductPojo> productList ) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update products set quantity=quantity-? where p_id=?");
        int x=0;
        for(ProductPojo p:productList)
        {
            String id=p.getProductId();
            int q=p.getQuantity();
            ps.setInt(1, q);
            ps.setString(2, id);
            int row=ps.executeUpdate();
            if(row==1)
                x++;
        }
        return x==productList.size();
    }
    public static List<ProductPojo> getProductFromOrder(Map<String,Integer> mp) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from products where p_id=? order by p_id");
        List<ProductPojo> al=new ArrayList<>();
        for(Map.Entry<String,Integer> e:mp.entrySet())
        {
            ps.setString(1, e.getKey());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                ProductPojo p=new ProductPojo();
                p.setProductId(rs.getString(1));
                p.setProductName(rs.getString(2));
                p.setProductCompanyName(rs.getString(3));
                p.setProductPrice(rs.getDouble(4));
                p.setOurPrice(rs.getDouble(5));
                p.setProductTax(rs.getInt(6));
                p.setQuantity(e.getValue());
                double amt=rs.getDouble(5);
                amt=amt+(amt*rs.getInt(6)/100);
                p.setTotal(amt*e.getValue());
                al.add(p);
            }
        }
        return al;
    }
}
