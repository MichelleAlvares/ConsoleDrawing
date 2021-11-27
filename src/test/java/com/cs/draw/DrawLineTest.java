package com.cs.draw;

import com.cs.model.Line;
import com.cs.model.Point;
import com.cs.validation.BorderValidation;
import com.cs.validation.LineValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DrawLineTest {

    @Mock
    private LineValidation lineValidation;
    @Mock
    private BorderValidation borderValidation;
    @InjectMocks
    private DrawLine drawLine;

    @Test
    void testDrawLineWhenYisEqual() {
        char[][] input = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };

        char[][] expectedOutput = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', 'x', ' ', 'x', ' ', 'x', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', 'x', ' ', 'x', 'x', 'x', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', 'x', ' ', ' ', ' ', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', 'x', ' ', ' ', ' ', 'x', ' ', 'x', ' ', '|'},
                {'|', ' ', ' ', 'x', ' ', ' ', ' ', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };

        Mockito.when(lineValidation.valid(Mockito.any())).thenReturn(true);
        Mockito.when(borderValidation.withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
        drawLine.draw(new Line(10, 8, "L", new Point(3, 1), new Point(3, 8)), input);

        Assertions.assertArrayEquals(expectedOutput, input);
    }

    @Test
    void testDrawLineWhenXisEqual() {
        char[][] input = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };

        char[][] expectedOutput = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', 'x', 'x', 'x', ' ', 'x', ' ', 'x', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };

        Mockito.when(lineValidation.valid(Mockito.any())).thenReturn(true);
        Mockito.when(borderValidation.withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
        drawLine.draw(new Line(10, 8, "L", new Point(1, 1), new Point(3, 1)), input);

        Assertions.assertArrayEquals(expectedOutput, input);
    }

    @Test
    void outsideBorder() {
        Mockito.when(lineValidation.valid(Mockito.any())).thenReturn(true);
        Mockito.when(borderValidation.withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(false);
        drawLine.draw(new Line(10, 8, "L", new Point(11, 1), new Point(11, 8)), new char[][]{});
        Mockito.verify(lineValidation, Mockito.times(1)).valid(Mockito.any());
        Mockito.verify(borderValidation, Mockito.times(1)).withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    void notALine() {
        Mockito.when(lineValidation.valid(Mockito.any())).thenReturn(false);
        drawLine.draw(new Line(10, 8, "L", new Point(1, 3), new Point(4, 7)), new char[][]{});
        Mockito.verify(lineValidation, Mockito.times(1)).valid(Mockito.any());
    }
}
