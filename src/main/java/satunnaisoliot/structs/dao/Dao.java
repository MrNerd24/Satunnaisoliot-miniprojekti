package satunnaisoliot.structs.dao;

import java.util.List;

import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.interfaces.Reference;

public interface Dao {
    public void addReference(Reference ref);
    public void deleteReference(Reference ref);
    public List<Reference> findAll();
    public int rowcount();
    public int countReferenceswithSameBibTexKey(String bibTexKey);
}
