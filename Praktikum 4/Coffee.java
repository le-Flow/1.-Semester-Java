package canteen;

import java.util.Arrays;

class Coffee extends CanteenProduct {
    CoffeeIngredients[] ingredients;
    
    public Coffee(String name, Coffee baseProduct, CoffeeIngredients... ingredients) {
        super(name, baseProduct);
        this.ingredients = ingredients;
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.length() < 4) {
            throw new IllegalArgumentException("Name must be at least 4 characters long");
        }
        if (ingredients.length == 0) {
            throw new IllegalArgumentException("Ingredients array cannot be empty");
        }
    }

    
    public Coffee(String name, CoffeeIngredients... ingredients) {
        this(name, null, ingredients);
    }

    public Coffee getBaseProduct() {
         return (Coffee) super.getBaseproduct();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coffee other = (Coffee) obj;
        return super.equals(obj) && Arrays.equals(ingredients, other.ingredients);
    }


    
    @Override
    public double getPrice() {
        double summe = 0;
        if (baseProduct != null) {
            summe += baseProduct.getPrice();
        }
        
        for (int h = 0; h < this.ingredients.length; h++) {
            switch(ingredients[h]) {
                case FROTHED_MILK:
                    summe += 1.5;
                    break;
                case FROTHED_MILK_XXL:
                    summe += 2.0;
                    break;
                case MILK:
                    summe += 1.0;
                    break;
                case SUGAR:
                    summe += 0.0;
                    break;
                case HAZELNUT_SYRUP:
                    summe += 0.8;
                    break;
                case VANILLA_SYRUP:
                    summe += 1.2;
                    break;
                case CARAMEl_SYRUP:
                    summe += 0.8;
                    break;
                case CHOCOLATE:
                    summe += 1.0;
                    break;
                case CHOCOLATE_POWDER:
                    summe += 0.0;
                    break;
                case ESPRESSO_SHOT:
                    summe += 1.2;
                    break;
                case HOT_WATER:
                    summe += 0.0;
                    break;
            }
        }
        return summe;
    }
    
    @Override
    public String toString() {
        return String.format("%s\t\t\t%f", this.name, this.getPrice());
    }
}
