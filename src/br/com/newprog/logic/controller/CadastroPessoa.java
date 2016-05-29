package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.PessoaBO;
import br.com.newprog.bo.UsuarioBO;
import br.com.newprog.model.Pessoa;
import br.com.newprog.model.Usuario;
import br.com.newprog.model.Enums.TipoPessoa;

public class CadastroPessoa implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Pessoa pessoa = new Pessoa.PessoaBuilder(req.getParameter("nome"), req.getParameter("cpf"))
				.comCelular(req.getParameter("telcelular")).comEmail(req.getParameter("email"))
				.comRg(req.getParameter("rg")).comTel(req.getParameter("telfixo"))
				.comTipo(TipoPessoa.fromInteger(Integer.parseInt(req.getParameter("rdTipoPessoa")))).builder();

		if (req.getParameter("id") != null && req.getParameter("id") != "") {

			if (req.getParameter("id_usuario") != null && req.getParameter("id_usuario") != "") {
				Usuario usuario = UsuarioBO.getInstance().find(Integer.parseInt(req.getParameter("id_usuario")));
				pessoa.setUsuario(usuario);
			}
			pessoa.setId(Integer.parseInt(req.getParameter("id")));
			return editar(pessoa);
		} else {
			return cadastrar(pessoa);
		}
	}

	private String cadastrar(Pessoa pessoa) {
		return PessoaBO.getInstance().salvar(pessoa);
	}

	private String editar(Pessoa pessoa) {
		return PessoaBO.getInstance().alterar(pessoa);
	}

}
