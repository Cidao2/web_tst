package br.com.cidao.web_tst.persistencia.entitade;

import java.util.Arrays;
import java.util.Date;

public class pedido {
	private Integer id;
	private Date data;
	private Cliente cliente;
	private itenPedido[] itens;
	/*
	 * construtor 
	 */
	public pedido(Date data, Cliente cliente) {
		this.data = data;
		this.cliente = cliente;
	}
	public pedido() {
	}
	/*
	 * get set
	 */
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public itenPedido[] getItens() {
		return itens;
	}
	public void setItens(itenPedido[] itens) {
		this.itens = itens;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/*
	 * to string
	 */
	@Override
	public String toString() {
		return "pedido [id=" + id + ", data=" + data + ", cliente=" + cliente + ", itens=" + Arrays.toString(itens)
				+ "]";
	}
	
}
