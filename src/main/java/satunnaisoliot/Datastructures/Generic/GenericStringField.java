package satunnaisoliot.Datastructures.Generic;

import java.util.Objects;

public abstract class GenericStringField extends GenericField {

    private String content;

    public GenericStringField(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public String toBibTex() {
        return content;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.content);
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
        final GenericStringField other = (GenericStringField) obj;
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        return true;
    }

}
