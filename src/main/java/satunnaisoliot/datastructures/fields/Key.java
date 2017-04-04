package satunnaisoliot.datastructures.fields;

import java.util.HashMap;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericNumberField;

public class Key extends GenericNumberField {

    private static HashMap<Integer, Key> keys = new HashMap<>();

    public Key(int key) {
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

    @Override
    public String getTypeString() {
        return "key";
    }
}
