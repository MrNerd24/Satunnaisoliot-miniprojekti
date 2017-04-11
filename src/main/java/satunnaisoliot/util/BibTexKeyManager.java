/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.util;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import satunnaisoliot.datastructures.database.ReferenceDao;
import satunnaisoliot.datastructures.interfaces.Reference;

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
            try {
                for (Reference ref : dao.findAll()) {
                    keys.add(ref.getBibTexKey());
                }
            } catch (SQLException ex) {
                Logger.getLogger(BibTexKeyManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return keys.contains(bibkey);
    }
    
    public static void addKey(String bibKey) {
        keys.add(bibKey);
    }
    
}
