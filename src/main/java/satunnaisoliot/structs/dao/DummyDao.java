/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.structs.dao;

import java.util.List;
import satunnaisoliot.structs.interfaces.Reference;

/**
 *
 * @author jambo
 */
public class DummyDao implements Dao {

    @Override
    public void addReference(Reference ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void createFile() {

    }

    private void addToFile(String text) {
        //luo työpöydälle tekstitiedoston (popup jossa annetaan tiedoston nimi yms)

    }

    @Override
    public List<Reference> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int rowcount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int countReferenceswithSameBibTexKey(String bibTexKey) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteReference(Reference ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
