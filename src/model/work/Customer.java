/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.work;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Customer {
    private int number;
    private String name;
    private String email;
    private String phoneNumber;
    private Date firstOrderDate;
    private String shoppingCart;
    private String tag;
    
    private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    private ArrayList<Quotation> quotations = new ArrayList<Quotation>();
    
    public Customer(int number, String name, String email, String phoneNumber, Date firstOrderDate, String shoppingCart, String tag){
        this.number = number;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstOrderDate = firstOrderDate;
        this.shoppingCart = shoppingCart;
        this.tag = tag;
    }
    
    // getters and setters

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getFirstOrderDate() {
        return firstOrderDate;
    }

    public void setFirstOrderDate(Date firstOrderDate) {
        this.firstOrderDate = firstOrderDate;
    }

    public String getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(String shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
}
