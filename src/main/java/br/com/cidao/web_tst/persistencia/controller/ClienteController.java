package br.com.cidao.web_tst.persistencia.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cidao.web_tst.persistencia.DAO.CidadeDAO;
import br.com.cidao.web_tst.persistencia.DAO.ClienteDAO;
import br.com.cidao.web_tst.persistencia.entitade.Cliente;

@SuppressWarnings("serial")
@WebServlet("/clictrl.do")
public class ClienteController extends HttpServlet{
	static ClienteDAO xDAO = new ClienteDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ac = req.getParameter("ac");
		if (ac.equals("lst")) {
			List<Cliente> lx = xDAO.buscarTodos();
			req.setAttribute("lx", lx);
			req.getRequestDispatcher("WEB-INF/listaClientes.jsp").forward(req, resp);;
		}else if (ac.equals("excl")){
			String id = req.getParameter("id");
			Cliente x = new Cliente();
			if (id!=null) {x.setId(Integer.parseInt(id));}
			xDAO.excluir(x);
			System.out.println("Excluido com Sucesso o id : " + id);
			//resp.getWriter().print("<b>Sucesso Exclussão</b>");
			resp.sendRedirect("clictrl.do?ac=lst");
		}else if(ac.equals("alt")) {
			Cliente cliente_b = xDAO.buscarPorId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("cliente_b", cliente_b);
			req.getRequestDispatcher("WEB-INF/frmCliente.jsp").forward(req, resp);;
		}else if (ac.equals("cad")) {
			Cliente cliente_b = new Cliente();
			cliente_b.setId(0);
			req.setAttribute("cliente_b", cliente_b);
			req.getRequestDispatcher("WEB-INF/frmCliente.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente x = new Cliente(
				req.getParameter("nome"),
				req.getParameter("endereco"),
				req.getParameter("cep"),
				req.getParameter("email"),
				req.getParameter("cpf"),
				req.getParameter("rg"));
		x.setCidade( new CidadeDAO().buscarPorId( Integer.parseInt( req.getParameter("cidade") )) );
		String id = req.getParameter("id");
		if (id!=null) {x.setId(Integer.parseInt(id));}
		xDAO.salvar(x);

		resp.sendRedirect("prodctrl.do?ac=lst");
	}
}
