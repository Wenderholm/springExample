package com.example.springexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessagePrinterConfig {
    private final String decorator;

    public MessagePrinterConfig(@Value("${app.message.decorator}") String decorator) {
        this.decorator = decorator;
    }

    Function<String,String> getDecorator(){
        if(decorator.equals("UPPERCASE")){
            return elem -> elem.toUpperCase();
        }else if(decorator.equals("LOWERCASE")){
            return elem -> elem.toLowerCase();
        }
        throw new InvalidDecorationException("No decoration found for: " + decorator);
    }
}
