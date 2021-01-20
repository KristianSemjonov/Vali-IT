package ee.bcs.valiit.tasks;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Lesson2 {

    public static void main(String[] args) {
        exercise5(1,10);
        System.out.println(exercise5(1,10));
        //seqLength(2);

        // TODO siia saab kirjutada koodi testimiseks
    }

    // TODO loo 10 elemendile täisarvude massiv
    // TODO loe sisse konsoolist 10 täisarvu
    // TODO trüki arvud välja vastupidises järiekorras
    public static void exercise1() {
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Sisesta nr: ");
            array[i] = scanner.nextInt(); // mida ta annab? annab sisestada uut numbrit?
        }
        for (int i = 9; i >= 0; i--) { // see funktsioon trykib arvud vastupidises j2rjekorras
            System.out.println(array[i] + " ");
        }
    }

    // TODO prindi välja x esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static void exercise2(int x) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    //for(int i = 2; i <= x*2; i=i+2){
    //for(int = 1; i<=x;i++)
    //System.put.println(i*2 + " ")
    //System.out.print(x + " ");

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void exercise3(int x, int y) {
        for (int i = 1; i <= x; ++i) { // prindib ylevalt alla i numbrid 3
            for (int j = 1; j <= y; ++j) {
                System.out.print(i * j + " "); // prindib yhe reana
            }
            System.out.println(""); //prindib ruuduna
        }
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element
    // nr 1 = 0
    // nr 2 = 1
    // nr 3 = 1
    public static int exercise4(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0;
            int b = 1;
            for (int i = 1; i < n; i++) {
                int tmp = a; //antud kohas tähendab ajutine a väärtus mida?`kas on for(ajutine väärtus?)
                a = b;
                b = b + tmp; //muidu peaks oelma a+b, aga enne a juba kasutatud 2ra, loome ajutise a
            }
            return b;
        }
    }

    public static String exercise5(int x, int y) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        // TODO 1 (tee alamfunktsioon) mis leiab 3n+1 sequenci pikkuse
        // kui on paaris / 2 kui on paaritu *3+1
        // TODO 2 tee tsükkel mis leiab i -> j kõige suurema tsükkli pikkuse
        int maxLength = 0; //suurema tsykkli pikkus alguses on 0? tsykkli pikus nr 1, nr 10, nr 20 ja missugusne k]ige pikem
        for (int i = x; i <= y; i++) { //i on 1, 1 on v2iksem kui 10, siis ligub j'rgmisle reala ja jada pikkuseks on 1?
            int seqLength = seqLength(i); //defineerime squence nime
            if (seqLength > maxLength) {
                maxLength = seqLength; //k]ige pikem jada pikkus selle svahemikus
            }
        }
        return x + " " + y + " " + maxLength;
    }

    public static int seqLength(int n) { //alam funktsioon, mis leiab 3n+1 jada pikkuse
        int count = 1; //jada algab  //sisend on yks, kordagi ysklisse ei l2he
        while (n > 1) { //kui jah
            count++; // siis liida üks jada juurde ja see iga alloleva tsükli kohta?
            if (n % 2 == 0) { //
                n = n / 2; // kui tsükkel n on paaris
            } else {
                n = n * 3 + 1; //tsükkel n on paaritu
            }
        }
        return count;
    }
}

