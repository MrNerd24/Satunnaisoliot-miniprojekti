package satunnaisoliot.datastructures.fields;

import java.util.HashMap;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Journal extends GenericStringField {

    private static HashMap<String, Journal> journals = new HashMap<>();

    private Journal(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.JOURNAL;
    }

    @Override
    public String getTypeString() {
        return "journal";
    }
    
    public static Journal getJournalObject(String journal) {
        if (Journal.journals.get(journal) == null) {
            Journal.journals.put(journal, new Journal(journal));
        }
        return Journal.journals.get(journal);
    }

}
