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
public class Quotation {
    private int number;
    private Date orderDate;
    
    public Quotation(int number, Date orderDate){
        this.number = number;
        this.orderDate = orderDate;
    }
    
    //getters and setters

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
}
