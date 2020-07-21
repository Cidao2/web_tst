package br.com.cidao.web_tst.persistencia.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cidao.web_tst.persistencia.DAO.UsuarioDAO;
import br.com.cidao.web_tst.persistencia.entitade.Usuario;

@SuppressWarnings("serial")
@WebServlet("/usuctrl.do")
public class UsuarioController extends HttpServlet{
	static UsuarioDAO xDAO = new UsuarioDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ac = req.getParameter("ac");
		if (ac.equals("lst")) {
			List<Usuario> lx = xDAO.buscarTodos();
			req.setAttribute("lx", lx);
			req.getRequestDispatcher("WEB-INF/listaUsu.jsp").forward(req, resp);;
		}else if (ac.equals("excl")){
			String id = req.getParameter("id");
			Usuario x = new Usuario();
			if (id!=null) {x.setId(Integer.parseInt(id));}
			xDAO.excluir(x);
			System.out.println("Excluido com Sucesso o id : " + id);
			//resp.getWriter().print("<b>Sucesso Exclussão</b>");
			resp.sendRedirect("usuctrl.do?ac=lst");
		}else if(ac.equals("alt")) {
			Usuario ub = xDAO.buscarPorId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("ub", ub);
			req.getRequestDispatcher("WEB-INF/frmUsu.jsp").forward(req, resp);;
		}else if (ac.equals("cad")) {
			Usuario ub = new Usuario(0,"","","");
			req.setAttribute("ub", ub);
			req.getRequestDispatcher("WEB-INF/frmUsu.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario x = new Usuario(
				req.getParameter("nome"),
				req.getParameter("login"),
				req.getParameter("senha"));
		String id = req.getParameter("id");
		if (id!=null) {x.setId(Integer.parseInt(id));}
		x = xDAO.salvar(x);

		//System.out.println("Salvo com sucesso : " + x);
		//resp.getWriter().print("<b>Sucesso</b>");

		resp.sendRedirect("usuctrl.do?ac=lst");
	}
}
