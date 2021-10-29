package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PubKey {
    private List<Long> resultList = new ArrayList<>();
    private List<Long> encryptList = new ArrayList<>();
    private Iterator<Long> iterator;
    private long e;
    private long n;


    public PubKey(List<Long> list, long e, long n) {
        this.encryptList = list;
        this.e = e;
        this.n = n;
        iterator = encryptList.iterator();
        while(iterator.hasNext()) {
            long k = iterator.next();
            long i = (long)Math.pow(k,e) % n;
            resultList.add(i);
        }
    }

    public List<Long> getResultList() {
        return this.resultList;
    }
}
