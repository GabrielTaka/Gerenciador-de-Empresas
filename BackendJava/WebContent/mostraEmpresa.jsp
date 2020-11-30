<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp"></c:import> 

	<form action="/gerenciador/entrada?acao=EditaEmpresa&id=${empresa.getId()}" method="post">
		nome:
		<input type="text" name="nomeEmpresa" value="${empresa.getNome()}"/>
		<input type="submit" />
	</form>
</body>
</html>