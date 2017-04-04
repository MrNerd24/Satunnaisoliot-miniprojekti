package satunnaisoliot.Datastructures.References;

import java.util.List;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Fields.Address;
import satunnaisoliot.Datastructures.Fields.Editor;
import satunnaisoliot.Datastructures.Fields.Month;
import satunnaisoliot.Datastructures.Fields.Note;
import satunnaisoliot.Datastructures.Fields.Title;
import satunnaisoliot.Datastructures.Fields.Volume;
import satunnaisoliot.Datastructures.Fields.Number;
import satunnaisoliot.Datastructures.Fields.Organization;
import satunnaisoliot.Datastructures.Fields.Publisher;
import satunnaisoliot.Datastructures.Fields.Series;
import satunnaisoliot.Datastructures.Fields.Year;
import satunnaisoliot.Datastructures.Generic.GenericReference;
import satunnaisoliot.Datastructures.Interfaces.Field;

public class Proceedings extends GenericReference {

    public Proceedings(Title title, Year year) {
        addField(FieldType.TITLE, title);
        addField(FieldType.YEAR, year);
    }

    public void setTitle(int index, Title value) {
        setField(FieldType.TITLE, index, value);
    }

    public void addTitle(Title value) {
        addField(FieldType.TITLE, value);
    }

    public List<Field> getTitles() {
        return getFields(FieldType.TITLE);
    }

    public void setYear(int index, Year value) {
        setField(FieldType.YEAR, index, value);
    }

    public void addYear(Year value) {
        addField(FieldType.YEAR, value);
    }

    public List<Field> getYears() {
        return getFields(FieldType.YEAR);
    }

    public void setEditor(int index, Editor value) {
        setField(FieldType.EDITOR, index, value);
    }

    public void addEditor(Editor value) {
        addField(FieldType.EDITOR, value);
    }

    public List<Field> getEditors() {
        return getFields(FieldType.EDITOR);
    }

    public void setVolume(int index, Volume value) {
        setField(FieldType.VOLUME, index, value);
    }

    public void addVolume(Volume value) {
        addField(FieldType.VOLUME, value);
    }

    public List<Field> getVolumes() {
        return getFields(FieldType.VOLUME);
    }

    public void setNumber(int index, Number value) {
        setField(FieldType.NUMBER, index, value);
    }

    public void addNumber(Number value) {
        addField(FieldType.NUMBER, value);
    }

    public List<Field> getNumbers() {
        return getFields(FieldType.NUMBER);
    }

    public void setSeries(int index, Series value) {
        setField(FieldType.SERIES, index, value);
    }

    public void addSeries(Series value) {
        addField(FieldType.SERIES, value);
    }

    public List<Field> getSeriesList() {
        return getFields(FieldType.SERIES);
    }

    public void setAddress(int index, Address value) {
        setField(FieldType.ADDRESS, index, value);
    }

    public void addAddress(Address value) {
        addField(FieldType.ADDRESS, value);
    }

    public List<Field> getAddresses() {
        return getFields(FieldType.ADDRESS);
    }

    public void setMonth(int index, Month value) {
        setField(FieldType.MONTH, index, value);
    }

    public void addMonth(Month value) {
        addField(FieldType.MONTH, value);
    }

    public List<Field> getMonths() {
        return getFields(FieldType.MONTH);
    }

    public void setPublisher(int index, Publisher value) {
        setField(FieldType.PUBLISHER, index, value);
    }

    public void addPublisher(Publisher value) {
        addField(FieldType.PUBLISHER, value);
    }

    public List<Field> getPublishers() {
        return getFields(FieldType.PUBLISHER);
    }

    public void setOrganization(int index, Organization value) {
        setField(FieldType.ORGANIZATION, index, value);
    }

    public void addOrganization(Organization value) {
        addField(FieldType.ORGANIZATION, value);
    }

    public List<Field> getOrganizations() {
        return getFields(FieldType.ORGANIZATION);
    }

    public void setNote(int index, Note value) {
        setField(FieldType.NOTE, index, value);
    }

    public void addNote(Note value) {
        addField(FieldType.NOTE, value);
    }

    public List<Field> getNotes() {
        return getFields(FieldType.NOTE);
    }

    @Override
    public List<String> toBibTex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
