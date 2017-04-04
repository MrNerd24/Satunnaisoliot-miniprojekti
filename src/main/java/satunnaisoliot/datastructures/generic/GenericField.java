package satunnaisoliot.datastructures.generic;

import satunnaisoliot.datastructures.interfaces.Field;
import satunnaisoliot.datastructures.interfaces.Reference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juuso_j0pbwen
 */
public abstract class GenericField implements Field {

    List<Reference> references = new ArrayList<>();

    /**
     * 
     * @return a list of references that have this field and it's value.
     */
    @Override
    public List<Reference> getReferences() {
        return references;
    }

    /**
     * Links a reference that uses this field and it's value.
     * @param reference to be linked.
     */
    @Override
    public void linkReference(Reference reference) {
        references.add(reference);
    }

    /**
     * Removes a linked reference. Should be done when a reference doesn't have this field and it's value anymore.
     * @param reference to be removed.
     */
    public void removeReference(Reference reference) {
        references.remove(reference);
    }

}
