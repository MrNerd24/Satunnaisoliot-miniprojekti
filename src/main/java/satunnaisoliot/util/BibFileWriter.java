package satunnaisoliot.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import satunnaisoliot.structs.interfaces.Reference;

public class BibFileWriter {

    public static void writeToFile(File file, List<Reference> references) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }

        for (Reference reference : references) {
            for (String bibLine : reference.toBibTex()) {
                writer.println(bibLine);
            }
            writer.println();
        }
        writer.close();
    }

}
