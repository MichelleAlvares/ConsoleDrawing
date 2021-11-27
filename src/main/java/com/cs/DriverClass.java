package com.cs;

import com.cs.service.CommandConsoleService;

import java.util.Scanner;

import static com.cs.constants.AppConstants.EMPTY_STRING;

class DriverClass {
    private static CommandConsoleService consoleService = new CommandConsoleService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter(EMPTY_STRING);
        consoleService.welcomeMessage();

        char[][] consoleDrawing;
        String command;
        boolean consoleInput = consoleService.isConsoleCommandInputPresent(scanner);

        while (consoleInput) {
            command = scanner.nextLine();
            consoleDrawing = consoleService.processCommand(command, scanner);

            consoleService.printCharArray(consoleDrawing);

            consoleService.askUserToEnterNextCommand(command);

            consoleInput = consoleService.isConsoleCommandInputPresent(scanner);
        }
    }
}
