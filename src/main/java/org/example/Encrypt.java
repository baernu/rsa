package org.example;

import java.math.BigInteger;
import java.util.List;

public class Encrypt {

    protected List<BigInteger> encryptList;
    protected BigInteger e;
    protected BigInteger n;

    public Encrypt() {

    }

    public Encrypt(List<BigInteger> list, BigInteger e, BigInteger n) {
        this.encryptList = list;
        this.e = e;
        this.n = n;
    }

    public List<BigInteger> getEncryptList() {
        return encryptList;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getN() {
        return n;
    }
}
