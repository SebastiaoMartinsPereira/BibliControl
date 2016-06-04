package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.UsuarioBO;
import br.com.newprog.model.Usuario;

public class EditarUsuario implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {
			Usuario usuario = UsuarioBO.getInstance().getById(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("us_editar", usuario);
			req.setAttribute("editar", true);
			return "/view/cadastroUsuario.jsp";
		} catch (Exception e) {
			return "/view/error.jsp?error=1";
		}
	}
}
