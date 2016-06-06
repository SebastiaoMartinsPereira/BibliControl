package br.com.newprog.logic.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.EmprestimoBO;
import br.com.newprog.bo.ItemBO;
import br.com.newprog.model.Emprestimo;
import br.com.newprog.model.Item;

public class ReceberItem implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Emprestimo obj = new Emprestimo();
		Item item = new Item();
		
		obj = EmprestimoBO.getInstance().find(Integer.parseInt(req.getParameter("id")));
		
		if (obj.getId() > 0){			
			obj.setEntregue(true);
			obj.setDataDevoluvao(new Date());
			item = ItemBO.getInstance().find(obj.getItem_id());
			item.setEmprestado(false);
			ItemBO.getInstance().alterar(item);
			
			return EmprestimoBO.getInstance().alterar(obj);
		}
		
		return "";
	}
}
