package satunnaisoliot.Datastructures.Generic;

import satunnaisoliot.Datastructures.Interfaces.Field;
import satunnaisoliot.Datastructures.Interfaces.Reference;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericField implements Field {

    List<Reference> references = new ArrayList<>();

    @Override
    public List<Reference> getReferences() {
        return references;
    }

    @Override
    public void linkReference(Reference reference) {
        references.add(reference);
    }

    public void removeReference(Reference reference) {
        references.remove(reference);
    }

}
