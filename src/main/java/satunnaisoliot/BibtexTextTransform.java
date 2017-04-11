package satunnaisoliot;

import java.text.CharacterIterator;
import java.text.Normalizer;
import java.text.StringCharacterIterator;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This package is for the various text transformations that are required
 * for multilingual text to be represented in the ASCII-only BibTex format.
 */
public class BibtexTextTransform {

    // LaTex has commands for these few odd latin letters
    static final Map<String, String> charTransforms;
    static {
        Map<String, String> map = new HashMap();
        map.put("å", "\\aa");
        map.put("Å", "\\AA");
        map.put("æ", "\\ae");
        map.put("Æ", "\\AE");
        map.put("œ", "\\oe");
        map.put("Œ", "\\OE");
        map.put("ø", "\\o");
        map.put("Ø", "\\O");
        map.put("ß", "\\ss");
        map.put("Ð", "\\DH"); // capital eth
        map.put("ð", "\\dh");
        map.put("Đ", "\\DJ"); // capital barred D
        map.put("đ", "\\d");
        map.put("Ŋ", "\\NG");
        map.put("ŋ", "\\ng");
        map.put("Þ", "\\TH");
        map.put("þ", "\\th");
        charTransforms = Collections.unmodifiableMap(map);
    }

    // Here we map combining characters in the Combining Diacritical Marks
    // unicode block (U+0300 to U+036F) to LaTex commands
    // http://www.fileformat.info/info/unicode/block/combining_diacritical_marks/list.htm
    static final Map<String, String> diacriticCommands;
    static {
        Map<String, String> map = new HashMap();
        map.put("\u0300", "\\`"); // COMBINING GRAVE ACCENT
        map.put("\u0301", "\\'"); // COMBINING ACUTE ACCENT
        map.put("\u0302", "\\^"); // COMBINING CIRCUMFLEX ACCENT
        map.put("\u0303", "\\~"); // COMBINING TILDE ~
        map.put("\u0304", "\\="); // COMBINING MACRON
        map.put("\u0305", "\\="); // COMBINING OVERLINE
        map.put("\u0306", "\\u"); // COMBINING BREVE (u above letter)
        map.put("\u0307", "\\."); // COMBINING DOT ABOVE
        map.put("\u0308", "\\\"");// COMBINING DIAERESIS
        map.put("\u030A", "\\r"); // COMBINING RING ABOVE
        map.put("\u030B", "\\H"); // COMBINING DOUBLE ACUTE ACCENT (as in ő)
        map.put("\u030C", "\\v"); // COMBINING CARON (as in š)
        map.put("\u0323", "\\d"); // COMBINING DOT BELOW
        map.put("\u0326", "\\k"); // COMBINING COMMA BELOW
        map.put("\u0327", "\\c"); // COMBINING CEDILLA
        map.put("\u0328", "\\k"); // COMBINING OGONEK
        map.put("\u0331", "\\b"); // COMBINING MACRON BELOW
        map.put("\u0332", "\\b"); // COMBINING LOW LINE
        map.put("\u0340", "\\`"); // COMBINING GRAVE TONE MARK
        map.put("\u0341", "\\'"); // COMBINING ACUTE TONE MARK
        diacriticCommands = Collections.unmodifiableMap(map);
    }

    // Because i and j need special attention.
    static final Set<String> diacriticsAboveLetter;
    static {
        Set<String> set = new HashSet();
        set.add("\u0300"); // COMBINING GRAVE ACCENT
        set.add("\u0301"); // COMBINING ACUTE ACCENT
        set.add("\u0302"); // COMBINING CIRCUMFLEX ACCENT
        set.add("\u0303"); // COMBINING TILDE
        set.add("\u0304"); // COMBINING MACRON
        set.add("\u0305"); // COMBINING OVERLINE
        set.add("\u0306"); // COMBINING BREVE
        set.add("\u0307"); // COMBINING DOT ABOVE
        set.add("\u0308"); // COMBINING DIAERESIS
        set.add("\u030A"); // COMBINING RING ABOVE
        set.add("\u030B"); // COMBINING DOUBLE ACUTE ACCENT
        set.add("\u030C"); // COMBINING CARON
        set.add("\u0340"); // COMBINING GRAVE TONE MARK
        set.add("\u0341"); // COMBINING ACUTE TONE MARK
        diacriticsAboveLetter = Collections.unmodifiableSet(set);
    }

    static boolean canBeExportedVerbatim(char c) {
        // Some characters, like for instance the control characters U+007F
        // and U+0000 to U+0019, can't be exported in the resultant BiBTex file.
        if (Character.isISOControl(c)) return false;
        return Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BASIC_LATIN;
    }

    static boolean canBeExportedVerbatim(int c) {
        if (Character.isISOControl(c)) return false;
        return Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BASIC_LATIN;
    }

    static String texifyGrapheme(String grapheme) {
        if (charTransforms.keySet().contains(grapheme)) {
            return charTransforms.get(grapheme);
        }

        String normalizedSequence = Normalizer.normalize(grapheme, Normalizer.Form.NFKD);

        // Some normalizations come out as just a sequence of a-z, for example
        // the fi ligature U+FB01
        boolean normalizationIsJustBasicLatin = true;
        StringCharacterIterator iter = new StringCharacterIterator(normalizedSequence);
        for (char c = iter.first(); c != CharacterIterator.DONE; c = iter.next()) {
            if (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.BASIC_LATIN) {
                normalizationIsJustBasicLatin = false;
            }
        }
        if (normalizationIsJustBasicLatin) {
            return normalizedSequence;
        }

        String baseChar = normalizedSequence.substring(0, 1);
        String rest = normalizedSequence.substring(1);

        if (baseChar.equals("i") || baseChar.equals("j")) {
            if (diacriticsAboveLetter.contains(rest)) {
                if (baseChar.equals("i")) {
                    baseChar = "\\i";
                } else {
                    baseChar = "\\j";
                }
            }
        }

        if (diacriticCommands.containsKey(rest)) {
            String latexCommand = diacriticCommands.get(rest);
            return latexCommand + "{" + baseChar + "}";
        } else {
            // Nothing close to the original accent, so lets just return
            // the letter itself; better than nothing.
            if (baseChar.equals("\\i")) return "i";
            if (baseChar.equals("\\j")) return "j";
            return baseChar;
        }
    }

    public static String texifyString(String unicodey) {
        if (unicodey.length() <= 1) {
            return texifyGrapheme(unicodey);
        }

        // Because Java doesn't have a grapheme-based string traversal system
        // (like that in Perl 6), we have to go thru the string and check
        // if a sequence of characters make up a grapheme we can separate
        // and pass to texifyGrapheme
        String grapheme = unicodey.substring(0, 1);
        String texified = "";

        for (int i = 1; i < unicodey.length(); i++) {
            char current = unicodey.charAt(i);
            // Combining characters are in the "Mark, Nonspacing (Mn)" Unicode
            // category http://www.fileformat.info/info/unicode/category/Mn/list.htm
            if (Character.getType(current) == Character.NON_SPACING_MARK) {
                grapheme += current;
            } else {
                texified += texifyGrapheme(grapheme);
                grapheme = Character.toString(current);
            }
        }
        // do the same for the final character
        texified += texifyGrapheme(grapheme);

        return texified;
    }
}
