/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReferenceManager.Lomake;

/**
 *
 * @author Peter
 */
public class LomakeController {
    public static void main(String[] args){ //stub testaamiselle
        ArticleForm af = new ArticleForm();
        af.showForm();
    }
    public static void SaveArticle(String author, String title, String journal, String year, String volume, String number, String pages, String month, String note, String key){
        ArticleStub article = new ArticleStub(author, title, journal, year, volume, number, pages, month, note, key);
}
    public static void SaveBook(String author, String title, String publisher, String year, String volume, String series, String address, String month, String note, String key){
        BookStub book = new BookStub(author, title, publisher, year, volume, series, address, month, note, key);
}
    public static void SaveProceeding(String title, String year, String editor, String volume, String series, String address, String month, String publisher, String organization, String note, String key){
        ProceedingsStub proceeding = new ProceedingsStub(title, year, editor, volume, series, address, month, publisher, organization, note, key);
}
}
