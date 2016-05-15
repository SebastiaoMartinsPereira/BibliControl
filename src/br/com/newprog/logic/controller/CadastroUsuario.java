package br.com.newprog.logic.controller;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.NonUniqueObjectException;
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
			usuario.setLogin(req.getParameter("admin"));
			usuario.setLogin(req.getParameter("login"));
			usuario.setSenha(req.getParameter("senha"));
			usuario.setAdmin(Boolean.parseBoolean(req.getParameter("admin")));
			usuario.setPessoa(pessoa);
			cadastrar(usuario);
			return "/view/sucesso.jsp";
		} catch(ConstraintViolationException ex){
			return "/view/error.jsp?error=3";
		}catch (NonUniqueObjectException ex) {
			return "/view/error.jsp?error=4";
		} catch (EntityExistsException ex) {
			return "/view/error.jsp?error=5";
		} catch (Exception e) {
			return "/view/error.jsp?error=1";
		}
	}

	private void cadastrar(Usuario usuario) {
		UsuarioBO.getInstance().salvar(usuario);
	}

}
