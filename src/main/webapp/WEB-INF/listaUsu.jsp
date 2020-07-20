<%@page import="br.com.cidao.web_tst.persistencia.entitade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Usuarios</title>
<script type="text/javascript">
	function confirmaExclusao(id){
		if(window.confirm("Tem certeza que deseja excluir o Registro:"+id)){
			location.href="usuctrl.do?ac=excl&id="+id;
		}
	}
	function novo() {
		location.href="usuctrl.do?ac=cad";
	}
</script>
</head>
<body>
	<%@include file="menu.jsp" %> <a href="usuctrl.do?ac=cad">Novo Usuário</a>
	
	<%
	/**
	*** exclusao sem o java script
	*** <a href="usuctrl.do?ac=excl&id=<#=u.getId()#>"> Excluir</a>
	*/
	List<Usuario> lx = (List<Usuario>)request.getAttribute("lx");

	%>
	<table border="1">
		<tr> <th>Id</th>  <th>Nome</th>  <th>Login</th>  <th>Senha</th>  <th>Ação</th>  </tr>
	
		<% for(Usuario u:lx){%>
			<tr>
				<td><% out.print(u.getId()); %></td>
				<td><%=u.getNome() %></td>
				<td><%=u.getLogin()%></td>
				<td><%=u.getSenha()%></td>
				<td>
				<a href="javascript:confirmaExclusao(<%=u.getId()%>)">Excluir</a>
				|
				<a href="usuctrl.do?ac=alt&id=<%=u.getId()%>">Alterar</a>
				|
				<input type="button" onclick="javascript:novo()" value="Novo">
				</td>
			</tr>
		<%}%>
	</table>	
	
</body>
</html>