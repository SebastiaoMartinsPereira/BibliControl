package br.com.newprog.logic.controller;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;

import br.com.newprog.bo.PessoaBO;
import br.com.newprog.bo.UsuarioBO;
import br.com.newprog.model.Pessoa;
import br.com.newprog.model.Usuario;

public class CadastroUsuario implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {

			Usuario usuario = new Usuario();
			Pessoa pessoa = PessoaBO.getInstance().find(Long.parseLong(req.getParameter("usuarios")));
			usuario.setLogin(req.getParameter("login"));
			usuario.setSenha(req.getParameter("senha"));
			usuario.setAdmin(Boolean.parseBoolean(req.getParameter("admin")));
			usuario.setPessoa(pessoa);

			if (req.getParameter("id") != null) {
				usuario.setId(Integer.parseInt(req.getParameter("id")));
				return editar(usuario);
			} else {
				return cadastrar(usuario);
			}

		} catch (ConstraintViolationException ex) {
			req.setAttribute("error", "Violação de regras!");
			return "/view/error.jsp";
		} catch (EntityExistsException ex) {
			req.setAttribute("error", "Esta pessoa já possui usuário cadastrado!");
			return "/view/error.jsp";
		} catch (Exception e) {
			req.setAttribute("error", "Ocorreram problemas durannte a execução!<br/>Contate o administrador");
			return "/view/error.jsp";
		}
	}

	private String cadastrar(Usuario usuario) {
		return UsuarioBO.getInstance().salvar(usuario);
	}

	private String editar(Usuario usuario) {
		return UsuarioBO.getInstance().alterar(usuario);
	}

}
