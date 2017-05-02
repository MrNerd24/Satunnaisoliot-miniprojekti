/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.util;

/**
 *
 * @author jambo
 */
public class BibtexParser {

    private String texString;

    private boolean isArticle = false;
    private boolean isBook = false;
    private boolean isProceedings = false;
    private String organization = "";
    private String note = "";
    private String key = "";
    private String title = "";
    private String author = "";
    private String bibkey = "";
    private String month = "";
    private String pages = "";
    private String number = "";
    private String volume = "";
    private String year = "";
    private String journal = "";
    private String editor = "";
    private String address = "";
    private String series = "";
    private String publisher = "";

    public BibtexParser(String text) {
        this.texString = text;
        initFields();
    }

    private void initFields() {
        this.texString.toLowerCase();

        this.isArticle = isTypeArticle();
        this.isBook = isTypeBook();
        this.isProceedings = isProceedings();

        this.organization = getFirstSubstringAfter("organization");
        this.note = getFirstSubstringAfter("note");
        this.key = getFirstSubstringAfter("key");
        this.title = getFirstSubstringAfter("title");
        this.author = getFirstSubstringAfter("author");
        this.bibkey = getFirstSubstringBetweenChars('{', ',');
        this.month = getFirstSubstringAfter("month");
        this.pages = getFirstSubstringAfter("pages");
        this.number = getFirstSubstringAfter("number");
        this.volume = getFirstSubstringAfter("volume");
        this.year = getFirstSubstringAfter("year");
        this.journal = getFirstSubstringAfter("journal");
        this.editor = getFirstSubstringAfter("editor");
        this.address = getFirstSubstringAfter("address");
        this.series = getFirstSubstringAfter("series");
        this.publisher = getFirstSubstringAfter("publisher");

    }

    public boolean typeIsArticle() {
        return this.isArticle;
    }

    public boolean typeIsBoook() {
        return this.isBook;
    }

    public boolean typeIsProceedings() {
        return this.isProceedings;
    }

    public String getOrganization() {
        return this.organization;
    }

    public String getNote() {
        return this.note;
    }

    public String getKey() {
        return this.key;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getSeries() {
        return this.series;
    }

    public String getAddress() {
        return this.address;
    }

    public String getEditor() {
        return this.editor;
    }

    public String getJournal() {
        return this.journal;
    }

    public String getYear() {
        return this.year;
    }

    public String getVolume() {
        return this.volume;
    }

    public String getNumber() {
        return this.number;
    }

    public String getPages() {
        return this.pages;
    }

    public String getMonth() {
        return this.month;
    }

    public String getBibkey() {
        return this.bibkey;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    private boolean isTypeArticle() {
        return this.texString.contains("@article");
    }

    private boolean isTypeBook() {
        return this.texString.contains("@book");
    }

    private boolean isProceedings() {
        return this.texString.contains("@proceedings");
    }

    private String getFirstSubstringAfter(String identifier) {
        if (this.texString.contains(identifier) && this.texString.contains("" + '{')
                && this.texString.contains("" + '}')) {

            int indexOfIdentifier = this.texString.indexOf(identifier);
            int firstDelimiterIndex = this.texString.indexOf('{', indexOfIdentifier);
            int lastDelimiterIndex = this.texString.indexOf('}', firstDelimiterIndex + 1);
            return "" + this.texString.subSequence(firstDelimiterIndex + 1, lastDelimiterIndex);
        } else {
            return "";
        }
    }

    private String getFirstSubstringBetweenChars(char ch1, char ch2) {
        if (this.texString.contains("" + ch1)
                && this.texString.contains("" + ch2)) {

            int indexOfFirstChar = this.texString.indexOf(ch1 + "");
            int indexOfSecondChar = this.texString.indexOf(ch2 + "");
            return "" + this.texString.subSequence(indexOfFirstChar + 1, indexOfSecondChar);
        }
        
        return "";
    }
}
