package br.com.cidao.web_tst.persistencia.entitade;

public class Produto {
	private Integer id;
	private String nome;
	private Double valor_vda;
	private Double valor_custo;
	private Double peso;
	private Double estoque;
	private Double qtd_minima;
	/*
	 * construtor
	 */
	public Produto(String nome, Double valor_vda, Double valor_custo, Double peso, Double estoque, Double qtd_minima) {
		this.nome = nome;
		this.valor_vda = valor_vda;
		this.valor_custo = valor_custo;
		this.peso = peso;
		this.estoque = estoque;
		this.qtd_minima = qtd_minima;
	}
	public Produto() {
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
	public Double getValor_vda() {
		return valor_vda;
	}
	public void setValor_vda(Double valor_vda) {
		this.valor_vda = valor_vda;
	}
	public Double getValor_custo() {
		return valor_custo;
	}
	public void setValor_custo(Double valor_custo) {
		this.valor_custo = valor_custo;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getEstoque() {
		return estoque;
	}
	public void setEstoque(Double estoque) {
		this.estoque = estoque;
	}
	public Double getQtd_minima() {
		return qtd_minima;
	}
	public void setQtd_minima(Double qtd_minima) {
		this.qtd_minima = qtd_minima;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor_vda=" + valor_vda + ", valor_custo=" + valor_custo
				+ ", peso=" + peso + ", estoque=" + estoque + ", qtd_minima=" + qtd_minima + "]";
	}
}
