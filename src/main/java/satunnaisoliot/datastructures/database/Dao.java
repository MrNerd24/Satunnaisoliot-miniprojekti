/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.datastructures.database;

import java.sql.SQLException;
import java.util.List;
import satunnaisoliot.datastructures.interfaces.Reference;

/**
 *
 * @author jambo
 */
public interface Dao {
    public void addReference(Reference ref);
    public List<Reference> findAll() throws SQLException;
}
