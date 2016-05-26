package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.PessoaBO;
import br.com.newprog.model.Pessoa;
import br.com.newprog.model.Enums.TipoPessoa;

public class CadastroPessoa implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Pessoa pessoa = new Pessoa.PessoaBuilder(req.getParameter("nome"), req.getParameter("cpf"))
				.comCelular(req.getParameter("telcelular")).comEmail(req.getParameter("email"))
				.comRg(req.getParameter("rg")).comTel(req.getParameter("telfixo"))
				.comTipo(TipoPessoa.fromInteger(Integer.parseInt(req.getParameter("rdTipoPessoa")))).builder();

		cadastrar(pessoa);
		return "/view/sucesso.jsp";
	}

	private void cadastrar(Pessoa pessoa) {
		PessoaBO.getInstance().salvar(pessoa);
	}
}
