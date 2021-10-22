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
    private final BigInteger p = BigInteger.valueOf(11);
    private final BigInteger q = BigInteger.valueOf(13);
    private final BigInteger n = p.multiply(q);
    private final BigInteger np = (p.subtract(BigInteger.valueOf(1))).multiply(q.subtract(BigInteger.valueOf(1)));
    private final BigInteger d = BigInteger.valueOf(103);

    public static void main( String[] args )
    {
        App app = new App();

        String input = "Doch je mehr sich die Kryptowährungen dort einnisten, desto mehr steigt das Risiko am Finanzplatz. Kommt es zu einem Absturz der Bitcoin-Kurse, könnte es das künftig auch einen breiteren Anlegerkreis treffen und nicht nur einige wenige Spekulanten.Im Falle des Bitcoin-ETF des amerikanische Anbieter ProShares stellt sich zudem die Frage, wie stark der Zusammenhang mit dem Bitcoin-Kurs ist. Der neue Bitcoin-ETF investiert in Futures. Dabei handelt sich um Terminkontrakte, die den künftigen Preis der Kryptowährung abbilden. Somit setzen die Anleger also nicht direkt Eins zu Eins auf den Bitcoin, sondern indirekt über Futures-Kontrakte.";
        Hashing hash = new Hashing(input, 200);
        List<Hash> hasList = hash.getHashList();
        Iterator<Hash> iterator1 = hasList.iterator();
        List<BigInteger> pubResult = new ArrayList<>();
        while (iterator1.hasNext()) {
            Ascii ascii = new Ascii(iterator1.next());
            PubKey pubKey = new PubKey(ascii.getByteList(), app.e,app.n);

            pubKey.getResultList().stream().forEach(e -> System.out.print(e + " "));
            pubResult.addAll(pubKey.getResultList());
        }

        System.out.println();
        PrivKey privKey = new PrivKey(pubResult,app.d, app.n);
        privKey.getResultList().stream().forEach(e -> System.out.print(e + " "));
        System.out.println();
        privKey.getResultList().stream().forEach(e -> {
            System.out.print((char)e.byteValue());
        });


        System.out.println();
        int c = (int) 'D';
        int d = (int)'o';
        System.out.println(c + " " + d);



        /*PrivKey privKey = new PrivKey(dArray[0], app.n);

        ascii.getByteList().stream().forEach(e-> System.out.println(e));
        Hashing hash = new Hashing(input, 200);
        List<String> hasList = hash.getHashList();
        Iterator<String> iterator = hasList.iterator();
        Ascii ascii = new Ascii(iterator.next());
        List<Integer> byteList = ascii.getByteList();
        Decrypt decrypt = new Decrypt(byteList, app.e , app.n);
        Encrypt encrypt = new Encrypt(byteList, app.d, app.n);*/
    }
}
