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
						<h2 class="frm-main-header">Cadastro de Itens</h2>
						<hr />

						<form class="form-horizontal frm-main"
							action="../mvc" method="post">
							<!-- tipos item -->
							<div class="form-group">
								<label class="radio-inline frm-rd-tipo">Tipo Item</label> <label
									class="radio-inline frm-rd-tipo"> <input id="rdlivro"
									name="tipo" value="0" type="radio" checked="checked">
									Livro
								</label> <label class="radio-inline frm-rd-tipo"> <input
									id="rdRevista" name="tipo" value="1" type="radio">
									Revista 
							</div>
							<!-- fim-tipos item -->

							<div class="form-group">
								<label for="txtDescricao"
									class="col-lg-2 col-sm-2 control-label">Descrição</label>
								<div class="col-lg-9 col-sm-10">
									<input type="text" class="form-control" id="txtDescricao"
										name="descricao" placeholder="Descrição" />
								</div>
							</div>

							<div class="form-group">
								<label for="txtCodigo" class="col-lg-2 col-sm-2 control-label">Código
									Interno</label>
								<div class="col-lg-3 col-sm-10">
									<input type="text" class="form-control" id="txtCodigo"
										name="codigoInterno" placeholder="LV-0001" />
								</div>
							</div>
							<div class="form-group">
								<label for="chkEspecial" class="col-lg-2 col-sm-2 control-label">Especial</label>
								<div class="col-lg-1 col-sm-1">
									<input type="checkbox" id="chkEspecial" class="form-control"
										name="especial" value="1" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-lg-11 col-sm-10 frm-btn">
									<button id="btnLogar" name="btnLogar" type="submit"
										class="btn btn-primary text-left">Salvar</button>
								</div>
							</div>
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