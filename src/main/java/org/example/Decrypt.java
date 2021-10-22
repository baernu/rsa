package org.example;

import java.math.BigInteger;
import java.util.List;

public class Decrypt {
    protected List<BigInteger> decryptList;
    protected BigInteger n;
    protected BigInteger d;

    public Decrypt() {
    }

    public Decrypt(List<BigInteger> list, BigInteger d, BigInteger n) {
        this.decryptList = list;
        this.n = n;
        this.d = d;
    }

    public List<BigInteger> getDecryptList() {
        return decryptList;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getD() {
        return d;
    }
}
