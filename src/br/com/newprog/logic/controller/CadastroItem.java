package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.ItemBO;
import br.com.newprog.model.Item;
import br.com.newprog.model.Enums.TipoItem;

public class CadastroItem implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		Item obj = new Item();
		obj.setCodigoInterno(req.getParameter("codigoInterno"));
		obj.setDescricao(req.getParameter("descricao"));
		obj.setEspecial( Boolean.parseBoolean(req.getParameter("especial")));
		obj.setTipo(TipoItem.fromInteger(Integer.parseInt(req.getParameter("tipo"))));
		
		cadastrar(obj);
		req.setAttribute("sucesso","Item incluso com sucesso");
		return "/view/sucesso.jsp";
	}
	
	private void cadastrar(Item obj){
		ItemBO.getInstance().salvar(obj);
	}
	

}
