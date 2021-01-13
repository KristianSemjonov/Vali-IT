package ee.bcs.valiit.tasks;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;

import java.util.ArrayList;

public class Lesson3 {
    public static void main(String[] args) {
        //System.out.println(sum(new int[]{1,2,3,4,5}));
        //System.out.println(factorial(5));
        System.out.println(sort(int [] 3,5,1));
    }

    public static int sum(int[] x){
        // Todo liida kokku kõik numbrid massivis x

        int sum = 0;
        for(int i=0; i < x.length; i++){ //.length funktsiooniga vaatab kogu pikkuse jada 1 kuni 5?
            sum +=x [i]; //liidame summile X v''rtuse I /positsioonil i
        }
        return sum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.

        int f = x; //algab nt 5-st, teine tsykkel 10, siis 30 ja viimane 120, edasi ei l2he kuna 5i ei ole v2iksem 5-st
        for(int i = 1;i<x;i++){ // 1 on v2iksem kui 5, siis liigume alla ja korrutame i 1 x5,
            // siis liigume tagasi i2, on v2iksem 5, siis liigume alla ja i2 x 5 saame 10 ja edasi ts[kklis
            f *=i;
        }
        return f;
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
    }

    public static int[] sort(int[] a) { // int [] a {3,5,1}
        // TODO sorteeri massiiv suuruse järgi.
        // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    List<Integer> numberList = new ArrayList<>();
    ArrayList<>() = min.ArrayList<>();
    int a = min.ArrayList<>();

        return new int[a];
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        return "";
    }

    public static boolean isPrime(int x){
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        return false;
    }
}
