package primeharvester;

import java.math.BigInteger;
import java.util.Iterator;

public class PrimeHarvesterMain {
    public static void main(String[] args) {
        BigInteger startValue = new BigInteger("4");
        BigInteger endValue = new BigInteger("4");

        PrimeHarvester primeHarvester = new PrimeHarvester(startValue, endValue);

        Iterator<BigInteger> iterator = primeHarvester.iterator();
        while (iterator.hasNext()) {
            BigInteger prime = iterator.next();
            System.out.println(prime);
        }

        long primeCount = primeHarvester.getPrimeCount();
        System.out.println("Number of primes: " + primeCount);
    }
}
