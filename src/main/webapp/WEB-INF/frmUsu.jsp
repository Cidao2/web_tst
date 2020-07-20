<%@page import="br.com.cidao.web_tst.persistencia.entitade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Usuarios</title>

<script type="text/javascript">
	function novo() {
		location.href="usuctrl.do?ac=cad";
	}
</script>
</head>
<body>
	<%@include file="menu.jsp"%>
	<%
	/**
	*** 
	*** 
	*/
	Usuario ub = (Usuario) request.getAttribute("ub");
	%>

	<form action="usuctrl.do" method="post">
		<fieldset>
			<legend>Cadastrar Usuário</legend>
			<br>Id    :	<input type="number" name="id"    value="<%=ub.getId()%>">
			<br>Nome  :	<input type="text"   name="nome"  value="<%=ub.getNome()%>"> 
			<br>Login :	<input type="text"   name="login" value="<%=ub.getLogin()%>"> 
			<br>Senha :	<input type="text"   name="senha" value="<%=ub.getSenha()%>">
			<br>		<input type="submit" value="Salvar">
			<input type="button" onclick="javascript:novo()" value="Novo">
		</fieldset>
	</form>
</body>
</html>