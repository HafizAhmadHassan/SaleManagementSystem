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
public class Person {

    public Person(){}
    
    public Person(String ID, String Name, String Address, String Mobile, String PaymentMethod,String Approved) {
        try {
            this.ID = ID;
            this.Name = Name;
            this.Address = Address;
            this.Mobile = Mobile;
            this.PaymentMethod = PaymentMethod;
            this.Approved = Approved;
        } catch (Exception e) {
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

    public String getID() {
        try {
            return ID;
        } catch (Exception e) {
            return "";
        }
    }

    public void setID(String ID) {
        try {
            this.ID = ID;
        } catch (Exception e) {
        }
    }

    public String getName() {
        try {
            return Name;
        } catch (Exception e) {
            return "";
        }
    }

    public void setName(String Name) {
        try {
            this.Name = Name;
        } catch (Exception e) {
        }
    }

    public String getAddress() {
        try {
            return Address;
        } catch (Exception e) {
            return "";
        }
    }

    public void setAddress(String Address) {
        try {
            this.Address = Address;
        } catch (Exception e) {
        }
    }

    public String getMobile() {
        try {
            return Mobile;
        } catch (Exception e) {
            return "";
        }
    }

    public void setMobile(String Mobile) {
        try {
            this.Mobile = Mobile;
        } catch (Exception e) {
        }
    }

    public String getPaymentMethod() {
        try {
            return PaymentMethod;
        } catch (Exception e) {
            return "";
        }
    }

    public void setPaymentMethod(String PaymentMethod) {
        try {
            this.PaymentMethod = PaymentMethod;
        } catch (Exception e) {
        }
    }
    
    public boolean matchPerson(Person R){
        try{
            if(this==R)
                return true;
            else 
                return false;
        }catch(Exception e){return false;}
    }
    
    private String ID;
    private String Name;
    private String Address;
    private String Mobile;
    private String PaymentMethod;
    private String Approved;
}
