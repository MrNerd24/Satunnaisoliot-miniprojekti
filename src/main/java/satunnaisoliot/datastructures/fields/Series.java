package satunnaisoliot.datastructures.fields;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Series extends GenericStringField {

    public Series(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.SERIES;
    }

    @Override
    public String getTypeString() {
        return "series";
    }

}
