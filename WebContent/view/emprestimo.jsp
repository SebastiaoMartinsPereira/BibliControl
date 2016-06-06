<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<title>BibliControl</title>
<%@include file="../includes/headerImports.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main-cadastro-pessoa.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/script/jquery-ui-1.11.4.custom/jquery-ui.min.css" />
</head>
<body>
	<div class="container-fluid">
		<%@include file="../includes/header.jsp"%>
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
									<span>Empréstimos</span>
								</c:otherwise>
							</c:choose>
						</h2>
						<hr />

						<form class="form-horizontal frm-main"
							action="${pageContext.request.contextPath}/mvc" method="post">
							<div class="form-group">
								<label for="txtId" class="col-lg-2 col-sm-2 control-label">Pessoa
									Id: </label>
								<div class="col-lg-2 col-sm-10">
									<input type="text" class="form-control" id="pessoaid"
										name="pessoaid" readonly="readonly"
										value="${pessoa_editar.nome}" placeholder="Id" />
								</div>
								<label id="lblTipoPessoa"
									class="col-lg-2 col-sm-2 control-label"></label>
							</div>

							<div class=form-group>
								<label for="txtNome" class="col-lg-2 col-sm-2 control-label">Nome</label>
								<div class="col-lg-9 col-sm-10 ui-widge">
									<input type="text" class="form-control" id="nome" name="nome"
										value="${pessoa_editar.nome}" placeholder="Nome completo" />
								</div>
							</div>

							<div class="form-group">
								<fieldset>
									<legend>Item</legend>
								</fieldset>
							</div>

							<div class="form-group">
								<label for="itemid" class="col-lg-2 col-sm-2 control-label">Item
									Id: </label>
								<div class="col-lg-2 col-sm-10">
									<input type="text" class="form-control" id="itemid"
										name="itemid" readonly="readonly"
										value="${pessoa_editar.nome}" placeholder="Id" />
								</div>
								<label id="lblTipoItem" class="col-lg-2 col-sm-2 control-label"></label>
								<label id="lblEspecial" class="col-lg-3 col-sm-2 control-label"></label>
							</div>

							<div class=form-group>
								<label for="nomeItem" class="col-lg-2 col-sm-2 control-label">Nome</label>
								<div class="col-lg-9 col-sm-10 ui-widge">
									<input type="text" class="form-control" id="nomeItem"
										name="nomeItem" value="${pessoa_editar.nome}" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-lg-11 col-sm-10 frm-btn">
									<button id="btnLogar" name="btnLogar" type="submit"
										class="btn btn-primary text-left">Salvar</button>
								</div>
							</div>

							<c:if test="${pessoa_editar.id != null}">
								<input type="hidden" id="id" value="${pessoa_editar.id}"
									name="id">
								<input type="hidden" id="id_usuario"
									value="${pessoa_editar.usuario.id}" name="id_usuario">
							</c:if>
							<input type="hidden" id="logica" value="RealizarEmprestimo"	name="logica"> 
							<input type="hidden" id="listar" value="${pageContext.request.contextPath}/ListarPessoas">
							<input type="hidden" id="listarItem" value="${pageContext.request.contextPath}/ListarItens">
							
						</form>
					</div>
				</div>

			</div>
		</div>
		</main>
		<%@include file="../includes/footer.jsp"%>
	</div>

	<script
		src="${pageContext.request.contextPath}/script/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
	<script type="text/javascript">
		var pessoas = new Array();
		var itens = new Array();
		
		$(carregarCamposPessoas);
		$(carregarCamposItens);

		$('#nome').on('keyup', function() {
			listarPessoas();
		}).on('blur', function() {
			tratarCamposPessoa(this);
		});

		$('#nomeItem').on('keyup', function() {
			listarItens();
		}).on('blur', function() {
			tratarCamposItem(this);
		});

		function listarPessoas() {
			try {
				var _nome = $('#nome').val()
				var _get = $('#listar').val();

				$.ajax({
					data : {
						pessoa_nome : _nome
					},
					dataType : 'json',
					url : _get,
					type : 'GET',
					success : function(data) {
						sucesso(data);
					},
					error : function(data) {
						error(data);
					}
				});
			} catch (e) {
				alert(e);
			}
			;
		};

		function sucesso(data) {
			pessoas = new Array();
			$.each(data, function() {
				var id = this.id;
				var nome = this.nome;
				var tipo = this.tipo;
				pessoas.push(nome + "," + id + "," + tipo);
			});

			carregarCamposPessoas();
		};

		function error(data) {
			alert(data);
		};

		function carregarCamposPessoas() {
			$("#nome").autocomplete({
				source : pessoas
			});
		};

		function tratarCamposPessoa(elemento) {
			if ($(elemento).val().indexOf(',') > 0) {
				var id = $(elemento).val().substring(
						$(elemento).val().indexOf(','),
						$(elemento).val().lastIndexOf(','));
				var nome = $(elemento).val().substring(0,
						$(elemento).val().indexOf(','));
				var tipo = $(elemento).val().substring(
						$(elemento).val().lastIndexOf(',') + 1);
				$("#lblTipoPessoa").html("Tipo :" + tipo);
				$("#pessoaid").val(id.substring(1));
				$(elemento).val(nome);
			}
			;
		};

		function listarItens() {

			try {
				var _nome = $('#nomeItem').val()
				var _get = $('#listarItem').val();

				$.ajax({
					data : {
						item_nome : _nome
					},
					dataType : 'json',
					url : _get,
					type : 'GET',
					success : function(data) {
						sucessoItens(data);
					},
					error : function(data) {
						error(data);
					}
				});
			} catch (e) {
				alert(e);
			}
		};

		function sucessoItens(data) {
			itens = new Array();
			$.each(data, function() {
				var id = this.id;
				var nome = this.nome;
				var tipo = this.tipo;
				var especial = this.especial;

				if (especial == "SIM") {
					itens.push(nome + "," + id + "," + tipo + ", ESPECIAL");
				} else {
					itens.push(nome + "," + id + "," + tipo);
				}
			});

			carregarCamposItens();
		};

		function carregarCamposItens() {
			$("#nomeItem").autocomplete({
				source : itens
			});
		};

		function tratarCamposItem(elemento) {
			
			$("#lblTipoItem").html("");
			$("#itemid").val("");		
			$("#lblEspecial").html("");

			if ($(elemento).val().indexOf(',') > 0) {

				var dados = $(elemento).val().split(',');
				var nome = dados[0];
				var id = dados[1];
				var tipo = dados[2];
				var especial = dados[3];

				$("#lblTipoItem").html("Tipo :" + tipo);
				$("#itemid").val(id);
				$(elemento).val(nome);
				$("#lblEspecial").html("Categoria :" + especial);
			}
			;
		};
	</script>

</body>
</html>