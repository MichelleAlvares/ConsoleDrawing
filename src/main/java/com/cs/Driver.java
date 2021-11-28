package com.cs;

import com.cs.service.CommandConsoleService;

import java.util.Scanner;

import static com.cs.constants.AppConstants.EMPTY_STRING;

class Driver {
    private static CommandConsoleService consoleService = new CommandConsoleService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter(EMPTY_STRING);
        consoleService.displayWelcomeMessage();

        char[][] drawing;
        String command;
        boolean consoleInput = consoleService.isConsoleCommandInputPresent(scanner);

        while (consoleInput) {
            command = scanner.nextLine();
            drawing = consoleService.processCommand(command, scanner);

            consoleService.displayConsoleDrawing(drawing);

            consoleService.askUserToEnterNextCommand(command);

            consoleInput = consoleService.isConsoleCommandInputPresent(scanner);
        }
    }
}
