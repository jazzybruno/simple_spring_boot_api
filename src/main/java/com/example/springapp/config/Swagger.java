//package com.example.springapp.config;
//
//import com.google.common.base.Predicate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.documentation.RequestHandler;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.paths.RelativePathProvider;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import javax.servlet.ServletContext;
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
//@Configuration
//@EnableSwagger2
//@EnableWebMvc
//public class Swagger {
//
////    private final ServletContext servletContext;
//
//
//    @Autowired
//    public Swagger() {
//
//    }
//
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//                registry.addResourceHandler("/webjars/**")
//                        .addResourceLocations("classpath:/META-INF/resources/webjars/");
//            }
//        };
//    }
//
//
//    @Bean
//    public Docket api() {
//        ServletContext servletContext = null;
//        return new Docket(DocumentationType.SWAGGER_2).directModelSubstitute(LocalDate.class, Date.class)
//                .pathProvider(new RelativePathProvider(servletContext) {
//                    public String getApplicationBasePath() {
//                        return "/";
//                    }
//                }).select().apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.example.springapp.controllers"))
//                .paths((Predicate<String>) PathSelectors.any()).build().apiInfo(apiInfo()).securitySchemes(Arrays.asList(apiKey()))
//                .securityContexts(Collections.singletonList(securityContext()));
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("Bearer", "Authorization", "header");
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths((Predicate<String>) PathSelectors.regex("/.*")).build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
//        return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Confidential API").description("APIs Documentation")
//                .termsOfServiceUrl("https://github.com/username/repo")
//                .version("1.0").build();
//    }
//}