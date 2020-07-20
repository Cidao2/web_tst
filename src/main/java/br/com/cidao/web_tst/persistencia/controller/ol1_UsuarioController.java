package br.com.cidao.web_tst.persistencia.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cidao.web_tst.persistencia.DAO.UsuarioDAO;
import br.com.cidao.web_tst.persistencia.entitade.Usuario;

@WebServlet("/ol1usuctrl.do")
public class ol1_UsuarioController extends HttpServlet{

	public ol1_UsuarioController() {
		System.out.println("Construtor....");
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init ....");
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//System.out.println("chamou o doGet   " + req);
		// http://localhost:8080/web_tst/usuctrl.do?nome=getNome&login=getlogin&senha=getSenha
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		Usuario x = new Usuario(req.getParameter("nome"),
				req.getParameter("login"),req.getParameter("senha"));
		UsuarioDAO xDAO = new UsuarioDAO();
		x = xDAO.salvar(x);

		System.out.println("Salvo com sucesso : " + x);
		resp.getWriter().print("<b>Sucesso</b>");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy ......");
		super.destroy();
	}
}
