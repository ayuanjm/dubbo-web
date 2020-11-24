package com.sunyur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ImportResource({"classpath:xml_config/*.xml"})
@EnableSwagger2
@SpringBootApplication
public class DemoWebStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebStartApplication.class, args);
    }

}
