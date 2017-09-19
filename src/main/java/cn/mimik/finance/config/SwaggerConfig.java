package cn.mimik.finance.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
//      http://127.0.0.1:8082/swagger-ui.html
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("finance")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")//api测试请求地址
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.mimik.finance.web.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(testApiInfo());
    }


    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.mimik.finance.web.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(demoApiInfo());
    }

    private ApiInfo testApiInfo() {
        Contact contact = new Contact("个人理财系统", "http://127.0.0.1:8080/", "278674028@qq.com");
        return new ApiInfoBuilder()
                .title("个人理财系统API接口")
                .description("REST风格API")
                .version("0.1")
                .termsOfServiceUrl("finance.mimik.cn")
                .contact(contact)
                .license("主页")
                .licenseUrl("finance.mimik.cn").build();
    }

    private ApiInfo demoApiInfo() {
        Contact contact = new Contact("个人理财系统", "http://127.0.0.1:8080/", "123456@qq.com");
        ApiInfo apiInfo = new ApiInfo("个人理财系统Restful接口",//大标题
                "REST风格API",//小标题
                "0.1",//版本
                "finance.mimik.cn",
                contact,//作者
                "个人理财系统",//链接显示文字
                "finance.mimik.cn"//网站链接
        );
        return apiInfo;
    }
}