package com.cs.service;

import com.cs.parse.ParseBucketFillInput;
import com.cs.parse.ParseCanvasInput;
import com.cs.parse.ParseLineInput;
import com.cs.parse.ParseRectangleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
class DrawingCommandConsoleTest {

    private Scanner scanner;
    @Mock
    private ParseCanvasInput parseCanvasInput;
    @Mock
    private ParseLineInput parseLineInput;
    @Mock
    private ParseRectangleInput parseRectangleInput;
    @Mock
    private ParseBucketFillInput parseBucketFillInput;
    @InjectMocks
    private CommandConsoleService consoleService = new CommandConsoleService();

    @Test
    void processScannerInputCanvasTest() {
        Mockito.when(parseCanvasInput.parseCanvas(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}});
        scanner = new Scanner("C 5 3");
        consoleService.processCommand("C 5 3", scanner);
        Mockito.verify(parseCanvasInput, Mockito.times(1)).parseCanvas(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void processScannerInputLineTest() {
        Mockito.doNothing().when(parseLineInput).parseLineInput(Mockito.any(), Mockito.any(), Mockito.any());
        scanner = new Scanner("L 5 3 5 8");
        consoleService.processCommand("L 5 3 5 8", scanner);
        Mockito.verify(parseLineInput, Mockito.times(1)).parseLineInput(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void processScannerInputRectangleTest() {
        Mockito.doNothing().when(parseRectangleInput).parseRectangleInput(Mockito.any(), Mockito.any(), Mockito.any());
        scanner = new Scanner("R 5 3 5 8");
        consoleService.processCommand("R 5 3 5 8", scanner);
        Mockito.verify(parseRectangleInput, Mockito.times(1)).parseRectangleInput(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void processScannerInputFillTest() {
        Mockito.doNothing().when(parseBucketFillInput).parseBucketFillInput(Mockito.any(), Mockito.any(), Mockito.any());
        scanner = new Scanner("B 5 3 o");
        consoleService.processCommand("B 5 3 o", scanner);
        Mockito.verify(parseBucketFillInput, Mockito.times(1)).parseBucketFillInput(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void processScannerQuitTest() {
        scanner = new Scanner("Q");
        consoleService.processCommand("Q", scanner);
        Mockito.verify(parseCanvasInput, Mockito.never()).parseCanvas(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(parseLineInput, Mockito.never()).parseLineInput(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(parseRectangleInput, Mockito.never()).parseRectangleInput(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(parseBucketFillInput, Mockito.never()).parseBucketFillInput(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void processScannerInvalidCommandTest() {
        scanner = new Scanner("7 5 3 o");
        consoleService.processCommand("7 5 3 o", scanner);
        Mockito.verify(parseCanvasInput, Mockito.never()).parseCanvas(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(parseLineInput, Mockito.never()).parseLineInput(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(parseRectangleInput, Mockito.never()).parseRectangleInput(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(parseBucketFillInput, Mockito.never()).parseBucketFillInput(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void processScannerEmptyInputTest() {
        scanner = new Scanner("");
        consoleService.processCommand("", scanner);
        Mockito.verify(parseCanvasInput, Mockito.never()).parseCanvas(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(parseLineInput, Mockito.never()).parseLineInput(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(parseRectangleInput, Mockito.never()).parseRectangleInput(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(parseBucketFillInput, Mockito.never()).parseBucketFillInput(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void isConsoleCommandInputPresentTest() {
        scanner = new Scanner("tt");
        Assertions.assertTrue(consoleService.isConsoleCommandInputPresent(scanner));
        scanner.close();
        Assertions.assertFalse(consoleService.isConsoleCommandInputPresent(scanner));
    }
}
