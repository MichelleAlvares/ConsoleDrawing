package com.cs.constants;

import java.util.Map;

public class AppConstants {

    public static final char SPACE = ' ';
    public static final char DASH = '-';
    public static final char PIPE = '|';
    public static final char X = 'x';

    public static final String CANVAS = "C";
    public static final String LINE = "L";
    public static final String RECTANGLE = "R";
    public static final String BUCKET_FILL = "B";
    public static final String QUIT = "Q";
    public static final String EMPTY_STRING = "";

    public static final String SCANNER_NOT_CLOSED = "Unable to close Scanner";
    public static final String INT = "Integer";
    public static final String CHAR = "Character";

    public static final Map<String, Integer> NO_OF_PARAMETERS = Map.of(CANVAS, 2,
            LINE, 4,
            RECTANGLE, 4,
            BUCKET_FILL, 3);

    public static final Map<String, Map<Integer, String>> EXPECTED_DATA_TYPES = Map.of(CANVAS, Map.of(1, INT, 2, INT),
            LINE, Map.of(1, INT, 2, INT, 3, INT, 4, INT),
            RECTANGLE, Map.of(1, INT, 2, INT, 3, INT, 4, INT),
            BUCKET_FILL, Map.of(1, INT, 2, INT, 3, CHAR));


    public static class UserInstructions {
        public static final String USER_INSTRUCTIONS = "\nCommand \t\tDescription\n" +
                "C w h           To create a new canvas of width w and height h.\n" +
                "L x1 y1 x2 y2   To create a new line from (x1,y1) to (x2,y2). Currently only\n" +
                "                horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
                "                will be drawn using the 'x' character.\n" +
                "R x1 y1 x2 y2   To create a new rectangle, whose upper left corner is (x1,y1) and\n" +
                "                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" +
                "                using the 'x' character.\n" +
                "B x y c         To fill the entire area connected to (x,y) with \"colour\" c. The\n" +
                "                behavior of this is the same as that of the \"bucket fill\" tool in paint\n" +
                "                programs.\n" +
                "Q               To quit the program.";

        public static final String ENTER_COMMAND = "enter command: ";
    }

    public static class ErrorMessage {
        public static final String ERROR_MESSAGE = "\nERROR MESSAGE: ";
        public static final String NOT_VALID_COMMAND = "Not a valid command";
        public static final String NUMBER_GREATER_THAN_ZERO_MESSAGE = "Number greater than 0 is expected";
        public static final String DRAW_CANVAS_MESSAGE = "Please draw Canvas first";
        public static final String CANVAS_VALIDATION_FAILED_MESSAGE = "Invalid Input. Canvas cannot be drawn. Dimensions should be greater than 0.";
        public static final String BORDER_VALIDATION_FAILED_MESSAGE = "Invalid Input. Point is not within border";
        public static final String HORIZONTAL_VERTICAL_LINE_VALIDATION_FAILED_MESSAGE = "Invalid Input. Only Horizontal and Vertical lines are supported.";
        public static final String RECTANGLE_VALIDATION_FAILED_MESSAGE = "Invalid Input. Rectangle cannot be drawn. First point should be the top left corner and the second point should be the bottom right corner";
    }

    public static class InformationalMessage {
        public static final String INPUT_PARAMETERS = " input parameters.";
        public static final String NEEDS = " needs ";
        public static final String NEEDS_PARAMETERS = " needs parameter ";
        public static final String TYPE_OF_PARAMETER = " to be of type ";
    }
}
