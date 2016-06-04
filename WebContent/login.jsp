<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>BibliControl</title>
<%@include file="../includes/headerImports.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="../includes/header.jsp"%>
		<main>
		<div class="container">
			<div class="main-index">
				<div class="row">
					<div
						class="col-lg-offset-9 col-lg-3 wrapper-login animated bounceInLeft">
						<h2 class="frm-login-header">Login</h2>
						<form class="form-horizontal frm-login" method="post" action="mvc">
							<div class="form-group">
								<label for="txtUser" class="col-sm-2 control-label">Usuário</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="txtUser"
										placeholder="user.user" name="login" />
								</div>
							</div>
							<div class="form-group">
								<label for="txtPass" class="col-sm-2 control-label">Senha</label>
								<div class="col-sm-10">
									<input type="password" id="txtPass" name="senha"
										class="form-control" placeholder="******" />
								</div>
							</div>
							<div class="form-group">
								<button id="btnLogar" name="btnLogar" class="btn btn-primary">Logar</button>
							</div>

							<c:if test="${error != null }">
								<div class="form-group">
									<span class="msg-error">${error}</span>
								</div>
							</c:if>
							<input type="hidden" id="logica" value="Login" name="logica">
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