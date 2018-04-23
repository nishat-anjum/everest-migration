package com.tigerit.evr.migration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by raqib on 24/11/15.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
    }
}
