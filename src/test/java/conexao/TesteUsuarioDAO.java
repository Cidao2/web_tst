package conexao;

import java.util.List;

import br.com.cidao.web_tst.persistencia.DAO.UsuarioDAO;
import br.com.cidao.web_tst.persistencia.entitade.Usuario;

public class TesteUsuarioDAO {

	static UsuarioDAO xDAO;

	public static void main(String[] args) {
		xDAO = new UsuarioDAO();

		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		//testeBuscarPorId();
		testeBuscarTodos();
		//testeAutenticar();
	}
	
	public static void testeCadastrar() {
		Usuario x = new Usuario(null, "nome tst 10","log tst 10","sh tst 10");
		Usuario xb = xDAO.salvar(x);
		System.out.println("Cadastrado com sucesso=> " + xb);
	}

	public static void testeAlterar() {
		Usuario x = new Usuario(6, "nome alt 6","log alt 6","sh alt 6");
		Usuario xb = xDAO.salvar(x);
		System.out.println("Alterado com sucesso" + xb);
	}
	
	public static void testeExcluir() {
		Usuario x = new Usuario(5,null,null,null);
		xDAO.excluir(x);
		System.out.println("Excluido com sucesso");
	}
	
	public static void testeBuscarPorId() {
		Usuario x = xDAO.buscarPorId(7);
		System.out.println(x);
	}
	
	public static void testeBuscarTodos() {
		List<Usuario> l = xDAO.buscarTodos();
		for (Usuario x : l) {
			System.out.println(x);
		}
	}
	
	public static void testeAutenticar() {
		Usuario x = new Usuario(null,"jj","123");
		Usuario xb = xDAO.autenticar(x);
		System.out.println(xb);
	}
}
