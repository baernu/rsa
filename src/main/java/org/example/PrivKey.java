package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrivKey extends Decrypt{

    private List<BigInteger> resultList = new ArrayList<>();
    private Iterator<BigInteger> iterator = decryptList.iterator();

    public PrivKey(List<BigInteger> list, BigInteger d, BigInteger n) {
        super(list, d, n);
        while(iterator.hasNext()) {
            BigInteger k = iterator.next();
            BigInteger i = k.modPow(d,n);
            resultList.add(i);
        }
    }

    public List<BigInteger> getResultList() {
        return this.resultList;
    }
}
