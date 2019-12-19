/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aliim
 */
public class Database {
    
    public void closeStatementAndResultSet(Statement statement,ResultSet resultSet){
        try {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
    }
    
    public void closeConnection(Connection con){
        try {
            
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
    }
    
    
    public Connection setConnection(Connection con){
        
        try {
            String connectionUrl = "jdbc:sqlserver://localhost;databaseName=SalesManagement;integratedSecurity=true";
            try {
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionUrl);
            } catch (ClassNotFoundException cnfex) {
                return null;
            } catch (SQLException ex) {
                return null;
            }
            return con;
        }catch(Exception e){
            return null;
        }
            
    }
    
    public void getAllProducts(ArrayList<Product> List,Connection con){
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            
            int id, quantity;
            String name, approved;
            double cost, price;
            
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM Product");
                
                while (resultSet.next()) {
                    id = resultSet.getInt("ID");
                    name = resultSet.getString("ProductName");
                    quantity = resultSet.getInt("Stock");
                    cost = resultSet.getDouble("Price");
                    price = resultSet.getDouble("SalePrice");
                    approved = resultSet.getString("Approved");
                    List.add(new Product(id, name, price, cost, quantity, approved));
                }
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }
    
     public void getAllPerson(ArrayList<Person> List,Connection con){
         try {
             Statement statement = null;
             ResultSet resultSet = null;
             String id;
             String address;
             String name, approved;
             String paymentMethod, mobile;
             try {

                if(con==null)
                    con = setConnection(con);
                 statement = con.createStatement();
                 resultSet = statement.executeQuery("SELECT * FROM Person");
                 
                 while (resultSet.next()) {
                     id = resultSet.getString("PID");
                     name = resultSet.getString("Name");
                     address = resultSet.getString("Address");
                     paymentMethod = resultSet.getString("Payment Method");
                     mobile = resultSet.getString("Mobile");
                     approved = resultSet.getString("Approved");
                     List.add(new Person(id, name, address, mobile, paymentMethod, approved));
                 }
             }
             catch (Exception e) {
             } finally {
                closeStatementAndResultSet(statement, resultSet);
             }
         } catch (Exception e) {
         }
    }
    
    public String getProductNames(Connection con) {
	try {
            Statement statement = null;
            ResultSet resultSet = null;
            String values = "";
            
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM Product where Approved = 'Y'");
                
                while (resultSet.next()) {
                    if ("".equals(values)) {
                        values = resultSet.getString("ProductName");
                    } else {
                        values = values + "," + resultSet.getString("ProductName");
                    }                    
                }
                
            }
            catch (Exception e) {
                return "";
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            return values;
        } catch (Exception e) {
            return "";
        }
    }

        public boolean checkPersonExistance(String text,Connection con) {
            try {
                Statement statement = null;
                ResultSet resultSet = null;
                boolean present = false;
                try {
                    if(con==null)
                        con = setConnection(con);
                    statement = con.createStatement();
                    resultSet = statement.executeQuery("SELECT Mobile FROM Person");
                    
                    while (resultSet.next() && !present) {
                        if (text.equals(resultSet.getString("Mobile"))) {
                            present = true;
                        }
                    }
                    
                } 
                catch (Exception e) {
                    return false;
                } finally {
                closeStatementAndResultSet(statement, resultSet);
                }
                
                return present;
            } catch (Exception e) {
                return false;
            }
        }
        
        public boolean checkPersonApproved(String text,Connection con) {
            try {
                Statement statement = null;
                ResultSet resultSet = null;
                boolean present = false;
                try {
                    if(con==null)
                        con = setConnection(con);
                    statement = con.createStatement();
                    resultSet = statement.executeQuery("SELECT Mobile FROM Person where Approved = 'Y'");
                    
                    while (resultSet.next() && !present) {
                        if (text.equals(resultSet.getString("Mobile"))) {
                            present = true;
                        }
                    }
                    
                } 
                catch (Exception e) {
                    return false;
                } finally {
                closeStatementAndResultSet(statement, resultSet);
                }
                
                return present;
            } catch (Exception e) {
                return false;
            }
        }

    public String getPersonID(String text,Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            String present = "";
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM Person");
                
                while (resultSet.next()) {
                    if (text.equals(resultSet.getString("Mobile"))) {
                        present = resultSet.getString("ID");
                    }
                }
                
            }
            catch (Exception e) {
                return "";
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            
            return present;
        } catch (Exception e) {
            return "";
        }
    }
    
    
    public String receivePersonID(Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            String values = "";
            
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM Person where Approved = 'Y' and PID != 'A1'");
                
                while (resultSet.next()) {
                    if ("".equals(values)) {
                        values = resultSet.getString("PID");
                    } else {
                        values = values + "," + resultSet.getString("PID");
                    }                    
                }
                return values;
            } 
            catch (Exception e) {
                return "";
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
            return "";
        }
    }

    public int Submit(DefaultTableModel Model, String ID, String discount, String total,Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            boolean exit = true;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet=statement.executeQuery("Select * from OrderDetails");
                int j=1;
                for(j=1;resultSet.next() && exit;++j){
                    if(j!=resultSet.getInt("OrderID"))
                        exit=false;
                }
                if(!exit)
                    j--;
                statement.executeUpdate("Insert into OrderDetails Values (" + Integer.toString(j) + "," + ID + "," + total + "," + discount +",CONVERT (date, SYSDATETIME()))");
                for (int i = 0; i < Model.getRowCount(); ++i) {
                        statement.executeUpdate("Insert into Orders Values (" + Integer.toString(j) + "," + getProductID((String) Model.getValueAt(i, 1),con) + "," + (String) Model.getValueAt(i, 2) + ")");
                        updateStock(getProductID((String) Model.getValueAt(i, 1),con),(String) Model.getValueAt(i, 2),con);
                    }
                return j;
            }
            catch (Exception e) {
                return 0;
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
                return 0;
        }
     }

    public boolean addNewPerson(String string, String text, String text0, String text1,ArrayList<Person> P,String text2,Connection con) {
        try {
            Statement statement = null;        
            ResultSet resultSet = null;
                try {
                    if(con==null)
                        con = setConnection(con);
                    statement = con.createStatement();
                    if ("Yes".equals(text2)) {
                        resultSet = statement.executeQuery("Select ID from Member order by cast(substring(ID,2,LEN(ID)) as Int) ");
                        int j = 1;
                        boolean stop1 = true;
                        for (j = 1; resultSet.next() && stop1; ++j) {
                            if (Integer.parseInt(resultSet.getString(1).substring(1)) != j) {
                                stop1 = false;
                                j--;
                            }
                        }
                        P.add(new Person("S" + Integer.toString(j), text, text1, text0, string, "N"));
                        statement.execute("Insert into Person values('S" + Integer.toString(j) + "','" + text + "','" + text1 + "','" + text0 + "','" + string + "', 'N');");
                        statement.execute("Insert into Member values('S" + Integer.toString(j) + "'," + Integer.toString(j) + ", 0)");
                    } else {
                        resultSet = statement.executeQuery("Select PID from Person where PID Like 'C%' order by cast(substring(PID,2,LEN(PID)) as Int) ");
                        int i = 1;
                        boolean stop = true;
                        for (i = 1; resultSet.next() && stop; ++i) {
                            String x = resultSet.getString(1).substring(1);
                            if (Integer.parseInt(resultSet.getString(1).substring(1)) != i) {
                                stop = false;
                                i--;
                            }
                        }
                        P.add(new Person("C" + Integer.toString(i), text, text1, text0, string, "N"));
                        statement.execute("Insert into Person values('C" + Integer.toString(i) + "','" + text + "','" + text1 + "','" + text0 + "','" + string + "', 'N');");
                    }
                    
                    return true;
                } 
                catch (Exception e) {
                    return false;
                } finally {
                    closeStatementAndResultSet(statement, resultSet);
                }
        } catch (Exception e) {
            return false;
        }
    }

    boolean checkUsernameAndPassword(String text, String text0, Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            boolean notfound=true;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT Employee.ID,Employee.Username,Employee.Password FROM Employee join Person on Employee.ID=Person.PID where person.Approved='Y'");    
                while (resultSet.next() && notfound) {
                    if (text.equals(resultSet.getString("Username")) && text0.equals(resultSet.getString("Password"))) {
                        NoteOrders.Employee = resultSet.getString("ID");
                        notfound = false;
                    }
                }
                
            } 
            catch (Exception e) {
                return false;
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            
            return !notfound;
        } catch (Exception e) {
            return false;
        }
    
    }
    
    boolean checkCorrectPerson(String text,String text1, Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            boolean notfound=true;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM Employee");
                while (resultSet.next() && notfound) {
                    if (NoteOrders.Employee.equals(resultSet.getString("ID")) && text.equals(resultSet.getString("Username")) && text1.equals(resultSet.getString("Password"))) {
                        notfound = false;
                    }
                }
                
            } 
            catch (Exception e) {
                return false;
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            
            return !notfound;
        } catch (Exception e) {
            return false;
        }
    }

    void changePassword(String valueOf,Connection con) { 
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                statement.executeUpdate("update [Employee] set [Password]='"+valueOf+"' where [ID] ='"+NoteOrders.Employee+"'");

            } 
            catch (Exception e) {
                
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
            
        }
    }
    
    public void setOrderTables(DefaultTableModel Model,DefaultTableModel Model1,String text,Connection con){
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            Model.setRowCount(0);
            Model1.setRowCount(0);
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                if(!"".equals(text)){
                    resultSet = statement.executeQuery("select O.*,P.ProductName,P.SalePrice from Orders O join Product P on O.ProductID=P.ID join OrderDetails OD on OD.OrderID=O.OrderID join Person Pr on Pr.PID = OD.CustID where Pr.Mobile = '"+text+"'");
                    while (resultSet.next()) {
                        Object[] row = {resultSet.getString("OrderID"),resultSet.getString("ProductID"),resultSet.getString("ProductName"),resultSet.getString("QuantityOrdered"),resultSet.getString("SalePrice")};
                        Model.addRow(row);
                    }
                    resultSet = statement.executeQuery("select OD.*,Pr.Mobile from OrderDetails OD left join Person Pr on Pr.PID = OD.CustID where Pr.Mobile = '"+text+"'");
                    while (resultSet.next()) {
                        Object[] row = {resultSet.getString("OrderID"),resultSet.getString("Mobile"),resultSet.getString("TotalCost"),resultSet.getString("Discount")};
                        Model1.addRow(row);
                    }
                }
                else{
                    resultSet = statement.executeQuery("select O.*,P.ProductName,P.SalePrice from Orders O join Product P on O.ProductID=P.ID join OrderDetails OD on OD.OrderID=O.OrderID");
                    while (resultSet.next()) {
                        Object[] row = {resultSet.getString("OrderID"),resultSet.getString("ProductID"),resultSet.getString("ProductName"),resultSet.getString("QuantityOrdered"),resultSet.getString("SalePrice")};
                        Model.addRow(row);
                    }
                    resultSet = statement.executeQuery("select OD.*,Pr.Mobile from OrderDetails OD left join Person Pr on Pr.PID = OD.CustID");
                    while (resultSet.next()) {
                        Object[] row = {resultSet.getString("OrderID"),resultSet.getString("Mobile"),resultSet.getString("TotalCost"),resultSet.getString("Discount")};
                        Model1.addRow(row);
                        
                    }
                }
                
            }
            catch (Exception e) {
                
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }

    boolean deleteOrder1(String text, Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            boolean exists = false;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet =statement.executeQuery("Select * from Orders where OrderID = "+text);
                while(resultSet.next()){
                    exists=true;
                }
                statement.executeUpdate("delete from Orders where OrderID = "+text);
                statement.executeUpdate("delete from OrderDetails where OrderID = "+text);

            }
            catch (Exception e) {
                
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            return exists;
        } catch (Exception e) {
            return false;
        }
    }

    boolean PersonApproval(String text, Connection con) {
       try {
            Statement statement = null;
            ResultSet resultSet = null;
            boolean exists = false;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet =statement.executeQuery("Select * from Person where Approved = 'N' and PID = '"+text+"'");
                while(resultSet.next()){
                    exists=true;
                }
                statement.executeUpdate("update Person set Approved = 'Y' where PID ='"+text+"'"); 
            }
            catch (Exception e) {
                
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            return exists;
        } catch (Exception e) {
            return false;
        }
    }

    boolean ProductApproval(String text, Connection con) { 
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            boolean exists = false;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet =statement.executeQuery("Select * from Product where Approved = 'N' and ID = "+text);
                while(resultSet.next()){
                    exists=true;
                }
                statement.executeUpdate("update Product set Approved = 'Y' where ID ="+text); 
            }
            catch (Exception e) {
                
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            return exists;
        } catch (Exception e) {
            return false;
        }
    }

    void deletePerson(String text, Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                statement.executeUpdate("delete from Person where  PID!='A1' and Approved = 'N' and PID = '"+text+"'");

            }
            catch (Exception e) {
                
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            } catch (Exception e) {
        }
    }

    void deleteProduct(String text, Connection con) {
     try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                statement.executeUpdate("delete from Product where Approved = 'N' and ID = "+text);

            } 
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            } catch (Exception e) {
        }  
    }
    
    boolean deleteProduct1(String text, Connection con) {
     try {
            Statement statement = null;
            ResultSet resultSet = null;
            boolean exists = false;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet =  statement.executeQuery("Select * from Product where ProductName = '"+text+"'");
                String id = resultSet.getString("ID");
                if(resultSet.next()){
                    if(resultSet.getString("ProductName").equals(text)){
                        exists=true;
                        statement.executeUpdate("delete from Product where ProductName = '"+text+"'");
                    }
                    return exists;
                }
                else return false;
            } 
            catch (Exception e) {
                return false;
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            } catch (Exception e) {
                return false;
        }
    }
    
    boolean deletePerson1(String text, Connection con) {
     try {
            Statement statement = null;
            ResultSet resultSet = null;
            boolean exists = false;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet =  statement.executeQuery("Select * from Person where PID!='A1' and PID = '"+text+"'");
                if(resultSet.next()){
                    if(resultSet.getString("PID").equals(text)){
                        exists=true;
                        if(text.substring(0,1).equals("S"))
                            statement.executeUpdate("delete from Member where ID!='A1' and ID = '"+text+"'");
                        if(text.substring(0,1).equals("E") || text.substring(0,1).equals("M"))
                            statement.executeUpdate("delete from Employee where ID!='A1' and ID = '"+text+"'");
                        statement.executeUpdate("delete from Person where PID!='A1' and PID = '"+text+"'");
                    return exists;
                    
                    }
                    return false;
                }
                return false;
            } 
            catch (Exception e) {
                return false;
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            } catch (Exception e) {
                return false;
        }
    }

    void PersonList(DefaultTableModel Model,Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            Model.setRowCount(0);
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet = statement.executeQuery("select * from Person where Approved='N'");
                while (resultSet.next()) {
                    Object[] row = {resultSet.getString("PID"),resultSet.getString("Mobile"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getString("Payment Method")};
                    Model.addRow(row);
                }
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }

    void ProductList(DefaultTableModel Model,Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            Model.setRowCount(0);
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet = statement.executeQuery("select * from Product where Approved='N'");
                while (resultSet.next()) {
                    Object[] row = {resultSet.getString("ID"),resultSet.getString("ProductName"),resultSet.getString("Price"),resultSet.getString("SalePrice"),resultSet.getString("Stock")};
                    Model.addRow(row);
                }
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }

    void EditPerson(String ID,String Name,String Address,String Mobile, String Payment,String Salary,String points, Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                statement.executeUpdate("update Person set Name='"+Name+"',Mobile='"+Mobile+"',[Payment Method]='"+Payment+"',Address='"+Address+"' where PID='"+ID+"'");
                if("E".equals(ID.substring(0,1)) ||"M".equals(ID.substring(0,1))){                    
                    statement.executeUpdate("update Employee set Salary="+Salary+" where ID='"+ID+"'");
                }
                else if("S".equals(ID.substring(0,1)))
                    statement.executeUpdate("update Member set Point="+points+" where ID='"+ID+"'");
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }
    
    
    void EditProduct(String text,String text0, String text1, String text2, Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                statement.executeUpdate("update Product set Price="+text0+",SalePrice="+text+",Stock="+text1+" where ProductName='"+text2+"'");
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }
    
    void loadProduct(String string, JTextField jTextField15, JTextField jTextField150,JTextField jTextField151, Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet=statement.executeQuery("Select * From Product where ProductName='"+string+"'");
                if(resultSet.next()){
                    jTextField150.setText(Integer.toString(resultSet.getInt("Price")));
                    jTextField15.setText(Integer.toString(resultSet.getInt("SalePrice")));
                    jTextField151.setText(Integer.toString(resultSet.getInt("Stock")));
                }
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }
    
    void loadPerson(String ID,JTextField CardID,JTextField Name, JTextField Mobile, JTextField Address,JComboBox<String> Payment,JTextField Salary,JSpinner Points, Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                if("E".equals(ID.substring(0,1)) || "M".equals(ID.substring(0,1)))
                    resultSet=statement.executeQuery("Select * From Person join Employee on Person.PID=Employee.ID where Person.PID='"+ID+"'");
                else if("C".equals(ID.substring(0,1)))
                    resultSet=statement.executeQuery("Select * From Person where Person.PID='"+ID+"'");
                 else if("S".equals(ID.substring(0,1)))
                    resultSet=statement.executeQuery("Select * From Person join Member on Person.PID=Member.ID where Person.PID='"+ID+"'");
                if(resultSet.next()){
                    Name.setText(resultSet.getString("Name"));
                    Mobile.setText(resultSet.getString("Mobile"));
                    Address.setText(resultSet.getString("Address"));
                    String x =resultSet.getString("Payment Method");
                    Payment.setSelectedItem(resultSet.getString("Payment Method"));
                    if("S".equals(ID.substring(0,1))){
                        Points.setValue(resultSet.getInt("Point"));
                        CardID.setText(resultSet.getString("CardID"));
                    }
                    else{
                        Points.setValue((int)0);
                        CardID.setText("");
                    }
                    if("M".equals(ID.substring(0,1)) || "E".equals(ID.substring(0,1)))
                        Salary.setText(resultSet.getString("Salary"));
                    else
                        Salary.setText("");
                }
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }
        
    boolean addproduct(String text1,String text2,String text3,String text4, Connection con) { 
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            boolean exists = false;
            boolean match=true;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet =statement.executeQuery("Select * from Product where ProductName='"+text1+"'");
                while(resultSet.next()){
                    exists=true;
                }
                if(!exists){
                    resultSet =statement.executeQuery("Select * from Product order by ID");
                    int i=1;
                    for(i=1;resultSet.next() && match;++i){
                        if(resultSet.getInt("ID")!=i)
                            match=false;
                    }
                    if(!match)
                        i--;
                    statement.executeUpdate("insert into [Product] values("+Integer.toString(i)+",'"+text1+"',"+text2+","+text3+","+text4+",'N')"); 
                }
                return exists;
            }
            catch (Exception e) {
                System.out.print(e);
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            return exists;
        } catch (Exception e) {
            return false;
        }
    }


    void getPersonDetails(JLabel jLabel23, JLabel jLabel18, JLabel jLabel22, JLabel jLabel25, JLabel jLabel24, Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet=statement.executeQuery("Select * From Person join Employee on Person.PID=Employee.ID where Person.PID='"+NoteOrders.Employee+"'"); 
                if(resultSet.next()){
                    jLabel23.setText(resultSet.getString("Name"));
                    jLabel18.setText(resultSet.getString("Mobile"));
                    jLabel22.setText(resultSet.getString("Address"));
                    jLabel25.setText(resultSet.getString("Salary"));
                    if("A".equals(NoteOrders.Employee.substring(0,1)))
                        jLabel24.setText("Administrator");
                    else if("E".equals(NoteOrders.Employee.substring(0,1)))
                        jLabel24.setText("Sales Person");
                    else if("M".equals(NoteOrders.Employee.substring(0,1)))
                        jLabel24.setText("Manager");
                }
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }

    boolean checkProductInStock(String quantity,String product,Connection con) {
    try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet=statement.executeQuery("Select * From Product where ProductName='"+product+"'");
                if(resultSet.next()){
                    if(Integer.parseInt(quantity)<=resultSet.getInt("Stock"))
                        return true;
                    else
                        return false;
                }else
                    return false;
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
            return false;
        }
        return false;   
    }
    
    double getSalePrice(String prod, Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            double SalePrice =0; 
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet=statement.executeQuery("Select * From Product where ProductName='"+prod+"'");
                if(resultSet.next()){
                    SalePrice = resultSet.getDouble("SalePrice");
                    return SalePrice;
                }else return 0;
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

    boolean addEmployee1(String text, String text0, String text1, String text2, String string, String string0, Connection con) {
        try {
            Statement statement = null;        
            ResultSet resultSet = null;
                try {
                    if(con==null)
                        con = setConnection(con);
                    statement = con.createStatement();
                        if("Sales Person".equals(string0)){
                            resultSet = statement.executeQuery("Select ID from Employee where ID Like 'E%' order by cast(substring(ID,2,LEN(ID)) as Int) ");
                            int i = 1;
                            boolean stop = true;
                            for (i = 1; resultSet.next() && stop; ++i) {
                                String x = resultSet.getString(1).substring(1);
                                if (Integer.parseInt(resultSet.getString(1).substring(1)) != i) {
                                    stop = false;
                                    i--;
                                }
                            }
                            statement.execute("Insert into Person values('E" + Integer.toString(i) + "','" + text + "','" + text1 + "','" + text0 + "','" + string + "', 'N');");
                            statement.execute("Insert into Employee values('E" + Integer.toString(i) + "','" + text2 + "','" + text0 + "','123456')");
                        }else if("Manager".equals(string0)){
                            resultSet = statement.executeQuery("Select ID from Employee where ID Like 'M%' order by cast(substring(ID,2,LEN(ID)) as Int) ");
                            int i = 1;
                            boolean stop = true;
                            for (i = 1; resultSet.next() && stop; ++i) {
                                String x = resultSet.getString(1).substring(1);
                                if (Integer.parseInt(resultSet.getString(1).substring(1)) != i) {
                                    stop = false;
                                    i--;
                                }
                            }
                            statement.execute("Insert into Person values('M" + Integer.toString(i) + "','" + text + "','" + text1 + "','" + text0 + "','" + string + "', 'N');");                            
                            statement.execute("Insert into Employee values('M" + Integer.toString(i) + "','" + text2 + "','" + text0 + "','123456')");
                        }
                        return true;
                }
                catch (Exception e) {
                    return false;
                } finally {
                    closeStatementAndResultSet(statement, resultSet);
                }
        } catch (Exception e) {
            return false;
        }
    }

    private String getProductID(String string,Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM Product where ProductName= '"+string+"'");
                if(resultSet.next())
                    return resultSet.getString("ID");
                else return "";
                
            }
            catch (Exception e) {
                return "";
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
            
        } catch (Exception e) {
            return "";
        }
    }

    private void updateStock(String productID, String string, Connection con) {
       try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                statement.executeUpdate("update Product set Stock = Stock - "+string+" where ID="+productID);
              
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }

    boolean checkProductExistance(String text, Connection con) {
        try {
                Statement statement = null;
                ResultSet resultSet = null;
                boolean present = false;
                try {
                    if(con==null)
                        con = setConnection(con);
                    statement = con.createStatement();
                    resultSet = statement.executeQuery("SELECT ProductName FROM Product");
                    
                    while (resultSet.next() && !present) {
                        if (text.equals(resultSet.getString("ProductName"))) {
                            present = true;
                        }
                    }
                    
                } 
                catch (Exception e) {
                    return false;
                } finally {
                closeStatementAndResultSet(statement, resultSet);
                }
                
                return present;
            } catch (Exception e) {
                return false;
            }
    }

    void viewSalesSummary(DefaultTableModel Model,Connection con) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                if(con==null)
                    con = setConnection(con);
                statement = con.createStatement();
                resultSet=statement.executeQuery("select SUM(O.QuantityOrdered) Quantity,SUM(O.QuantityOrdered*P.Price) TotalCost,SUM(OD.TotalCost) TotalSale,SUM(OD.TotalCost-OD.Discount) AfterDiscount, SUM(OD.TotalCost-OD.Discount) -SUM(O.QuantityOrdered*P.Price) Profit,Month(OD.date) MonthBefore,Year(OD.date)  YearBefore,Month(DateAdd(month,1,OD.date)) MonthAfter,Year(DateAdd(month,1,OD.date)) After from OrderDetails OD join Orders O on O.OrderID=OD.OrderID join Product P on P.ID=O.ProductID where OD.date<GETDATE() Group by Month(GETDATE()-OD.date) ,OD.date Order By Month(GETDATE()-OD.date)");
                for(int i=1;resultSet.next();i++){
                    Object[] row = {Integer.toString(i),resultSet.getString("Quantity"),resultSet.getString("TotalCost"),resultSet.getString("TotalSale"),resultSet.getString("AfterDiscount"),resultSet.getString("Profit"),"1/"+resultSet.getString("MonthBefore")+"/"+resultSet.getString("YearBefore"),"1/"+resultSet.getString("MonthAfter")+"/"+resultSet.getString("After")};
                    Model.addRow(row);
                }
            }
            catch (Exception e) {
            } finally {
                closeStatementAndResultSet(statement, resultSet);
            }
        } catch (Exception e) {
        }
    }
    
}
