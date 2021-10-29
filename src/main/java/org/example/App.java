package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

//    Aufgabe a)
    private final long e = 7;
    private final long p = 1223;
    private final long q = 6451;
    private final long n = p*q;
//    private final BigInteger np = (p.subtract(BigInteger.valueOf(1))).multiply(q.subtract(BigInteger.valueOf(1)));
    private final long d = 4503943;

    public static void main( String[] args )
    {
        App app = new App();

        String input = "An encryption";
        Hashing hashing = new Hashing(input, 100);
        List<Hash> hasList = hashing.getHashList();
        Iterator<Hash> iterator1 = hasList.iterator();
        List<Long> pubResult = new ArrayList<>();
        while (iterator1.hasNext()) {
            Ascii ascii = new Ascii(iterator1.next());
            PubKey pubKey = new PubKey(ascii.getByteList(), app.e,app.n);
            pubResult.addAll( pubKey.getResultList());
            System.out.println("Output of the encrypted message is as follow: ");
            pubKey.getResultList().stream().forEach(e -> System.out.print(e + " "));
            System.out.println();
            System.out.println();
            PrivKey privKey = new PrivKey(pubKey.getResultList(), app.d, app.n);
            privKey.getResultList().stream().forEach(element -> System.out.print(element + " "));
            System.out.println();
            privKey.getResultList().stream().forEach(e -> {
                System.out.print((char)e.byteValue());
            });

        }
        CrackCode crackCode = new CrackCode(app.e, app.n);
        crackCode.crackMethod();
        crackCode.generateD();
        List<Long> dList = crackCode.getDlist();
        dList.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();
        dList = crackCode.getDlist();

        /*for (long  dValue : dList) {
            PrivKey privKey = new PrivKey(pubResult, dValue, app.n);
            privKey.getResultList().stream().forEach(e -> {
                System.out.print((char) e.byteValue());
            });
        }*/

    }
}
