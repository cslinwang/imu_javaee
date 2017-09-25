<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<%@page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>ddd</title>
<% 
  Context ctx=new InitialContext();
  DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dstest");
  Connection conn=ds.getConnection();
  Statement stmt=conn.createStatement();
  ResultSet rs=stmt.executeQuery("select * from news_inf");
  while(rs.next())
  {
    out.println(rs.getString(1)+"\t"+rs.getString(2)+"<br/>");
  }
%>
</head>
<body>

</body>
</html>