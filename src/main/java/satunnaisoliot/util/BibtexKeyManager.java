/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.util;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import satunnaisoliot.structs.dao.ReferenceDao;
import satunnaisoliot.structs.interfaces.Reference;

/**
 *
 * @author juuso_j0pbwen
 */
public class BibtexKeyManager {
    
    
    public static boolean hasKey(String bibkey) {
        List<Reference> references = DataManager.getDao().findAll();
        for (Reference reference : references) {
            if (reference.getBibTexKey().equals(bibkey)) {
                return true;
            }
        }
        return false;
    }
    
}
