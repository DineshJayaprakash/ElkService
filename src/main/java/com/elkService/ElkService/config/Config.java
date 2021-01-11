package com.elkService.ElkService.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * class Config
 * 
 * @author dines
 * @created date 28/12
 * @description used to create singleton bean
 *
 */
@Configuration
public class Config {
	



	/**
	 * method modelMapper
	 * 
	 * @param none
	 * @return ModelMapper bean
	 * @description used for predefined utility operation
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean 
	public RestTemplate myRestTemplate() {
		return new RestTemplate();
	}
	

	

}
