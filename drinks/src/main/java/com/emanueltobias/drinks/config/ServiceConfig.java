package com.emanueltobias.drinks.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.emanueltobias.drinks.service.CadastroCervejaService;
import com.emanueltobias.drinks.storage.FotoStorage;

@Configuration
@ComponentScan(basePackageClasses = {CadastroCervejaService.class, FotoStorage.class})
public class ServiceConfig {
	

}
