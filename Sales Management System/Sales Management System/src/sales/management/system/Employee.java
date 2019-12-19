/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.management.system;

import java.awt.TextField;
import java.sql.Connection;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static sales.management.system.NoteOrders.db;


/**
 *
 * @author aliim
 */
public class Employee extends Person{

    public Employee() {
        super();
    }
    
    Employee(JLabel jLabel23, JLabel jLabel18, JLabel jLabel22, JLabel jLabel25, JLabel jLabel24) {
        super(db.getPersonID(jLabel18.getText(), NoteOrders.con),jLabel23.getText(),jLabel22.getText(),jLabel18.getText(),"","Y");
        try {
            db.getPersonDetails(jLabel23,jLabel18,jLabel22,jLabel25,jLabel24,con);
        } catch (Exception e) {
        }
    }

    public void attachConnection(Connection con){
        try {
            this.con = con;
        } catch (Exception e) {
        }
    }
    
    public Connection getCon() {
        try {
            return con;
        } catch (Exception e) {
            return null;
        }
    }

    public void setCon(Connection con) {
        try {
            this.con = con;
        } catch (Exception e) {
        }
    }
    
    
    public void changePassword1(JPasswordField jPasswordField3){
        try {
            db.changePassword(String.valueOf(jPasswordField3.getPassword()), con);
        } catch (Exception e) {
        }
    }
    
    public boolean addProductInTable(JTable table,JComboBox<String> product,JTextField quantity,int count,TextField textField5,TextField textField8,TextField textField7,JPanel jPanel3){
        try {
            DefaultTableModel Model = (DefaultTableModel) table.getModel();
            String prod = (String) product.getSelectedItem();
            boolean notduplicate = true;
            double saleprice=0;
            for (int k = 0; k < Model.getRowCount() && notduplicate; ++k) {
                if (Model.getValueAt(k, 1).equals(prod)) {
                    notduplicate = false;
                }
            }
            if (notduplicate) {
                    if (db.checkProductInStock(quantity.getText(),prod,con) && Integer.parseInt(quantity.getText()) > 0) {
                        if (!"Select".equals(prod)) {
                            saleprice= db.getSalePrice(prod,con);
                            Object[] row = {count, prod, quantity.getText(), Double.toString((Double.parseDouble(quantity.getText()) * saleprice))};
                            Model.addRow(row);
                            textField8.setText(Double.toString(Double.parseDouble(textField8.getText()) + (Double.parseDouble(quantity.getText()) * saleprice)));
                            textField5.setText(Double.toString(Double.parseDouble(textField8.getText()) - Double.parseDouble(textField7.getText())));
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Please Select the appropriate Product.", "Error", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    } else {
                        if(Integer.parseInt(quantity.getText()) <= 0)
                             JOptionPane.showMessageDialog(null, "Quantity 0 cannot be entered.", "Error", JOptionPane.ERROR_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "Quantity of Product: "+prod+" greater than the amount in stock cannot be entered.", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
            } else {
                JOptionPane.showMessageDialog(null, "Duplicate entries are not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
    void printReceipt(DefaultTableModel Model, String text, int Billno) {
        try {
            InvoiceData inv = new InvoiceData(Billno);
            for (int i = 0; i < Model.getRowCount(); ++i) {
                double price=(Double.parseDouble((String) Model.getValueAt(i, 3))/Double.parseDouble((String) Model.getValueAt(i, 2)));
                inv.addItem(i + 1, (String) Model.getValueAt(i, 1), price, Integer.parseInt((String) Model.getValueAt(i, 2)));
            }            
            inv.setDiscount(Integer.parseInt(text));
            try {
                new ReportCreator().createPdf(inv);
            } catch (Exception e) {
            }
        } catch (NumberFormatException numberFormatException) {
        }
    }
    void showSalesDetailsFromStart(DefaultTableModel Model) {
       db.viewSalesSummary(Model, con);
    }
    
    void viewSaleDetails(JTable order_t, JTable order_detail_t,String text){}
    
    private Connection con = null;
    private double Salary;
    private String Username;
    private String Password;

}
