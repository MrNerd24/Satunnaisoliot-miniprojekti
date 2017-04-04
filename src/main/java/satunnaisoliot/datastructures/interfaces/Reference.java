package satunnaisoliot.datastructures.interfaces;

import satunnaisoliot.datastructures.enums.FieldType;
import java.util.List;

public interface Reference {

    public void addField(FieldType name, Field value);

    public void setField(FieldType name, int index, Field value);

    public List<Field> getFields(FieldType name);

    public List<String> toBibTex();
}
