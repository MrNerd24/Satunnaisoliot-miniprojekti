package satunnaisoliot.Datastructures.Fields;

import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

public class Address extends GenericStringField {

    public Address(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.ADDRESS;
    }

    @Override
    public String getTypeString() {
        return "address";
    }

}
