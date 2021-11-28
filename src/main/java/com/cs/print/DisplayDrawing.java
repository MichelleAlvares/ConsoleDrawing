package com.cs.print;

public class DisplayDrawing {

    public void printDrawing(char[][] chars) {
        if (chars != null && chars.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (char[] l : chars) {
                for (char s : l) {
                    sb.append(s);
                }
                System.out.println(sb.toString());
                sb.setLength(0);
            }
        }
    }
}
