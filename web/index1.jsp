<%-- 
    Document   : index
    Created on : Feb 13, 2019, 3:32:06 PM
    Author     : Djole
--%>
<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        
        <%  Konekcija kon=new Konekcija();
        
        String query="select * from korisnik";
        
        ResultSet rs;
        rs=kon.query(query);
        
        while(rs.next()){
            %>
            <h1>Ime;<%=rs.getString(2)%>Prezime:<%=rs.getString(3)%>  </h1>
        <% } %>
        <div style="width:300px;height: 400px; background-color: cadetblue;">
        <%
        ResultSet rs2;
        String kveri2="select * from korisnik where username='Korinik'";   
        rs2=kon.query(kveri2);
        String poruka="Korisnik";  String poruka1="login ne valja";
        if(rs2.next()==true){   //ako nema
        %>
         <%=poruka%>
        
        <% }else{    //ako ima%>  
        
        <%=poruka1%>
        <% } %>
        
</div>
        
    </body>
</html>
