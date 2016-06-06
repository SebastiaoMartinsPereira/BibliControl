package br.com.newprog.logic.controller;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;

import br.com.newprog.bo.EmprestimoBO;
import br.com.newprog.bo.ItemBO;
import br.com.newprog.bo.PessoaBO;
import br.com.newprog.bo.UsuarioBO;
import br.com.newprog.model.Emprestimo;
import br.com.newprog.model.Item;
import br.com.newprog.model.Pessoa;
import br.com.newprog.model.Usuario;

public class RealizarEmprestimo implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {

			Emprestimo emprestimo = new Emprestimo();

			if (req.getParameter("pessoaid") != null) {

				Pessoa pessoa = PessoaBO.getInstance().find(Long.parseLong(req.getParameter("pessoaid")));
				Item item = ItemBO.getInstance().find(Long.parseLong(req.getParameter("itemid")));
                
				emprestimo.setPessoa_id(pessoa.getId());
				emprestimo.setItem_id(item.getId());
				emprestimo.setDataEmprestimo(new Date());

				Calendar c = Calendar.getInstance();
				c.setTime(emprestimo.getDataEmprestimo());
				c.add(Calendar.DATE, 7);
				emprestimo.setDataDevoluvao(c.getTime());
				item.setEmprestado(true);
				return cadastrar(emprestimo,item);
			} else {
				return "";
			}

		} catch (Exception e) {
			req.setAttribute("error", "Ocorreram problemas durannte a execução!<br/>Contate o administrador");
			return "/view/error.jsp";
		}
	}

	private String cadastrar(Emprestimo emprestimo,Item item) {
		ItemBO.getInstance().alterar(item);
		return EmprestimoBO.getInstance().salvar(emprestimo);
		
	}

	private String editar(Usuario usuario) {
		return UsuarioBO.getInstance().alterar(usuario);
	}

}
