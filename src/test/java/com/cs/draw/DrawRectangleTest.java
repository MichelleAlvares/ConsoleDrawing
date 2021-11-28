package com.cs.draw;

import com.cs.model.Point;
import com.cs.model.Rectangle;
import com.cs.validation.BorderValidation;
import com.cs.validation.RectangleValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DrawRectangleTest {

    @Mock
    RectangleValidation rectangleValidation;
    @Mock
    BorderValidation borderValidation;
    @Mock
    DrawLine drawLine;
    @InjectMocks
    private DrawRectangle drawRectangle;

    @Test
    void testDrawRectangle() {

        Mockito.when(rectangleValidation.valid(Mockito.any())).thenReturn(true);
        Mockito.when(borderValidation.withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
        Mockito.doNothing().when(drawLine).draw(Mockito.any(), Mockito.any());

        drawRectangle.draw(new Rectangle(10, 8, "R", new Point(3, 4), new Point(6, 8)), new char[][]{});
        Mockito.verify(drawLine, Mockito.times(4)).draw(Mockito.any(), Mockito.any());
    }

    @Test
    void pointsNotInOrder() {
        Mockito.when(rectangleValidation.valid(Mockito.any())).thenReturn(false);
        //x1,y1's position if to the right of x2,y2 hence cannot draw the rectangle.
        drawRectangle.draw(new Rectangle(10, 8, "R", new Point(7, 9), new Point(6, 8)), new char[][]{});
        Mockito.verify(drawLine, Mockito.never()).draw(Mockito.any(), Mockito.any());
        Mockito.verify(rectangleValidation, Mockito.times(1)).displayInvalidInputMessage();
    }

    @Test
    void inputPointsLieOnTheSameLine(){
        Mockito.when(rectangleValidation.valid(Mockito.any())).thenReturn(false);
        //y1=y2 hence its a line. cannot draw a rectangle
        drawRectangle.draw(new Rectangle(10, 8, "R", new Point(4, 8), new Point(6, 8)), new char[][]{});
        Mockito.verify(drawLine, Mockito.never()).draw(Mockito.any(), Mockito.any());
        Mockito.verify(rectangleValidation, Mockito.times(1)).displayInvalidInputMessage();
    }

    @Test
    void outsideBorder(){
        Mockito.when(rectangleValidation.valid(Mockito.any())).thenReturn(true);
        Mockito.when(borderValidation.withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(false);
        drawRectangle.draw(new Rectangle(10, 8, "R", new Point(4, 8), new Point(6, 19)), new char[][]{});
        Mockito.verify(drawLine, Mockito.never()).draw(Mockito.any(), Mockito.any());
        Mockito.verify(borderValidation, Mockito.times(1)).displayInvalidInputMessage();
    }
}
