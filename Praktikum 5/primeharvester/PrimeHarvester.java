package primeharvester;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeHarvester implements Iterable<BigInteger> {
    private final BigInteger startValue;
    private final BigInteger endValue;

    public PrimeHarvester(BigInteger startValue, BigInteger endValue) {
        if (startValue == null || endValue == null) {
            throw new IllegalArgumentException("Values must not be null.");
        }
        if (startValue.compareTo(BigInteger.TWO) < 0) {
            throw new IllegalArgumentException("startValue must be greater than or equal to 2.");
        }
        if (endValue.compareTo(startValue) < 0) {
            throw new IllegalArgumentException("endValue must be greater than or equal to startValue.");
        }
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public Iterator<BigInteger> iterator() {
        return new Iterator<BigInteger>() {
            private BigInteger current = startValue;

            @Override
            public boolean hasNext() {
                return current.compareTo(endValue) <= 0;
            }

            @Override
            public BigInteger next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more primes in the range.");
                }
                while (!current.isProbablePrime(100)) {
                    current = current.add(BigInteger.ONE);
                }
                BigInteger prime = current;
                current = current.add(BigInteger.ONE);
                return prime;
            }
        };
    }

    public long getPrimeCount() {
    if (startValue.equals(endValue)) {
        return startValue.isProbablePrime(100) ? 1 : 0;
    }

    long count = -1;
    Iterator<BigInteger> iterator = iterator();
    while (iterator.hasNext()) {
        iterator.next();
        count++;
    }
    return count;
}

}
