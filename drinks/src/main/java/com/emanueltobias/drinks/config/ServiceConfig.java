package com.emanueltobias.drinks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.emanueltobias.drinks.service.CadastroCervejaService;
import com.emanueltobias.drinks.storage.local.FotoStorage;
import com.emanueltobias.drinks.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {
	
	@Bean
	public FotoStorage fotoStorege() {
		return new FotoStorageLocal();
	}

}
