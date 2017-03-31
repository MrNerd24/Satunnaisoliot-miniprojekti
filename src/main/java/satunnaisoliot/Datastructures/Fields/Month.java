package satunnaisoliot.Datastructures.Fields;

import java.util.HashMap;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericNumberField;

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
}
