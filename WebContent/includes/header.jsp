<%@ page import="java.io.*,java.util.*,br.com.newprog.model.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/view/home.jsp">BiblioControl
				<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
			</a>
			<button type="button" data-target=".navbar-collapse"
				data-toggle="collapse" class="navbar-toggle btn-menu">Menu</button>
		</div>
		<div class="collapse navbar-collapse">

			<!-- Estrutura de um menu no top da tela -->
			<ul class="navbar-nav nav">

				<!-- Defini o bot�o que ir� mostrar a lista de op��es -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> A��es <span class="caret"></span>
				</a> <!-- lista de op��es dentro de um menu dropdown -->
					<ul class="dropdown-menu">
						<li><a href="" class="iten-menu-responsivo-adapter">
								Empr�stimo <span class="glyphicon glyphicon-export navbar-right"></span>
						</a></li>
						<li><a href="" class="iten-menu-responsivo-adapter">
								Devolu��o <span class="glyphicon glyphicon-import navbar-right"></span>
						</a></li>

					</ul></li>

				<!-- Defini o bot�o que ir� mostrar a lista de op��es -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Cadastro <span class="caret"></span>
				</a> <!-- lista de op��es dentro de um menu dropdown -->
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/view/cadastroPessoa.jsp"
							class="iten-menu-responsivo-adapter">Pessoas <span
								class="glyphicon glyphicon-user navbar-right"></span>
						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/view/cadastroUsuario.jsp"
							class="iten-menu-responsivo-adapter">Usu�rios <span
								class="glyphicon glyphicon-star navbar-right"></span>
						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/view/cadastroItem.jsp"
							class="iten-menu-responsivo-adapter">Itens <span
								class="glyphicon glyphicon-book navbar-right"> </span>
						</a></li>
					</ul></li>
				<!-- Defini o bot�o que ir� mostrar a lista de op��es -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Consulta <span class="caret"></span>
				</a> <!-- lista de op��es dentro de um menu dropdown -->
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/view/listaPessoas.jsp"
							class="iten-menu-responsivo-adapter">Pessoas <span
								class="glyphicon glyphicon-user navbar-right"></span>
						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/view/listaUsuarios.jsp"
							class="iten-menu-responsivo-adapter">Usu�rios <span
								class="glyphicon glyphicon-star navbar-right"></span>
						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/view/listaItens.jsp"
							class="iten-menu-responsivo-adapter">Itens <span
								class="glyphicon glyphicon-book navbar-right"> </span>
						</a></li>
						<li><a href="#" class="iten-menu-responsivo-adapter">Empr�stimos
								<span class="glyphicon glyphicon-usd navbar-right"> </span>
						</a></li>
					</ul></li>
			</ul>

			<!-- Estrutura de um menu no top da tela -->
			<ul class="navbar-nav nav navbar-right text-center">
				<!-- Defini o bot�o que ir� mostrar a lista de op��es -->
				<li class="dropdown text-center menu-user"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> ${usuario.login == null ? 'Logar' : usuario.login}
						<span class="caret"></span>
				</a> <!-- lista de op��es dentro de um menu dropdown -->
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/login.jsp"
							class="iten-menu-responsivo-adapter">Login <span
								class="glyphicon glyphicon-user navbar-right"></span>
						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/mvc?logica=Logout"
							class="iten-menu-responsivo-adapter">Logout <span
								class="glyphicon glyphicon-star navbar-right"></span>
						</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>


</header>