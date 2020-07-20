package br.com.cidao.web_tst.persistencia.entitade;

public class Estado {
	private Integer id;
	private String nome;
	private String pais;
	/*
	 * construtor
	 */
	public Estado(String nome, String pais) {
		this.nome = nome;
		this.pais = pais;
	}
	public Estado() {
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}
}
