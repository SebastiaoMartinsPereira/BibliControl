package br.com.newprog.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.bo.UsuarioBO;
import br.com.newprog.model.Usuario;

public class Login  implements Logic {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Usuario obj = new Usuario();
		obj.setLogin(req.getParameter("login"));
		obj.setSenha(req.getParameter("senha"));
        
		obj = verificarlogin(obj);
		
		if(obj.getId() > 0){
			req.setAttribute("usuario",obj );
			req.getSession().setAttribute("usuario", obj);
			return "/view/home.jsp";
		}
		return "/view/error.jsp";  	
	}

	private Usuario verificarlogin(Usuario obj) {
		return UsuarioBO.getInstance().getUsuario(obj);
	}

}
