package satunnaisoliot.util;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.interfaces.Reference;

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
        String year = reference.getField(FieldType.YEAR);

        String bibTexKey = generateBibTexKeyAuthorQuantityCheck(authorContent);
        bibTexKey += addYearToBibTexKey(year);
        bibTexKey += getLetterSuffix(bibTexKey);

        reference.setBibTexKey(bibTexKey);
    }

    private static String generateBibTexKeyAuthorQuantityCheck(String authorContent) {
        if (authorContent.contains(";")) {
            //Many authors
            return generateBibTexKeyForManyAuthors(authorContent);
        }
        return generateBibTexKeyForOneAuthor(authorContent);
    }

    private static String generateBibTexKeyForManyAuthors(String authorContent) {
        String bibTexKey = "";
        String[] authors = authorContent.split(";");

        for (int i = 0; i < authors.length; i++) {
            String author = authors[i].trim();
            bibTexKey += author.charAt(0); //Take first letter of each last name
        }
        return bibTexKey;
    }

    private static String generateBibTexKeyForOneAuthor(String authorContent) {
        //Only one author
        //Take three first letters of the last name or all if less than three
        String lastName = getLastNameFromAuthorContent(authorContent);
        return lettersFromOneAuthorsLastName(lastName);
    }

    private static String getLastNameFromAuthorContent(String authorContent) {
        int commaIndex = authorContent.indexOf(",");
        if (commaIndex == -1) {
            return authorContent;
        }
        return authorContent.substring(0, commaIndex);
    }

    private static String lettersFromOneAuthorsLastName(String lastName) {
        if (lastName.length() < 3) {
            return lastName;
        }
        return lastName.substring(0, 3);
    }

    private static String addYearToBibTexKey(String year) {
        if (year != null) {
            if (year.length() < 2) {
                return year;
            } else {
                return year.substring(2);
            }
        }
        return "";
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
