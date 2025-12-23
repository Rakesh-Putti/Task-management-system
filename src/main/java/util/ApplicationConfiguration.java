package util;



import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;



@Configuration
public class ApplicationConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Task Management System")
                        .description("Task Management System is a role-based project allowing Admins, Managers, and Users "
                                + "to manage tasks, teams, and collaborate effectively. "
                                + "Admins manage teams and assign tasks, Managers create and assign tasks, "
                                + "and Users track and update their assigned tasks.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("RakeshVarma")
                                .email("rakeshvarmaputti@gmail.com"))
                        .license(new License().name("License").url("#")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.project.task_management_system")
                .build();
    }
}

