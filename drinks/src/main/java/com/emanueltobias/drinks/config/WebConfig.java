/**
 * @author Emanuel
 *
 */
package com.emanueltobias.drinks.config;

import javax.cache.Caching;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableCaching
@EnableAsync
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public CacheManager cacheManager() throws Exception {
		/*
		 * CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
		 * .maximumSize(3) .expireAfterAccess(20, TimeUnit.SECONDS);
		 * 
		 * GuavaCacheManager cacheManager = new GuavaCacheManager();
		 * cacheManager.setCacheBuilder(cacheBuilder); return cacheManager;
		 */

		return new JCacheCacheManager(Caching.getCachingProvider().getCacheManager(
				getClass().getResource("/env/ehcache.xml").toURI(),
				getClass().getClassLoader()));
		// Padrão
		// return new ConcurrentMapCacheManager();
	}

}
