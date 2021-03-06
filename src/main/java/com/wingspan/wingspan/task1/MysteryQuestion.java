package com.wingspan.wingspan.task1;

public class MysteryQuestion {

    /**
     * Encodes passed param String s according to rules: - only stings with .length() == 10 are
     * allowed for encoding. - inserts '(' before 1-st character - inserts ')' after 3-rd character
     * - inserts '-' after 6-th character - digits stay without changes - letters replacing
     * allgorithm: - #1 get ASCII representation of lowercased letter and subtract 97 (ASCII
     * representation of 'a'). save result - #2 50 (ASCII representation fo '2') + result from #1
     * divided by / 3 - Non alfanumeric symbols produce RuntimeException
     */
    public static String function(String s) {
        if (s.length() != 10) {
            throw new RuntimeException();
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                sb.append('(');
            } else if (i == 3) {
                sb.append(')');
            } else if (i == 6) {
                sb.append('-');
            }
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (Character.isLetter(c)) {
                char c1 = (char) (Character.toLowerCase(c) - 'a');
                char c2 = (char) (((int) '2') + (c1 / 3));
                sb.append(c2);
            } else {
                throw new RuntimeException();
            }
        }
        return sb.toString();
    }
}
