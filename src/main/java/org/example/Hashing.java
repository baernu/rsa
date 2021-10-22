package org.example;

import java.util.ArrayList;
import java.util.List;

public class Hashing extends Hash  {
    private  List<Hash> hashList = new ArrayList<>();

    public Hashing(String string, int blockSize) {
        char[] chars = string.toCharArray();
        int length = chars.length;
        int size = length;
        int i = 0;
        char[] chars1;


        while (size > 0) {
            int k = 0;
            if (size > blockSize) {
                chars1 = new char[blockSize];
            } else {
                chars1 = new char[size];
            }
            while (i < length && k < blockSize) {
                chars1[k] = chars[i];
                k++; i++;
                size--;
            }

            hashList.add(new Hash<String>(String.valueOf(chars1)));

        }
    }

    public List<Hash> getHashList() {
        return this.hashList;
    }
}
