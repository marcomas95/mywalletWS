package com.wallet.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.wallet"})
public class WalletWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletWebserviceApplication.class, args);
    }
}
