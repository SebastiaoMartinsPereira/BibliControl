package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.ItemBO;
import br.com.newprog.model.Item;

public class EditarItem implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {
			Item item = ItemBO.getInstance().find(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("item_editar", item);
			return "/view/cadastroItem.jsp";
		} catch (Exception e) {
			return "/view/error.jsp";
		}
	}
}
