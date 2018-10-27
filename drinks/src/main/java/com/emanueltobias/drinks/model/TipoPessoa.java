package com.emanueltobias.drinks.model;

import com.emanueltobias.drinks.model.validation.group.CpfGroupCheck;
import com.emanueltobias.drinks.model.validation.group.CnpjGroupCheck;;

public enum TipoPessoa {
	
	FISICA("Física", "CPF", "000.000.000-00", CpfGroupCheck.class) {
		@Override
		public String formatar(String cpfOUCnpj) {
			return cpfOUCnpj.replaceAll("(\\d{3})(\\d{3})(\\d{3})", "$1.$2.$3-");
		}
	},
	
	JURIDICA("Jurídica", "CNPJ", "00.000.000/0000-00", CnpjGroupCheck.class) {
		@Override
		public String formatar(String cpfOUCnpj) {
			return cpfOUCnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})", "$1.$2.$3/$4-");
		}
	};

	private String descricao;
	private String documento;
	private String mascara;
	private Class<?> grupo;
	
		TipoPessoa(String descricao, String documento, String mascara, Class<?> grupo) {
			this.descricao = descricao;
			this.documento = documento;
			this.mascara = mascara;
			this.grupo = grupo;
		}
		
		public abstract String formatar(String cpfOUCnpj);

		public String getDescricao() {
			return descricao;
		}

		public String getDocumento() {
			return documento;
		}

		public String getMascara() {
			return mascara;
		}

		public Class<?> getGrupo() {
			return grupo;
		}
		
		public static String removerFormatacao(String cpfOuCnpj) {
			return cpfOuCnpj.replaceAll("\\.|-|/", "");
		}
		
		
}
