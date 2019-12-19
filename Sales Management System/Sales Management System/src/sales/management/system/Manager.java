/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.management.system;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static sales.management.system.NoteOrders.db;

/**
 *
 * @author aliim
 */
public class Manager extends Employee {
    

    Manager(JLabel jLabel23, JLabel jLabel18, JLabel jLabel22, JLabel jLabel25, JLabel jLabel24) {
        super(jLabel23,jLabel18,jLabel22,jLabel25,jLabel24);
        try {
            db.getPersonDetails(jLabel23,jLabel18,jLabel22,jLabel25,jLabel24,NoteOrders.con);
        } catch (Exception e) {
        } 
    }
    
    void showPersonApprovalList(JTable table){
        try {
            DefaultTableModel Model = (DefaultTableModel) table.getModel();
            NoteOrders.db.PersonList(Model, NoteOrders.con);
        } catch (Exception e) {
        }
    
    }
    void showProductApprovalList(JTable table){
        try {
            DefaultTableModel Model = (DefaultTableModel) table.getModel();
            NoteOrders.db.ProductList(Model, NoteOrders.con);
        } catch (Exception e) {
        }
    
    }
    boolean approvePerson(String text) {
        try {
            return NoteOrders.db.PersonApproval(text, NoteOrders.con);
        } catch (Exception e) {
            return false;
        }
    }

    boolean approveProduct(String text) {
        try {
            return NoteOrders.db.ProductApproval(text, NoteOrders.con);
        } catch (Exception e) {
            return false;
        }
    }

    void disapprovePerson(String text) {
        try {
            NoteOrders.db.deletePerson(text, NoteOrders.con);
        } catch (Exception e) {
        }
     }

    void disapproveProduct(String text) {
        try {
            NoteOrders.db.deleteProduct(text, NoteOrders.con);
        } catch (Exception e) {
        }
    }
    
     @Override
    void viewSaleDetails(JTable order_t, JTable order_detail_t,String text) {
        try {
            DefaultTableModel Model = (DefaultTableModel) order_t.getModel();
            DefaultTableModel Model1 = (DefaultTableModel) order_detail_t.getModel();
            db.setOrderTables(Model, Model1, text, NoteOrders.con);
        } catch (Exception e) {
        }
    }
    
}
