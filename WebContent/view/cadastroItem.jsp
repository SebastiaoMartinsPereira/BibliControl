<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Item</title>
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
								<c:when test="${item_editar != null}">
									<span>Editar Item</span>
								</c:when>
								<c:otherwise>
									<span> Cadastrar Item</span>
								</c:otherwise>
							</c:choose>
						</h2>
						<hr />

						<form class="form-horizontal frm-main" action="${pageContext.request.contextPath}/mvc"
							method="post">
							<!-- tipos item -->
							<div class="form-group">
								<label class="radio-inline frm-rd-tipo">Tipo Item</label>


								<c:choose>
									<c:when test="${item_editar.tipo == 'LIVRO'}">
										<label class="radio-inline frm-rd-tipo"> <input
											id="rdlivro" name="tipo" value="0" type="radio"
											checked="checked"> Livro
										</label>
									</c:when>
									<c:when test="${item_editar.tipo == 'REVISTA' }">
										<label class="radio-inline frm-rd-tipo"> <input
											id="rdRevista" checked="checked" name="tipo" value="1"
											type="radio"> Revista
										</label>
									</c:when>
									<c:otherwise>
										<label class="radio-inline frm-rd-tipo"> <input
											id="rdlivro" name="tipo" value="0" type="radio"
											checked="checked"> Livro
										</label>
										<label class="radio-inline frm-rd-tipo"> <input
											id="rdRevista" name="tipo" value="1" type="radio">
											Revista
										</label>
									</c:otherwise>
								</c:choose>
							</div>
							<!-- fim-tipos item -->

							<div class="form-group">
								<label for="txtDescricao"
									class="col-lg-2 col-sm-2 control-label">Descrição</label>
								<div class="col-lg-9 col-sm-10">
									<input type="text" class="form-control" id="txtDescricao"
										value="${item_editar.descricao}" name="descricao"
										placeholder="Descrição" />
								</div>
							</div>

							<div class="form-group">
								<label for="txtCodigo" class="col-lg-2 col-sm-2 control-label">Código
									Interno</label>
								<div class="col-lg-3 col-sm-10">
									<input type="text" class="form-control" id="txtCodigo"
										value="${item_editar.codigoInterno}" name="codigoInterno"
										placeholder="LV-0001" />
								</div>
							</div>
							<div class="form-group">
								<label for="chkEspecial" class="col-lg-2 col-sm-2 control-label">Especial</label>
								<div class="col-lg-1 col-sm-1">

									<c:choose>
										<c:when test="${item_editar.especial == true}">
											<input type="checkbox" id="chkEspecial" class="form-control"
												name="especial" checked="checked" value="true" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" id="chkEspecial" class="form-control"
												name="especial" value="true" />
										</c:otherwise>
									</c:choose>
								</div>
							</div>

							<div class="form-group">
								<div class="col-lg-11 col-sm-10 frm-btn">
									<button id="btnLogar" name="btnLogar" type="submit"
										class="btn btn-primary text-left">Salvar</button>
								</div>
							</div>
							<c:if test="${item_editar.id != null}">
								<input type="hidden" id="id" value="${item_editar.id}" name="id">
							</c:if>

							<input type="hidden" id="logica" value="CadastroItem"
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