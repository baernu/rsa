package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrackCode {
    private int n;
    private int d;
    private int e;
    private List<Primefactor> primeFactorList = new ArrayList<>();
    private List<Integer> dList = new ArrayList<>();

    public CrackCode(BigInteger d, BigInteger e, BigInteger n) {
        this.d = d.intValue();
        this.e = e.intValue();
        this.n = n.intValue();
    }

    public void crackMethod() {
        int k = (int)Math.sqrt(n);
        for (; k < k*n; k++) {
            if(n % k == 0) {
                int p = n/k;
                if ( isPrime(p) && isPrime(k)) {
                    if ((Math.pow(k + p, 2) - Math.pow(k - p, 2)) / 4 == n) {
                        primeFactorList.add(new Primefactor(p, k));
                    }
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
            int p = actualPair.getP();
            int q = actualPair.getQ();
            int lamda_n = (p-1)*(q-1);
            System.out.println(p + " " + q);
            while (d < 1000) {
                if (d*e % lamda_n == 1) {
                    dList.add(d);
                }
                d++;
            }
        }

    }

    public boolean isPrime(int p) {
        boolean flag = false;
        for (int i = 2; i <= p / 2; ++i) {
            if (p % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return true;
        } else {
            return false;
        }
    }


    public List<Integer> getDlist() {
        return this.dList;
    }
}
