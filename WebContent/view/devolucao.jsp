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
							<span>Devolução</span>
						</h2>
						<hr />

						<form class="form-horizontal frm-main"
							action="${pageContext.request.contextPath}/mvc" method="post">
							<div class="form-group">
								<label for="txtId" class="col-lg-2 col-sm-2 control-label">Pessoa
									Id: </label>
								<div class="col-lg-2 col-sm-10">
									<input type="text" class="form-control" id="pessoaid"
										name="pessoaid" placeholder="Id" />
								</div>

								<label for="pessoaNome" class="col-lg-1 col-sm-2 control-label">Nome
								</label>
								<div class="col-lg-6 col-sm-10">
									<input type="text" class="form-control" id="pessoaNome"
										name="pessoaNome" placeholder="Nome" />
								</div>
								<div class=col-lg-1>
									<a class="btn btn-success" id="buscar" href=""> <span
										class="glyphicon glyphicon-search"></span>
									</a>
								</div>
							</div>

							<div class="form-group">
								<fieldset>
									<legend>Itens</legend>
								</fieldset>
							</div>

							<table class="table table-striped">
								<thead>
									<tr>
										<th>Id</th>
										<th>Data Empréstimo</th>
										<th>Data Devolução</th>
										<th>Id Item</th>
										<th>Id Pessoa</th>
										<th>Receber</th>
										<!-- <th>Adiar</th> -->
									</tr>
								</thead>
								<tbody>

								</tbody>
							</table>

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

		$('#pessoaid').on('blur', function() {
			buscarPessoa(this);
		});

		$('#buscar').on('click', function() {
			event.preventDefault();
			buscarEmprestimos(this);
		});

		$('#nomeItem').on('keyup', function() {
			listarItens();
		}).on('blur', function() {
			tratarCamposItem(this);
		});

		function buscarPessoa() {
			try {
				var _pessoaId = $('#pessoaid').val()
				var _get = "${pageContext.request.contextPath}/BuscarPessoa";

				$.ajax({
					data : {
						id : _pessoaId
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

		function buscarEmprestimos() {
			try {
				var _pessoaId = $('#pessoaid').val()
				var _get = "${pageContext.request.contextPath}/BuscarEmprestimo";

				$.ajax({
					data : {
						id : _pessoaId
					},
					dataType : 'json',
					url : _get,
					type : 'GET',
					success : function(data) {
						sucessoBusca(data);
					},
					error : function(data) {
						error("Não foi possícel completar a solicitação!");
					}
				});
			} catch (e) {
				alert(e);
			}
			;
		};

		function sucesso(data) {
			pessoas = new Array();

			if ($(data).size() === 1) {
				$("#pessoaNome").val(data.d.nome);
			}
			;

			$.each(data, function() {
				var id = this.id;
				var nome = this.nome;
				pessoas.push(nome + "," + id);
			});
		};

		function sucessoBusca(data) {
			emprestimos = new Array();

			$.each(data, function() {
				var id = this.id;
				var dataEmprestimo = this.dataEmprestimo.substring(0, 10);
				var dataDevolucao = this.dataDevolucao.substring(0, 10);
				var item = this.item_id;
				var pessoa = this.pessoa_id
				emprestimos.push(id + "," + dataEmprestimo + ","
						+ dataDevolucao + "," + item + "," + pessoa);
			});

			if ($(emprestimos).size() > 0) {
				var corpo = $("table tbody");
                $(corpo).html("");
                
				emprestimos.forEach(function(e) {
					var tr = document.createElement("tr");
					var da = e.split(",");
					da.forEach(function(d) {
						var td = document.createElement("td");
						$(td).html(d);
						$(tr).append(td);
					});
					
					var btnDevolver = '<td><a class="btn btn-success" href="${pageContext.request.contextPath}/mvc?logica=ReceberItem&id='+ da[0]+ '"> <span class="glyphicon glyphicon-share-alt"></span></a></td>';
					var btnAdiar = '<td><a class="btn btn-success"	href="${pageContext.request.contextPath}/mvc?logica=AdiarItem&id='+ da[0]+ '"><span class="glyphicon glyphicon-pencil"></span></a></td>';

					$(tr).append(btnDevolver);
					/* $(tr).append(btnAdiar); */
					
					$(corpo).append(tr);
				});
			}
		};

		
		function error(data) {
			alert(data);
		};

	</script>

</body>
</html>