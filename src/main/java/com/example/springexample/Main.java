package com.example.springexample;

import com.example.springexample.producer.ConsoleMessageProducer;
import com.example.springexample.producer.MessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//       polimorfizm
//        MessageProducer messageProducer1 = new ConsoleMessageProducer();
//        MessageProducer messageProducer1 = new SimpleMessageProducer();
//        MessagePrinter messagePrinter = new MessagePrinter(messageProducer1);

        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        MessageController messageController = context.getBean(MessageController.class);
        messageController.mainLoop();
    }

//    dane konfiguracyjne. Scanner uzywany do wszystkich klas - wstrzykiwany do konstruktora
    @Bean
    Scanner scanner() {
        return new Scanner(System.in);
    }
}
