package satunnaisoliot.datastructures.fields;

import java.util.HashMap;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

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
