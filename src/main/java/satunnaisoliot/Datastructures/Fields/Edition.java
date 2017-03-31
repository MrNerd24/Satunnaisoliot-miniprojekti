package satunnaisoliot.Datastructures.Fields;

import java.util.HashMap;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericNumberField;

public class Edition extends GenericNumberField {

    private static HashMap<Integer, Edition> editions = new HashMap<>();

    private Edition(int edition) {
        super(edition);
    }

    @Override
    public FieldType getType() {
        return FieldType.EDITION;
    }

    public static Edition getEditionObject(int edition) {
        if (Edition.editions.get(edition) == null) {
            Edition.editions.put(edition, new Edition(edition));
        }
        return Edition.editions.get(edition);
    }

}
