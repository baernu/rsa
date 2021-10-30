package org.example;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    private long d;

    private final long e2 = 5;
    private final long p2 = 4397;
    private final long q2 = 6553;
    private final long n2 = p2*q2;
    private long d2;
    private final long[] array = { 28622196,    21971577,   27158728,     7214722,    23473607,     1701273,     4740891,    27230503,     1720257};
    private List<Long> m_2 = Arrays.stream(array).boxed().collect(Collectors.toList());

    private final long e3 = 11;
    private final long n3 = 94729993;

    private long d3;
    private final long[] array3 = { 68088123,    41089920,    61640887,    68088123,    33554432,     3638134,    41851974,   39858633,    10131853,    68996563,    36901199,    10131853,    76136512};
    private List<Long> m_3 = Arrays.stream(array).boxed().collect(Collectors.toList());

    public static void main( String[] args )
    {
        App app = new App();
        //Crack the code with the missing d. In the following code the d is computed.
        System.out.println("The missing d1 has the value: ");
        CrackCode crackCode = new CrackCode(app.e, app.n);
        crackCode.crackMethod();
        crackCode.generateD();
        List<Long> dList = crackCode.getDlist();
        dList.stream().forEach(e -> System.out.print(e + " "));
        app.d = dList.get(0);
        System.out.println();

        //In the following code the message m_1 is been transformed to ascii and then encrypted with the prims p_1 and q_1 and e.
        //The implementation of the hashing in blocks is programmed in the class Hashing. -> A chararray is divided in blocks and
        //we iterate over the blocks.
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
            //In the following code the encrypted code is been decoded and first print as ascii values, then as text.
            System.out.println("The decrypted ascii values are as follow : ");
            PrivKey privKey = new PrivKey(pubKey.getResultList(), app.d, app.n);
            privKey.getResultList().stream().forEach(element -> System.out.print(element + " "));
            System.out.println();
            System.out.println("The decrypted text is as follow: ");
            privKey.getResultList().stream().forEach(e -> {
                System.out.print((char)e.byteValue());
            });
            System.out.println();
            System.out.println();

            //In the following code the encrypted message m_2 is been decrypted with the prims p_2 and q_2 and e_2.
            //In the following code the encrypted code is been decoded as text.
            //First the missing d is computed.
            System.out.println("The missing d2 has the value: ");
            CrackCode crackCode2 = new CrackCode(app.e2, app.n2);
            crackCode2.crackMethod();
            crackCode2.generateD();
            List<Long> dList2 = crackCode2.getDlist();
            dList2.forEach(e -> System.out.print(e + " "));
            System.out.println();

            //In the following code the message m_2 is decrypted and then ascii is transformed to text.
            for (long d2 : dList2 ) {
                System.out.println("The decrypted ascii values are as follow : ");
                PrivKey privKey2 = new PrivKey(app.m_2, d2, app.n2);
                privKey2.getResultList().stream().forEach(element -> System.out.print(element + " "));
                System.out.println();
                System.out.println("The decrypted message m_2 is as follow: ");
                privKey2.getResultList().stream().forEach(e -> {
                    System.out.print((char) e.byteValue());
                });
                System.out.println();
                System.out.println();
            }
            //In the following code the encrypted message m_3 is been decrypted with n3 and e3.
            //In the following code the encrypted code is been decoded as text.
            //First the missing d is computed.
            System.out.println("The missing d3 has the value: ");
            CrackCode crackCode3 = new CrackCode(app.e3, app.n3);
            crackCode3.crackMethod();
            crackCode3.generateD();
            List<Long> dList3 = crackCode3.getDlist();
            dList3.stream().forEach(e -> System.out.print(e + " "));
            System.out.println();

           /* //In the following code the message m_3 is decrypted and then ascii is transformed to text.
            for (long d3 : dList3) {
                System.out.println("The decrypted ascii values are as follow : ");
                PrivKey privKey3 = new PrivKey(app.m_2, d3, app.n2);
                privKey3.getResultList().stream().forEach(element -> System.out.print(element + " "));
                System.out.println();
                System.out.println("The decrypted message m_3 is as follow: ");
                privKey3.getResultList().forEach(e -> {
                    System.out.print((char) e.byteValue());
                });
                System.out.println();
                System.out.println();
            }*/

        }



    }
}
