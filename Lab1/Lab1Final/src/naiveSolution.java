import java.util.ArrayList;
public class naiveSolution {
    int m;
    int n;
    long operationCount;
    naiveSolution(int m, int n){
        this.m = m;
        this.n = n;
    }

    public ArrayList<Integer> naiveSol(int number){
        ArrayList<Integer> primeFactor = new ArrayList<Integer>();
        int n = number;
        while(n % 2 == 0){ //divide by 2
            operationCount++;
            n /= 2;
            if(!primeFactor.contains(2)){
                primeFactor.add(2);
            }
        }
        for(int i = 3 ; i * i <= n ; i +=2 ){ //then loop from 3 to sqrt(n)
            operationCount++;
            while( n % i == 0){
                operationCount++;
                if(!primeFactor.contains(i)){
                    primeFactor.add(i);
                }
                n /= i;
            }
        }
        if(n > 2){ //if remaining n > 2 then n is prime too
            primeFactor.add(n);
        }
        return primeFactor;
    }

    public ArrayList<Integer> findCommonPrime(){ //find common prime from n and m
        ArrayList<Integer> pm = naiveSol(m);
        ArrayList<Integer> pn = naiveSol(n);
        ArrayList<Integer> cp = new ArrayList<>();
        for(int pom : pm){
            operationCount++;
            for(int pon : pn){
                operationCount++;
                if(pom == pon && !cp.contains(pom)){
                    cp.add(pom);
                }
            }
        }
        return cp;
    }

    public int findGCD(){
        ArrayList<Integer> cp = findCommonPrime();
        if(cp.isEmpty()){
            return 1;
        }else{
            int gcd = 1;
            for(int n : cp){
                gcd *= n;
            }
            return gcd;
        }
    }

    public long getOperationCount() {
        return operationCount;
    }
}
