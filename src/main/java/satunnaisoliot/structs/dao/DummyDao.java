package satunnaisoliot.structs.dao;

import satunnaisoliot.structs.interfaces.Reference;

import java.util.List;

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

    @Override
    public List<Reference> findAllContainingString(String searchTerm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
