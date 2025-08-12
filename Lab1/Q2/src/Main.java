import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        mathTools mt = new mathTools();
        ArrayList<Integer> pl = mt.findFactorization(20);
        for(int n : pl){
            System.out.println(n);
        }
    }
}
