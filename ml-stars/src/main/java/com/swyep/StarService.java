package com.swyep;

public class StarService {

    public static String SYMBOL = "*";

    public String getStars(int totalRows) {
        StringBuilder str = new StringBuilder();
        if (totalRows == 0) return "";
        int columnLength = ((totalRows - 1) * 2) + 1;
        for (int n = 0; n < totalRows; n++) {
            int contentLength = (n * 2) + 1;
            Double sideLength = Math.floor((columnLength - contentLength) / 2.0d);
            str.append(replicateStringByTimes(" ", sideLength.intValue()))
                    .append(replicateStringByTimes(SYMBOL, contentLength))
                    .append(replicateStringByTimes(" ", sideLength.intValue()))
                    .append("\n");
        }
        return str.toString();
    }

    private String replicateStringByTimes(String s, int times) {
        StringBuilder str = new StringBuilder();
        for (int i = 0 ; i < times ; i++) {
            str.append(s);
        }
        return str.toString();
    }

}