<%@page import="java.util.List, br.com.gabriel.gerenciador.modelo.Empresa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServer"/>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/gerenciador/entrada?acao=Login" method="post">
		Login: 
		<input type="text" name="login"/>
		senha:
		<input type="password" name="senha">
		<input type="submit" />
	</form>
</body>
</html>