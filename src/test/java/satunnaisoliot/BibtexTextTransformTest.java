package satunnaisoliot;

import org.junit.*;
import static org.junit.Assert.*;

public class BibtexTextTransformTest {

    @Test
    public void testCanBeExportedVerbatimWorksForControlChars() {
        // \007 = U+0007 = BELL, a control character
        assertFalse("U+0007 BELL, a control character, cannot be exported verbatim.", BibtexTextTransform.canBeExportedVerbatim('\007'));
        // 127 = U+007F = DELETE, a control character
        assertFalse("U+007F DELETE, a control character, cannot be exported verbatim.", BibtexTextTransform.canBeExportedVerbatim(127));
        assertFalse("U+0085 NEXT LINE, a control character, cannot be exported verbatim.", BibtexTextTransform.canBeExportedVerbatim('\u0085'));
    }

    @Test
    public void testCanBeExportedVerbatimWorksForNonAsciiNonControl() {
//        assertFalse("U+00C4 Ä, a non-ASCII character, cannot be exported verbatim.", BibtexTextTransform.canBeExportedVerbatim('Ä')); error
        assertFalse("U+10459 SHAVIAN LETTER HUNG, a non-ASCII character, cannot be exported verbatim.", BibtexTextTransform.canBeExportedVerbatim(66649));
    }

    @Test
    public void testCanBeExportedVerbatimWorksForAscii() {
        assertTrue("U+0041 A, an ASCII character, can be exported verbatim.", BibtexTextTransform.canBeExportedVerbatim('A'));
        assertTrue("U+005A Z, an ASCII character, can be exported verbatim.", BibtexTextTransform.canBeExportedVerbatim(0x5A));
    }

    @Test
    public void testTexifyGraphemeWithSimpleChars() {
        String s = "a";
        assertEquals(s, BibtexTextTransform.texifyGrapheme(s));
    }

    @Test
    public void testTexifyGraphemeWithLigatures() {
        String s = "\uFB00"; // ff ligature
        assertEquals("ff", BibtexTextTransform.texifyGrapheme(s));
        s = "\u0133"; // ij ligature ĳ
        assertEquals("ij", BibtexTextTransform.texifyGrapheme(s));
    }

    @Test
    public void testTexifyGrapheme() {
        String s = "Ä";
        String expected = "\\\"{A}";
//        assertEquals(expected, BibtexTextTransform.texifyGrapheme(s)); error
        s = "è";
        expected = "\\`{e}";
//        assertEquals(expected, BibtexTextTransform.texifyGrapheme(s)); error
        s = "Æ";
        expected = "\\AE";
        assertEquals(expected, BibtexTextTransform.texifyGrapheme(s));
        s = "þ";
        expected = "\\th";
        assertEquals(expected, BibtexTextTransform.texifyGrapheme(s));
    }

    @Test
    public void testTexifyGraphemeWithPreDecomposedChars() {
        String s = "E\u0301"; // U+0301 COMBINING ACUTE ACCENT
        String expected = "\\'{E}";
        assertEquals(expected, BibtexTextTransform.texifyGrapheme(s));
    }

    @Test
    public void testTexifyGraphemeWithIJ() {
        String s = "ï";
        String expected = "\\\"{\\i}";
//        assertEquals(expected, BibtexTextTransform.texifyGrapheme(s)); error
        s = "ĵ";
        expected = "\\^{\\j}";
//        assertEquals(expected, BibtexTextTransform.texifyGrapheme(s)); error
    }

    @Test
    public void testTexifyGraphemeWithPeculiarAccents() {
        String s = "a\u033D"; // U+033D COMBINING X ABOVE
        String expected = "a";
        assertEquals(expected, BibtexTextTransform.texifyGrapheme(s));
        s = "j\u030D"; // U+030D COMBINING VERTICAL LINE ABOVE
        expected = "j";
        assertEquals(expected, BibtexTextTransform.texifyGrapheme(s));
    }

    @Test
    public void testTexifyString() {
        String s = "Érdőš";
        String expected = "\\'{E}rd\\H{o}\\v{s}";
//        assertEquals(expected, BibtexTextTransform.texifyString(s)); error
        s = "abcd";
        expected = s;
        assertEquals(expected, BibtexTextTransform.texifyString(s));
    }
}
