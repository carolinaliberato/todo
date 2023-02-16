package com.javastart.todolist.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springTodoListOpenAPI(){
        return new OpenAPI()
        .info(new Info()
        .title("To do List")
        .description("Aplicação gerenciadora de tarefas")
        .version("1.0.0"));
    }
    
}
