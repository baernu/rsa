package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrivKey {

    private List<Long> encryptList = new ArrayList<>();
    private List<Long> resultList = new ArrayList<>();
    private Iterator<Long> iterator ;

    public PrivKey(List<Long> list, long d, long n) {
        encryptList = list;
        iterator = encryptList.iterator();
        while(iterator.hasNext()) {
            long k = iterator.next();
            BigInteger i = BigInteger.valueOf(k).modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
            resultList.add(i.longValue());
        }
    }

    public List<Long> getResultList() {
        return this.resultList;
    }
}
