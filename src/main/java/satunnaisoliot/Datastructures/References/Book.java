package satunnaisoliot.Datastructures.References;

import java.util.List;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Fields.Address;
import satunnaisoliot.Datastructures.Fields.Author;
import satunnaisoliot.Datastructures.Fields.Edition;
import satunnaisoliot.Datastructures.Fields.Editor;
import satunnaisoliot.Datastructures.Fields.Month;
import satunnaisoliot.Datastructures.Fields.Note;
import satunnaisoliot.Datastructures.Fields.Pages;
import satunnaisoliot.Datastructures.Fields.Publisher;
import satunnaisoliot.Datastructures.Fields.Title;
import satunnaisoliot.Datastructures.Fields.Volume;
import satunnaisoliot.Datastructures.Fields.Series;
import satunnaisoliot.Datastructures.Fields.Year;
import satunnaisoliot.Datastructures.Generic.GenericReference;
import satunnaisoliot.Datastructures.Interfaces.Field;

public class Book extends GenericReference {

    public Book(Author author, Title title, Publisher publisher, Year year) {
        addField(FieldType.AUTHOR, author);
        addField(FieldType.TITLE, title);
        addField(FieldType.PUBLISHER, publisher);
        addField(FieldType.YEAR, year);
    }

    public void setAuthor(int index, Author value) {
        setField(FieldType.AUTHOR, index, value);
    }

    public void addAuthor(Author value) {
        addField(FieldType.AUTHOR, value);
    }

    public List<Field> getAuthors() {
        return getFields(FieldType.AUTHOR);
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

    public void setPublisher(int index, Publisher value) {
        setField(FieldType.PUBLISHER, index, value);
    }

    public void addPublisher(Publisher value) {
        addField(FieldType.PUBLISHER, value);
    }

    public List<Field> getPublishers() {
        return getFields(FieldType.PUBLISHER);
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

    public void setNumber(int index, satunnaisoliot.Datastructures.Fields.Number value) {
        setField(FieldType.NUMBER, index, value);
    }

    public void addNumber(satunnaisoliot.Datastructures.Fields.Number value) {
        addField(FieldType.NUMBER, value);
    }

    public List<Field> getNumbers() {
        return getFields(FieldType.NUMBER);
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

    public void setNote(int index, Note value) {
        setField(FieldType.NOTE, index, value);
    }

    public void addNote(Note value) {
        addField(FieldType.NOTE, value);
    }

    public List<Field> getNotes() {
        return getFields(FieldType.NOTE);
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

    public void setEdition(int index, Edition value) {
        setField(FieldType.EDITION, index, value);
    }

    public void addEdition(Edition value) {
        addField(FieldType.EDITION, value);
    }

    public List<Field> getEditions() {
        return getFields(FieldType.EDITION);
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

    @Override
    public List<String> toBibTex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
