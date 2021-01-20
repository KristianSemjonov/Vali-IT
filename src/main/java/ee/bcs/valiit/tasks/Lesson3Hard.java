package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {
    public static void main(String[] args) {
        //System.out.println(evenFibonacci(10));
        //System.out.println(morseCode("sos"));
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        // The first few terms of Fibonacci Numbers are, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233
        int a = 0;
        int b = 1;
        int sum = 0;
        while (b <= x) {
            if (b % 2 == 0) {
                sum += b;
            }
            int tmp = a;
            a = b;
            b = tmp + b;
        }
        return sum;
    }


//    public static String randomGame(int a) {
//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random(); //loome random inti ehk objekti, selleks et tekiks v]imalus kutsuda v2lja rnandom inti
//        int count = 0;
//        int randomNumber = random.nextInt(100);
//        while (true) {
//            count++;
//            System.out.println("Sisesta number");
//            int guess = scanner.nextInt();
//            if (guess == randomNumber) {
//                System.out.println("Arvasid ära " + count + " korraga");
//                break;
//            } else if (count >= 10) {
//                System.out.println("Ei arvanud ära. Tegelik number oli: " + randomNumber);
//                break;
//            } else if (guess > randomNumber) {
//                System.out.println("Number oli väiksem");
//            } else {
//                System.out.println("Number oli suurem");
//            }
//            return randomNumber;
//        }
//    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        Map<String, String> morseCodes = new HashMap<>();
        morseCodes.put("s", "...");
        morseCodes.put("o", "---");
        morseCodes.put("i", "..");
        morseCodes.put("m", "--");

        String result = "";
        for (int i = 0; i < text.length(); i++) {
            String character = text.substring(i, i + 1);
            result += morseCodes.get(character) + " ";
        }
        return result;
    }
}