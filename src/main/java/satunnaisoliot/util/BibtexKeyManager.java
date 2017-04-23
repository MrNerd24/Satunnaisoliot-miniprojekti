/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.util;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import satunnaisoliot.structs.dao.ReferenceDao;
import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.interfaces.Reference;

/**
 *
 * @author juuso_j0pbwen
 */
public class BibtexKeyManager {

    /**
     * Checks if some saved reference has the bibTexKey given as parameter
     *
     * @param bibTexkey to be checked.
     * @return true, if some saved reference has that bibTexKey, false if not.
     */
    public static boolean hasKey(String bibTexkey) {
        List<Reference> references = DataManager.getDao().findAll();
        for (Reference reference : references) {
            if (reference.getBibTexKey().equals(bibTexkey)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Handles reference's BibTexKey by generating it if it's empty or by making
     * it unique.
     *
     * @param reference that gets BibTexkey handled.
     * @return true, if changes were made, false if not.
     */
    public static boolean handleBibTexKey(Reference reference) {
        if (reference.getBibTexKey() == null || reference.getBibTexKey().isEmpty()) {
            generateBibTexKey(reference);
            return true;
        } else {
            return makeBibTexKeyUnique(reference);
        }
    }

    private static void generateBibTexKey(Reference reference) {
        String authorContent = reference.getField(FieldType.AUTHOR);
        String bibTexKey = "";

        if (authorContent.contains(";")) {
            //Many authors
            String[] authors = authorContent.split(";");

            for (int i = 0; i < authors.length; i++) {
                String author = authors[i];
                bibTexKey += author.charAt(0); //Take first letter of each last name
            }
        } else {
            //Only one author
            //Take three first letters of the last name or all if less than three
            int commaIndex = authorContent.indexOf(",");
            String lastName;
            if (commaIndex == -1) {
                lastName = authorContent;
            } else {
                lastName = authorContent.substring(0, commaIndex);
            }

            if (lastName.length() < 3) {
                bibTexKey += lastName;
            } else {
                bibTexKey += lastName.substring(0, 3);
            }
        }
        //Add year
        String year = reference.getField(FieldType.YEAR);
        if (year.length() < 2) {
            bibTexKey += year;
        } else {
            bibTexKey += year.substring(2);
        }

        bibTexKey += getLetterSuffix(bibTexKey);

        reference.setBibTexKey(bibTexKey);
    }

    private static String getLetterSuffix(String bibTexKey) {
        HashSet<String> bibTexKeys = new HashSet<>();
        List<Reference> references = DataManager.getDao().findAll();
        for (Reference reference : references) {
            bibTexKeys.add(reference.getBibTexKey());
        }

        String letters = "abcdefghijklmnopqrstuvwxyz";
        String ans = "";
        ArrayDeque<String> suffixes = new ArrayDeque<String>();
        suffixes.add(ans);
        do {
            ans = suffixes.poll();
            for (char c : letters.toCharArray()) {
                suffixes.add(ans + c);
            }
        } while (bibTexKeys.contains(bibTexKey + ans));
        return ans;
    }

    private static boolean makeBibTexKeyUnique(Reference reference) {
        String suffix = getLetterSuffix(reference.getBibTexKey());
        if (suffix.isEmpty()) {
            return false;
        }
        reference.setBibTexKey(reference.getBibTexKey() + suffix);
        return true;
    }
}
