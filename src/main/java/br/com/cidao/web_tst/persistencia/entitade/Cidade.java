package br.com.cidao.web_tst.persistencia.entitade;

public class Cidade {
	private Integer id;
	private String nome;
	private Estado estado;
	/*
	 * construtor
	 */
	public Cidade(String cidade, Estado estado) {
		this.nome = cidade;
		this.estado = estado;
	}
	public Cidade() {
	}
	/*
	 * get set
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCidade() {
		return nome;
	}
	public void setCidade(String cidade) {
		this.nome = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", cidade=" + nome + ", UF=" + estado + "]";
	}
}
