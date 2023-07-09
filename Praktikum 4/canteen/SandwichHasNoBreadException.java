package canteen;

class SandwichHasNoBreadException extends RuntimeException {
    private static final long serialVersionUID = -3387516983124329948L;
    
    public SandwichHasNoBreadException() {

    }

    public SandwichHasNoBreadException(String str)
    {
        super(str);
    }
 }
 
