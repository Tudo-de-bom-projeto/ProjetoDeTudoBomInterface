/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tudodebom.model;

/**
 *
 * @author ritha
 */
public class Produto {
    
    	private int id_produto;
	private String nome_produto;
	private int qtd_produto;
	private boolean tipo_medicamento;
	private boolean tipo_generico;
	private Double preco;
	
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	public int getQtd_produto() {
		return qtd_produto;
	}
	public void setQtd_produto(int qtd_produto) {
		this.qtd_produto = qtd_produto;
	}
	public boolean isTipo_medicamento() {
		return tipo_medicamento;
	}
	public void setTipo_medicamento(boolean tipo_medicamento) {
		this.tipo_medicamento = tipo_medicamento;
	}
	public boolean isTipo_generico() {
		return tipo_generico;
	}
	public void setTipo_generico(boolean tipo_generico) {
		this.tipo_generico = tipo_generico;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
    
}
