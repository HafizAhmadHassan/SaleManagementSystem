/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.management.system;

import java.util.Vector;
public class InvoiceData {
    private int invoiceId;
    private double discount;
    private Vector<InvoiceItem> items;
    
    public InvoiceData (int id) {
        try {
            invoiceId = id;
            items = new Vector<InvoiceItem>();
            discount = 0;
        } catch (Exception e) {
        }
    }

    
    public int getInvoiceId()
    {
        try {
            return invoiceId;
        } catch (Exception e) {
            return 0;
        }
    }
    public double getDiscount() {
        try {
            return discount;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public void setDiscount(double disc)
    {
        try {
            discount = disc;
        } catch (Exception e) {
        }
    }
    
    public Vector<InvoiceItem> getVector()
    {
        try {
            return items;
        } catch (Exception e) {
            return null;
        }
    }
    public void addItem(int id, String name, double unitPrice, int quantity)
    {
        try {
            InvoiceItem temp = new InvoiceItem(id, name, unitPrice, quantity);
            items.add(temp);
        } catch (Exception e) {
        }
    }
    
    public void removeItem(int id)
    {
        try {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getId() == id) {
                    items.removeElementAt(i);
                    break;
                }
            }
        } catch (Exception e) {
        }
    }
    
    public double getTotal()
    {
        try {
            double total = 0;
            for (int i = 0; i < items.size(); i++) {
                total += items.get(i).getSubtotal();
            }
            total = total - discount;
            return total;
        } catch (Exception e) {
            return 0;
        }
    }
    
}
