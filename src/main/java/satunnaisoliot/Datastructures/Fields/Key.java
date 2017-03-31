package satunnaisoliot.Datastructures.Fields;

import java.util.HashMap;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericNumberField;

public class Key extends GenericNumberField {

    private static HashMap<Integer, Key> keys = new HashMap<>();

    private Key(int key) {
        super(key);
    }

    @Override
    public FieldType getType() {
        return FieldType.KEY;
    }

    public static Key getKeyObject(int key) {
        if (Key.keys.get(key) == null) {
            Key.keys.put(key, new Key(key));
        }
        return Key.keys.get(key);
    }
}
