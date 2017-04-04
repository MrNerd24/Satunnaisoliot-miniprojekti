package satunnaisoliot.datastructures.fields;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Editor extends GenericStringField {

    public Editor(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.EDITOR;
    }

    @Override
    public String getTypeString() {
        return "editor";
    }

}
