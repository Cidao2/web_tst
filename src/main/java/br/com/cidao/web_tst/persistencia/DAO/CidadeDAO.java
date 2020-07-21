package br.com.cidao.web_tst.persistencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cidao.web_tst.persistencia.entitade.Cidade;
import br.com.cidao.web_tst.persistencia.jdbc.ConexaoFactory;

public class CidadeDAO {

	private Connection con;

	/**
	 * construtor
	 * Obtendo uma conexao com Banco
	 */
	public CidadeDAO() {
		con= ConexaoFactory.getConnection();
	}

	/**
	 *  Metodo Cadastrar
	 * @param Cidade
	 */
	public void cadastrar(Cidade x){
		String sql = "insert into cidade (nome, uf) values (?, ? )";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setString(1, x.getNome());
			p.setString(2, x.getUf());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo Alterar
	 * @param Cidade
	 */
	public void alterar(Cidade x) {
		String sql = "update cidade set nome =?, uf=? where id=?";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setString(1, x.getNome());
			p.setString(2, x.getUf());
			p.setInt(3, x.getId());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Alterar ou Cadastrar dependendo do id
	 * @param Cidade
	 * @return Cidade buscando pela autenticacao cidade e senha precisa alterar bco para ter um unico cidade
	 */
	public void salvar(Cidade x) {
		
		if (x.getId()!=null && x.getId()>0) {
			alterar(x);
		}else {
			cadastrar(x);
		}
	}

	/**
	 * Metodo Excluir
	 * @param Cidade
	 */
	public void excluir(Cidade x) {
		String sql = "delete from cidade where id=?";
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
	 * @return Cidade ou null
	 */
	public Cidade buscarPorId (Integer id) {
		Cidade x = null;
		String sql = "select * from cidade where id=?";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			if (r.next()) {
				x = new Cidade();
				x.setId(r.getInt("id"));
				x.setNome(r.getString("nome"));
				x.setUf(r.getString("uf"));
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
	 * @return lista de Cidades
	 */
	public List<Cidade> buscarTodos(){
		List<Cidade> l = new ArrayList<Cidade>();
		String sql = "select * from cidade";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Cidade x = new Cidade();
				x.setId(r.getInt("id"));
				x.setNome(r.getString("nome"));
				x.setUf(r.getString("uf"));
				l.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
		return l;
	}
	// ============  FIM  =============
}
