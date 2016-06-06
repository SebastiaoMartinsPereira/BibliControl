package br.com.newprog.logic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.EmprestimoBO;
import br.com.newprog.model.Emprestimo;

@WebServlet(name = "BuscarEmprestimo", urlPatterns = { "/BuscarEmprestimo" })
public class BuscarEmprestimoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BuscarEmprestimoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		StringBuilder out = new StringBuilder();

		if (!"".equals(request.getParameter("id"))) {
			List<List> itens = EmprestimoBO.getInstance().getEmprestimo((Long.parseLong(request.getParameter("id"))));

			out.append("{");

			for (int i = 0; i < itens.size(); i++) {

				if (i == itens.size() - 1) {
					out.append(
							String.format(" \"%d\":{\"id\":\"%s\",\"dataDevolucao\":\"%s\",\"dataEmprestimo\":\"%s\",\"item_id\":\"%s\",\"pessoa_id\":\"%s\"}",
									i,itens.get(i).get(0), itens.get(i).get(1), itens.get(i).get(2),itens.get(i).get(3),itens.get(i).get(4)));
				} else {
					out.append(String.format(" \"%d\":{\"id\":\"%s\",\"dataDevolucao\":\"%s\",\"dataEmprestimo\":\"%s\",\"item_id\":\"%s\",\"pessoa_id\":\"%s\"},",
							i,itens.get(i).get(0), itens.get(i).get(1), itens.get(i).get(2),itens.get(i).get(3),itens.get(i).get(4)));
				}

			}
			out.append("}");

		}

		System.out.println(out.toString());
		PrintWriter _out = response.getWriter();
		_out.println(out.toString());
		_out.close();
	}

}
