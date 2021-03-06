package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.ItemBO;
import br.com.newprog.model.Item;
import br.com.newprog.model.Enums.TipoItem;

public class CadastroItem implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Item obj = new Item();
		obj.setCodigoInterno(req.getParameter("codigoInterno"));
		obj.setDescricao(req.getParameter("descricao"));
		obj.setEspecial(Boolean.parseBoolean(req.getParameter("especial")));
		obj.setTipo(TipoItem.fromInteger(Integer.parseInt(req.getParameter("tipo"))));

		if (req.getParameter("id") != null && req.getParameter("id") != "") {
			obj.setId(Integer.parseInt(req.getParameter("id")));
			return editar(obj);
		} else {
			return cadastrar(obj);
		}
	}

	private String cadastrar(Item obj) {
		return ItemBO.getInstance().salvar(obj);
	}

	private String editar(Item obj) {
		return ItemBO.getInstance().alterar(obj);
	}

}
