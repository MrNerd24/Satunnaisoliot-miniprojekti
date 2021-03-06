package satunnaisoliot.structs;

import java.util.ArrayList;
import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.interfaces.Reference;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import satunnaisoliot.util.BibtexTextTransform;

public abstract class GenericReference implements Reference {

    EnumMap<FieldType, String> entries = new EnumMap<FieldType, String>(FieldType.class);
    String bibTexKey;

    public String getBibTexKey() {
        return bibTexKey;
    }

    public void setBibTexKey(String bibTexKey) {
        this.bibTexKey = bibTexKey;
    }

    @Override
    public void setField(FieldType name, String value) {
        entries.put(name, value);

    }

    @Override
    public String getField(FieldType name) {
        return entries.get(name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.entries);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GenericReference other = (GenericReference) obj;
        if (!Objects.equals(this.entries, other.entries)) {
            return false;
        }
        return true;
    }

    @Override
    public List<String> toBibTex() {
        if (getBibTexKey() == null) {
            throw new RuntimeException("BibTex key was null when trying to generate Bibtex");
        }
        ArrayList<String> lines = new ArrayList<String>();

        String type = getType().toString().toLowerCase();
        String start = "@" + type + "{" + getBibTexKey() + ",";
        lines.add(BibtexTextTransform.texifyString(start));

        for (FieldType field : FieldType.values()) {
            String content = getField(field);
            if (content == null || content.isEmpty()) {
                continue;
            }
            String[] values = content.split(";");

            String value = values[0];
            for (int i = 1; i < values.length; i++) {
                value = value + " and " + values[i] ;
            }
            value = BibtexTextTransform.texifyString(value);
            lines.add("\t" + field.toString().toLowerCase() + " = {" + value + "},");
        }
        lines.add("}");
        return lines;
    }


    @Override
    public String toString() {
        return getType().toString() + " " + getBibTexKey();
    }
}
