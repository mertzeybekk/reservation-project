package com.market.isteucuzagelsin;

import com.market.isteucuzagelsin.Mapper.ModelMapperManager;
import com.market.isteucuzagelsin.Mapper.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IsteucuzagelsinApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsteucuzagelsinApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
