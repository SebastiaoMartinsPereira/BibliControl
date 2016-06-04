<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pessoas</title>
<%@include file="../includes/headerImports.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main-cadastro-pessoa.css" />
</head>
<body>
	<div class="container-fluid">
		<%@include file="/includes/header.jsp"%>
		<main>
		<div class="container">
			<div class="main-index">
				<div class="row">
					<div class="col-lg-11 wrapper-main  animated bounceInLeft">
						<h2 class="frm-main-header">
							<c:choose>
								<c:when test="${pessoa_editar.id != null}">
									<span>Editar Pessoa</span>
								</c:when>
								<c:otherwise>
									<span>Cadastro de Pessoas</span>
								</c:otherwise>
							</c:choose>
						</h2>
						<hr />

						<form class="form-horizontal frm-main"
							action="${pageContext.request.contextPath}/mvc" method="post">
							<!-- tipos pessoa -->
							<div class="form-group">
								<label class="radio-inline frm-rd-tipo">Tipo Pessoa</label>
								<c:choose>
									<c:when test="${pessoa_editar.tipo == 'ALUNO'}">
										<label class="radio-inline frm-rd-tipo"> <input
											id="rdFuncionario" name="rdTipoPessoa" value="0" type="radio"
											checked="checked"> Aluno
										</label>
									</c:when>
									<c:when test="${pessoa_editar.tipo == 'FUNCIONARIO' }">
										<label class="radio-inline frm-rd-tipo"> <input
											id="rdAluno" name="rdTipoPessoa" checked="checked" value="1"
											type="radio"> Funcionário
										</label>
									</c:when>
									<c:when test="${pessoa_editar.tipo == 'PROFESSOR' }">
										<label class="radio-inline frm-rd-tipo"> <input
											id="rdProfessor" name="rdTipoPessoa" checked="checked"
											value="2" type="radio"> Professor
										</label>
									</c:when>
									<c:otherwise>
										<label class="radio-inline frm-rd-tipo"> <input
											id="rdFuncionario" name="rdTipoPessoa" value="0" type="radio"
											checked="checked"> Aluno
										</label>
										<label class="radio-inline frm-rd-tipo"> <input
											id="rdAluno" name="rdTipoPessoa" value="1" type="radio">
											Funcionário
										</label>
										<label class="radio-inline frm-rd-tipo"> <input
											id="rdProfessor" name="rdTipoPessoa" value="2" type="radio">
											Professor
										</label>
									</c:otherwise>
								</c:choose>
							</div>
							<!-- fim-tipos pessoa -->
							<div class="form-group">
								<label for="txtNome" class="col-lg-2 col-sm-2 control-label">Nome</label>
								<div class="col-lg-9 col-sm-10">
									<input type="text" class="form-control" id="nome" name="nome"
										value="${pessoa_editar.nome}" placeholder="Nome completo" />
								</div>
							</div>

							<div class="form-group">
								<label for="txtRg" class="col-lg-2 col-sm-2 control-label">Rg</label>
								<div class="col-lg-3 col-sm-10">
									<input type="text" class="form-control" id="txtRg" name="rg"
										value="${pessoa_editar.rg}" placeholder="99999999" />
								</div>

								<label for="txtCpf" class="col-lg-2 col-sm-2 control-label">Cpf</label>
								<div class="col-lg-4 col-sm-10">
									<input type="text" id="txtCpf" class="form-control" name="cpf"
										value="${pessoa_editar.cpf}" placeholder="999.999.999-99" />
								</div>
							</div>

							<div class="form-group">
								<fieldset>
									<legend>Contato</legend>
								</fieldset>
							</div>

							<div class="form-group">
								<label for="txtEmail" class="col-lg-2 col-sm-2 control-label">E-mail</label>
								<div class="col-lg-9 col-sm-10">
									<div class="input-group">
										<span class="input-group-addon">@</span> <input type="text"
											id="txtEmail" class="form-control" name="email"
											value="${pessoa_editar.email}" placeholder="email@email.com">

									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="txtTelFixo" class="col-lg-2 col-sm-2 control-label">Tel.
									Fixo</label>
								<div class="col-lg-3 col-sm-10">
									<input type="text" class="form-control" id="txtTelFixo"
										value="${pessoa_editar.tel_fixo}" placeholder="(11) 99999999"
										name="telfixo" />
								</div>

								<label for="txtCelular" class="col-lg-2 col-sm-2 control-label">Celular</label>
								<div class="col-lg-4 col-sm-10">
									<input type="text" id="txtCelular" class="form-control"
										value="${pessoa_editar.tel_celular}"
										placeholder="(11) 91111-1111" name="telcelular" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-lg-11 col-sm-10 frm-btn">
									<button id="btnLogar" name="btnLogar" type="submit"
										class="btn btn-primary text-left">Salvar</button>
								</div>
							</div>
							
							<c:if test="${pessoa_editar.id != null}">
								<input type="hidden" id="id" value="${pessoa_editar.id}" name="id">
								<input type="hidden" id="id_usuario" value="${pessoa_editar.usuario.id}" name="id_usuario">
							</c:if>

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