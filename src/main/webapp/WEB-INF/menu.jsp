<%@page import="br.com.cidao.web_tst.persistencia.entitade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Sistema de aprendisado do crud<br>
Usuario Logado :<%=((Usuario)request.getSession().getAttribute("usuAut")).getNome() %><br>
<a href="autenticador.do">Sair</a> |
<a href="home.do">Home</a> |
<a href="usuctrl.do?ac=lst">Usuários</a> |
<a href="prodctrl.do?ac=lst">Produto</a> |
<a href="WEB-INF/frmCli.jsp">Cliente</a> |