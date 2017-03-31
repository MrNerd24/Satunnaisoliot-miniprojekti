package satunnaisoliot.Datastructures.Fields;

import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

public class Title extends GenericStringField {

    public Title(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.TITLE;
    }

}
