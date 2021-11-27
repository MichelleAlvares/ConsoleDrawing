package com.cs.print;

public class PrintArray {

    public void printCharArray(char[][] chars) {
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
