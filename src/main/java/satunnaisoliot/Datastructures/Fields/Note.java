package satunnaisoliot.Datastructures.Fields;

import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

public class Note extends GenericStringField {

    public Note(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.NOTE;
    }

}
