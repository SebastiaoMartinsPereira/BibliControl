<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- //import de bibliotecas jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Importa a classe Dao  -->
<%@ page import="br.com.newprog.dao.PessoaDAO"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuários</title>
<%@include file="../includes/headerImports.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main-cadastro-pessoa.css" />
</head>
<body>
	<jsp:useBean id="pessoadao" class="br.com.newprog.dao.PessoaDAO" />
	<jsp:setProperty property="*" name="pessoadao" />
	<div class="container-fluid">
		<%@include file="/includes/header.jsp"%>
		<main>
		<div class="container">
			<div class="main-index">
				<div class="row">
					<div class="col-lg-11 wrapper-main  animated bounceInLeft">
						<h2 class="frm-main-header">Cadastro de Usuários</h2>
						<hr />
						<form class="form-horizontal frm-main"
							action="../UsuarioController" method="post">
							<div class="form-group">

								<label for="txtNome" class="col-lg-2 col-sm-2 control-label">Pessoa</label>
								<div class="col-lg-9 col-sm-10">
									<select name="usuarios" class="col-lg-4 col-sm-10">
										<c:forEach var="pessoa" items="${pessoadao.pessoas}">
											<option value="${pessoa.id}">${pessoa.nome}
										</c:forEach>

									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="txtRg" class="col-lg-2 col-sm-2 control-label">Login</label>
								<div class="col-lg-3 col-sm-10">
									<input type="text" class="form-control" id="txtLogin"
										name="login" placeholder="user.user" />
								</div>
								<br />
							</div>
							<div class="form-group">
								<label for="txtCpf" class="col-lg-2 col-sm-2 control-label">Senha</label>
								<div class="col-lg-4 col-sm-10">
									<input type="text" id="txtSenha" class="form-control"
										name="senha" placeholder="*****" />
								</div>
							</div>

							<div class="form-group">
								<label for="txtCpf" class="col-lg-2 col-sm-2 control-label">Admin</label>
								<div class="col-lg-1 col-sm-1">
									<input type="checkbox" id="xhkAdmin" class="form-control"
										name="admin" value="1" />
								</div>
							</div>


							<div class="form-group">
								<div class="col-lg-11 col-sm-10 frm-btn">
									<button id="btnSalvar" name="btnSalvar" type="submit"
										class="btn btn-primary text-left">Salvar</button>
								</div>
							</div>

							<input type="hidden" id="logica" value="CadastroPessoa"
								name="logica">
						</form>
					</div>
				</div>

			</div>
		</div>
		</main>
		<%@include file="../includes/footer.jsp"%>
	</div>
</body>
</html>