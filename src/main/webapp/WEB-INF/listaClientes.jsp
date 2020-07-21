<%@page import="br.com.cidao.web_tst.persistencia.entitade.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
<script type="text/javascript">
	function confirmaExclusao(id){
		if(window.confirm("Tem certeza que deseja excluir o Registro:"+id)){
			location.href="prodctrl.do?ac=excl&id="+id;
		}
	}
	function novo() {
		location.href="prodctrl.do?ac=cad";
	}
</script>
</head>
<body>
	<%@include file="menu.jsp" %> <a href="prodctrl.do?ac=cad">Novo Produto</a>
	
	<%
	/**
	*** exclusao sem o java script
	*** <a href="prodctrl.do?ac=excl&id=<#=u.getId()#>"> Excluir</a>
	*/
	List<Produto> lx = (List<Produto>)request.getAttribute("lx");

	%>
	<table border="1">
		<tr> <th>Id</th>  <th>Nome</th>  <th>valor Venda</th>  <th>valor Custo</th>  <th>Peso</th>  <th>Estoque</th>  <th>Qtde Minima</th>  <th>Ação</th>  </tr>
	
		<% for(Produto u:lx){%>
			<tr>
				<td><% out.print(u.getId()); %></td>
				<td><%=u.getNome() %></td>
				<td><%=u.getValor_vda()%></td>
				<td><%=u.getValor_custo()%></td>
				<td><%=u.getPeso()%></td>
				<td><%=u.getEstoque()%></td>
				<td><%=u.getQtd_minima()%></td>
				<td>
				<a href="javascript:confirmaExclusao(<%=u.getId()%>)">Excluir</a>
				|
				<a href="prodctrl.do?ac=alt&id=<%=u.getId()%>">Alterar</a>
				|
				<input type="button" onclick="javascript:novo()" value="Novo">
				</td>
			</tr>
		<%}%>
	</table>	
	
</body>
</html>