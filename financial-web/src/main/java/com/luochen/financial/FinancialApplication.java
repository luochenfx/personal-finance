package com.luochen.financial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author luochenfx
 */
@EnableAsync
@SpringBootApplication
public class FinancialApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialApplication.class, args);
    }

}
