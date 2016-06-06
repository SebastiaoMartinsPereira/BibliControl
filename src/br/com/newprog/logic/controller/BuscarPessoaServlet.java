package br.com.newprog.logic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.PessoaBO;
import br.com.newprog.model.Pessoa;

@WebServlet(name = "BuscarPessoa", urlPatterns = { "/BuscarPessoa" })
public class BuscarPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setAttribute("lista", pessoas);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		StringBuilder out = new StringBuilder();

		if (!"".equals(request.getParameter("id"))) {
			Pessoa pessoa = PessoaBO.getInstance().find(Integer.parseInt(request.getParameter("id")));
			out.append("{ \"d\" : ");
			out.append(String.format("{\"id\":\"%s\",\"nome\":\"%s\"}", pessoa.getId(), pessoa.getNome()));
			out.append("}");
		}

		/*
		 * out.append("{");
		 * 
		 * for (int i = 0; i < itens.size(); i++) {
		 * 
		 * String especial =
		 * Boolean.parseBoolean(itens.get(i).get(3).toString()) == true ? "SIM"
		 * : "NÃO";
		 * 
		 * if (i == itens.size() - 1) { out.append(String.format(
		 * " \"%d\":{\"id\":\"%s\",\"nome\":\"%s\",\"tipo\":\"%s\",\"especial\":\"%s\"}"
		 * , i, itens.get(i).get(0), itens.get(i).get(1), itens.get(i).get(2),
		 * especial)); } else { out.append(String.format(
		 * " \"%d\":{\"id\":\"%s\",\"nome\":\"%s\",\"tipo\":\"%s\",\"especial\":\"%s\"},"
		 * , i, itens.get(i).get(0), itens.get(i).get(1), itens.get(i).get(2),
		 * especial)); }
		 * 
		 * } out.append("}");
		 */

		System.out.println(out.toString());
		PrintWriter _out = response.getWriter();
		_out.println(out.toString());
		_out.close();
	}

}
