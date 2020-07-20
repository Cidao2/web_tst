package conexao;

import java.util.List;

import br.com.cidao.web_tst.persistencia.DAO.ProdutoDAO;
import br.com.cidao.web_tst.persistencia.entitade.Produto;

public class TesteProdutoDAO {

	static ProdutoDAO xDAO;

	public static void main(String[] args) {
		xDAO = new ProdutoDAO();

		testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		//testeBuscarPorId();
		testeBuscarTodos();
	}
	
	public static void testeCadastrar() {
		Produto x = new Produto("nome tst 03", 10.0, 20.0, 30.0, 40.0, 50.0);
		xDAO.salvar(x);
		System.out.println("Cadastrado com sucesso=> " + x);
	}

	public static void testeAlterar() {
		Produto x = new Produto("nome ALTERADO tst 01", 10.0, 20.0, 30.0, 40.0, 50.0);
		x.setId(1);
		xDAO.salvar(x);
		System.out.println("Alterado com sucesso" + x);
	}
	
	public static void testeExcluir() {
		Produto x = new Produto();
		x.setId(1);
		xDAO.excluir(x);
		System.out.println("Excluido com sucesso");
	}
	
	public static void testeBuscarPorId() {
		Produto x = xDAO.buscarPorId(1);
		System.out.println(x);
	}
	
	public static void testeBuscarTodos() {
		List<Produto> l = xDAO.buscarTodos();
		for (Produto x : l) {
			System.out.println(x);
		}
	}
	//============  FIM  ==============
}
