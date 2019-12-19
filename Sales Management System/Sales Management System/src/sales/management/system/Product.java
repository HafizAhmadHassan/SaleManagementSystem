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
public class Product {

   public Product searchProduct(String name){
       try {
           return (this.ProductName.equals(name)) ? this : null;
       } catch (Exception e) {
            return null;
       }
   }
    
    public boolean matchProduct(String Name){
        try {
            return (this.ProductName.equals(Name)) ? true : false;
        } catch (Exception e) {
            return false;
        }
    }

    public Product(int ID, String ProductName, double SalePrice, double CostPrice, int inStock, String Approved) {
        try {
            this.ID = ID;
            this.ProductName = ProductName;
            this.SalePrice = SalePrice;
            this.CostPrice = CostPrice;
            this.inStock = inStock;
            this.Approved = Approved;
        } catch (Exception e) {
        }
    }
    
    
    public int getID() {
        try {
            return ID;
        } catch (Exception e) {
            return 0;
        }
    }

    public void setID(int ID) {
        try {
            this.ID = ID;
        } catch (Exception e) {
        }
    }

    public String getProductName() {
        try {
            return ProductName;
        } catch (Exception e) {
            return "";
        }
    }

    public void setProductName(String ProductName) {
        try {
            this.ProductName = ProductName;
        } catch (Exception e) {
        }
    }

    public double getSalePrice() {
        try {
            return SalePrice;
        } catch (Exception e) {
            return 0;
        }
    }

    public void setSalePrice(double SalePrice) {
        try {
            this.SalePrice = SalePrice;
        } catch (Exception e) {
        }
    }

    public double getCostPrice() {
        try {
            return CostPrice;
        } catch (Exception e) {
            return 0;
        }
    }

    public void setCostPrice(double CostPrice) {
        try {
            this.CostPrice = CostPrice;
        } catch (Exception e) {
        }
    }

    public int getInStock() {
        try {
            return inStock;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getApproved() {
        try {
            return Approved;
        } catch (Exception e) {
            return "";
        }
    }

    public void setApproved(String Approved) {
        try {
            this.Approved = Approved;
        } catch (Exception e) {
        }
    }

    public void setInStock(int inStock) {
        try {
            this.inStock = inStock;
        } catch (Exception e) {
        }
    }
    
    private int ID;
    private String ProductName;
    private double SalePrice;
    private double CostPrice;
    private int inStock;
    private String Approved;
}
