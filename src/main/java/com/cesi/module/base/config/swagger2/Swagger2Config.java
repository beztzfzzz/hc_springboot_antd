package com.cesi.module.base.config.swagger2;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger配置类:
 *
 * @author Angel --守护天使
 * @version v.0.1
 * @date 2016年9月7日
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @SuppressWarnings("unchecked")
    @Bean
    public Docket apij() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("apij")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                // base，最终调用接口后会和paths拼接在一起
                .pathMapping("/")
                .select()
                //过滤的接口
                .paths(Predicates.or(PathSelectors.regex("/apij/.*")))
                .build()
                .apiInfo(apijApiInfo());
        return docket;
    }

    private ApiInfo apijApiInfo() {
        ApiInfo apiInfo = new ApiInfo("apij相关接口",//大标题
                "apij相关接口，免登录验证的接口.",//小标题
                "1.0.0",//版本
                "http://www.dward.cn/",
                "Farando",//作者
                "XXX科技有限公司",//链接显示文字
                "http://www.dward.cn/"//网站链接
        );
        return apiInfo;
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Docket api() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Access-Token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(Predicates.or(PathSelectors.regex("/api/.*")))//过滤的接口
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiApiInfo());
        return docket;
    }

    private ApiInfo apiApiInfo() {
        ApiInfo apiInfo = new ApiInfo("api相关接口",//大标题
                "api相关接口，需要权限验证的业务接口.",//小标题
                "1.0.0",//版本
                "http://www.dward.cn/",
                "Farando",//作者
                "XXX科技有限公司",//链接显示文字
                "http://www.dward.cn/"//网站链接
        );
        return apiInfo;
    }

}