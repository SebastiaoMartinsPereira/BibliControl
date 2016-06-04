package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.UsuarioBO;
import br.com.newprog.model.Usuario;

public class DeletarUsuario implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {
			Usuario usuario = UsuarioBO.getInstance().find(Long.parseLong(req.getParameter("id")));
			deletar(usuario);
			return "/view/listaUsuarios.jsp";
		} catch (Exception e) {
			return "/view/error.jsp?error=1";
		}
	}

	private void deletar(Usuario usuario) {
		UsuarioBO.getInstance().remover(usuario);
	}
}
