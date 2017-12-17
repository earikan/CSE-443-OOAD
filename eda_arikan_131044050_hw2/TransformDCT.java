import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author arika
 */
public class TransformDCT extends TransformWithHook {

    private double[] outputNumberReal;


    public TransformDCT() {
        printExecuteTime = false;
    }


    @Override
    void transformNumbers() {
        outputNumberReal = new double[inputNumberList.size()];
        for (int i = 0; i < inputNumberList.size(); i++) {
            double sum = 0;
            for (int j = 0; j < inputNumberList.size(); j++) {
                sum += inputNumberList.get(j) * Math.cos((j + 0.5) * i * (Math.PI / inputNumberList.size()));
            }
            outputNumberReal[i] = sum;
        }
    }


    @Override
    void calculateTimeOfExecution() {
        //do nothing
    }


    @Override
    void write_N_Numbers(String filename) throws FileNotFoundException, IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < outputNumberReal.length; ++i) {
                writer.write(String.valueOf(outputNumberReal[i]));
                writer.write("\n");
            }
        }
    }
}
