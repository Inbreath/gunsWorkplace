package com.ums.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.ums.gateway"})
@ImportResource(value = "classpath:xml/all.xml")
public class AppStarter extends WebMvcConfigurerAdapter {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Welcome to ums-member!</title>\n" +
                "<style>\n" +
                "    body {\n" +
                "        width: 35em;\n" +
                "        margin: 0 auto;\n" +
                "        font-family: Tahoma, Verdana, Arial, sans-serif;\n" +
                "    }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Welcome to ums-member!</h1>\n" +
                "<p>If you see this page, the ums-member system is successfully installed and\n" +
                "working. Further configuration is required.</p>\n" +
                "\n" +
                "<p><em>Thank you for using our system.</em></p>\n" +
                "</body>\n" +
                "</html>";
    }

    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }

    @Bean
    public Validator localValidatorFactoryBean() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer config) {
        config.favorPathExtension(false);
    }
}
