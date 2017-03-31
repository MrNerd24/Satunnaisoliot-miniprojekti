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
    public static void SaveArticle(String auth, String t, String jour, String yr, String vol, String nmbr, String pgs, String mnth, String nt, String k){
        ArticleStub article = new ArticleStub(auth,t,jour,yr,vol,nmbr,pgs,mnth,nt,k);
}
}
