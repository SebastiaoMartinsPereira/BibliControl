package br.com.newprog.logic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.PessoaBO;

@WebServlet(name = "ListarPessoas", urlPatterns = { "/ListarPessoas" })
public class ListarPessoasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarPessoasServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("rawtypes")
		List<List> pessoas = PessoaBO.getInstance().getNomeIdPessoa(request.getParameter("pessoa_nome").toString());

		// request.setAttribute("lista", pessoas);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		StringBuilder out = new StringBuilder();
		out.append("{");

		for (int i = 0; i < pessoas.size(); i++) {

			if (i == pessoas.size() - 1) {
				out.append(String.format(" \"%d\":{\"id\":\"%s\",\"nome\":\"%s\",\"tipo\":\"%s\"}",i, pessoas.get(i).get(0),pessoas.get(i).get(1),pessoas.get(i).get(2)));
			} else {
				out.append(String.format(" \"%d\":{\"id\":\"%s\",\"nome\":\"%s\",\"tipo\":\"%s\"},",i, pessoas.get(i).get(0),pessoas.get(i).get(1),pessoas.get(i).get(2)));
			}

		}
		out.append("}");
		System.out.println(out.toString());
		PrintWriter _out = response.getWriter();
		_out.println(out.toString());
		_out.close();

	}
}
