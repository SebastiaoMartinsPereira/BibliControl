package br.com.newprog.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/AdicionaPessoaController")
public class AdicionaPessoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AdicionaPessoaController() {
        super();
         
    }

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pessoa adicinada com sucesso");
	}

}
