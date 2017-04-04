package satunnaisoliot.datastructures.fields;

import java.util.HashMap;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericNumberField;

public class Month extends GenericNumberField {

    private static HashMap<Integer, Month> months = new HashMap<>();

    private Month(int month) {
        super(month);
    }

    @Override
    public FieldType getType() {
        return FieldType.MONTH;
    }

    public static Month getMonthObject(int month) {
        if (Month.months.get(month) == null) {
            Month.months.put(month, new Month(month));
        }
        return Month.months.get(month);
    }

    @Override
    public String getTypeString() {
        return "month";
    }
}
