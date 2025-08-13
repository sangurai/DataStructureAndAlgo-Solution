public class effSol {
    long m;
    long n;
    int operationCount;
    effSol(){
    }

    public long GCD(long m, long n){
        operationCount++;

        if(m == 0){
            return n;
        }
        if(n == 0){return m;}
        if(m == n){return n;}
        if(m > n){
            return findGCD(m%n, n);
        }
        if(m < n){
            return findGCD(m, n%m);
        }
        return 0;
    }
    public long findGCD(long m, long n){
        long gcd = GCD(m, n);
        return gcd;
    }

    public int getOperationCount(){return operationCount;}
}
