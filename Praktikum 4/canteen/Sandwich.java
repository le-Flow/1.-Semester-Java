package canteen;
import java.util.*;

class Sandwich extends CanteenProduct implements Ratable{
    SandwichIngredients[] ingredients;
    List<Integer> ratings=new ArrayList<Integer>();  
    
    public Sandwich(String name, SandwichIngredients... ingredients) {
        super(name);
        this.ingredients = ingredients;

        if (name == null || name.trim().length() < 4) {
            throw new IllegalArgumentException("name cannot be empty or null.");
        }

        int error = 1;
        for (int h = 0; h < this.ingredients.length; h++) {
            if (this.ingredients[h] == SandwichIngredients.BREAD || this.ingredients[h] == SandwichIngredients.WHOLE_GRAIN_BREAD) {
                error = 0;
                break;
            }
        }

        if (error == 1) {
            throw new SandwichHasNoBreadException();
        }

        if (this.ingredients.length < 2) {
            throw new SandwichHasTooFewIngredientsException();
        }
        this.name = name.trim();
    }

    @Override
    public double getPrice() {
        double summe = 0;

        double[] preise = new double[this.ingredients.length];
        for (int h = 0; h < this.ingredients.length; h++) {
            preise[h] = ingredientPrice(this.ingredients[h]);
        }
        Arrays.sort(preise);

        for(int k = preise.length - 1; k >= preise.length - 4; k--) {
            summe += preise[k];
        }

        return summe;
    }
    
    private double ingredientPrice(SandwichIngredients ingredient) {
        switch(ingredient) {
            case BREAD:
                return 0.5;
            case WHOLE_GRAIN_BREAD:
                return 0.7;
            case SALAMI:
                return 0.5;
            case HAM:
                return 0.5;
            case CHICKEN:
                return 0.5;
            case BEEF:
                return 1.0;
            case VEGAN_MEET_REPLACEMENT:
                return 1.0;
            case CHEDDAR:
                return 0.5;
            case MOZARELLA:
                return 0.5;
            case EMMENTAL:
                return 1.0;
            case CREAM_CHEESE:
                return 0.5;
            case TOMATO:
                return 0.2;
            case CUCUMBER:
                return 0.2;
            case PAPRIKA:
                return 0.4;
            case SALAD:
                return 0.2;
            case KETCHUP:
                return 0.2;
            case MAYONNAISE:
                return 0.2;
            case SPICY_JOGHURT:
                return 0.6;
                
        }
        return 0;
    }
    
    public double getKcal() {
        double summe = 0;
        
        for (int h = 0; h < this.ingredients.length; h++) {
            switch(this.ingredients[h]) {
                case BREAD:
                    summe += 190;
                    break;
                case WHOLE_GRAIN_BREAD:
                    summe += 194;
                    break;
                case SALAMI:
                    summe += 115;
                    break;
                case HAM:
                    summe += 46;
                    break;
                case CHICKEN:
                    summe += 55;
                    break;
                case BEEF:
                    summe += 70;
                    break;
                case VEGAN_MEET_REPLACEMENT:
                    summe += 117;
                    break;
                case CHEDDAR:
                    summe += 113;
                    break;
                case MOZARELLA:
                    summe += 35;
                    break;
                case EMMENTAL:
                    summe += 120;
                    break;
                case CREAM_CHEESE:
                    summe += 100;
                    break;
                case TOMATO:
                    summe += 7;
                    break;
                case CUCUMBER:
                    summe += 3;
                    break;
                case PAPRIKA:
                    summe += 4;
                    break;
                case SALAD:
                    summe += 2;
                    break;
                case KETCHUP:
                    summe += 20;
                    break;
                case MAYONNAISE:
                    summe += 68;
                    break;
                case SPICY_JOGHURT:
                    summe += 15;
                    break;
            }
        }
    
        return summe;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%f kcal)\t\t\t%f", this.name, getKcal(), getPrice());
    }
    
    public void rateProduct(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("rating must be between 1 and 5 points");
        }
        ratings.add(rating);
    }
    
    public double getAvgRating() {
        double summe = 0;
        for (int h = 0; h < ratings.size(); h++) {
            summe += ratings.get(h);
        }
        return summe / ratings.size();
    }
    
    public int getNumberOfRatings() {
        return ratings.size();
    }
}
