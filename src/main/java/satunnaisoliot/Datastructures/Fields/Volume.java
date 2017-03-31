package satunnaisoliot.Datastructures.Fields;

import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

public class Volume extends GenericStringField {

    public Volume(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.VOLUME;
    }

}
