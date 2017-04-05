package satunnaisoliot.datastructures.references;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.enums.ReferenceType;
import satunnaisoliot.datastructures.generic.GenericReference;


public class Proceedings extends GenericReference {

    public void setTitle(String value) {
        setField(FieldType.TITLE, value);
    }

    public String getTitle() {
        return getField(FieldType.TITLE);
    }

    public void setYear(String value) {
        setField(FieldType.YEAR, value);
    }

    public String getYear() {
        return getField(FieldType.YEAR);
    }

    public void setEditor(String value) {
        setField(FieldType.EDITOR, value);
    }

    public String getEditor() {
        return getField(FieldType.EDITOR);
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

    public void setSeries(String value) {
        setField(FieldType.SERIES, value);
    }

    public String getSeries() {
        return getField(FieldType.SERIES);
    }

    public void setAddress(String value) {
        setField(FieldType.ADDRESS, value);
    }

    public String getAddress() {
        return getField(FieldType.ADDRESS);
    }

    public void setMonth(String value) {
        setField(FieldType.MONTH, value);
    }

    public String getMonth() {
        return getField(FieldType.MONTH);
    }

    public void setPublisher(String value) {
        setField(FieldType.PUBLISHER, value);
    }

    public String getPublisher() {
        return getField(FieldType.PUBLISHER);
    }

    public void setOrganization(String value) {
        setField(FieldType.ORGANIZATION, value);
    }

    public String getOrganization() {
        return getField(FieldType.ORGANIZATION);
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
        return ReferenceType.PROCEEDINGS;
    }


}
