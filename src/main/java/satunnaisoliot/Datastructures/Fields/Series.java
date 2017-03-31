package satunnaisoliot.Datastructures.Fields;

import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

public class Series extends GenericStringField {

    public Series(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.SERIES;
    }

}
