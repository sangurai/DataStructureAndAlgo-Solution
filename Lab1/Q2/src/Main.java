import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //plot number operation vs index of arrayList
        mathTools mt = new mathTools(3234496,7268362);
        System.out.println(mt.findGCD());
        System.out.println(mt.getOperationCount());
    }
}
