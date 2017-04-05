package satunnaisoliot.datastructures.generic;

import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.interfaces.Reference;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author juuso_j0pbwen
 */
public abstract class GenericReference implements Reference {

    EnumMap<FieldType, String> entries = new EnumMap<FieldType, String>(FieldType.class);

    @Override
    public void setField(FieldType name, String value) {
        entries.put(name, value);

    }

    @Override
    public String getField(FieldType name) {
        return entries.get(name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.entries);
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

    @Override
    public List<String> toBibTex() {
        return null;
    }

    @Override
    public String toString() {
        return "GenericReference{" + '}';
    }
    
}
