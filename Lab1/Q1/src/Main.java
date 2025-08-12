import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {
        mathTools mt = new mathTools(20, 40);
        ArrayList<Integer> sol = mt.findCommonPrime();
        for(int i = 0; i<sol.size(); i++){
            System.out.println(sol.get(i));
        }
    }
}