package com.cloudkeeper.leasing.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

/**
 * swagger 配置文件
 * @author jerry
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cloudkeeper.leasing"))
                .paths(PathSelectors.regex("^(?!auth).*$"))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                ;
    }

    /**
     * 创建 api 信息
     * @return api
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("租赁系统 RESTful APIs")
                .description("租赁系统")
//                .termsOfServiceUrl("http://localhost:8080/")
                //.contact(contact)
                .version("1.0")
                .build();
    }

    /**
     * 添加 请求头 用户认证
     * @return 参数集合
     */
    @Nonnull
    private List<ApiKey> securitySchemes() {
        return Collections.singletonList(new ApiKey("Authorization", "authorization", "header"));
    }

    /**
     * 添加 请求头
     * @return 参数内容集合
     */
    @Nonnull
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$"))
                .build());
    }

    /**
     * 默认参数
     * @return 默认参数集合
     */
    @Nonnull
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("Authorization", authorizationScopes));
    }

}
