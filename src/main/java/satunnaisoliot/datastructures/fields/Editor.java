package satunnaisoliot.datastructures.fields;

import java.util.HashMap;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Editor extends GenericStringField {

    private static HashMap<String, Editor> editors = new HashMap<>();

    private Editor(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.EDITOR;
    }

    @Override
    public String getTypeString() {
        return "editor";
    }
    
    public static Editor getEditorObject(String editor) {
        if (Editor.editors.get(editor) == null) {
            Editor.editors.put(editor, new Editor(editor));
        }
        return Editor.editors.get(editor);
    }

}
