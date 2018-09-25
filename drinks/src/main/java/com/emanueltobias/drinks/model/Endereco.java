package com.emanueltobias.drinks.model;

import org.hibernate.validator.constraints.NotBlank;

public class Endereco {

	@NotBlank(message = "Logadouro é obrigatorio")
	private String logadouro;
	
	@NotBlank(message = "Número é obrigaorio")
	private int numero;
	
	private String complemento;
	
	@NotBlank(message = "CEP é obrigatorio")
	private String cep;
	
	@NotBlank(message = "Estado é obrigatorio")
	private String estado;
	
	@NotBlank(message = "Cidade é obrigatorio")
	private String cidade;
	
	
	public String getLogadouro() {
		return logadouro;
	}
	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
