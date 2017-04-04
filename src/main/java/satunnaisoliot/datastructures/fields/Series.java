package satunnaisoliot.datastructures.fields;

import java.util.HashMap;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericStringField;

public class Series extends GenericStringField {

    private static HashMap<String, Series> serieses = new HashMap<>();

    private Series(String content) {
        super(content);
    }

    @Override
    public FieldType getType() {
        return FieldType.SERIES;
    }

    @Override
    public String getTypeString() {
        return "series";
    }
    
    public static Series getSeriesObject(String series) {
        if (Series.serieses.get(series) == null) {
            Series.serieses.put(series, new Series(series));
        }
        return Series.serieses.get(series);
    }

}
