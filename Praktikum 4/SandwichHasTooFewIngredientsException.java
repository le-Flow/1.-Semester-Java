package canteen;

class SandwichHasTooFewIngredientsException extends RuntimeException {
    private static final long serialVersionUID = -3387516983124329948L;
    
    public SandwichHasTooFewIngredientsException() {

    }

    public SandwichHasTooFewIngredientsException(String str)
    {
        super(str);
    }
 }
