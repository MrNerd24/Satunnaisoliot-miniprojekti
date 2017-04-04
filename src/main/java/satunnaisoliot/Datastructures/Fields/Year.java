package satunnaisoliot.Datastructures.Fields;

import java.util.HashMap;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericNumberField;

public class Year extends GenericNumberField {

    private static HashMap<Integer, Year> years = new HashMap<>();

    public Year(int year) {
        super(year);
    }

    @Override
    public FieldType getType() {
        return FieldType.YEAR;
    }

    public static Year getYearObject(int year) {
        if (Year.years.get(year) == null) {
            Year.years.put(year, new Year(year));
        }
        return Year.years.get(year);
    }

    @Override
    public String getTypeString() {
        return "year";
    }
}
