package com.example.demo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

import com.example.demo.model.ConfigurationProperties;

@Configuration
@EnableAutoConfiguration
@PropertySource({"classpath:infrastructure.properties","classpath:springbatch.properties"})
public class BatchConfiguration {

	@Autowired ConfigurableEnvironment configurableEnvironment;
	
	@Bean
	public ConfigurationProperties configurationProperties() {
		ConfigurationProperties configurationProperties=new ConfigurationProperties();
		Iterator<org.springframework.core.env.PropertySource<?>> it=configurableEnvironment.getPropertySources().iterator();
		while(it.hasNext()) {
			org.springframework.core.env.PropertySource<?> propSource= it.next();
			if(propSource.getName().contains(".properties")) {
				Properties al=(Properties) propSource.getSource();
				al.forEach((k,v) -> configurationProperties.getPropertyMap().put(k.toString(), v.toString()));
			}
		}
		/*while(it.hasNext()) {
			org.springframework.core.env.PropertySource propSource=it.next();
			if(propSource.getName().contains(".properties")) {
					Property prop=(Property) propSource.getSource();
			}
		}*/
		return configurationProperties;
	}
}
