import java.util.Scanner;

public class ShipSalvage {    
    final static private char[][] exampleMap = {
        {'O', 'O', ' ', 'O', ' ', ' ', 'O', 'O', 'O', 'O'},
        {' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' '},
        {'O', ' ', ' ', 'O', ' ', 'O', 'O', 'O', ' ', 'O'},
        {'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O'},
        {'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {'O', ' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'O'},
        {' ', ' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'O'},
        {'O', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O'},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', 'O', 'O', 'O', 'O', 'O', 'O'}
    };
    
    
    public static void main(String[] args) {
        FieldState[][] map = getExample();
        Scanner sc = new Scanner(System.in);
        String eingabe;
        
        
        while (!allSalvaged(map)) {
            printMap(map, true);
            eingabe = sc.next();
            probeField(map, eingabe);
        }
        System.out.println("Alle Schiffe geborgen!");
        printMap(map, false);
    }
    
    public static boolean allSalvaged(FieldState[][] map) {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (map[y][x] == FieldState.OCCUPIED_HIDDEN) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void probeField(FieldState[][] map, String field) {

        if (field.length() != 2 ||field.charAt(0) < 'A' || field.charAt(0) > 'J' || field.charAt(1) < '1' || field.charAt(1) > '9') {
            return;
        }

        int xf = Character.toLowerCase(field.charAt(0)) - 97;
        int yf = Character.getNumericValue(field.charAt(1));

        if (xf >= 0 && xf <= 9 && yf >= 0 && yf <= 9) {
            if(map[yf][xf] == FieldState.EMPTY) {
                map[yf][xf] = FieldState.MISS;
                System.out.println("Nichts zu finden!");
            }
            
            if(map[yf][xf] == FieldState.OCCUPIED_HIDDEN) {
                map[yf][xf] = FieldState.OCCUPIED_SALVAGED;
                System.out.println("Wrack gefunden!");
            }
            
            if(map[yf][xf] == FieldState.OCCUPIED_SALVAGED) {
                map[yf][xf] = FieldState.OCCUPIED_SALVAGED;
                System.out.println("Bereits untersucht!");
            }
            
            if(map[yf][xf] == FieldState.MISS) {
                map[yf][xf] = FieldState.MISS;
                System.out.println("Bereits untersucht");
            }   
        }
    }
    
    
    public static void printMap(FieldState[][] map , boolean showHidden) {
        System.out.println("  ABCDEFGHIJ");
        System.out.println(" +----------+");
        
        for (int y = 0; y < 10; y++) {
            System.out.print(y + "|");
            for (int x = 0; x < 10; x++) {
                switch (map[y][x]) {
                    case EMPTY:
                        System.out.print(' ');
                        break;
                    case MISS:
                        System.out.print('X');
                        break;
                    case OCCUPIED_HIDDEN:
                        if (showHidden) {
                            System.out.print('O');
                        }
                        else {
                            System.out.print(' ');

                        }
                        break;
                    case OCCUPIED_SALVAGED:
                        System.out.print('#');
                        break;
                }
            }
            System.out.print("|");
            System.out.print('\n');
        }
        System.out.println(" +----------+");
    }
    
    
    public static void checkValidMap(FieldState[][] map) {
        if (map == null){
            throw new IllegalArgumentException("Error");
        }
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (map[y][x] == null) {
                    throw new IllegalArgumentException("Error");
                }
            }
        }       
        
        if (map.length != 10) {
            throw new IllegalArgumentException("Error");
        } 
        
        for (int y = 0; y < 10; y++) {
            if (map[y].length != 10) {
                throw new IllegalArgumentException("Error");
            }
        }
    }
    
    
    public static FieldState[][] getExample() {
        FieldState[][] state = new FieldState[10][10];
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                state[y][x] = fromOutput(exampleMap[y][x]);
            }
        }
        
        return state;
    }
    
    
    public static FieldState fromOutput(char output) {
        switch(output) {
            case ' ':
                return FieldState.EMPTY;
            case 'X':
                return FieldState.MISS;
            case 'O':
                return FieldState.OCCUPIED_HIDDEN;
            case '#':
                return FieldState.OCCUPIED_SALVAGED;
        }
        throw new IllegalArgumentException("Error!");
    }
}