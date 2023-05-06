public class PetOwner {
    private String name;
    private Pet firstPet;
    private Pet secondPet;

    // Konstruktor v
    public PetOwner(String name, Pet firstPet) {
        if (name == null || firstPet == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name and first pet cannot be null");
        }
        
        this.name = name;
        this.firstPet = firstPet;
    }

    public PetOwner(String name, Pet firstPet, Pet secondPet) {
        if (name == null || firstPet == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name and first pet cannot be null");
        }
        
        this.name = name;
        this.firstPet = firstPet;
        this.secondPet = secondPet;
    }

    // Kopier-Konstruktor v
    public PetOwner(PetOwner other) {
        if (other == null || other.name == null || other.firstPet == null || other.name.isEmpty()) {
            throw new IllegalArgumentException("Name and first pet cannot be null");
        }
        this.name = other.name;
        this.firstPet = new Pet(other.firstPet);
        if(other.secondPet != null){
            this.secondPet = new Pet(other.secondPet);
        }
    }

    // Interaktions methode v
    public void takeCareOfPets() {
        takeCareOfPet(firstPet);
        if (secondPet != null){
            takeCareOfPet(secondPet);
        }
    }

    private void takeCareOfPet(Pet pet) {
        if ((pet.getHungriness() >= pet.getSleepiness()) && (pet.getHungriness() >= pet.getSadness())) {
            pet.eat();
        } else if ((pet.getSleepiness() >= pet.getHungriness()) && (pet.getSleepiness() >= pet.getSadness())) {
            pet.sleep();
        } else {
            pet.play();
        }
    }

    
    // Vergleich methode v
    public boolean equals(PetOwner other) {
        // Check ob Object 2 = null
        if (other == null) {
            return false;
        }
        
        boolean sameName = name.equals(other.getName());
        boolean sameFirstPet = firstPet.equals(other.getFirstPet());
        boolean sameSecondPet = true;
        if(secondPet != null){
            sameSecondPet = secondPet.equals(other.getSecondPet());
        }   
        return sameName && sameFirstPet && sameSecondPet;
    }

    // String Repräsentation v
    public String toString(){
        if(secondPet == null) {
            return String.format(name + '\n' + "- First pet: " + 
            firstPet.toString() + '\n' + "- Second pet: "
            + "none");
        } else{   
            return String.format(name + '\n' + "- First pet: " + 
            firstPet.toString() + '\n' + "- Second pet: "
            + secondPet.toString());
        }
    }
    
    // Getter v
    public String getName() {
        return name;
    }

    public Pet getFirstPet() {
        return firstPet;
    }

    public Pet getSecondPet() {
        return secondPet;
    }
}
