/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.work;

import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Invoice {
    private int number;
    private Date orderDate;
    private float totalPrice;
    
    public Invoice(int number, Date orderDate, float totalPrice){
        this.number = number;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }
    
    
    //gettters and setters

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
