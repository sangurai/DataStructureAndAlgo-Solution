import java.util.ArrayList;
public class mathTools {
    mathTools(){
        System.out.println("mathTools object is created!");
    }

    public int[] primeByErathos(int n){
        boolean[] prime = new boolean[n + 1]; //creating all true array
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) { //marking false position in multiple index
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        int count = 0;
        for (int p = 2; p <= n; p++) { // count number of primes
            if (prime[p])
                count++;
        }
        //store prime in arrays
        int[] res = new int[count];
        int index = 0;
        for (int p = 2; p <= n; p++) {
            if (prime[p])
                res[index++] = p;
        }
        return res;
    }

    public ArrayList<Integer> findFactorization(int n){
        int number = n;
        int[] pbe = primeByErathos(number);
        ArrayList<Integer> factor = new ArrayList<>();
        for(int num : pbe){ //divide number by each prime
            if(number % num == 0){
                factor.add(num);
                number /= num;
            }
        }
        if(number > 2){ // if the remaining is bigger than 2 then itself is also prime
            factor.add(number);
        }
        return factor;
    }

}
