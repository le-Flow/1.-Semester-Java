package canteen;

import java.util.Objects;

abstract class CanteenProduct {
    public String name = "";
    public CanteenProduct baseProduct;
    
    CanteenProduct(String name, CanteenProduct baseProduct) {
        
        this.name = name;
        
        this.baseProduct = baseProduct;
    }
    
    CanteenProduct(String name) {
        this(name, null);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CanteenProduct other = (CanteenProduct) obj;
        return Objects.equals(name, other.name) &&
            Objects.equals(baseProduct, other.baseProduct);
    }

    
    public String getName() {
        return this.name;
    }
    
    public CanteenProduct getBaseproduct() {
        return this.baseProduct;
    }
    
    public abstract double getPrice();

}
