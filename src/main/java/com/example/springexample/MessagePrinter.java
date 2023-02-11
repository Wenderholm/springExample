package com.example.springexample;

import com.example.springexample.producer.MessageProducer;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MessagePrinter {

    private final MessageProducer messageProducer;
    private final MessagePrinterConfig printConfig;

    public MessagePrinter(MessageProducer messageProducer, MessagePrinterConfig printConfig) {
        this.messageProducer = messageProducer;
        this.printConfig = printConfig;
    }


    public void printMessage() {
        String message = messageProducer.getMessage();
        Function<String, String> decorator = printConfig.getDecorator();
        String apply = decorator.apply(message);
        System.out.println(apply);
    }
}
