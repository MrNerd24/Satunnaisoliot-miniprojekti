package satunnaisoliot.structs.generic;

import java.util.ArrayList;
import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.interfaces.Reference;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import satunnaisoliot.util.BibtexTextTransform;

/**
 *
 * @author juuso_j0pbwen
 */
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
            lines.add(field.toString().toLowerCase() + " = {" + value + "},");
        }
        lines.add("}");
        return lines;
    }

    public void generateBibTexKey() {
        String author = this.getField(FieldType.AUTHOR);
        String BibTexKey = "";

        if(author.contains(";")) {
            //Many authors
            String[] authors = author.split(";");

            for(int i = 0; i < authors.length; i++) {
                author = authors[i];
                BibTexKey += author.charAt(0); //Take first letter of each last name
            }
        } else {
            //Only one author
            //Take three first letters of the last name or all if less than three
            String lastName = author.substring(0, author.indexOf(","));

            if(lastName.length() < 3) {
                BibTexKey += lastName;
            } else {
                BibTexKey += lastName.substring(0, 3);
            }
        }
        //Add year
        String year = this.getField(FieldType.YEAR);
        BibTexKey += year.substring(2);

        setBibTexKey(BibTexKey);
    }

    @Override
    public String toString() {
        return getType().toString() + " " + getBibTexKey();
    }
}
