package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.PessoaBO;
import br.com.newprog.model.Pessoa;

public class EditarPessoa implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {
			Pessoa pessoa = PessoaBO.getInstance().find(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("pessoa_editar", pessoa);
			req.setAttribute("editar", true);
			return "/view/cadastroPessoa.jsp";
		} catch (Exception e) {
			return "/view/error.jsp";
		}
	}

}
