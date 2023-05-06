public class Pet {
    private String name;
    private PetType.Type type;
    private int happiness;
    private int hungriness;
    private int sleepiness;

    // Konstruktor v
    public Pet(String n, PetType.Type t) {
        if (n == null || n == "" || n.isEmpty() || t == null ) {
            throw new IllegalArgumentException("Pet name cannot be null");
        }
        name = n;
        type = t;
        happiness = 5;
        hungriness = 3;
        sleepiness = 1;
    }

    // Kopier-Konstruktor v
    public Pet(Pet other) {
        if (other == null) {
            throw new IllegalArgumentException("Pet name cannot be null");
        }
        this.name = other.name;
        this.type = other.type;
        this.happiness = other.happiness;
        this.hungriness = other.hungriness;
        this.sleepiness = other.sleepiness;
    }

    public void play(){
        happiness += Math.round(type.getHappinessMultiplier() * 2);
        hungriness += Math.round(type.getHungrinessMultiplier() * 2);
        sleepiness += Math.round(type.getSleepinessMultiplier() * 2);
        overflow();
    }

    public void eat(){
        happiness += Math.round(type.getHappinessMultiplier() * 1);
        hungriness -= Math.round(type.getHungrinessMultiplier() * 2);
        sleepiness += Math.round(type.getSleepinessMultiplier() * 1);
        overflow();
    }

    public void sleep(){
        happiness -= Math.round(type.getHappinessMultiplier() * 2);
        hungriness += Math.round(type.getHungrinessMultiplier() * 2);
        sleepiness -= Math.round(type.getSleepinessMultiplier() * 2);
        overflow();
    }

    // overflow v
    public void overflow(){
        if(happiness > 10){
            happiness = 10;
        } else if(happiness < 0){
            happiness = 0;
        } 
        
        if(hungriness > 10){
            hungriness = 10;
        } else if(hungriness < 0){
            hungriness = 0;
        } 
        
        if(sleepiness > 10){
            sleepiness = 10;
        } else if(sleepiness < 0){
            sleepiness = 0;
        }
    }

    // Vergleich Methode v
    public boolean equals(Pet other) {
        // Check ob Objekt 2 = null
        if (other == null) {
            return false;
        }
        boolean sameName = name.equals(other.getName());
        boolean sameType = type.equals(other.type);
        boolean sameHappiness = happiness == other.getHappiness();
        boolean sameSleepiness = sleepiness == other.getSleepiness();
        boolean sameHungriness = hungriness == other.getHungriness();

        return sameName && sameType && sameHappiness && sameSleepiness && sameHungriness;
    }

    // String Repräsentation v
    public String toString(){
        String mood;
        if(isHappy()){
            mood = " :-) (";
        } else if(isSad()){
            mood = " :-( (";
        } else {
            mood = " :-| (";
        }
        return String.format(name + mood + type + "): Ha: " + happiness + ", Hu: " + hungriness + ", Sl: " + sleepiness);
    }

    // Change Funktionen v
    public void changeHappiness(int x){
        happiness += x;
        overflow();
    }

    public void changeHungriness(int x){
        hungriness += x;
        overflow();
    }

    public void changeSleepiness(int x){
        sleepiness += x;
        overflow();
    }

    // Getter v
    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHungriness() {
        return hungriness;
    }

    public int getSleepiness() {
        return sleepiness;
    }

    public int getSadness() {
        return (10 - happiness);
    }

    public String getType() {
        return type.name();
    }

    public boolean isHappy() {
        return (happiness >= 8);
    }

    public boolean isSad() {
        return (happiness <= 2);
    }
}
