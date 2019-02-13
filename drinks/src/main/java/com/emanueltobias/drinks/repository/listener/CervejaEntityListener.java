package com.emanueltobias.drinks.repository.listener;

import javax.persistence.PostLoad;

import com.emanueltobias.drinks.DrinksApplication;
import com.emanueltobias.drinks.model.Cerveja;
import com.emanueltobias.drinks.storage.FotoStorage;

public class CervejaEntityListener {

	@PostLoad
	public void postLoad(final Cerveja cerveja) {
		FotoStorage fotoStorage = DrinksApplication.getBean(FotoStorage.class);
		
		cerveja.setUrlFoto(fotoStorage.getUrl(cerveja.getFotoOrMock()));
		cerveja.setUrlThumbnailFoto(fotoStorage.getUrl(FotoStorage.THUMBNAIL_PREFIX + cerveja.getFotoOrMock()));
	}
	
}