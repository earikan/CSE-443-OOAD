import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author arika
 */
public class TransformDFT extends TransformWithHook {

    private double[] outputNumberReal;
    private double[] outputNumberImaginal;


    public TransformDFT() {
        //constructor
    }


    @Override
    void transformNumbers() {
        outputNumberReal = new double[inputNumberList.size()];
        outputNumberImaginal = new double[inputNumberList.size()];

        for (int i = 0; i < inputNumberList.size(); i++) {
            for (int j = 0; j < inputNumberList.size(); j++) {
                outputNumberReal[i] += inputNumberList.get(j) * Math.cos(2 * Math.PI * j * i / inputNumberList.size());
                outputNumberImaginal[i] -= inputNumberList.get(j) * Math.sin(2 * Math.PI * j * i / inputNumberList.size());
            }
        }
    }


    @Override
    void write_N_Numbers(String filename) throws FileNotFoundException, IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < outputNumberReal.length; ++i) {
                writer.write(String.valueOf(outputNumberReal[i]));
                writer.write(" + ");
                writer.write(String.valueOf(outputNumberImaginal[i]));
                writer.write("i");
                writer.write("\n");
            }
        }
    }
}
