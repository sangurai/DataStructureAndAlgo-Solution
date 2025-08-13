import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
//        //get all operation count into tuple
        int[] xV = {111, 60, 42, 11, 7854, 89406024, 742271756};
        int[] yV = {234, 225, 584010, 13, 4746, 277984, 606228865};
        ArrayList<Integer> oCount = new ArrayList<>();
        for(int i = 0 ; i<xV.length ; i++){
//            naiveSolution ns = new naiveSolution(xV[i],yV[i]);
//            System.out.println(ns.findGCD());
//            System.out.println(ns.getOperationCount());
//            //by sieveSol
//            sieveSolution ss = new sieveSolution(xV[i],yV[i]);
//            System.out.println(ss.findGCD());
//            System.out.println(ss.getOperationCount());

            //คำถามคือต้องพลอทระหว่าง operation count กับอะไร?
            //most efficient way
            effSol es =new effSol();
            es.findGCD(xV[i], yV[i]);
            oCount.add(es.getOperationCount());
            System.out.println(oCount.get(i));
        }



    }
}