/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.util;

import java.util.HashSet;
import satunnaisoliot.datastructures.database.ReferenceDao;

/**
 *
 * @author juuso_j0pbwen
 */
public class BibTexKeyManager {
    
    private static HashSet<String> keys = null;
    
    public static boolean hasKey(String bibkey) {
        if (keys == null) {
            keys = new HashSet<String>();
            ReferenceDao dao = DataManager.getReferenceDao();
        }
    }
    
    public static void addKey(String bibKey) {
        
    }
    
}
