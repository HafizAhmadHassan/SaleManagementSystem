/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.management.system;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static sales.management.system.NoteOrders.db;

/**
 *
 * @author aliim
 */
public class Admin extends Employee {


    Admin(JLabel jLabel23, JLabel jLabel18, JLabel jLabel22, JLabel jLabel25, JLabel jLabel24) {
        super(jLabel23,jLabel18,jLabel22,jLabel25,jLabel24); 
        try {
            db.getPersonDetails(jLabel23,jLabel18,jLabel22,jLabel25,jLabel24,con);
            ProductList = new ArrayList<>();
            PersonList = new ArrayList<>();
            db.getAllPerson(PersonList, con);
            db.getAllProducts(ProductList, con);
        } catch (Exception e) {
        }
    }
    
    public void getProductList(Database db){
        try {
            db.getAllProducts(ProductList,con);
        } catch (Exception e) {
        }
    }
    
    public void getAllPerson(Database db){
        try {
            db.getAllPerson(PersonList,con);
        } catch (Exception e) {
        }
    }
    
    public boolean addPerson(Database db,JTextField textField5,JTextField textField6,JTextField textField7,JComboBox<String> jComboBox2,JComboBox<String> jComboBox3)
    {
        try {
            if (!"Select".equals((String) jComboBox3.getSelectedItem()) && !"Select".equals((String) jComboBox2.getSelectedItem()) && !textField5.getText().isEmpty() && !textField6.getText().isEmpty() ) {
                if (db.addNewPerson((String) jComboBox2.getSelectedItem(), textField5.getText(), textField6.getText(), textField7.getText(), PersonList, (String) jComboBox3.getSelectedItem(),con)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
                return false;
        }
    }
    
    

    public ArrayList<Product> getProductList() {
        try {
            return ProductList;
        } catch (Exception e) {
            return null;
        }
    }

    public void setProductList(ArrayList<Product> ProductList) {
        try {
            this.ProductList = ProductList;
        } catch (Exception e) {
        }
    }

    public ArrayList<Person> getPersonList() {
        try {
            return PersonList;
        } catch (Exception e) {
            return null;
        }
    }

    public void setPersonList(ArrayList<Person> PersonList) {
        try {
            this.PersonList = PersonList;
        } catch (Exception e) {
        }
    }
    
    @Override
    void viewSaleDetails(JTable order_t, JTable order_detail_t,String text) {
        try {
            DefaultTableModel Model = (DefaultTableModel) order_t.getModel();
            DefaultTableModel Model1 = (DefaultTableModel) order_detail_t.getModel();
            db.setOrderTables(Model, Model1, text, con);
        } catch (Exception e) {
        }
    }
    
    boolean addProduct1(String text0,String text1,String text2,String text3){
        try {
            return db.addproduct(text0, text1, text2, text3, con);
        } catch (Exception e) {
            return true;
        }
    }
    
    boolean deleteOrder(String text) {
        try {
            return db.deleteOrder1(text, con);
        } catch (Exception e) {
            return false;
        }
    }
    
    void searchPerson(String string, JTextField jTextField7, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JComboBox<String> jComboBox11, JTextField jTextField8, JSpinner jSpinner1) {
        try {
            db.loadPerson(string, jTextField7, jTextField1, jTextField2, jTextField3, jComboBox11, jTextField8, jSpinner1, con);
            
        } catch (Exception e) {
        }
}
    
    
    boolean deletePerson(String string) {
        try {
            return db.deletePerson1(string, con);
            
        } catch (Exception e) {
            return false;
        }
}
    
    
    boolean addEmployee(String text, String text0, String text1, String text2, String string, String string0) {
        try {
            return db.addEmployee1(text, text0, text1, text2, string, string0, con);
        } catch (Exception e) {
            return false;
        }
 }

    
    boolean deleteProductAvailaible(String text){
        try {
            return NoteOrders.db.deleteProduct1(text, NoteOrders.con);
        } catch (Exception e) {
            return false;
        }
    }
    
    private ArrayList<Product> ProductList;
    private ArrayList<Person> PersonList;
    private Connection con = null;    


}
