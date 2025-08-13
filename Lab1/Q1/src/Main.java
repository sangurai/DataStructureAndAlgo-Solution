import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {
        mathTools mt = new mathTools(45991767,77583796);
        ArrayList<Integer> sol = mt.findCommonPrime();
        for(int i = 0; i<sol.size(); i++){
            System.out.println(sol.get(i));
        }
        System.out.println(mt.findGCD());
        System.out.println(mt.getOperationCount());
    }
}