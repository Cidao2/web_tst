package br.com.cidao.web_tst.persistencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cidao.web_tst.persistencia.entitade.Cliente;
import br.com.cidao.web_tst.persistencia.jdbc.ConexaoFactory;

public class ClienteDAO {

	private Connection con;
	/**
	 * construtor
	 * Obtendo uma conexao com Banco
	 */
	public ClienteDAO() {
		con= ConexaoFactory.getConnection();
	}

	/**
	 *  Metodo Cadastrar
	 * @param Cliente
	 */
	public void cadastrar(Cliente x){
		String sql = "insert into cliente (nome, endereco, cep, cidade, email, cpf, rg) values (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setString(1, x.getNome());
			p.setString(2, x.getEndereco());
			p.setString(3, x.getCep());
			p.setInt(4, x.getCidade().getId() );
			p.setString(5, x.getEmail());
			p.setString(6, x.getCpf());
			p.setString(7, x.getRg());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo Alterar
	 * @param Cliente
	 */
	public void alterar(Cliente x) {
		String sql = "update cliente set nome =?, endereco=?, cep=?, cidade=?, email=?, cpf=?, rg=? where id=?";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setString(1, x.getNome());
			p.setString(2, x.getEndereco());
			p.setString(3, x.getCep());
			p.setInt(4, x.getCidade().getId() );
			p.setString(5, x.getEmail());
			p.setString(6, x.getCpf());
			p.setString(7, x.getRg());
			p.setInt(8, x.getId());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Alterar ou Cadastrar dependendo do id
	 * @param Cliente
	 * @return Cliente buscando pela autenticacao cliente e senha precisa alterar bco para ter um unico cliente
	 */
	public void salvar(Cliente x) {
		
		if (x.getId()!=null && x.getId()>0) {
			alterar(x);
		}else {
			cadastrar(x);
		}
	}

	/**
	 * Metodo Excluir
	 * @param Cliente
	 */
	public void excluir(Cliente x) {
		String sql = "delete from cliente where id=?";
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
	 * @return Cliente ou null
	 */
	
	public Cliente buscarPorId (Integer id) {

		Cliente x = null;
		String sql = "select * from cliente where id=?";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			if (r.next()) {
				x = new Cliente(
						r.getInt("id"),
						r.getString("nome"),
						r.getString("endereco"),
						r.getString("cep"),
new CidadeDAO().buscarPorId(r.getInt("cidade") ),
						r.getString("email"),
						r.getString("cpf"),
						r.getString("rg")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	/**
	 * buscar todos
	 * poderia retornar null caso nao encontrasse para analisar
	 * @return lista de Clientes
	 */
	public List<Cliente> buscarTodos(){
		List<Cliente> l = new ArrayList<Cliente>();
		String sql = "select * from cliente";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Cliente x = new Cliente(
								r.getInt("id"),
								r.getString("nome"),
								r.getString("endereco"),
								r.getString("cep"),
	new CidadeDAO().buscarPorId(r.getInt("cidade") ),
								r.getString("email"),
								r.getString("cpf"),
								r.getString("rg")
								);
				l.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	// ============  FIM  =============
/*
	String sql = "update cliente set nome =?, endereco=?, cep=?, email=?, cpf=?, rg=?, cidade=? where id=?";
	x.setCidade(new CidadeDAO().buscarPorId(r.getString("cep")););
	x.setCidade( Integer.parseInt( new CidadeDAO().buscarPorId(   r.getString("cidade"))));
	String sqlcid = "select * from cidade inner join cidade on cliente.cidade = cidade.id where id=?";
	throw new RuntimeException(e);

				x.setId(		r.getInt(	"id"		));
				x.setNome(		r.getString("nome"		));
				x.setEndereco(	r.getString("endereco"	));
				x.setCep(		r.getString("cep"		));
				x.setCidade(
	new CidadeDAO().buscarPorId(r.getInt(	"cidade") 	));
				x.setEmail(		r.getString("email"		));
				x.setCpf(		r.getString("cpf"		));
				x.setRg(		r.getString("rg"		));
 */
}
