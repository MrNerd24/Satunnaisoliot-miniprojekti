package satunnaisoliot.Datastructures.Interfaces;

import satunnaisoliot.Datastructures.Enums.FieldType;
import java.util.List;

public interface Field {

    public List<Reference> getReferences();

    public void linkReference(Reference reference);

    public void removeReference(Reference reference);

    public String toBibTex();

    public FieldType getType();
    
    public String getTypeString();
}
