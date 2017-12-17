import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author arika
 */
public class Transform {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        TransformWithHook twh = new TransformDFT() ;
        twh.setWantPrintExecuteTime(true);
        twh.prepare("inputFile.txt", "DFTout.txt", 10);
        

        TransformWithHook twh2 = new TransformDCT();
        twh2.prepare("inputFile.txt", "DCTout.txt", 10);
        
    }
    
}
