package com.cs;

import java.util.Scanner;

import com.cs.console.CommandConsole;

import static com.cs.constants.AppConstants.EMPTY_STRING;

class DriverClass {
    private static CommandConsole commandConsole = new CommandConsole();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter(EMPTY_STRING);
        commandConsole.displayWelcomeMessage();

        String command;
        boolean consoleInput = commandConsole.isConsoleCommandInputPresent(scanner);

        while (consoleInput) {
            command = scanner.nextLine();
           commandConsole.processCommand(command, scanner);

            commandConsole.displayDrawing();

            commandConsole.askUserToEnterNextCommand(command);

            consoleInput = commandConsole.isConsoleCommandInputPresent(scanner);
        }
    }
}
