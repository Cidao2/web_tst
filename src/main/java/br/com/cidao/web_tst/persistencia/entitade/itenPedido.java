package br.com.cidao.web_tst.persistencia.entitade;

public class itenPedido {

	private Integer id;
	private Produto produto;
	private String nome;
	private Double valor;
	/*
	 * construtor
	 */
	public itenPedido(String nome, Double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	public itenPedido() {
	}
	/**
	 * get set
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	/*
	 * 	to string
	 */
	@Override
	public String toString() {
		return "itenPedido [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}
	
}
