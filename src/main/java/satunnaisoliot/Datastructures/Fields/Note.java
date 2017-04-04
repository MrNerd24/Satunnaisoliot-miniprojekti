package satunnaisoliot.Datastructures.Fields;

import java.util.HashMap;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericStringField;

public class Note extends GenericStringField {

    private static HashMap<String, Note> notes = new HashMap<>();

    private Note(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.NOTE;
    }

    @Override
    public String getTypeString() {
        return "note";
    }
    
    public static Note getNoteObject(String note) {
        if (Note.notes.get(note) == null) {
            Note.notes.put(note, new Note(note));
        }
        return Note.notes.get(note);
    }

}
