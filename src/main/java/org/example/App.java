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

    private final BigInteger e = BigInteger.valueOf(7);
//    private final BigInteger p = BigInteger.valueOf(11);
//    private final BigInteger q = BigInteger.valueOf(13);
    private final BigInteger n = BigInteger.valueOf(143); //p.multiply(q);
//    private final BigInteger np = (p.subtract(BigInteger.valueOf(1))).multiply(q.subtract(BigInteger.valueOf(1)));
    private final BigInteger d = BigInteger.valueOf(103);

    public static void main( String[] args )
    {
        App app = new App();

        String input = "Doch je mehr sich die Kryptowährungen dort einnisten, desto mehr steigt das Risiko am Finanzplatz. Kommt es zu einem Absturz der Bitcoin-Kurse, könnte es das künftig auch einen breiteren Anlegerkreis treffen und nicht nur einige wenige Spekulanten.Im Falle des Bitcoin-ETF des amerikanische Anbieter ProShares stellt sich zudem die Frage, wie stark der Zusammenhang mit dem Bitcoin-Kurs ist. Der neue Bitcoin-ETF investiert in Futures. Dabei handelt sich um Terminkontrakte, die den künftigen Preis der Kryptowährung abbilden. Somit setzen die Anleger also nicht direkt Eins zu Eins auf den Bitcoin, sondern indirekt über Futures-Kontrakte.";
        Hashing hashing = new Hashing(input, 100);
        List<Hash> hasList = hashing.getHashList();
        Iterator<Hash> iterator1 = hasList.iterator();
        List<BigInteger> pubResult = new ArrayList<>();
        while (iterator1.hasNext()) {
            Ascii ascii = new Ascii(iterator1.next());
            PubKey pubKey = new PubKey(ascii.getByteList(), app.e,app.n);
            pubResult.addAll( pubKey.getResultList());
            pubKey.getResultList().stream().forEach(e -> System.out.print(e + " "));
            System.out.println();
            PrivKey privKey = new PrivKey(pubKey.getResultList(), app.d, app.n);
            privKey.getResultList().stream().forEach(e -> System.out.print(e + " "));
            System.out.println();
            privKey.getResultList().stream().forEach(e -> {
                System.out.print((char)e.byteValue());
            });

        }
        CrackCode crackCode = new CrackCode(app.d, app.e, app.n);
        crackCode.crackMethod();
        crackCode.generateD();
        List<Integer> dList = crackCode.getDlist();
        dList.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();
        dList = crackCode.getDlist();
        for (int  dValue : dList) {
            PrivKey privKey = new PrivKey(pubResult, BigInteger.valueOf(dValue), app.n);
            privKey.getResultList().stream().forEach(e -> {
                System.out.print((char) e.byteValue());
            });
        }

    }
}
