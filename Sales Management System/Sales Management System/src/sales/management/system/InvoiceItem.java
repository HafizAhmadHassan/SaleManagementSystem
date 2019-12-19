/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.management.system;

/**
 *
 * @author Ans
 */
public class InvoiceItem {
    private int id;
    private double unitPrice;
    private int quantity;
    private String name;

    public InvoiceItem(int id, String name, double unitPrice, int quantity) {
        try {
            this.id = id;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
            this.name = name;
        } catch (Exception e) {
        }
    }

    public int getId()
    {
        try {
            return id;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public double getUnitPrice() {
        try {
            return unitPrice;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getQuantity() {
        try {
            return quantity;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getName() {
        try {
            return name;
        } catch (Exception e) {
            return "";
        }
    }
    
    public double getSubtotal()
    {
        try {
            return unitPrice * quantity;
        } catch (Exception e) {
            return 0;
        }
    }
    
}
