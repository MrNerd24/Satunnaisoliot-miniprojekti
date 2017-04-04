package satunnaisoliot.datastructures.fields;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Volume extends GenericStringField {

    public Volume(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.VOLUME;
    }

    @Override
    public String getTypeString() {
        return "volume";
    }

}
