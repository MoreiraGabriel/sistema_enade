package br.com.cesjf.enade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cesjf.enade.model.Usuario;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
    public Docket enadeApi() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("br.com.cesjf.enade"))              
          .paths(PathSelectors.ant("/**"))                          
          .build()
          .ignoredParameterTypes(Usuario.class);                                           
    }
}
