package com.cs.parse;

import com.cs.model.Shape2D;

import java.util.Scanner;

import static com.cs.constants.AppConstants.*;
import static com.cs.constants.AppConstants.ErrorMessage.*;

public class DrawingCommandParser {

    private ParseCanvasInput parseCanvasInput;
    private ParseLineInput parseLineInput;
    private ParseRectangleInput parseRectangleInput;
    private ParseBucketFillInput parseBucketFillInput;
    private ParseQuitInput parseQuitInput;
    private Shape2D shape2D;

    public DrawingCommandParser() {
        this.parseCanvasInput = new ParseCanvasInput();
        this.parseLineInput = new ParseLineInput();
        this.parseRectangleInput = new ParseRectangleInput();
        this.parseBucketFillInput = new ParseBucketFillInput();
        this.parseQuitInput = new ParseQuitInput();
        this.shape2D = new Shape2D();
    }
    public char[][] parseCommand(String command, char[][] drawing, Scanner scanner) {
        String[] userInputArray = command.split(String.valueOf(SPACE));

        switch (userInputArray[0].toUpperCase()) {
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
                parseQuitInput.parseQuitInput(scanner);
                return null;
            case EMPTY_STRING:
                return null;
            default:
                System.out.println(ERROR_MESSAGE + NOT_VALID_COMMAND);
        }
        return drawing;
    }
}
