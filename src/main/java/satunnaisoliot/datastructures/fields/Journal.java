package satunnaisoliot.datastructures.fields;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Journal extends GenericStringField {

    public Journal(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.JOURNAL;
    }

    @Override
    public String getTypeString() {
        return "journal";
    }

}
