import java.util.Random;

public class Ziegenproblem {
    public static void main(String[] args) {
        Random rand = new Random();
        int Iterationen = 10_000_000;
        int tauschen = 0;
        int bleiben = 0;
        for (int i = 0; i < Iterationen; i++) {
            int[] türen = {0, 0, 1};
            int gewaehlt = rand.nextInt(3);
            int gezeigt;
            do {
                gezeigt = rand.nextInt(3);
            } while (gezeigt == gewaehlt || türen[gezeigt] == 1);
                int andere = 3 - gewaehlt - gezeigt;
            if (türen[andere] == 1) {
                tauschen++;
            } else {
                bleiben++;
            }
        }
        double tauschenProzent = (double) tauschen / Iterationen * 100;
        double bleibenProzent = (double) bleiben / Iterationen * 100;
        System.out.println("Türen tauschen: " + tauschenProzent + "%");
        System.out.println("Nicht tauschen: " + bleibenProzent + "%");
    }
}
