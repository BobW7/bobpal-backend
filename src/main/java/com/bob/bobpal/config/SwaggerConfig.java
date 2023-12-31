package com.bob.bobpal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Profile("dev")
public class SwaggerConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //一定标注控制器的信息
                .apis(RequestHandlerSelectors.basePackage("com.bob.bobpal.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * api信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Bob用户中心")
                .description("接口文档")
                .termsOfServiceUrl("https://github.com/BobW7")
                .contact(new Contact("bob", "https://github.com/BobW7", "1186717311@qq.com"))
                .version("1.0")
                .build();
    }
}
