package br.com.cidao.web_tst.persistencia.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//todos urls e todos as requisicao
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST} , urlPatterns="/*")
public class FiltroAutenticacao implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//casting do servlet para http
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		//captura qualquer url digitada
		String uri = httpRequest.getRequestURI();
		//captura sessao
		HttpSession sessao = httpRequest.getSession(false);
		
		/**
		 * poderia refinar o filtro buscando na sessao se tem usuario 
		 */
		
		//o indexoff consulta a uri retorna -1 , se existir retorna a posicao na variavel
		if (sessao!=null || // se existir sessao passa  ou
			uri.indexOf("login.html")!=-1 || // se na url tiver login.html ou
			uri.indexOf("autenticador.do")!=-1) { // se na url tiver autenticador.do

			//deixa passar
			chain.doFilter(request, response);
		}else {
			httpResponse.sendRedirect("login.html");  // qualquer outra coisa chama tela de login
		}
		
	}

	@Override
	public void destroy() {
	}

}
