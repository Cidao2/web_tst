package br.com.cidao.web_tst.persistencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cidao.web_tst.persistencia.entitade.Usuario;
import br.com.cidao.web_tst.persistencia.jdbc.ConexaoFactory;

public class UsuarioDAO {

	private Connection con;

	/**
	 * construtor
	 * Obtendo uma conexao com Banco
	 */
	public UsuarioDAO() {
		con= ConexaoFactory.getConnection();
	}

	/**
	 *  Metodo Cadastrar
	 * @param Usuario
	 */
	public void cadastrar(Usuario x){
		String sql = "insert into usuario (nome, login, senha) values (?, ? ,md5(?) )";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setString(1, x.getNome());
			p.setString(2, x.getLogin());
			p.setString(3, x.getSenha());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo Alterar
	 * @param Usuario
	 */
	public void alterar(Usuario x) {
		String sql = "update usuario set nome =?, login=?, senha=md5(?) where id=?";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setString(1, x.getNome());
			p.setString(2, x.getLogin());
			p.setString(3, x.getSenha());
			p.setInt(4, x.getId());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Alterar ou Cadastrar dependendo do id
	 * @param Usuario
	 * @return Usuario buscando pela autenticacao usuario e senha precisa alterar bco para ter um unico usuario
	 */
	public Usuario salvar(Usuario x) {
		
		if (x.getId()!=null && x.getId()>0) {
			alterar(x);
		}else {
			cadastrar(x);
		}
		return autenticar(x);
	}

	/**
	 * Metodo Excluir
	 * @param Usuario
	 */
	public void excluir(Usuario x) {
		String sql = "delete from usuario where id=?";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setInt(1, x.getId());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * buscar por id
	 * @param id
	 * @return Usuario ou null
	 */
	public Usuario buscarPorId (Integer id) {
		Usuario x = null;
		String sql = "select * from usuario where id=?";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			if (r.next()) {
				x = new Usuario();
				x.setId(r.getInt("id"));
				x.setNome(r.getString("nome"));
				x.setLogin(r.getString("login"));
				x.setSenha(r.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
		return x;
	}
	
	/**
	 * buscar todos
	 * poderia retornar null caso nao encontrasse para analisar
	 * @return lista de Usuarios
	 */
	public List<Usuario> buscarTodos(){
		List<Usuario> l = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Usuario x = new Usuario();
				x.setId(r.getInt("id"));
				x.setNome(r.getString("nome"));
				x.setLogin(r.getString("login"));
				x.setSenha(r.getString("senha"));
				l.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
		return l;
	}

	/**
	 * autenticar
	 * @param usario com login e senha
	 * @return usuario com parametros acima
	 */
	public Usuario autenticar(Usuario xc) {
		Usuario x = null;
		String sql = "select * from usuario where login=? and senha=md5(?)";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setString(1, xc.getLogin());
			p.setString(2, xc.getSenha());
			ResultSet r = p.executeQuery();
			if (r.next()) {
				x = new Usuario();
				x.setId(r.getInt("id"));
				x.setNome(r.getString("nome"));
				x.setLogin(r.getString("login"));
				x.setSenha(r.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
		return x;
	}
}
