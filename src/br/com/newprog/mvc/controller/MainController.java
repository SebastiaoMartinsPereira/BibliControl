package br.com.newprog.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.newprog.logic.controller.Logic;


@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		/*recebe o parametro enviado na requisi��o*/
		String parametro = req.getParameter("logic");
        /*monta o caminho para a clase de logica solicitada*/
		String nomeDaClasse = "br.com.newprog.logic." + parametro;
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Logic logica = (Logic) classe.newInstance();
			String pagina = logica.executa(req, res);
			req.getRequestDispatcher(pagina).forward(req, res);
		} catch (Exception e) {
			throw new ServletException(
					"A l�gica de neg�cios causou uma exce��o", e);
		}

		super.service(req , res);
	}
}
