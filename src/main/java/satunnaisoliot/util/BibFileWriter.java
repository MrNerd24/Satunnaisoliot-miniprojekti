/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import satunnaisoliot.structs.interfaces.Reference;

/**
 *
 * @author juuso_j0pbwen
 */
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
