<%@page import="java.util.List,br.com.gabriel.gerenciador.modelo.Empresa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<c:import url="logout-parcial.jsp"></c:import> 
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>
				${empresa.nome} 
				 <a href="entrada?acao=MostraEmpresa&id=${empresa.id}"> Editar </a> 
				 <a href="entrada?acao=RemoveEmpresa&id=${empresa.id}"> Remover  </a>
			</li>	
		</c:forEach>
	</ul>	
</body>
</html>