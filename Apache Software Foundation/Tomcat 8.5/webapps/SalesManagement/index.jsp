<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        	<%@ page import="java.sql.*" %>
		<% Connection connection = db.DBConnection.createConnection();%>
    

<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="bootstrap/css/bootstrap.css" crossorigin="anonymous"/>
      <title>SalesManagement</title>
      <link rel="stylesheet" href="custom/custom.css"/>

   </head>
   <body>
 
 
      </div> <!--End of nav and parallax-->
      <div class='jumbotron'>
         <h1>Customer Viewable Inventory</h1>
         <div class='content'>

            <br/>
            
<br/>
<% Statement st = connection.createStatement(); %>
<% ResultSet result = st.executeQuery("select * from Product WHERE approved = 'Y'"); %>
<table class="table table-hover">
    <thead>
      <tr style='background-color: grey; color: white;'>
      	<th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
      </tr>
    </thead>
    <tbody>
    <%while(result.next()){ %>
      <tr>
      	<td><%=result.getString(1) %></td>
        <td><%=result.getString(2) %></td>
      	<td><%=result.getString(4) %></td>
        <td><%=result.getString(5) %></td>
      	
	<%} %>
      </tr>
      
    </tbody>
  </table>
         </div>


         </div>
      </div>

      <script src="jQuery/jquery-3.2.1.js" crossorigin="anonymous"></script>
      <script src="custom/custom.js"></script>
    <script src="bootstrap/js/bootstrap.js" crossorigin="anonymous"></script>
 

   </body>
</html>