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
						<h2 class="frm-main-header">
							<c:choose>
								<c:when test="${us_editar.login != null}">
									<span>Editar Usuário</span>
								</c:when>
								<c:otherwise>
									<span> Cadastrar usuário</span>
								</c:otherwise>
							</c:choose>

						</h2>
						<hr />
						<form class="form-horizontal frm-main"
							action="${pageContext.request.contextPath}/mvc" method="post">
							<div class="form-group">

								<label for="txtNome" class="col-lg-2 col-sm-2 control-label">Pessoa</label>
								<div class="col-lg-9 col-sm-10">
									<select name="usuarios" class="col-lg-4 col-sm-10">
										<c:if test="${us_editar.pessoa.id == null}">
											<option selected="selected" value="0">nenhum
										</c:if>
										<c:forEach var="pessoa" items="${pessoadao.pessoas}">
											<c:choose>
												<c:when
													test="${us_editar.login != null && (pessoa.id == us_editar.pessoa.id) }">
													<option value="${pessoa.id}" selected="selected">${pessoa.nome}
												</c:when>
												<c:otherwise>
													<option value="${pessoa.id}">${pessoa.nome}
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="txtRg" class="col-lg-2 col-sm-2 control-label">Login</label>
								<div class="col-lg-3 col-sm-10">
									<input type="text" class="form-control" id="txtLogin"
										name="login" placeholder="user.user"
										value="${us_editar.login}" />
								</div>
								<br />
							</div>
							<div class="form-group">
								<label for="txtCpf" class="col-lg-2 col-sm-2 control-label">Senha</label>
								<div class="col-lg-4 col-sm-10">
									<input type="password" id="txtSenha" class="form-control"
										name="senha" placeholder="*****" value="${us_editar.senha}" />
								</div>
							</div>

							<div class="form-group">
								<label for="txtCpf" class="col-lg-2 col-sm-2 control-label">Admin</label>
								<div class="col-lg-1 col-sm-1">

									<c:choose>
										<c:when test="${us_editar.admin == true}">
											<input type="checkbox" id="chkAdmin" class="form-control"
												name="admin" value="true" checked="checked" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" id="chkAdmin" class="form-control"
												name="admin" value="true" />
										</c:otherwise>
									</c:choose>
								</div>
							</div>


							<div class="form-group">
								<div class="col-lg-11 col-sm-10 frm-btn">
									<button id="btnSalvar" name="btnSalvar" type="submit"
										value="${us_editar.admin}" class="btn btn-primary text-left">Salvar</button>
								</div>
							</div>

							<c:if test="${us_editar.id != null}">
								<input type="hidden" id="id" value="${us_editar.id}" name="id">
							</c:if>

							<input type="hidden" id="logica" value="CadastroUsuario"
								name="logica">

						</form>
					</div>
				</div>

			</div>
		</div>
		</main>
		<%@include file="../includes/footer.jsp"%>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/script/js/editar_usuario.js">
		
	</script>
	<script type="text/javascript">
		//var teste = new EditarUsuario();
		//var param = GetQueryStringParams('us_editar');

		function GetQueryStringParams(sParam) {
			var sPageURL = window.location.search.substring(1);
			var sURLVariables = sPageURL.split('&');
			for (var i = 0; i < sURLVariables.length; i++) {
				var sParameterName = sURLVariables[i].split('=');
				if (sParameterName[0] == sParam) {
					return sParameterName[1];
				}
			}
		};
	</script>
</body>
</html>