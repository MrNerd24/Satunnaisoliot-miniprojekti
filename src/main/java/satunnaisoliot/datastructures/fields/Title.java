package satunnaisoliot.datastructures.fields;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Title extends GenericStringField {

    public Title(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.TITLE;
    }

    @Override
    public String getTypeString() {
        return "title";
    }

}
