package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogicaPessoa implements Logic{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		System.out.println("passei na lçogica");
		
		return null;
	}

}
