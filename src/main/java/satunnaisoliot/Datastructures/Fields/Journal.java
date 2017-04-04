package satunnaisoliot.Datastructures.Fields;

import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

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
