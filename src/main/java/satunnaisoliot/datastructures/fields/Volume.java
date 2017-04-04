package satunnaisoliot.datastructures.fields;

import java.util.HashMap;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Volume extends GenericStringField {

    private static HashMap<String, Volume> volumes = new HashMap<>();

    private Volume(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.VOLUME;
    }

    @Override
    public String getTypeString() {
        return "volume";
    }

    public static Volume getVolumeObject(String volume) {
        if (Volume.volumes.get(volume) == null) {
            Volume.volumes.put(volume, new Volume(volume));
        }
        return Volume.volumes.get(volume);
    }

}
