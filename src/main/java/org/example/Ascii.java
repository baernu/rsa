package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Ascii {
    private List<Long> result = new ArrayList<>();
    private String input = "";
    private char[] chars = new char[1000];
    private String string = "";

    public Ascii(Hash<String> hash) {

        this.input = hash.getValue();
       chars = hash.getValue().toCharArray();
        for (int i = 0; i < chars.length; i++) {
//            result.add(BigInteger.valueOf((Integer.parseInt(String.valueOf((int)chars[i])))));
            result.add((long)(int)chars[i]);
//            result.add((long)chars[i]);
        }
    }

    public List<Long> getByteList() {
        return this.result;
    }
}
