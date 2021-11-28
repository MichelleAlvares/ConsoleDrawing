package com.cs.console;

import com.cs.model.Shape2D;
import com.cs.parse.DrawingCommandParser;
import com.cs.parse.ParseBucketFillInput;
import com.cs.parse.ParseCanvasInput;
import com.cs.parse.ParseLineInput;
import com.cs.parse.ParseRectangleInput;
import com.cs.print.PrintArray;

import java.util.*;

import static com.cs.constants.AppConstants.*;

public class CommandConsole {

    private ParseCanvasInput parseCanvasInput;
    private ParseLineInput parseLineInput;
    private ParseRectangleInput parseRectangleInput;
    private ParseBucketFillInput parseBucketFillInput;
    private Shape2D shape2D;
    private PrintArray print;
    private DrawingCommandParser drawingCommandParser; 
    

    public CommandConsole() {
        this.parseCanvasInput = new ParseCanvasInput();
        this.parseLineInput = new ParseLineInput();
        this.parseRectangleInput = new ParseRectangleInput();
        this.parseBucketFillInput = new ParseBucketFillInput();
        this.drawingCommandParser = new DrawingCommandParser();
        this.shape2D = new Shape2D();
        this.print = new PrintArray();
    }

    private char[][] drawing;

    public void processCommand(String command, Scanner scanner) {
  
    drawingCommandParser.parse(command, scanner,drawing);
		/*
		 * switch (userInputArray[0]) { case CANVAS: drawingConsole =
		 * parseCanvasInput.parseCanvas(userInputArray, shape2D); break; case LINE:
		 * parseLineInput.parseLineInput(userInputArray, drawingConsole, shape2D);
		 * break; case RECTANGLE:
		 * parseRectangleInput.parseRectangleInput(userInputArray, drawingConsole,
		 * shape2D); break; case BUCKET_FILL:
		 * parseBucketFillInput.parseBucketFillInput(userInputArray, drawingConsole,
		 * shape2D); break; case QUIT: closeScanner(scanner); return null; case
		 * EMPTY_STRING: return null; default: System.out.println(ERROR_MESSAGE +
		 * NOT_VALID_COMMAND); }
		 */
      
    }

    private void closeScanner(Scanner scanner) {
        try {
            if (scanner != null)
                scanner.close();
        } catch (Exception e) {
            System.out.println(SCANNER_NOT_CLOSED);
        }
    }

    public void displayDrawing() {
        print.printCharArray(drawing);
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
