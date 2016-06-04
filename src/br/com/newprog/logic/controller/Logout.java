package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.getSession().setAttribute("usuario", null);
		return "/login.jsp";
	}

}