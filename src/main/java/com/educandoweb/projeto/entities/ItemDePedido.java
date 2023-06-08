package com.educandoweb.projeto.entities;

import java.io.Serializable;
import java.util.Objects;

import com.educandoweb.projeto.entities.pk.ItemDePedidoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Item_de_pedido")
public class ItemDePedido implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemDePedidoPK id= new ItemDePedidoPK();
	
	private Integer quantidade;
	private Double preco;
	
	
	public ItemDePedido() {
		
	}


	public ItemDePedido(Pedido pedido ,Produto produto ,Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public double getSubTotal() {
		return quantidade*preco;
	}


	@Override
	public int hashCode() {
		return Objects.hash(preco, quantidade);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDePedido other = (ItemDePedido) obj;
		return Objects.equals(preco, other.preco) && Objects.equals(quantidade, other.quantidade);
	}
	
	
	

}
