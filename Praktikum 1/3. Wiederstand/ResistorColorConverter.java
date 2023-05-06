import java.util.Scanner;

public class ResistorColorConverter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie die Farben auf dem Resistor an:");
        String colors = sc.nextLine().toLowerCase();
        
        String[] colorArr = colors.split(" ");
        String color1 = colorArr[0];
        String color2 = colorArr[1];
        String color3 = colorArr[2];
        String color4 = null;
        
        if(colorArr.length == 3){
            System.out.println((valueAssignment(color1) * valueAssignment(color2)) * valueAssignment(color3) + "Ohm");
        } else if(colorArr.length == 4){
            color4 = colorArr[3];
            System.out.println((valueAssignment(color1) * valueAssignment(color2) * valueAssignment(color3)) * valueAssignment(color4) + "Ohm");
        }
    }

    public static float valueAssignment(String input){
        switch (input) {
            case "silber":
                return 0.01f;
            case "gold":
                return 0.1f;
            case "schwarz":
                return 1;
            case "braun":
                return 10;
            case "rot":
                return 100;
            case "orange":
                return 1_000;
            case "gelb":
                return 10_000;
            case "gruen":
                return 100_000;
            case "blau":
                return 1_000_000;
            case "violett":
                return 10_000_000;
            case "grau":
                return 100_000_000;
            case "weiß":
                return 1_000_000_000;
            default:
                //throw new UngueltigeEingabe("Die Farbe " + input + " ist nicht vorhanden ");
                System.out.println("Die Farbe" + input + "ist nicht vorhanden");
                System.exit(0);
                return 0;
        }
    }
}
