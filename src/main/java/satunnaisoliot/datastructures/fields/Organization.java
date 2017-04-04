package satunnaisoliot.datastructures.fields;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Organization extends GenericStringField {

    public Organization(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.ORGANIZATION;
    }

    @Override
    public String getTypeString() {
        return "organization";
    }

}
