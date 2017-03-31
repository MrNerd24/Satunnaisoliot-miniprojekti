package satunnaisoliot.Datastructures.Generic;

import satunnaisoliot.Datastructures.Enums.FieldType;
import satunnaisoliot.Datastructures.Interfaces.Field;
import satunnaisoliot.Datastructures.Interfaces.Reference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import satunnaisoliot.Datastructures.Fields.Key;

public abstract class GenericReference implements Reference {

    EnumMap<FieldType, List<Field>> entries = new EnumMap<FieldType, List<Field>>(FieldType.class);

    @Override
    public void addField(FieldType name, Field value) {
        if (entries.get(name) == null) {
            entries.put(name, new ArrayList<Field>());
        }
        entries.get(name).add(value);
        value.linkReference(this);
    }

    @Override
    public void setField(FieldType name, int index, Field value) {
        if (entries.get(name) == null) {
            entries.put(name, new ArrayList<Field>());
        }
        entries.get(name).get(index).removeReference(this);
        value.linkReference(this);
        entries.get(name).set(index, value);

    }

    @Override
    public List<Field> getFields(FieldType name) {
        return entries.get(name);
    }

    public void setKey(int index, Key value) {
        setField(FieldType.YEAR, index, value);
    }

    public void addKey(Key value) {
        addField(FieldType.YEAR, value);
    }

    public List<Field> getKeys() {
        return getFields(FieldType.YEAR);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.entries);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GenericReference other = (GenericReference) obj;
        if (!Objects.equals(this.entries, other.entries)) {
            return false;
        }
        return true;
    }
    
    

}
