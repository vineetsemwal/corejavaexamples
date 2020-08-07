<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*"  %>

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

<!--expression below-->
<%= "hello in expression" %>

<br>

<!---Comment-->

Scriplet below
<br>
<%
for( int i=0; i<10;i++){
out.println("i="+i+" <br>");
}
%>

Another Scriplet below
<br>

<%

List<String> list=new ArrayList<>();
list.add("prakash");
list.add("praadeep");
list.add("anuj");
for(String name:list){
out.println(name+"<br>");
}

%>


</body>
</html>


