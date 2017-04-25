package satunnaisoliot.structs.interfaces;

import satunnaisoliot.structs.enums.FieldType;
import java.util.List;
import satunnaisoliot.structs.enums.ReferenceType;

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
