package com.example.springexample;

import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.Scanner;

@Controller
public class MessageController {
    private final Scanner scanner;
    private final MessagePrinter messagePrinter;

    public MessageController(Scanner scanner, MessagePrinter messagePrinter) {
        this.scanner = scanner;
        this.messagePrinter = messagePrinter;
    }
    public void mainLoop(){
        Option option;
        do{
            option = chooseOption();
            executeOption(option);
        }while (option != Option.EXIT);
    }

    private void executeOption(Option option) {
        switch (option){
            case NEXT_MESSAGE -> printMessage();
            case EXIT -> exit();
        }
    }

    private void exit() {
        System.out.println("koniec programu ;)");
    }

    private void printMessage() {
        messagePrinter.printMessage();
    }

    private Option chooseOption() {
        int optionNumber;
        Optional<Option> option;
        do {
            printOptions();
            System.out.println("Wybierz opcje:");
            optionNumber = scanner.nextInt();
            scanner.nextLine();
            option = Option.fromInt(optionNumber);
        } while(option.isEmpty());
        return option.get();
    }

    private void printOptions() {
        Option[] options = Option.values();
        System.out.println("Opcje");
        for (Option option : options) {
            System.out.println(option);
        }
    }

    private enum Option{
        EXIT(0,"Wyjście z programu"),
        NEXT_MESSAGE(1, "Wczytaj kolejny komunikat");

        private final int number;
        private final String description;

        Option(int number, String description) {
            this.number = number;
            this.description = description;
        }

//        wypisanie optionala po podanym numerze
        static Optional<Option> fromInt(int number){
            Option[] options = Option.values();
            if(number >= 0 && number< options.length){
//                wyswietla subscription enuma pod podanym numerem
                return Optional.of(options[number]);
            }else{
                return Optional.empty();
            }
        }

        @Override
        public String toString() {
            return number + " - " + description;
        }
    }

}
