package satunnaisoliot.datastructures.references;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.fields.Author;
import satunnaisoliot.datastructures.fields.Journal;
import satunnaisoliot.datastructures.fields.Title;
import satunnaisoliot.datastructures.fields.Volume;
import satunnaisoliot.datastructures.fields.Year;
import satunnaisoliot.datastructures.fields.Number;
import satunnaisoliot.datastructures.generic.GenericReference;
import java.util.List;
import satunnaisoliot.datastructures.fields.Month;
import satunnaisoliot.datastructures.fields.Note;
import satunnaisoliot.datastructures.fields.Pages;
import satunnaisoliot.datastructures.interfaces.Field;

public class Article extends GenericReference {

    public Article(Author author, Title title, Journal journal, Year year, Volume volume) {
        addField(FieldType.AUTHOR, author);
        addField(FieldType.TITLE, title);
        addField(FieldType.JOURNAL, journal);
        addField(FieldType.YEAR, year);
        addField(FieldType.VOLUME, volume);
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

    public void setJournal(int index, Journal value) {
        setField(FieldType.JOURNAL, index, value);
    }

    public void addJournal(Journal value) {
        addField(FieldType.JOURNAL, value);
    }

    public List<Field> getJournals() {
        return getFields(FieldType.JOURNAL);
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

    public void setPages(int index, Pages value) {
        setField(FieldType.PAGES, index, value);
    }

    public void addPages(Pages value) {
        addField(FieldType.PAGES, value);
    }

    public List<Field> getPagesList() {
        return getFields(FieldType.PAGES);
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

    @Override
    public List<String> toBibTex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
