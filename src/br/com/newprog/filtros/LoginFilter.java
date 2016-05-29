package br.com.newprog.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/view/*")
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
 
		if (((HttpServletRequest) request).getSession().getAttribute("usuario") != null) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("../login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		 
	}

}
