<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="br.com.newprog.model.Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuários</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/listausuarios.css" />
</head>

<%@include file="../includes/headerImports.jsp"%>
</head>
<body>
	<jsp:useBean id="dao" class="br.com.newprog.dao.UsuarioDAO" />
	<jsp:setProperty name="dao" property="*" />
	<div class="container-fluid">
		<%@include file="../includes/header.jsp"%>
		<main>
		<div class="container">
			<div class="main-index">
				<div class="row">
					<div class="col-lg-11 wrapper-main  animated bounceInLeft">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Id</th>
									<th>Login</th>
									<th>Admin</th>
									<th>Pessoa</th>
									<th>Tipo</th>
									<th>Deletar</th>
									<th>Editar</th>
								</tr>
							</thead>
							<c:forEach var="obj" items="${dao.usuarios}">
								<tr>
									<td>${obj.id}</td>
									<td>${obj.login}</td>
									<td>${obj.admin}</td>
									<td>${obj.pessoa.nome}</td>
									<td>${obj.pessoa.tipo}</td>
									<td><a class="btn btn-danger"
										href="${pageContext.request.contextPath}/mvc?logica=DeletarUsuario&id=${obj.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a class="btn btn-success"
										href="${pageContext.request.contextPath}/mvc?logica=EditarUsuario&id=${obj.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
		</main>
		<c:import url="../includes/footer.jsp" />
	</div>
</body>
</html>