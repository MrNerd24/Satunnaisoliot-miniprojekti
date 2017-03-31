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
public class ArticleStub {
    String author = "";
    String title = "";
    String journal = "";
    String year = "";
    String volume = "";
    String number = "";
    String pages = "";
    String month = "";
    String note = "";
    String key = "";
    
    public ArticleStub(String auth, String t, String jour, String yr, String vol, String nmbr, String pgs, String mnth, String nt, String k){
        author = auth;
        title = t;
        journal = jour;
        year = yr;
        volume = vol;
        number = nmbr;
        pages = pgs;
        month = mnth;
        note = nt;
        key = k;

    }
}
