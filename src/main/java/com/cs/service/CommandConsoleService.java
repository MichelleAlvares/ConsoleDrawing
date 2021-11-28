package com.cs.service;

import com.cs.parse.*;
import com.cs.print.DisplayDrawing;

import java.util.*;

import static com.cs.constants.AppConstants.*;

public class CommandConsoleService {

    private DrawingCommandParser drawingCommandParser;
    private DisplayDrawing print;

    public CommandConsoleService() {
        this.drawingCommandParser = new DrawingCommandParser();
        this.print = new DisplayDrawing();
    }

    private char[][] drawing;

    public char[][] processCommand(String command, Scanner scanner) {
        drawing = drawingCommandParser.processCommand(command, drawing, scanner);
        return drawing;
    }

    public void displayConsoleDrawing(char[][] chars) {
        print.printDrawing(chars);
    }

    public boolean isConsoleCommandInputPresent(Scanner scanner) {
        boolean y;
        try {
            y = scanner.hasNext();
            return y;
        } catch (IllegalStateException e) {
            scanner.close();
            return false;
        }
    }

    public void displayWelcomeMessage() {
        System.out.println(USER_INSTRUCTIONS);
        System.out.print(ENTER_COMMAND);
    }

    public void askUserToEnterNextCommand(String command) {
        if (!QUIT.equals(command))
            System.out.print(ENTER_COMMAND);
    }
}
