import java.util.ArrayList;
//public class sieveSolution {
//    long operationCount;
//    int m;
//    int n;
//    sieveSolution(int m, int n){
//        this.m = m;
//        this.n = n;
//        operationCount = 0;
//    }
//    public int[] primeByErathos(int n){
//        boolean[] prime = new boolean[n + 1]; //creating all true array
//        for (int i = 0; i <= n; i++) {
//            operationCount++;
//            prime[i] = true;
//        }
//        for (int p = 2; p * p <= n; p++) { //marking false position in multiple index
//            operationCount++;
//            if (prime[p]) {
//                for (int i = p * p; i <= n; i += p) {
//                    operationCount++;
//                    prime[i] = false;
//                }
//            }
//        }
//        int count = 0;
//        for (int p = 2; p <= n; p++) { // count number of primes
//            operationCount++;
//            if (prime[p])
//                count++;
//        }
//        //store prime in arrays
//        int[] res = new int[count];
//        int index = 0;
//        for (int p = 2; p <= n; p++) {
//            operationCount++;
//            if (prime[p])
//                res[index++] = p;
//        }
//        return res;
//    }
//
//    public ArrayList<Integer> findFactorization(int n){
//        int number = n;
//        int[] pbe = primeByErathos(number);
//        ArrayList<Integer> factor = new ArrayList<>();
//        for(int num : pbe){ //divide number by each prime
//            operationCount++;
//            if(number % num == 0){
//                factor.add(num);
//                number /= num;
//            }
//        }
//        if(number > 2){ // if the remaining is bigger than 2 then itself is also prime
//            factor.add(number);
//        }
//        return factor;
//    }
//
//    public ArrayList<Integer> findCommonPrime(){ //find common prime from n and m
//        ArrayList<Integer> pm = findFactorization(m);
//        ArrayList<Integer> pn = findFactorization(n);
//        ArrayList<Integer> cp = new ArrayList<>();
//        for(int pom : pm){
//            operationCount++;
//            for(int pon : pn){
//                operationCount++;
//                if(pom == pon && !cp.contains(pom)){
//                    cp.add(pom);
//                }
//            }
//        }
//        return cp;
//    }
//
//    public int findGCD(){
//        ArrayList<Integer> cp = findCommonPrime();
//        if(cp.isEmpty()){
//            return 1;
//        }else{
//            int gcd = 1;
//            for(int n : cp){
//                gcd *= n;
//            }
//            return gcd;
//        }
//    }
//
//    public long getOperationCount(){
//        return operationCount;
//    }
//
//}

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

