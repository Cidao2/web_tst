package conexao;

import java.util.List;

import br.com.cidao.web_tst.persistencia.DAO.CidadeDAO;
import br.com.cidao.web_tst.persistencia.entitade.Cidade;

public class TesteCidadeDAO {

	static CidadeDAO xDAO;

	public static void main(String[] args) {
		xDAO = new CidadeDAO();

		//testeCadastrar();
		testeAlterar();
		//testeExcluir();
		testeBuscarPorId();
		testeBuscarTodos();
	}
	
	public static void testeCadastrar() {
		Cidade x = new Cidade(null, "Belo Horizonte","MG");
		xDAO.salvar(x);
		System.out.println("Cadastrado com sucesso=> " + x);
	}

	public static void testeAlterar() {
		Cidade x = new Cidade(1, "Atibaia","SP");
		xDAO.salvar(x);
		System.out.println("Alterado com sucesso" + x);
	}
	
	public static void testeExcluir() {
		Cidade x = new Cidade();
		x.setId(1);
		xDAO.excluir(x);
		System.out.println("Excluido com sucesso");
	}
	
	public static void testeBuscarPorId() {
		Cidade x = xDAO.buscarPorId(1);
		System.out.println(x);
	}
	
	public static void testeBuscarTodos() {
		List<Cidade> l = xDAO.buscarTodos();
		for (Cidade x : l) {
			System.out.println(x);
		}
	}
	//=========  FIM  ==========
}
