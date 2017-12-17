import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author arika
 */
public abstract class TransformWithHook {

    protected List<Double> inputNumberList = new ArrayList<>();
    protected long startTime;
    protected long endTime;
    protected boolean printExecuteTime = false;


    public void prepare(String inputFile, String outputFile, int N) throws FileNotFoundException, IOException {
        startTime = System.currentTimeMillis();
        read_N_Numbers(inputFile, N);
        transformNumbers();
        write_N_Numbers(outputFile);
        endTime = System.currentTimeMillis();
        if (wantPrintTimeOfExecution()) {
            calculateTimeOfExecution();
        }
    }


    public void read_N_Numbers(String filename, int N) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int counter = 0;
        while (scanner.hasNext() && counter < N) {
            Object ob = scanner.next();
            String str = ob.toString();
            double d = Double.valueOf(str);
            inputNumberList.add(d);
            ++counter;
        }
    }


    public void printInputNumbers() {
        for (int i = 0; i < inputNumberList.size(); ++i) {
            System.out.println(inputNumberList.get(i));
        }
    }


    abstract void transformNumbers();


    abstract void write_N_Numbers(String filename) throws FileNotFoundException, IOException;


    boolean wantPrintTimeOfExecution() {
        return printExecuteTime;
    }


    public void setWantPrintExecuteTime(boolean printExecuteTime) {
        this.printExecuteTime = printExecuteTime;
    }


    void calculateTimeOfExecution() {
        System.out.println("Execution Time " + (endTime - startTime) + " milliseconds");
    }
}
