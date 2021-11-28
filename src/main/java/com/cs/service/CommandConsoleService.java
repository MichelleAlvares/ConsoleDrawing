package com.cs.service;

import com.cs.model.Shape2D;
import com.cs.parse.ParseBucketFillInput;
import com.cs.parse.ParseCanvasInput;
import com.cs.parse.ParseLineInput;
import com.cs.parse.ParseRectangleInput;
import com.cs.print.PrintArray;

import java.util.*;

import static com.cs.constants.AppConstants.*;
import static com.cs.constants.AppConstants.ErrorMessage.*;

public class CommandConsoleService {

    private ParseCanvasInput parseCanvasInput;
    private ParseLineInput parseLineInput;
    private ParseRectangleInput parseRectangleInput;
    private ParseBucketFillInput parseBucketFillInput;
    private Shape2D shape2D;
    private PrintArray print;

    public CommandConsoleService() {
        this.parseCanvasInput = new ParseCanvasInput();
        this.parseLineInput = new ParseLineInput();
        this.parseRectangleInput = new ParseRectangleInput();
        this.parseBucketFillInput = new ParseBucketFillInput();
        this.shape2D = new Shape2D();
        this.print = new PrintArray();
    }

    private char[][] drawing;

    public char[][] processCommand(String command, Scanner scanner) {
        String[] userInputArray = command.split(String.valueOf(SPACE));

        switch (userInputArray[0]) {
            case CANVAS:
                drawing = parseCanvasInput.parseCanvas(userInputArray, drawing, shape2D);
                break;
            case LINE:
                parseLineInput.parseLineInput(userInputArray, drawing, shape2D);
                break;
            case RECTANGLE:
                parseRectangleInput.parseRectangleInput(userInputArray, drawing, shape2D);
                break;
            case BUCKET_FILL:
                parseBucketFillInput.parseBucketFillInput(userInputArray, drawing, shape2D);
                break;
            case QUIT:
                closeScanner(scanner);
                return null;
            case EMPTY_STRING:
                return null;
            default:
                System.out.println(ERROR_MESSAGE + NOT_VALID_COMMAND);
        }
        return drawing;
    }

    private void closeScanner(Scanner scanner) {
        try {
            if (scanner != null)
                scanner.close();
        } catch (Exception e) {
            System.out.println(SCANNER_NOT_CLOSED);
        }
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
