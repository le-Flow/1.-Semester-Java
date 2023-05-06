import java.util.Scanner;

public class PseudoRandomNumbers {
    public static long m = 2147483647; //modolo
    public static long a = 48271;     //multiplies
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long x, y, min, max, c = 0;
        int anzahl;
        System.out.print("Geben Sie Ihren gewÜnschten Seed ein: ");
        x = sc.nextInt();
        System.out.print("Geben Sie Ihre gewÜnschte Anzahl an Ausgaben ein: ");
        anzahl = sc.nextInt();
        if(x <= 0 || anzahl <= 0){
            System.out.println("Der Seed und die Anzahl muessen einen Wert über 0 haben.");
            return;
        }
        System.out.print("Geben Sie das gewÜnschte Minimum an: ");
        min = sc.nextInt();
        System.out.print("Geben Sie Ihre gewÜnschte Maximum an: ");
        max = sc.nextInt();
        if(min >= max){
            System.out.println("Min muss kleiner als Max sein!");
            return;
        }
        for(int i = anzahl; i > 0; i--){
            x = (a * x + c) % m;
            y = (x % (max - min)) + min;
            System.out.print(y + "   ");
        }
    }
}
