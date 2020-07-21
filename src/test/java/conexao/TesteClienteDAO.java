package conexao;

import java.util.List;

import br.com.cidao.web_tst.persistencia.DAO.CidadeDAO;
import br.com.cidao.web_tst.persistencia.DAO.ClienteDAO;
import br.com.cidao.web_tst.persistencia.entitade.Cliente;

public class TesteClienteDAO {

	static ClienteDAO xDAO = new ClienteDAO();

	public static void main(String[] args) {
		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		testeBuscarTodos();
		testeBuscarPorId();
	}

	public static void testeCadastrar() {
		Cliente x = new Cliente(
				null, //id
				"nome 9", //nome
				"endereco 9", //endereco
				"cep 9", //cep
				new CidadeDAO().buscarPorId(9),
				"email 9", //email
				"cpf 9", //cpf
				"rg 9" //rg
				);
		xDAO.salvar(x);
		System.out.println("Cadastrado com sucesso=> " + x);
	}

	public static void testeAlterar() {
		Cliente x = new Cliente(
				5,  //id
				"nome 5", //nome
				"endereco 5", //endereco
				"cep 5", // cep
				new CidadeDAO().buscarPorId(5),
				"email 5", //email
				"cpf 5", //cpf
				"rg 5" //rg
				);
		xDAO.salvar(x);
		System.out.println("Alterado com sucesso" + x);
	}
	
	public static void testeExcluir() {
		Cliente x = new Cliente();
		x.setId(3);
		xDAO.excluir(x);
		System.out.println("Excluido com sucesso");
	}
	
	public static void testeBuscarPorId() {
		System.out.println(xDAO.buscarPorId(4));
	}
	
	public static void testeBuscarTodos() {
		List<Cliente> l = xDAO.buscarTodos();
		for (Cliente x : l) {
			System.out.println(x);
		}
	}
	//=========  FIM  ==========
	/*
		x.setCidade( new CidadeDAO().buscarPorId(6));
		x.setId(6);
	 */
}
