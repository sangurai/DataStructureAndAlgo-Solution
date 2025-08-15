import java.util.ArrayList;

public class sieveSolution {
    private long operationCount;
    private int m, n;
    sieveSolution(int m, int n) {
        this.m = m;
        this.n = n;
        operationCount = 0;
    }
    public long getOperationCount() { return operationCount; }

    public int gcdUsingPrimes() {
        ArrayList<Integer> pm = factorizePrimes(m);
        ArrayList<Integer> pn = factorizePrimes(n);
        int gcd = 1;
        for (Integer prime : pm) {
            if (pn.contains(prime)) {
                gcd *= prime;
                pn.remove(prime);
            }
        }
        return gcd;
    }

    private ArrayList<Integer> factorizePrimes(int num) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int p : sievePrimes((int)Math.sqrt(num))) {
            while (num % p == 0) {
                factors.add(p);
                num /= p;
                operationCount++;
            }
        }
        if (num > 1) {
            factors.add(num);
            operationCount++;
        }
        return factors;
    }

    private ArrayList<Integer> sievePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) isPrime[i] = true;
        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                    operationCount++;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }

    public int findGCD() { return gcdUsingPrimes(); }
}

