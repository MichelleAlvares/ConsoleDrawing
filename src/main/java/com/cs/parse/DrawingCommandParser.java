package com.cs.parse;

import static com.cs.constants.AppConstants.BUCKET_FILL;
import static com.cs.constants.AppConstants.CANVAS;
import static com.cs.constants.AppConstants.EMPTY_STRING;
import static com.cs.constants.AppConstants.ERROR_MESSAGE;
import static com.cs.constants.AppConstants.LINE;
import static com.cs.constants.AppConstants.NOT_VALID_COMMAND;
import static com.cs.constants.AppConstants.QUIT;
import static com.cs.constants.AppConstants.RECTANGLE;
import static com.cs.constants.AppConstants.SPACE;

import java.util.Scanner;

import com.cs.model.Shape2D;

public class DrawingCommandParser {

	private ParseCanvasInput parseCanvasInput;
    private ParseLineInput parseLineInput;
    private ParseRectangleInput parseRectangleInput;
    private ParseBucketFillInput parseBucketFillInput;
    private ParseQuitinput parseQuitInput;
    private Shape2D shape2D;
    private char[][] drawing;
    
	public DrawingCommandParser(){
		   this.parseCanvasInput = new ParseCanvasInput();
	        this.parseLineInput = new ParseLineInput();
	        this.parseRectangleInput = new ParseRectangleInput();
	        this.parseBucketFillInput = new ParseBucketFillInput();
	        this.parseQuitInput = new ParseQuitinput();
	        this.shape2D = new Shape2D();
	}
	public boolean parse(String command, Scanner scanner,char[][] drawing) {
		
		
		 String[] userInputArray = command.split(String.valueOf(SPACE));
		 boolean result=true;
	        switch (userInputArray[0]) {
	            case CANVAS:
	                 result = parseCanvasInput.parseCanvas(userInputArray, shape2D,drawing);
	                break;
	            case LINE:
	               result= parseLineInput.parseLineInput(userInputArray, drawing, shape2D); 
	                break;
	            case RECTANGLE:
	                parseRectangleInput.parseRectangleInput(userInputArray, drawing, shape2D);
	                break;
	            case BUCKET_FILL:
	                parseBucketFillInput.parseBucketFillInput(userInputArray, drawing, shape2D);
	                break;
	            case QUIT:
	            	parseQuitInput.quit(scanner);
	            case EMPTY_STRING:
	                result=false;
	            default:
	                System.out.println(ERROR_MESSAGE + NOT_VALID_COMMAND);
	        }
	        return result;
	        
	}
}
