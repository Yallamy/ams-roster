package br.com.mesttra.roster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RosterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RosterApplication.class, args);
    }

}
