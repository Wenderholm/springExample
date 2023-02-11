package com.example.springexample.producer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

@Service
@Profile("file")
public class FileMessageProducer implements MessageProducer{
    private final Scanner scanner;

    public FileMessageProducer(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getMessage() {
        Path path = getPath();
        try {
            return String.join(" ", Files.readAllLines(path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    private Path getPath(){
        System.out.println("File name to read:");
        String fileName = scanner.nextLine();
        return Path.of(fileName);
    }
}
