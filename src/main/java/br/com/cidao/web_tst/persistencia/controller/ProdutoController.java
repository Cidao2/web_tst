package br.com.cidao.web_tst.persistencia.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cidao.web_tst.persistencia.DAO.ProdutoDAO;
import br.com.cidao.web_tst.persistencia.entitade.Produto;

@SuppressWarnings("serial")
@WebServlet("/prodctrl.do")
public class ProdutoController extends HttpServlet{
	static ProdutoDAO xDAO = new ProdutoDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ac = req.getParameter("ac");
		if (ac.equals("lst")) {
			List<Produto> lx = xDAO.buscarTodos();
			req.setAttribute("lx", lx);
			req.getRequestDispatcher("WEB-INF/listaProd.jsp").forward(req, resp);;
		}else if (ac.equals("excl")){
			String id = req.getParameter("id");
			Produto x = new Produto();
			if (id!=null) {x.setId(Integer.parseInt(id));}
			xDAO.excluir(x);
			System.out.println("Excluido com Sucesso o id : " + id);
			//resp.getWriter().print("<b>Sucesso Exclussão</b>");
			resp.sendRedirect("prodctrl.do?ac=lst");
		}else if(ac.equals("alt")) {
			Produto prodb = xDAO.buscarPorId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("prodb", prodb);
			req.getRequestDispatcher("WEB-INF/frmProd.jsp").forward(req, resp);;
		}else if (ac.equals("cad")) {
			Produto prodb = new Produto();
			prodb.setId(0);
			req.setAttribute("prodb", prodb);
			req.getRequestDispatcher("WEB-INF/frmProd.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Produto x = new Produto(
				req.getParameter("nome"),
				Double.parseDouble( req.getParameter("valor_vda")),
				Double.parseDouble( req.getParameter("valor_custo")),
				Double.parseDouble( req.getParameter("peso")),
				Double.parseDouble( req.getParameter("estoque")),
				Double.parseDouble( req.getParameter("qtd_minima")));
		String id = req.getParameter("id");
		if (id!=null) {x.setId(Integer.parseInt(id));}
		xDAO.salvar(x);

		//System.out.println("Salvo com sucesso : " + x);
		//resp.getWriter().print("<b>Sucesso</b>");
	}
}
