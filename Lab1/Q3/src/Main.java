public class Main {
    static int findGCD(int m, int n){
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
    public static void main(String[] args) {
        int gon = findGCD(10,5);
        System.out.println(gon);

    }
}