import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Soubor {

    public static String ODDELOVAC = ",";

    //kredit|jmeno|primeni|datum
    public static void uloz(File file, ArrayList<Navstevnik> nav) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Navstevnik n : nav) {
            writer.write(n.getPocetKreditu()+ODDELOVAC+n.getJmeno()+ODDELOVAC+n.getPrijmeni()+ODDELOVAC+n.getDatumNavstevy()+"\n");
        }
        writer.close();
    }

}
