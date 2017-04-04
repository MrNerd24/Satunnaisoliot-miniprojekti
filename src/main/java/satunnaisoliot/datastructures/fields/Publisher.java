package satunnaisoliot.datastructures.fields;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

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
