<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>First JSP</title>
</head>
<body>
<h1> Our First jsp </h1>

<div>
 How are you?
</div>

<%
for( int i=0; i<10;i++){
out.println("i="+i+" <br>");
}
%>
</body>
</html>


