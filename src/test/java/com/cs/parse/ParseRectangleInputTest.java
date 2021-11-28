/*
package com.cs.parse;

import com.cs.draw.DrawRectangle;
import com.cs.model.Point;
import com.cs.model.Rectangle;
import com.cs.util.RectangleUtil;
import com.cs.validation.InputParameterValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.cs.constants.AppConstants.RECTANGLE;

@ExtendWith(MockitoExtension.class)
class ParseRectangleInputTest {

    @Mock
    private InputParameterValidation inputParameterValidation;
    @Mock
    private RectangleUtil rectangleUtil;
    @Mock
    private DrawRectangle drawRectangle;
    @InjectMocks
    private ParseRectangleInput parseRectangleInput;

    private final char[][] input = {{'-', '-', '-', '-', '-', '-', '-'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-', '-', '-'}
    };

    @Test
    void handleRectangleInput() {
        Mockito.when(inputParameterValidation.isCanvasDrawn(Mockito.any())).thenReturn(true);
        Mockito.when(inputParameterValidation.areCorrectNoOfParametersEntered(Mockito.anyString(), Mockito.any())).thenReturn(true);
        Mockito.when(inputParameterValidation.areParameterTypesCorrect(Mockito.anyString(), Mockito.any())).thenReturn(true);
        Mockito.when(rectangleUtil.getShape(Mockito.any(), Mockito.any())).thenReturn(new Rectangle());
        Mockito.doNothing().when(drawRectangle).draw(Mockito.any(), Mockito.any());

        parseRectangleInput.parseRectangleInput(new String[]{RECTANGLE, "1", "2", "1", "5"}, input, new Rectangle(5, 5, RECTANGLE, new Point(1, 2), new Point(1, 5)));
        Mockito.verify(drawRectangle, Mockito.times(1)).draw(Mockito.any(), Mockito.any());
    }

    @Test
    void handleRectangleCanvasNotDrawn() {
        Mockito.when(inputParameterValidation.isCanvasDrawn(Mockito.any())).thenReturn(false);

        parseRectangleInput.parseRectangleInput(new String[]{RECTANGLE, "1", "2", "1", "5"}, new char[][]{}, new Rectangle(5, 5, RECTANGLE, new Point(1, 2), new Point(1, 5)));
        Mockito.verify(drawRectangle, Mockito.never()).draw(Mockito.any(), Mockito.any());
    }

    @Test
    void handleRectangleInCorrectNoOfParametersEntered() {
        Mockito.when(inputParameterValidation.isCanvasDrawn(Mockito.any())).thenReturn(true);
        Mockito.when(inputParameterValidation.areCorrectNoOfParametersEntered(Mockito.anyString(), Mockito.any())).thenReturn(false);

        parseRectangleInput.parseRectangleInput(new String[]{RECTANGLE, "1", "2", "1", "5", "9"}, new char[][]{}, new Rectangle(5, 5, RECTANGLE, new Point(1, 2), new Point(1, 5)));
        Mockito.verify(drawRectangle, Mockito.never()).draw(Mockito.any(), Mockito.any());
    }

    @Test
    void handleRectangleIncorrectParameterType() {
        Mockito.when(inputParameterValidation.isCanvasDrawn(Mockito.any())).thenReturn(true);
        Mockito.when(inputParameterValidation.areCorrectNoOfParametersEntered(Mockito.anyString(), Mockito.any())).thenReturn(true);
        Mockito.when(inputParameterValidation.areParameterTypesCorrect(Mockito.anyString(), Mockito.any())).thenReturn(false);

        parseRectangleInput.parseRectangleInput(new String[]{RECTANGLE, "1", "i", "1", "5"}, new char[][]{}, new Rectangle(5, 5, RECTANGLE, new Point(1, 2), new Point(1, 5)));
        Mockito.verify(drawRectangle, Mockito.never()).draw(Mockito.any(), Mockito.any());
    }
}
*/
