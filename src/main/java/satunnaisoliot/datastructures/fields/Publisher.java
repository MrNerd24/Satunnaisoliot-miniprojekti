package satunnaisoliot.datastructures.fields;

import java.util.HashMap;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Publisher extends GenericStringField {

    private static HashMap<String, Publisher> publishers = new HashMap<>();

    private Publisher(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.PUBLISHER;
    }

    @Override
    public String getTypeString() {
        return "publisher";
    }
    
    public static Publisher getPublisherObject(String publisher) {
        if (Publisher.publishers.get(publisher) == null) {
            Publisher.publishers.put(publisher, new Publisher(publisher));
        }
        return Publisher.publishers.get(publisher);
    }

}
