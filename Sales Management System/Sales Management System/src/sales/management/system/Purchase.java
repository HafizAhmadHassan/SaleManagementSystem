/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.management.system;

/**
 *
 * @author aliim
 */
public class Purchase {

    public Purchase(String Date, String time, int quantityOrdered, int ProductID, String PersonID) {
        try {
            this.Date = Date;
            this.time = time;
            this.quantityOrdered = quantityOrdered;
            this.ProductID = ProductID;
            this.PersonID = PersonID;
        } catch (Exception e) {
        }
    }

    public String getDate() {
        try {
            return Date;
        } catch (Exception e) {
            return "";
        }
    }

    public void setDate(String Date) {
        try {
            this.Date = Date;
        } catch (Exception e) {
        }
    }

    public String getTime() {
        try {
            return time;
        } catch (Exception e) {
            return "";
        }
    }

    public void setTime(String time) {
        try {
            this.time = time;
        } catch (Exception e) {
        }
    }

    public int getQuantityOrdered() {
        try {
            return quantityOrdered;
        } catch (Exception e) {
            return 0;
        }
    }

    public void setQuantityOrdered(int quantityOrdered) {
        try {
            this.quantityOrdered = quantityOrdered;
        } catch (Exception e) {
        }
    }

    public int getProductID() {
        try {
            return ProductID;
        } catch (Exception e) {
            return 0;
        }
    }

    public void setProductID(int ProductID) {
        try {
            this.ProductID = ProductID;
        } catch (Exception e) {
        }
    }

    public String getPersonID() {
        try {
            return PersonID;
        } catch (Exception e) {
            return "";
        }
    }

    public void setPersonID(String PersonID) {
        try {
            this.PersonID = PersonID;
        } catch (Exception e) {
        }
    }
    
    private String Date;
    private String time;
    private int quantityOrdered;
    private int ProductID;
    private String PersonID;
    
}
