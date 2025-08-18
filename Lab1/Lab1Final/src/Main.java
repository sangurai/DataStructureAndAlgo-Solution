import java.util.ArrayList;
import java.util.Collections;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
public class Main {
    public static void main(String[] args) {
        //PREPARE TEST CASE
        int[] xV = {111, 60, 42, 11, 7854, 89406024, 742271756, 975922, 279392, 906443, 2226412, 6061228, 1691980, 3234496, 8356954, 81786288};
        int[] yV = {234, 225, 584010, 13, 4746, 277984, 606228865, 532283, 946230, 392685, 8648878, 5546440, 1414558, 7268362, 3705742, 61052652};
        ArrayList<Long> oCountNaive = new ArrayList<>();
        ArrayList<Long> oCountSieve = new ArrayList<>();
        ArrayList<Long> oCountEff = new ArrayList<>();

        //PREPARE DATA
        //naive------
        System.out.println("NAIVE SOL");
        for(int i = 0 ; i<xV.length ; i++){
            naiveSolution ns = new naiveSolution(xV[i],yV[i]);
            ns.findGCD();
            oCountNaive.add(ns.getOperationCount());
            System.out.print(oCountNaive.get(i) + " ");
        }
        Collections.sort(oCountNaive);

        //sieve------
        System.out.println("\nSIEVE SOL");
        for(int i = 0 ; i<xV.length ; i++){
            sieveSolution ss = new sieveSolution(xV[i],yV[i]);
            ss.findGCD();
            oCountSieve.add(ss.getOperationCount());
            System.out.print(oCountSieve.get(i) + " ");
        }
        Collections.sort(oCountSieve);
        //efficient------
        System.out.println("\nMOST EFF");
        for(int i = 0 ; i<xV.length ; i++){
            effSol es =new effSol();
            es.findGCD(xV[i], yV[i]);
            oCountEff.add((long) es.getOperationCount());
            System.out.print(oCountEff.get(i) + " ");
        }
        Collections.sort(oCountEff);


        //PLOT OPERATION COUNT WITH INDEXES
        //สมมุติมี 30 ตัวเปรียบเทียบกันก็เปรียบเทียบเรียงตัวเลยว่าตัวที่1ของแต่ละตัวดีต่างกันยังไงแค่ไหน แต่เรียงก่อน
        // Prepare series for plotting
        XYSeries naiveSeries = new XYSeries("Naive Solution");
        XYSeries sieveSeries = new XYSeries("Sieve Solution");
        XYSeries effSeries = new XYSeries("Efficient Solution");

        for (int i = 0; i < oCountNaive.size(); i++) {
            naiveSeries.add(i + 1, Math.log10(oCountNaive.get(i)));
        }
        for (int i = 0; i < oCountSieve.size(); i++) {
            sieveSeries.add(i + 1, Math.log10(oCountSieve.get(i)));
        }
        for (int i = 0; i < oCountEff.size(); i++) {
            effSeries.add(i + 1, Math.log10(oCountEff.get(i)));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(naiveSeries);
        dataset.addSeries(sieveSeries);
        dataset.addSeries(effSeries);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "GCD Algorithm Operation Count Comparison in Log Scale",
                "Test Case Index",
                "Operation Count",
                dataset
        );

        // Display chart
        ChartFrame frame = new ChartFrame("GCD Comparison", chart);
        frame.pack();
        frame.setVisible(true);

    }
}