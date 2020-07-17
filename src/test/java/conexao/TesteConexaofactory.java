package conexao;

import br.com.cidao.web_tst.persistencia.jdbc.ConexaoFactory;

public class TesteConexaofactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConexaoFactory.getConnection();
		System.out.println("ok");
	}

}
