package satunnaisoliot.datastructures.fields;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Note extends GenericStringField {

    public Note(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.NOTE;
    }

    @Override
    public String getTypeString() {
        return "note";
    }

}
