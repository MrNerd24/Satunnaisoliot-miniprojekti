package satunnaisoliot.datastructures.fields;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

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
