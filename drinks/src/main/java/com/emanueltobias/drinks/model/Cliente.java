package com.emanueltobias.drinks.model;

import org.hibernate.validator.constraints.NotBlank;

public class Cliente {
	
	@NotBlank(message = "Nome é obrigatorio")
	private String nome;
	
	@NotBlank(message = "CPF é obrigatorio")
	private String cpf;
	
	@NotBlank(message = "CNPJ é obrigatorio")
	private String cnpj;
	
	@NotBlank(message = "Telefone é obrigatorio")
	private String telefone;
	
	@NotBlank(message = "Email é obrigatorio")
	private String email;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
