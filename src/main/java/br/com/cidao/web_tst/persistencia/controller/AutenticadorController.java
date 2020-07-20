package br.com.cidao.web_tst.persistencia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cidao.web_tst.persistencia.DAO.UsuarioDAO;
import br.com.cidao.web_tst.persistencia.entitade.Usuario;

@SuppressWarnings("serial")
@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet {
	static UsuarioDAO xDAO = new UsuarioDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession sessao = req.getSession(false);
		 if(sessao!=null) {
			 sessao.invalidate();
		 }
		resp.sendRedirect("login.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuAut = new Usuario("", req.getParameter("login"), req.getParameter("senha"));
		usuAut = xDAO.autenticar(usuAut);
		if (usuAut != null) {
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuAut", usuAut);
			sessao.setMaxInactiveInterval(60 * 5);
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		} else {
			// resp.getWriter().print("<script> window.alert ('Não encontrado!');
			// location.href='login.html'; </script>");
			resp.sendRedirect("login.html");
		}
	}

}