package com.emanueltobias.drinks.model;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {
	
	@NotBlank(message = "Nome é obrigatorio")
	private String nome;
	
	@NotBlank(message = "Email é obrigatorio")
	private String email;
	
	@NotBlank(message = "A data de nascimento é obrigatoria")
	private String dataNascimento;
	
	@NotBlank(message = "A senha é obrigatoria")
	private String senha;
	
	@NotBlank(message = "Status é obrigatorio")
	private boolean status;
	
	@NotBlank(message = "Grupo é obrigatorio")
	private String grupo;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
