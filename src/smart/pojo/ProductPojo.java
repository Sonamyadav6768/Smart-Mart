/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmart.pojo;

public class ProductPojo {

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ProductPojo() {
    }

    public ProductPojo(String productId, String productName, String productCompanyName, double productPrice, double ourPrice, int productTax, int quantity,int total) {
        this.productId = productId;
        this.productName = productName;
        this.productCompanyName = productCompanyName;
        this.productPrice = productPrice;
        this.ourPrice = ourPrice;
        this.productTax = productTax;
        this.quantity = quantity;
        this.total=total;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCompanyName() {
        return productCompanyName;
    }

    public void setProductCompanyName(String productCompanyName) {
        this.productCompanyName = productCompanyName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public int getProductTax() {
        return productTax;
    }

    public void setProductTax(int productTax) {
        this.productTax = productTax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private String productId;
    private String productName;
    private String productCompanyName;
    private double productPrice;
    private double ourPrice;
    private int productTax;
    private int quantity;
    private double total;
}
