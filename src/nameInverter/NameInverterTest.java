package nameInverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameInverterTest  {
    private NameInverter nameInverter;

    @Before
    public void setup(){
        nameInverter = new NameInverter();
    }

    private void assertInverted(String originalName, String invertedName) {
        assertEquals(invertedName, nameInverter.invertName(originalName));
    }

    @Test
    public void givenNull_returnsEmptyString() throws Exception {
        assertInverted(null, "");
    }

    @Test
    public void givenEmptyString_returnEmptyString() throws Exception {
        assertInverted("", "");
    }

    @Test
    public void givenSimpleName_returnSimpleName() throws Exception {
        assertInverted("Name", "Name");
    }

    @Test
    public void givenFirstLast_returnLastFirst() throws Exception {
        assertInverted("First Last", "Last, First");
    }

    @Test
    public void givenSimpleNameWithSpaces_returnSimpleNameWithoutSpaces() throws Exception {
        assertInverted(" Name ", "Name");
    }

    @Test
    public void givenFirstLastWithExtraSpaces_returnLastFirst() throws Exception {
        assertInverted("  First   Last  ", "Last, First");
    }

    @Test
    public void ignoreHonorifics() throws Exception {
        assertInverted("Mr. First Last", "Last, First");
        assertInverted("Mrs. First Last", "Last, First");
    }

    @Test
    public void postNominals_stayAtEnd() throws Exception {
        assertInverted("First Last Sr.", "Last, First Sr.");
        assertInverted("First Last BS. Phd.", "Last, First BS. Phd.");
    }

    @Test
    public void integration() throws Exception {
        assertInverted("  Mr.    Ion       Apostol    Sr.     Phd.  ","Apostol, Ion Sr. Phd.");
    }
}
