package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.PessoaBO;
import br.com.newprog.model.Pessoa;

public class DeletarPessoa implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {
			Pessoa pessoa = PessoaBO.getInstance().find(Long.parseLong(req.getParameter("id")));
			deletar(pessoa);
			return "/view/listaPessoas.jsp";
		} catch (Exception e) {
			return "/view/error.jsp?error=1";
		}
	}

	private void deletar(Pessoa pessoa) {
		PessoaBO.getInstance().remover(pessoa);
	}

}
