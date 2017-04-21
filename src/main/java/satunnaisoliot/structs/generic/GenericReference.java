package satunnaisoliot.structs.generic;

import java.util.ArrayList;
import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.interfaces.Reference;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import satunnaisoliot.util.BibtexTextTransform;
import satunnaisoliot.util.DataManager;

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
        String authorContent = this.getField(FieldType.AUTHOR);
        String BibTexKey = "";

        if(authorContent.contains(";")) {
            //Many authors
            String[] authors = authorContent.split(";");

            for(int i = 0; i < authors.length; i++) {
                String author = authors[i];
                BibTexKey += author.charAt(0); //Take first letter of each last name
            }
        } else {
            //Only one author
            //Take three first letters of the last name or all if less than three
            String lastName = authorContent.substring(0, authorContent.indexOf(","));

            if(lastName.length() < 3) {
                BibTexKey += lastName;
            } else {
                BibTexKey += lastName.substring(0, 3);
            }
        }
        //Add year
        String year = this.getField(FieldType.YEAR);
        BibTexKey += year.substring(2);

        //Add letter if same author has multiple publications in the same year
        String letters = "abcdefghijklmnopqrstuvwxyz";
        int publications = DataManager.getDao().countPublicationsOfSameAuthorAndYear(authorContent, year);

        if(publications > 0) {
            BibTexKey += letters.charAt(publications - 1);
        }

        setBibTexKey(BibTexKey);
    }

    @Override
    public String toString() {
        return getType().toString() + " " + getBibTexKey();
    }
}
