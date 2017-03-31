package satunnaisoliot.Datastructures.Fields;

import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

public class Publisher extends GenericStringField {

    public Publisher(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.PUBLISHER;
    }

    @Override
    public String getTypeString() {
        return "publisher";
    }

}
