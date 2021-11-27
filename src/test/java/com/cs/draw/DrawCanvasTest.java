package com.cs.draw;

import com.cs.model.Canvas;
import com.cs.validation.CanvasValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DrawCanvasTest {

    @Mock
    private CanvasValidation canvasValidation;
    @InjectMocks
    private DrawCanvas drawCanvas;

    @Test
    void testDrawCanvas() {
        Mockito.when(canvasValidation.valid(Mockito.any())).thenReturn(true);
        char[][] input = new char[10][12];
        char[][] expectedOutput = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };

        drawCanvas.draw(new Canvas(10, 8, "C"), input);
        Assertions.assertArrayEquals(expectedOutput, input);
        Mockito.verify(canvasValidation, Mockito.times(1)).valid(Mockito.any());
    }

    @Test
    void zeroDimension() {
        Mockito.when(canvasValidation.valid(Mockito.any())).thenReturn(false);
        drawCanvas.draw(new Canvas(0, 8, "C"), new char[][]{});
        Mockito.verify(canvasValidation, Mockito.times(1)).valid(Mockito.any());
    }
}
