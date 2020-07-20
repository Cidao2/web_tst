<%@page import="br.com.cidao.web_tst.persistencia.entitade.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Produtos</title>

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
	Produto prodb = (Produto) request.getAttribute("prodb");
	%>

	<form action="usuctrl.do" method="post">
		<fieldset>
			<legend>Cadastrar Usuário</legend>
			<br>Id		:<input type="number" 	name="id"    		value="<%=prodb.getId()%>">
			<br>Nome	:<input type="text"   	name="nome"  		value="<%=prodb.getNome()%>"> 
			<br>$ Venda	:<input type="number" 	name="valor_vda" 	value="<%=prodb.getValor_vda()%>"> 
			<br>$ Custo :<input type="number"   name="valor_custo"	value="<%=prodb.getValor_custo()%>">
			<br>Peso	:<input type="number"   name="peso" 		value="<%=prodb.getPeso()%>">
			<br>Estoque :<input type="number"   name="estoque" 		value="<%=prodb.getEstoque()%>">
			<br>Qtd Minima:<input type="number"	name="qtd_minima" 	value="<%=prodb.getQtd_minima()%>">
			<br>		<input type="submit" value="Salvar">
			<input type="button" onclick="javascript:novo()" value="Novo">
		</fieldset>
	</form>
</body>
</html>