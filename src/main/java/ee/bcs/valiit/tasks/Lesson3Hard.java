package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {
    public static void main(String[] args) {
        randomGame();
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        return 0;
    }

    public static void randomGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
        Random random = new Random(); //loob sk2nneri
        int randomNumber = random.nextInt(100); //programm gen random numbri
        boolean hasWon = false;
        System.out.println("I have chosen random number from 0-100");
        System.out.println("Try to guess it");

        //System.out.println(randomNumber);
        Scanner scanner = new Scanner(System.in);

        for (int i = 10; i > 0; i--) {
            System.out.println("You have " + i + "guess(es) left. Choose again!");
            int guess = scanner.nextInt();
            System.out.println("Your guess was: " + guess);

            if (randomNumber < guess) {
                System.out.println("Its smaller than " + guess);
            }
            if (randomNumber > guess) {
                System.out.println("Its bigger than " + guess);
            }
            if (randomNumber == guess) {
                hasWon = true;
                break;
            }
        }
        if(hasWon){
            System.out.println("YOU WON!");
        } else{
            System.out.print("You lost!. Correct number was " + randomNumber);
        }
    }

    public static String morseCode(String text) {
        //TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis(https://en.wikipedia.org/wiki/Morse_code)
        //Kasuta sümboleid .ja -
        return "";
    }
}

