package br.com.cidao.web_tst.persistencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cidao.web_tst.persistencia.entitade.Produto;
import br.com.cidao.web_tst.persistencia.jdbc.ConexaoFactory;

public class ProdutoDAO {

	private Connection con;

	/**
	 * construtor
	 * Obtendo uma conexao com Banco
	 */
	public ProdutoDAO() {
		con= ConexaoFactory.getConnection();
	}

	/**
	 *  Metodo Cadastrar
	 * @param Produto
	 */
	public void cadastrar(Produto x){
		String sql = "insert into produto ("
			+ "nome, valor_vda, valor_custo, peso, estoque, qtd_minima"
			+ ") values (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setString(1, x.getNome());
			p.setDouble(2, x.getValor_vda());
			p.setDouble(3, x.getValor_custo());
			p.setDouble(4, x.getPeso());
			p.setDouble(5, x.getEstoque());
			p.setDouble(6, x.getQtd_minima());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo Alterar
	 * @param Produto
	 */
	public void alterar(Produto x) {
		String sql = "update produto set "
				+ "nome =?, valor_vda=?, valor_custo=?, peso=?, estoque=?, qtd_minima=? "
				+ "where id=?";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setString(1, x.getNome());
			p.setDouble(2, x.getValor_vda());
			p.setDouble(3, x.getValor_custo());
			p.setDouble(4, x.getPeso());
			p.setDouble(5, x.getEstoque());
			p.setDouble(6, x.getQtd_minima());
			p.setInt(7, x.getId());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Alterar ou Cadastrar dependendo do id
	 * @param Produto
	 * @return Produto buscando pela autenticacao produto e valor_custo precisa alterar bco para ter um unico produto
	 */
	public void salvar(Produto x) {
		
		if (x.getId()!=null && x.getId()>0) {
			alterar(x);
		}else {
			cadastrar(x);
		}
	}

	/**
	 * Metodo Excluir
	 * @param Produto
	 */
	public void excluir(Produto x) {
		String sql = "delete from produto where id=?";
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
	 * @return Produto ou null
	 */
	public Produto buscarPorId (Integer id) {
		Produto x = null;
		String sql = "select * from produto where id=?";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			if (r.next()) {
				x = new Produto();
				x.setId(r.getInt("id"));
				x.setNome(r.getString("nome"));
				x.setValor_vda(r.getDouble("valor_vda"));
				x.setValor_custo(r.getDouble("valor_custo"));
				x.setPeso(r.getDouble("peso"));
				x.setEstoque(r.getDouble("estoque"));
				x.setQtd_minima(r.getDouble("qtd_minima"));
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
	 * @return lista de Produtos
	 */
	public List<Produto> buscarTodos(){
		List<Produto> l = new ArrayList<Produto>();
		String sql = "select * from produto";
		try (PreparedStatement p =  con.prepareStatement(sql)){
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Produto x = new Produto();
				x.setId(r.getInt("id"));
				x.setNome(r.getString("nome"));
				x.setValor_vda(r.getDouble("valor_vda"));
				x.setValor_custo(r.getDouble("valor_custo"));
				x.setPeso(r.getDouble("peso"));
				x.setEstoque(r.getDouble("estoque"));
				x.setQtd_minima(r.getDouble("qtd_minima"));
				l.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
		return l;
	}
	//=====================  fim  ======================
}
