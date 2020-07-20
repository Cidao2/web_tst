package br.com.cidao.web_tst.persistencia.entitade;

public class Cliente {
	private Integer id;
	private String nome;
	private String end;
	private Cidade cidade;
	private String email;
	private String cpf;
	private String rg;
	/*
	 * construtor
	 */
	public Cliente(String nome, String end, Cidade cidade, String email, String cpf, String rg) {
		super();
		this.nome = nome;
		this.end = end;
		this.cidade = cidade;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	/*
	 * to string
	 */
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", end=" + end + ", cid=" + cidade.getCidade() +"/"+ cidade.getEstado().getNome() + ", email=" + email
				+ ", cpf=" + cpf + ", rg=" + rg + "]";
	}
}
