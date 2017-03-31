package satunnaisoliot.Datastructures.Fields;

import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

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
