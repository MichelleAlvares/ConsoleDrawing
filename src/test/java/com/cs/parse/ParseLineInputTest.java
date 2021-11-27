package com.cs.parse;

import com.cs.draw.DrawLine;
import com.cs.model.Line;
import com.cs.model.Point;
import com.cs.util.LineUtil;
import com.cs.validation.InputParameterValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.cs.constants.AppConstants.LINE;

@ExtendWith(MockitoExtension.class)
class ParseLineInputTest {

    @Mock
    private InputParameterValidation inputParameterValidation;
    @Mock
    private LineUtil lineUtil;
    @Mock
    private DrawLine drawLine;
    @InjectMocks
    private ParseLineInput parseLineInput;

    private final char[][] input = {{'-', '-', '-', '-', '-', '-', '-'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-', '-', '-'}
    };

    @Test
    void handleLineInput() {
        Mockito.when(inputParameterValidation.isCanvasDrawn(Mockito.any())).thenReturn(true);
        Mockito.when(inputParameterValidation.areCorrectNoOfParametersEntered(Mockito.anyString(), Mockito.any())).thenReturn(true);
        Mockito.when(inputParameterValidation.areParameterTypesCorrect(Mockito.anyString(), Mockito.any())).thenReturn(true);
        Mockito.when(lineUtil.getShape(Mockito.any(), Mockito.any())).thenReturn(new Line());
        Mockito.doNothing().when(drawLine).draw(Mockito.any(), Mockito.any());

        parseLineInput.parseLineInput(new String[]{LINE, "1", "2", "1", "5"}, input, new Line(5, 5, LINE, new Point(1, 2), new Point(1, 5)));
        Mockito.verify(drawLine, Mockito.times(1)).draw(Mockito.any(), Mockito.any());
    }

    @Test
    void handleLineCanvasNotDrawn() {
        Mockito.when(inputParameterValidation.isCanvasDrawn(Mockito.any())).thenReturn(false);

        parseLineInput.parseLineInput(new String[]{LINE, "1", "2", "1", "5"}, new char[][]{}, new Line(5, 5, LINE, new Point(1, 2), new Point(1, 5)));
        Mockito.verify(drawLine, Mockito.never()).draw(Mockito.any(), Mockito.any());
    }

    @Test
    void handleLineInCorrectNoOfParametersEntered() {
        Mockito.when(inputParameterValidation.isCanvasDrawn(Mockito.any())).thenReturn(true);
        Mockito.when(inputParameterValidation.areCorrectNoOfParametersEntered(Mockito.anyString(), Mockito.any())).thenReturn(false);

        parseLineInput.parseLineInput(new String[]{LINE, "1", "2", "1", "5", "9"}, new char[][]{}, new Line(5, 5, LINE, new Point(1, 2), new Point(1, 5)));
        Mockito.verify(drawLine, Mockito.never()).draw(Mockito.any(), Mockito.any());
    }

    @Test
    void handleLineIncorrectParameterType() {
        Mockito.when(inputParameterValidation.isCanvasDrawn(Mockito.any())).thenReturn(true);
        Mockito.when(inputParameterValidation.areCorrectNoOfParametersEntered(Mockito.anyString(), Mockito.any())).thenReturn(true);
        Mockito.when(inputParameterValidation.areParameterTypesCorrect(Mockito.anyString(), Mockito.any())).thenReturn(false);

        parseLineInput.parseLineInput(new String[]{LINE, "1", "i", "1", "5"}, new char[][]{}, new Line(5, 5, LINE, new Point(1, 2), new Point(1, 5)));
        Mockito.verify(drawLine, Mockito.never()).draw(Mockito.any(), Mockito.any());
    }
}
