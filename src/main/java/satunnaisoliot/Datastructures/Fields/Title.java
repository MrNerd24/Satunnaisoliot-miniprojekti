package satunnaisoliot.Datastructures.Fields;

import java.util.HashMap;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

public class Title extends GenericStringField {

    private static HashMap<String, Title> titles = new HashMap<>();

    private Title(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.TITLE;
    }

    @Override
    public String getTypeString() {
        return "title";
    }

    public static Title getTitleObject(String title) {
        if (Title.titles.get(title) == null) {
            Title.titles.put(title, new Title(title));
        }
        return Title.titles.get(title);
    }

}
