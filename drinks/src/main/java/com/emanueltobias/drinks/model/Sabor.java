package com.emanueltobias.drinks.model;

public enum Sabor {

	ADICICADA("Adocicada"), 
	AMARGA("Amarga"),
	FRUTADA("Frutada"),
	SUAVE("Suave");

	private String descricao;

	Sabor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {

		return descricao;
	}
}
