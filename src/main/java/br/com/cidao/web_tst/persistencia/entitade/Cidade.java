package br.com.cidao.web_tst.persistencia.entitade;

public class Cidade {
	private Integer id;
	private String nome;
	private String uf;
	/*
	 * construtor
	 */
	public Cidade(Integer id, String nome, String uf) {
		this.id = id;
		this.nome = nome;
		this.uf = uf;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", uf=" + uf + "]";
	}

}
