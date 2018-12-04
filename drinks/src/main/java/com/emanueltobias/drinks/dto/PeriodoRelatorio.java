package com.emanueltobias.drinks.dto;

import java.time.LocalDate;

public class PeriodoRelatorio {

	private LocalDate dataInicio;
	private LocalDate dataFinal;

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

}