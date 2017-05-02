package satunnaisoliot.structs.dao;

import satunnaisoliot.structs.interfaces.Reference;
import java.util.List;

public interface Dao {
    public void addReference(Reference ref);
    public void deleteReference(Reference ref);
    public List<Reference> findAll();
    public int rowcount();
    public int countReferenceswithSameBibTexKey(String bibTexKey);
    public List<Reference> findAllContainingString(String searchTerm);
}
