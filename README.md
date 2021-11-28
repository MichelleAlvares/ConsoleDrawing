**Problem Statement** <br />
*** The Problem ***

__Description:__

You're given the task of writing a simple console version of a drawing program. 
At this time, the functionality of the program is quite limited but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit


**Command** 	        |**Description**|
 ---------------------- |---------------|
C w h                   |Should create a new canvas of width w and height h.
L x1 y1 x2 y2           |Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.
R x1 y1 x2 y2           |Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.
B x y c                 |Should fill the entire area connected to (x,y) with "colour" c. The behavior of this is the same as that of the "bucket fill" tool in paint programs.
Q                       |Should quit the program.




**How to run the program:**
Use JRE Version 11 to execute the jar file
java -jar drawing-console-program.jar

**Assumptions:**
 1. Canvas starts from (0,0)
 2. Line, Rectangle and Fill can happen only after canvas is drawn.
 3. Only positive numbers will be accepted.
 4. All points will start from left to right eg line first point x1 y1 is the left most one or in case of a rectangle it is the top left one.
 5. Only horizontal or vertical line can be drawn.


**Improvements to the application:**
 1. Extending the application to draw 3D shapes.
 2. Allowing Oblique Lines hence giving users the capability to draw shapes with Oblique sides.


