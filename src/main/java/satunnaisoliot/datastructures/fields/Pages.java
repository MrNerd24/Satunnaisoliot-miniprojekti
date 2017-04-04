package satunnaisoliot.datastructures.fields;

import java.util.HashMap;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericNumberField;

public class Pages extends GenericNumberField {

    private static HashMap<Integer, Pages> pagesMap = new HashMap<>();

    private Pages(int pages) {
        super(pages);
    }

    @Override
    public FieldType getType() {
        return FieldType.PAGES;
    }

    public static Pages getPagesObject(int pages) {
        if (Pages.pagesMap.get(pages) == null) {
            Pages.pagesMap.put(pages, new Pages(pages));
        }
        return Pages.pagesMap.get(pages);
    }

    @Override
    public String getTypeString() {
        return "pages";
    }
    
}
