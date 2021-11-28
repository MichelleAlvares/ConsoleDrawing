package com.cs.parse;

import com.cs.draw.DrawCanvas;
import com.cs.model.Canvas;
import com.cs.util.CanvasUtil;
import com.cs.validation.InputParameterValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.cs.constants.AppConstants.CANVAS;

@ExtendWith(MockitoExtension.class)
class ParseCanvasInputTest {

    @Mock
    private InputParameterValidation inputParameterValidation;
    @Mock
    private CanvasUtil canvasUtil;
    @Mock
    private DrawCanvas drawCanvas;
    @InjectMocks
    private ParseCanvasInput parseCanvasInput;

    @Test
    void handleCanvasInput() {
        Mockito.when(inputParameterValidation.valid(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(true);
        Mockito.when(canvasUtil.getShape(Mockito.any(), Mockito.any())).thenReturn(new Canvas());
        Mockito.doNothing().when(drawCanvas).draw(Mockito.any(), Mockito.any());

        parseCanvasInput.parseCanvas(new String[]{CANVAS, "1", "2"}, new char[][]{}, new Canvas(5, 5, CANVAS));
        Mockito.verify(drawCanvas, Mockito.times(1)).draw(Mockito.any(), Mockito.any());
    }

    @Test
    void handleCanvasInputValidationFailed() {
        Mockito.when(inputParameterValidation.valid(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(false);

        parseCanvasInput.parseCanvas(new String[]{CANVAS, "1", "y"}, new char[][]{}, new Canvas(5, 5, CANVAS));
        Mockito.verify(drawCanvas, Mockito.never()).draw(Mockito.any(), Mockito.any());
    }
}
