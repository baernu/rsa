package org.example;

import java.util.ArrayList;
import java.util.List;

public class Hashing {
    private List<Hash> hashList = new ArrayList<>();

    public Hashing(String string, int blockSize) {
        char[] chars = string.toCharArray();
        int length = chars.length;
        while (length >= 0) {
            int k = 0;
            char[] chars1 = new char[blockSize];
            while (k < blockSize) {
                chars1[k] = chars[k];
                k++;
            }
            int i = 0;
            hashList.add(new Hash(String.valueOf(chars1), i++));
            length -= 200;

        }


    }

    public List<Hash> getHashList() {
        return this.hashList;
    }
}
