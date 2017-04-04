package satunnaisoliot.Datastructures.Fields;

import java.util.HashMap;
import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Generic.GenericNumberField;

public class Number extends GenericNumberField {

    private static HashMap<Integer, Number> numbers = new HashMap<>();

    private Number(int number) {
        super(number);
    }

    @Override
    public FieldType getType() {
        return FieldType.NUMBER;
    }

    public static Number getNumberObject(int number) {
        if (Number.numbers.get(number) == null) {
            Number.numbers.put(number, new Number(number));
        }
        return Number.numbers.get(number);
    }

    @Override
    public String getTypeString() {
        return "number";
    }
    
    

}
