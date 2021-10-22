package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PubKey extends Encrypt{
    private List<BigInteger> resultList = new ArrayList<>();
    private Iterator<BigInteger> iterator = encryptList.iterator();


    public PubKey(List<BigInteger> list, BigInteger e, BigInteger n) {
        super(list, e, n);
        while(iterator.hasNext()) {
            BigInteger k = iterator.next();
            BigInteger i = k.modPow(e, n);
            resultList.add(i);
        }
    }

    public List<BigInteger> getResultList() {
        return this.resultList;
    }
}
