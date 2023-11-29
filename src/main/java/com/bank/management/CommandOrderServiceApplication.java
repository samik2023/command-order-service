package com.bank.management;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;


@Slf4j
@SpringBootApplication
@EnableFeignClients
public class CommandOrderServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(CommandOrderServiceApplication.class, args);
    }
}
