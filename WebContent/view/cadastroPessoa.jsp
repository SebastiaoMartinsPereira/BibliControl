<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pessoas</title>
<%@include file="../includes/headerImports.jsp"%>
<link rel="stylesheet" type="text/css"
	href="../css/main-cadastro-pessoa.css" />
</head>
<body>
	<div class="container-fluid">
		<%@include file="../includes/header.jsp"%>
		<main>
		<div class="container">
			<div class="main-index">
				<div class="row">
					<div class="col-lg-11 wrapper-main  animated bounceInLeft">
						<h2 class="frm-main-header">Cadastro de Pessoas</h2>
						<hr />
						
						<form class="form-horizontal frm-main" action="../AdicionaPessoaController" method="post">
							<!-- tipos pessoa -->
							<div class="form-group">
								<label class="radio-inline frm-rd-tipo">Tipo Pessoa</label> <label
									class="radio-inline frm-rd-tipo"> <input
									id="rdFuncionario" name="rdTipoPessoa" value="0" type="radio"
									checked="checked"> Funcionário
								</label> <label class="radio-inline frm-rd-tipo"> <input
									id="rdAluno" name="rdTipoPessoa" value="1" type="radio">
									Aluno
								</label> <label class="radio-inline frm-rd-tipo"> <input
									id="rdProfessor" name="rdTipoPessoa" value="2" type="radio">
									Professor
								</label>
							</div>
							<!-- fim-tipos pessoa -->

							<div class="form-group">
								<label for="txtNome" class="col-lg-2 col-sm-2 control-label">Nome</label>
								<div class="col-lg-9 col-sm-10">
									<input type="text" class="form-control" id="txtNome"
										name="txtNome" placeholder="Nome completo" />
								</div>
							</div>

							<div class="form-group">
								<label for="txtRg" class="col-lg-2 col-sm-2 control-label">Rg</label>
								<div class="col-lg-3 col-sm-10">
									<input type="text" class="form-control" id="txtRg" name="txtRg"
										placeholder="99999999" />
								</div>

								<label for="txtCpf" class="col-lg-2 col-sm-2 control-label">Cpf</label>
								<div class="col-lg-4 col-sm-10">
									<input type="text" id="txtCpf" class="form-control"
										placeholder="999.999.999-99" />
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
											id="txtEmail" class="form-control"
											placeholder="email@email.com">
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="txtTelFixo" class="col-lg-2 col-sm-2 control-label">Tel.
									Fixo</label>
								<div class="col-lg-3 col-sm-10">
									<input type="text" class="form-control" id="txtTelFixo"
										name="txtTelFixo" placeholder="(11) 99999999" />
								</div>

								<label for="txtCelular" class="col-lg-2 col-sm-2 control-label">Celular</label>
								<div class="col-lg-4 col-sm-10">
									<input type="text" id="txtCelular" class="form-control"
										placeholder="(11) 91111-1111" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-lg-11 col-sm-10 frm-btn">
									<button id="btnLogar" name="btnLogar" type="submit"
										class="btn btn-primary text-left">Salvar</button>
								</div>
							</div>
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