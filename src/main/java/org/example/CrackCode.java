package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrackCode {
    private long n;
    private long d ;
    private long e;
    private long p;
    private long q;
    private List<Primefactor> primeFactorList = new ArrayList<>();
    private List<Long> dList = new ArrayList<>();

    public CrackCode( long e, long n) {

        this.e = e;
        this.n = n;
    }

    public void crackMethod() {
        long k = (long)Math.sqrt(n);
        for (; k < n; k++) {
            long x = k*k - n;
            if(x % 10 != 2 || x % 10 != 3 || x % 10 != 7 || x % 10 != 8){
                if (Math.sqrt(x) % 1 == 0) {
                    long u = k;
                    long v = (long) Math.sqrt(x);
                    p = u + v;
                    q = u - v;
                    primeFactorList.add(new Primefactor(p,q));
                }

            }

        }

    }

    public List<Primefactor> getPrimeFactorList() {
        return this.primeFactorList;
    }

    public void generateD() {
        Iterator<Primefactor> iterator = primeFactorList.iterator();
        while (iterator.hasNext()) {
            Primefactor actualPair = iterator.next();
            long p = actualPair.getP();
            long q = actualPair.getQ();
            long lamda_n = (p - 1)*(q - 1);
            while (d < lamda_n) {
                if ((d * e) % lamda_n == 1) {
                    dList.add(d);
                }
                d++;
            }
        }

    }


   /* public boolean isPrime(BigInteger p) {
        boolean flag = false;
        BigInteger i = new BigInteger( "2");

        for (; !i.equals(p.divide(BigInteger.valueOf(2))); i.add(BigInteger.valueOf(1))) {
            if (p.mod(i).equals(BigInteger.valueOf(0)) && !p.equals(BigInteger.valueOf(2))) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return true;
        } else {
            return false;
        }
    }*/


    public List<Long> getDlist() {
        return this.dList;
    }
}
