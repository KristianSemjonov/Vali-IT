package ee.bcs.valiit.tasks;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.sqrt;


public class Lesson3 {
    public static void main(String[] args) {
        //System.out.println(sum(new int[]{1,2,3,4,5}));
        //System.out.println(factorial(5));
        //System.out.println(sort(new int[] {3,5,1}));
        //System.out.println(Arrays.toString(sort(new int[]{5, -6, 9, 12, 7})));
        //System.out.println(Arrays.toString(sort2(new int[] {5, -6, 9, 12, 7})));
        //System.out.println(reverseString("Kristian"));
        System.out.println(isPrime(1)); //FALSE;
        System.out.println(isPrime(2)); //isPrime TRUE;
        System.out.println(isPrime(3)); //isPrime TRUE;
        System.out.println(isPrime(4)); //false

    }

    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x

        int sum = 0;
        for (int i = 0; i < x.length; i++) { //.length funktsiooniga vaatab kogu pikkuse jada 1 kuni 5?
            sum += x[i];                 //liidame summile X v''rtuse I /positsioonil i
        }
        return sum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.

        int f = x;                     //algab nt 5-st, teine tsykkel 10, siis 30 ja viimane 120, edasi ei l2he kuna 5i ei ole v2iksem 5-st
        for (int i = 1; i < x; i++) {  // 1 on v2iksem kui 5, siis liigume alla ja korrutame i 1 x5,
            // siis liigume tagasi i2, on v2iksem 5, siis liigume alla ja i2 x 5 saame 10 ja edasi ts[kklis
            f *= i;
        }
        return f;
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
    }

    // 5, -6, 9, 12, 7
    public static int[] sort(int[] a) { //bubble
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                }
            }
        }
        return a;
    }

    // 5, -6, 9, 12, 7
    public static int[] sort2(int[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            int minIndex = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            int tmp = array[j];
            array[j] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi

        System.out.println("Sisesta tekst: ");

        Scanner read = new Scanner(System.in);    //loome võimekuse trükkida sisse output aknasse
        String str = read.nextLine();               //loeb sisestatud teksti
        String reverse = "";                        //muutuja mille väärtus on String

        for (int i = str.length() - 1; i >= 0; i--) {     //loeme üksikute karakterite järg

            reverse = reverse + str.charAt(i); //tyhajle stringile lisan "N" hypab tagasi, i = 5, kas 5 suurem kui 0
            //6 indeks + 5 indeksi kohal olev t'ht
        }
        return reverse;
    }

    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        if (x <= 1) {   //need pole kohe kindlasti prime arvud, seega kohe v2listame v2lja
            return false; // kui vastab nxuetele, siis tagastame "false"
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) { //kontrollime kas selle jagatise j22k on null ehk kas tegu on paarisarv?
                return false;
            }

        }
        return true;
    }
}
