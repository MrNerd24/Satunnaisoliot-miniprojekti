package satunnaisoliot.Datastructures.Fields;

import java.util.HashMap;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

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
