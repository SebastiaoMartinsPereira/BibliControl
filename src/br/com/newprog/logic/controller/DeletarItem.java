package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.newprog.bo.ItemBO;
import br.com.newprog.model.Item;

public class DeletarItem implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {
			Item item = ItemBO.getInstance().find(Long.parseLong(req.getParameter("id")));
			deletar(item);
			return "/view/listaItens.jsp";
		} catch (Exception e) {
			return "/view/error.jsp";
		}
	}

	private void deletar(Item item) {
		ItemBO.getInstance().remover(item);
	}
}
