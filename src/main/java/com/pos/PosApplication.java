package com.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}


	/*@Bean(name="conversionService")
	public ConversionServiceFactoryBean getConversionService(ItemModelConverter itemModelConverter) {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();

		Set<Converter> converters = new HashSet<>();

		converters.add(itemModelConverter);

		bean.setConverters(converters);
		return bean;
	}*/

}
