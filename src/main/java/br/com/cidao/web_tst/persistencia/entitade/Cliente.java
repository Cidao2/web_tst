package br.com.cidao.web_tst.persistencia.entitade;

public class Cliente {
	private Integer id;
	private String nome;
	private String endereco;
	private String cep;
	private Cidade cidade;
	private String email;
	private String cpf;
	private String rg;
	/*
	 * construtor
	 */
	public Cliente(Integer id, String nome, String endereco, String cep, Cidade cidade, String email, String cpf,
			String rg) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
	}
	public Cliente(String nome, String endereco, String cep, String email, String cpf, String rg) {
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
	}
	public Cliente() {
	}
	/*
	 * get set
	 * 
	 * 
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cep=" + cep + ", cidade=" + cidade
				+ ", email=" + email + ", cpf=" + cpf + ", rg=" + rg + "]";
	}
	
	//   =======  FIM    =========
}
