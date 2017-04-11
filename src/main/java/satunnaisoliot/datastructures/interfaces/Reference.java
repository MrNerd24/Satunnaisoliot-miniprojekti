package satunnaisoliot.datastructures.interfaces;

import satunnaisoliot.datastructures.enums.FieldType;
import java.util.List;
import satunnaisoliot.datastructures.enums.ReferenceType;

public interface Reference {

    public void setField(FieldType name, String value);

    public String getField(FieldType name);
    
    public String getBibTexKey();
    
    public void setBibTexKey(String bibTexKey);

    public List<String> toBibTex();

    public ReferenceType getType();

    @Override
    public String toString();
}
