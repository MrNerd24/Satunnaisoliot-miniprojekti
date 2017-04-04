package satunnaisoliot.Datastructures.Fields;

import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

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
