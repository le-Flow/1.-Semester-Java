public class VirtualPetMain {
    
    public static void main(String[] args) {
        // Erstelle Haustiere und ihre Besitzer
        Pet rosco = new Pet("Rosco", PetType.Type.DOG);
        Pet morgana = new Pet("Morgana", PetType.Type.CAT);
        Pet rabbit = new Pet("Rabbit of Caerbannog", PetType.Type.RABBIT);
        PetOwner jimmy = new PetOwner("Jimmy", rosco, rabbit);
        PetOwner timmy = new PetOwner("Timmy", morgana, null);

        // Versorge die Haustiere und drucke ihren Status nach jeder Iteration
        for (int i = 1; i <= 10; i++) {
            jimmy.takeCareOfPets();
            timmy.takeCareOfPets();
            System.out.println('\n' + "Iteration:" + i);
            System.out.println(jimmy.toString());
            System.out.println(timmy.toString());
        }
        return;
    }
}
