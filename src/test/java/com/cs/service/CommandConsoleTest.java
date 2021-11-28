package com.cs.service;

import com.cs.parse.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
class CommandConsoleTest {

    private Scanner scanner;
    @Mock
    private DrawingCommandParser drawingCommandParser;
    @InjectMocks
    private CommandConsoleService consoleService = new CommandConsoleService();

    @Test
    void processScannerInputCanvasTest() {
        Mockito.when(drawingCommandParser.parseCommand(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}});
        scanner = new Scanner("C 5 3");
        consoleService.processCommand("C 5 3", scanner);
        Mockito.verify(drawingCommandParser, Mockito.times(1)).parseCommand(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void isConsoleCommandInputPresentTest() {
        scanner = new Scanner("tt");
        Assertions.assertTrue(consoleService.isConsoleCommandInputPresent(scanner));
        scanner.close();
        Assertions.assertFalse(consoleService.isConsoleCommandInputPresent(scanner));
    }
}
