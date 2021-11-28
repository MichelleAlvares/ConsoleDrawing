package com.cs.parse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class ParseQuitInputTest {

    private ParseQuitInput parseQuitInput = new ParseQuitInput();

    @Test
    void isConsoleCommandInputPresentTest() {
        Scanner scanner = new Scanner("tt");
        parseQuitInput.parseQuitInput(scanner);
        Assertions.assertThrows(IllegalStateException.class, scanner::nextLine);
    }
}
