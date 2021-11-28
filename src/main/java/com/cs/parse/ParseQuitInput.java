package com.cs.parse;

import java.util.Scanner;
import static com.cs.constants.AppConstants.SCANNER_NOT_CLOSED;

class ParseQuitInput {

    void parseQuitInput(Scanner scanner) {
        try {
            if (scanner != null)
                scanner.close();
        } catch (Exception e) {
            System.out.println(SCANNER_NOT_CLOSED);
        }
    }
}
