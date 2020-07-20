<%@page import="br.com.cidao.web_tst.persistencia.entitade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bem Vindo</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	<%
	Usuario usuAut = (Usuario)request.getSession().getAttribute("usuAut");
	%>

	<br>
	<br>Seja bem vindo !!!
	<br>
	<br>Nome1 : <%=((Usuario)request.getSession().getAttribute("usuAut")).getNome() %>
	<br>Nome2 : <%=usuAut.getNome()%>
	<br>
	<br>Login : <%=usuAut.getLogin() %>
</body>
</html>