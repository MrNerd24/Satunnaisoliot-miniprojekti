package satunnaisoliot.structs.references;

import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.enums.ReferenceType;
import satunnaisoliot.structs.GenericReference;


public class Article extends GenericReference {

    public Article() {
    }

    public void setAuthor(String value) {
        setField(FieldType.AUTHOR, value);
    }

    public String getAuthor() {
        return getField(FieldType.AUTHOR);
    }

    public void setTitle(String value) {
        setField(FieldType.TITLE, value);
    }

    public String getTitle() {
        return getField(FieldType.TITLE);
    }

    public void setJournal(String value) {
        setField(FieldType.JOURNAL, value);
    }

    public String getJournal() {
        return getField(FieldType.JOURNAL);
    }

    public void setYear(String value) {
        setField(FieldType.YEAR, value);
    }

    public String getYear() {
        return getField(FieldType.YEAR);
    }

    public void setVolume(String value) {
        setField(FieldType.VOLUME, value);
    }

    public String getVolume() {
        return getField(FieldType.VOLUME);
    }

    public void setNumber(String value) {
        setField(FieldType.NUMBER, value);
    }

    public String getNumber() {
        return getField(FieldType.NUMBER);
    }

    public void setPages(String value) {
        setField(FieldType.PAGES, value);
    }

    public String getPages() {
        return getField(FieldType.PAGES);
    }

    public void setMonth(String value) {
        setField(FieldType.MONTH, value);
    }

    public String getMonth() {
        return getField(FieldType.MONTH);
    }

    public void setNote(String value) {
        setField(FieldType.NOTE, value);
    }

    public String getNote() {
        return getField(FieldType.NOTE);
    }
    
    public void setKey(String value) {
        setField(FieldType.KEY, value);
    }

    public String getKey() {
        return getField(FieldType.KEY);
    }

    @Override
    public ReferenceType getType() {
        return ReferenceType.ARTICLE;
    }

}
