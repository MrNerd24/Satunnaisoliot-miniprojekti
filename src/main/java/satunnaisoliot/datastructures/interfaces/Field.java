package satunnaisoliot.datastructures.interfaces;

import satunnaisoliot.datastructures.enums.FieldType;
import java.util.List;

public interface Field {

    public List<Reference> getReferences();

    public void linkReference(Reference reference);

    public void removeReference(Reference reference);

    public String toBibTex();

    public FieldType getType();
    
    public String getTypeString();
}
