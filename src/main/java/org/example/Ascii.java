package org.example;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Ascii {
    private List<BigInteger> result = new ArrayList<>();
    private String input = "";
    private char[] chars = new char[1000];
    private String string = "";

    public Ascii(Hash hash) {

        this.input = hash.getString();
       chars = hash.getString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
           /* if (i % 3 != 0 || i == 0) {
                string = string.concat(String.valueOf((int)chars[i]));
            } else {
                BigInteger k = BigInteger.valueOf(Integer.parseInt(string));
                result.add(k);
                string = "";
                string = string.concat(String.valueOf((int)chars[i]));
            }*/
        result.add(BigInteger.valueOf((Integer.parseInt(String.valueOf((int)chars[i])))));

        }
    }

    public List<BigInteger> getByteList() {
        return this.result;
    }
}
